// ISerialPort.aidl
package com.sunyard.vi218asu806.appserver.aidl;

// Declare any non-default types here with import statements

interface ISerialPort {
    byte sysCmdUartSend(int len,in byte[] data);
    byte sysCmdUartReceive(int timeoutMS,int hopeLen,out int[] trueLen,out byte[] data);
    byte sysCmdUartCleanBuff();
}