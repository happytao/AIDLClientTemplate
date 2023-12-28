// IInsertCardReader.aidl
package com.sunyard.vi218asu806.appserver.aidl;

// Declare any non-default types here with import statements

interface IInsertCardReader {
    byte sysCmdCheckPSAMIC(in int cardNum,in int timeout,out byte[] data);
    byte sysCmdPSAMPowerOn(in int cardNum,out byte[] AtrData,out int[] len);
    byte sysCmdPSAMSendCmd(in int cardNum,in int cmdLen,in byte[] cmd,inout byte[] ack,out int[] len);
    byte sysCmdPSAMPowerOff(in int cardNum);
}