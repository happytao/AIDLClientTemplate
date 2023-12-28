// IPinPad.aidl
package com.sunyard.vi218asu806.appserver.aidl;
import com.sunyard.vi218asu806.appserver.aidl.PinContext;
import com.sunyard.vi218asu806.appserver.aidl.Crypt;


// Declare any non-default types here with import statements

interface IPinPad {
    byte sysCmdLoadMasterKey(in byte mKeyID,in byte mKeyType,in Crypt PKeyInfo);
    byte sysCmdLoadWorkKey(in byte mKeyID,in byte wKeyID,in byte wKeyType,in Crypt MKey,in int useNo);
    byte sysCmdGetRandom(out byte[] random);
    byte sysCmdGetMKVerify(in Crypt mKPara,out byte[] outData);
    byte sysCmdPINGather(in Crypt PINCtlPara);
    byte sysCmdGetPINCode(out byte[] code,in int timeout);
    byte sysCmdPINCancel();
    byte sysCmdGetPINBlock(in Crypt PINPara,out byte[] noKeyFlag,out byte[] encryData,out byte[] encryDataLen);
    byte sysCmdDataEnDe(in Crypt EnDePara,out byte[] outData);
    byte sysCmdMacEn(in Crypt data,out byte[] outData,out int[] outLen);
    byte sysCmdCheckKey(in byte key_type,in byte key_ID,in byte WKey_type,out byte[] data);
    byte sysCmdCleanKey(in byte keyType,in byte keyId,in byte WKey_type);
    byte sysCmdCleanKeys(in byte keyType);
    byte sysCmdDownloadTranskey(in byte tKeyID,in byte decTkKeyID,in Crypt PKeyInfo);

    byte sysCmdGetKey(out byte[] key,in int timeOutMs);
    byte sysCmdKeypadOpen();
    byte sysCmdGetKeypad(out byte[] code);
    byte sysCmdKeypadClose();

    byte sysCmdKeypadBeepCtrl(in int time,in byte type);
    byte test();

}