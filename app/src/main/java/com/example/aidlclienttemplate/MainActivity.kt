package com.example.aidlclienttemplate

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aidlclienttemplate.databinding.ActivityMainBinding
import com.sunyard.vi218asu806.appserver.aidl.IDeviceService
import com.sunyard.vi218asu806.appserver.aidl.ISystemManager

class MainActivity : AppCompatActivity() {
    companion object {
        private var TAG = MainActivity.javaClass.name
        private const val SERVICE_ACTION = "com.sunyard.vi218asu806.app_server"
//        private const val SERVICE_PACKAGE_NAME = "com.sunyard.vi218asu806.appserver"
    }
    private lateinit var mIDeviceService:IDeviceService

    private var mConnection: ServiceConnection = object:ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e(TAG, "onServiceConnected: 绑定服务")
            mIDeviceService =IDeviceService.Stub.asInterface(service)

            var ISystemManager = mIDeviceService.systemMagner
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }
    private val mDataBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding?>(this,R.layout.activity_main).apply {
            click = ProxyClick()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding

    }

    private fun bindServiceFun() {
        var intent = getIntentForPop(this, SERVICE_ACTION);
        var bindRet = bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
        Log.e(TAG,"绑定服务结果: $bindRet");

    }

    /**
     * 用于5.0以上系统绑定服务隐式意图的转换
     *
     * @param context
     * @param action  Intent的Action
     * @return Intent 显式意图
     */
    private fun getIntentForPop(context: Context, action: String): Intent? {
        val implicitIntent = Intent(action)
        return getExplicitIntent(context, implicitIntent) ?: return null
    }

    /**
     * 5.0 上采用隐式的方法启动服务，会报异常“Service Intent must be explicit”，该方法将隐式意图转成显式
     * @param context
     * @param implicitIntent
     * @return
     */
    private fun getExplicitIntent(context: Context, implicitIntent: Intent): Intent? {
        // Retrieve all services that can match the given intent
        val pm = context.packageManager
        val resolveInfo = pm.queryIntentServices(implicitIntent, 0)
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size != 1) {
            return null
        }
        // Get component info and create ComponentName
        val serviceInfo = resolveInfo[0]
        val packageName = serviceInfo.serviceInfo.packageName
        val className = serviceInfo.serviceInfo.name
        val component = ComponentName(packageName, className)
        // Create a new intent. Use the old one for extras and such reuse
        val explicitIntent = Intent(implicitIntent)
        // Set the component to be explicit
        explicitIntent.component = component
        return explicitIntent
    }

    inner class ProxyClick {
        fun clickBindService() {
            Log.e(TAG,"bindService")
            bindServiceFun()

        }

    }
}