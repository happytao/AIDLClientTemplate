// IRSA.aidl
package com.sunyard.vi218asu806.appserver.aidl;

// Declare any non-default types here with import statements

interface IRSA {
    byte sysCmdSM3Get(in byte[] data,in int dataLen,out byte[] outSM3);
    byte sysCmdSM4EnDe(in byte[] WKey,in byte Mode,in byte ECB_CBC,in byte[] IV,in int data_len,in byte[] data,out byte[] outData,out int[] outDataLen);
    byte sysCmdSM2GenKeyPair(in byte indexNum,out byte[] outData);
    int sysCmdSM2SetKeyPair(in byte indexNum,in byte[]privateKey,in byte[] publicKey);
    int sysCmdSM2PriKeySign(in byte indexNum,in byte[] ID,in byte[] data,out byte[] outData);
    int sysCmdSM2PubKeyVerify(in byte indexNum,in byte[] ID,in byte[] data,in byte[] sign,out byte[] outData);
    int sysCmdSM2PubKeyEncry(in byte indexNum,in byte[] data,out byte[] outData);
    int sysCmdSM2PriKeyDecrypt(in byte indexNum,in byte[] data,out byte[] outData,out int[] outDataLen);

   int sysCmdRSAGenKeyPair(in byte[] inData,out byte[] outData);
   int sysCmdRSASetKeyPair(in byte[] inData);
   int sysCmdRSAPriKeySign(in byte[] inData,out byte[] outData);
   int sysCmdRSAPubKeyVerify(in byte[] inData,out byte[] outData);

}