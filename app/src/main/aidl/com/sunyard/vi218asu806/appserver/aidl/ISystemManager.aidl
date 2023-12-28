package com.sunyard.vi218asu806.appserver.aidl;

interface ISystemManager {
    int sysSetDataTime(in byte[] str);
    int sysGetDataTime(out byte[] str);
    int sysReadSecurityChipSN(out byte[] sn);
    int sysGetSecurityChipVersion(out byte[] version);
    int sysLedControl(in byte index,in byte mode);
    void sysWriteSN(in String sn);
    String sysReadSN();
    int sysReadTamperRecord(out byte[] record);
    int SysClearTamperRecord();
    int sysSetScreenOffTimeout(in int time);
    int sysGetScreenOffTimeout();
    int sysGetScreenBrightness();
    int sysSetScreenBrightness(in int value);
    int sysGetScreenBrightnessMode();
    int sysSetScreenBrightnessMode(in boolean mode);
    int sysSetDebugSecurityChipMode(in boolean mode);
    int sysUartRecv(in char ComID,out byte[] strBuf,out int[] p_read_len,in int timeout,in int nbyte);
    int sysUartSend(in char ComID,in byte[] strBuf, in int nByte);
    int sysUartInit(in char ComID,in int Boudrate,in char flag_par,in char flag_dbs);
    int sysUartClearBuffer(char ComID);
    int sysUartLogEn(boolean en);
    int sysGetGpioValue(in int num);
    void sysSetGpioValue(in int num,in boolean type);
    void sysSetIOGpioValue(in String num,in boolean type);
    int sysGetIOGpioValue(in String num);
    int sysGetHWVersion();
    String sysGetEleTouchVersion();
    int sysControlEleTouch(in int type);
    void sysSetLinuxShell(in String command);
    String sysGetAppServerVersionName();
    void sysSetSecondsigned(in boolean type);
    void sysPeripheralsAutomaticallySleep(in boolean enable);
    /**
     * <i class="dis_ch">获取当前多任务键RecentKey状态 </i><i class="dis_en">Get recent key status </i>
     *
     * @return <i class="dis_ch">0-允许使用Recent键 </i><i class="dis_en">0-RecentKey enabled </i>
     *         <i class="dis_ch">1-禁止使用Recent键 </i><i class="dis_en">1-RecentKey disabled </i>
     *         <i class="dis_ch">-1-方法调用失败 </i><i class="dis_en">-1-Failed to execute this method </i>
     */
    int getKeyRecentState();
    /**
     * 设置多任务键RecentKey状态
     *
     * @param state 允许(true)或禁止(false)
     */
    void setKeyRecentState(boolean state);
    /**
     * 获取当前HomeKey状态
     *
     * @return true  允许使用HomeKey
     *         false 禁止使用HomeKey
     */
    int getKeyHomeState();
    /**
     * 设置是否允许使用HomeKey
     * @param state 允许(true)或禁止(false)
     */
    void setKeyHomeState(in boolean state);

    /**
     * <i class="dis_ch">获取当前电源键状态 </i><i class="dis_en">Get power key status </i>
     *
     * @return <i class="dis_ch">0-允许使用电源键 </i><i class="dis_en">0-Power key enabled </i>
     *         <i class="dis_ch">1-禁止使用电源键 </i><i class="dis_en">1-Power key disabled </i>
     *         <i class="dis_ch">-1-方法调用失败 </i><i class="dis_en">-1-Failed to execute this method </i>
     */
    int getKeyPowerState();

    /**
     * 设置是否允许使用电源键PowerKey
     *
     * @param state 允许(true)或禁止(false)
     */
    void setKeyPowerState(in boolean state);

    /**
     * <i class="dis_ch">获取当前Back键状态 </i><i class="dis_en">Get Back key status </i>
     *
     * @return <i class="dis_ch">0-允许使用Back键 </i><i class="dis_en">0-Back key enabled </i>
     *         <i class="dis_ch">1-禁止使用Back键 </i><i class="dis_en">1-Back key disabled </i>
     *         <i class="dis_ch">-1-方法调用失败 </i><i class="dis_en">-1-Failed to execute this method </i>
     */
    int getKeyBackState();

    /**
     * 设置是否允许使用返回键BackKey
     *
     * @param state 允许(true)或禁止(false)
     */
    void setKeyBackState(in boolean state);

    /**
     * <i class="dis_ch">获取当前状态栏状态 </i><i class="dis_en">Get current status bar's state </i>
     *
     * @return <i class="dis_ch">0-允许使用StatusBar </i><i class="dis_en">0-StatusBar enabled </i>
     *         <i class="dis_ch">1-禁止使用StatusBar </i><i class="dis_en">1-StatusBar disabled </i>
     *         <i class="dis_ch">-1-方法调用失败 </i><i class="dis_en">-1-Failed to execute this method </i>
     */
    int getStatusbarState();

    /**
     * 设置是否允许使用当前状态栏状态
     *
     * @param state 允许(true)或禁止(false)
     */
    void setStatusbarState(in boolean state);

    /**
     * 内部接口，仅系统签名应用可用
     * 设置是否打开USB调试
     *
     * @param  打开(true) 关闭(false)
     * @return 0:设置成功  小于0:设置失败
     */
    int setAdbDebug(in boolean status);

    /**
     * 设置开机logo
     *
     * @param  logoPath logo路径
     * @return 0:设置成功  小于0:设置失败
     */
    int setBootLogo(in String logoPath);

    /**
     * 设置开机动画
     *
     * @param  animationPath 动画路径
     * @return 0:设置成功  小于0:设置失败
     */
    int setBootAnimation(in String animationPath);


    /**
     * 内部接口，仅系统签名应用可用
     * 设置为开发模式
     */
    //void setAndroidToDevMode(in boolean en);

    /**
     * 获取Oem分区版本号
     */
    String getOemVersion();

    /**
     * 获取Private分区版本号
     */
    String getPrivateVersion();

    /**
     * 更新oem分区
     *
     * @param  oemPath oem.zip文件路径
     * @return 0:更新成功  小于0:更新失败
     */
    int updateOEM(String oemPath);

    /**
     * 更新private分区
     *
     * @param  privatePath private.zip文件路径
     * @return 0:更新成功  小于0:更新失败
     */
    int updatePrivate(String privatePath);
}