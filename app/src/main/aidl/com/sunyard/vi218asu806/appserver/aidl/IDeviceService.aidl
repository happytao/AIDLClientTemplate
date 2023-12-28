// IDeviceService.aidl
package com.sunyard.vi218asu806.appserver.aidl;
import com.sunyard.vi218asu806.appserver.aidl.IBuzzer;
import com.sunyard.vi218asu806.appserver.aidl.IInsertCardReader;
import com.sunyard.vi218asu806.appserver.aidl.IMagCardReader;
import com.sunyard.vi218asu806.appserver.aidl.IPinPad;
import com.sunyard.vi218asu806.appserver.aidl.IRSA;
import com.sunyard.vi218asu806.appserver.aidl.ISerialPort;
import com.sunyard.vi218asu806.appserver.aidl.ISystemManager;
import com.sunyard.vi218asu806.appserver.aidl.ISecureChipManager;

interface IDeviceService {
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    IBuzzer getBuzzer();
    IInsertCardReader getIInsertCardReader();
    IMagCardReader getIMagCardReader();
    IPinPad getIPinPad();
    IRSA getIRSA();
    ISerialPort getISerialPort();
    ISystemManager getSystemMagner();
    ISecureChipManager getISecureChipManager();

}