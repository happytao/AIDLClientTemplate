// ISecureChipManager.aidl
package com.sunyard.vi218asu806.appserver.aidl;
import com.sunyard.vi218asu806.appserver.aidl.TimeT;
// Declare any non-default types here with import statements

interface ISecureChipManager {
    byte sysCmdSetMode(in byte mode);
    byte sysCmdSynHeartbeat();
    byte sysCmdSetDebug(in byte en);
    byte sysCmdGetDeviceSN(out byte[] snLen,out byte[] sn,out byte[] kSnLen,out byte[] kSn);
    byte sysCmdSetDeviceSN(in byte snLen,in String sn,in byte kSnLen,in String kSn);
    String sysCmdGetVersion();
    TimeT sysCmdGetTime();
    byte sysCmdSetTime(in TimeT time);
    byte sysCmdOpenTamper(in boolean set);
    byte sysCmdCheckTamper(out byte[] status);
    byte sysCmdClearTamper();
    byte sysCmdUpdateFirmware(in byte fileType,in int totalLen);
    byte sysCmdSendFirmwarePacket(in byte fileType,in int totalPacket,in int currentPacket,in int currentPacketLlen,in byte[] data,out int[] ackPacketNum);
    byte sysCmdFormatFilesystem();
    byte sysCmdSetFileDownload(in int fileNameLen,in byte[] fileName,in int fileSize);
    byte sysCmdSendFilePacket(in int totalPacket,in int currentPacket,in int currentPacketLlen,in byte[] data,out int[] ackPacketNum);
    byte sysCmdSetDeviceReboot();
    byte sysCmdOpenWatchdog(in boolean en);
    byte sysCmdSetWatchdogTime(in int reloadTime);
    byte sysCmdCancel();
    byte sysCmdSetFlashData(in int offset,in int dataLen,in byte[] data);
    byte sysCmdGetFlashData(in int offset,in int dataLen,out byte[] outData);

}