package com.sunyard.vi218asu806.appserver.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Crypt implements Parcelable {
    //密钥类型 MKeyType
    public static final int DecipherMasterKey = 0;    /* 数据解密主密钥*/
    public static final int EncryptMasterKey = 1;    /* 数据加密主密钥 */
    public static final int PinMasterKey = 2;        /* PIN加密主密钥*/

    //DesType
    public static final byte DES_TYPE_SINGLE = 0x00;    /* 单DES */
    public static final byte DES_TYPE_DOUBLE = 0x01;    /* 双DES */
    public static final byte DES_TYPE_TRIPLE = 0x02;/* 3DES */
    public static final byte DES_TYPE_SM4 = 0x03;/* SM4 */

//    MkeyVerifyPara theMkeyVerifyPara = new MkeyVerifyPara();
//    EnDePara theEnDePara = new EnDePara();
//    MACPara theMACPare = new MACPara();
    /**
     * 主密钥数据
     * PKeyInfo
     */
    //PKeyInfo
    byte ucAlgType;
    byte ucEcbOrCbc;
    byte ucKTransType;
    byte[] ucKey = new byte[24];
    byte ucIVLen;
    byte[] ucIV = new byte[16];
    byte ucKVMode;
    byte ucKVDataLen;
    byte[] pKVData;
    byte ucKVLen;
    byte[] pKV;

    /**
     * 工作密钥数据
     */
    //MK_Verify_Para    /*定义密钥管理接口数据结构*/
    //public static class MkeyVerifyPara {
        byte MKeyID;  /* ******主密钥ID号*****/
//        byte MkeyType;           /*指定的MkeyID对应的密钥的算法类型*/
        short DataLen;           /*待加密或解密的数据长度*/
        byte[] Data = new byte[1204];           /*待校验数据*/

    /**
     * 单独采集用户输入PIN
     * PINCtlPara
     */
    //public class PINCTL { /*PIN输入控制结构*/
        byte enterUseFlag;
        int timeout;
        byte MIN;
        byte MAX;

    /**
     * 单独求用户PINBlock
     * PINBLOCK_IF
     */
    //public class PINBLOCK_IF{ /*定义获取PINBLOCK接口*/
        byte mode;
        byte PkeyID;
        short UseCnt;
        byte PinEnumLen;
        byte[] PinEnum;
        byte[] Card = new byte[16];

    /**
     * DES类/SM4加解密 ECB/CBC可选
     * 密钥管理接口数据结构 EnDePara
     */
    //public class EnDePara {        /*定义密钥管理接口数据结构*/
        byte wKeyID;           /********工作密钥ID号*****/
        //byte mode;
        byte ECB_CBC;               /*使用WkeyID对应的密钥的算法类型进行加解密*/
        //short DataLen;           /*待加密或解密的数据长度*/
        //byte[] Data;           /*待加密或解密的数据*/
        byte[] IV = new byte[16];

    /**
     * MAC加密命令_ECB/CBC可选
     * 钥管理接口数据结构
     */
//    public class MACPara {        /*定义密钥管理接口数据结构*/
    byte mac_wKeyID;           /********工作密钥ID号*****/
    byte mac_mode;
    byte mac_ECB_CBC;               /*使用WkeyID对应的密钥的算法类型进行加解密*/
    short mac_dataLen;           /*待加密或解密的数据长度*/
    byte[] mac_data;           /*待加密或解密的数据*/
    byte[] mac_IV = new byte[16];


    protected Crypt(Parcel in) {
        ucAlgType = in.readByte();
        ucEcbOrCbc = in.readByte();
        ucKTransType = in.readByte();
        ucKey = in.createByteArray();
        ucIVLen = in.readByte();
        ucIV = in.createByteArray();
        ucKVMode = in.readByte();
        ucKVDataLen = in.readByte();
        pKVData = in.createByteArray();
        ucKVLen = in.readByte();
        pKV = in.createByteArray();
        MKeyID = in.readByte();
        DataLen = (short) in.readInt();
        Data = in.createByteArray();
        enterUseFlag = in.readByte();
        timeout = in.readInt();
        MIN = in.readByte();
        MAX = in.readByte();
        mode = in.readByte();
        PkeyID = in.readByte();
        UseCnt = (short) in.readInt();
        PinEnumLen = in.readByte();
        PinEnum = in.createByteArray();
        Card = in.createByteArray();
        wKeyID = in.readByte();
        ECB_CBC = in.readByte();
        IV = in.createByteArray();
        mac_wKeyID = in.readByte();
        mac_mode = in.readByte();
        mac_ECB_CBC = in.readByte();
        mac_dataLen = (short) in.readInt();
        mac_data = in.createByteArray();
        mac_IV = in.createByteArray();
    }

    public Crypt() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(ucAlgType);
        dest.writeByte(ucEcbOrCbc);
        dest.writeByte(ucKTransType);
        dest.writeByteArray(ucKey);
        dest.writeByte(ucIVLen);
        dest.writeByteArray(ucIV);
        dest.writeByte(ucKVMode);
        dest.writeByte(ucKVDataLen);
        dest.writeByteArray(pKVData);
        dest.writeByte(ucKVLen);
        dest.writeByteArray(pKV);
        dest.writeByte(MKeyID);
        dest.writeInt((int) DataLen);
        dest.writeByteArray(Data);
        dest.writeByte(enterUseFlag);
        dest.writeInt(timeout);
        dest.writeByte(MIN);
        dest.writeByte(MAX);
        dest.writeByte(mode);
        dest.writeByte(PkeyID);
        dest.writeInt((int) UseCnt);
        dest.writeByte(PinEnumLen);
        dest.writeByteArray(PinEnum);
        dest.writeByteArray(Card);
        dest.writeByte(wKeyID);
        dest.writeByte(ECB_CBC);
        dest.writeByteArray(IV);
        dest.writeByte(mac_wKeyID);
        dest.writeByte(mac_mode);
        dest.writeByte(mac_ECB_CBC);
        dest.writeInt((int) mac_dataLen);
        dest.writeByteArray(mac_data);
        dest.writeByteArray(mac_IV);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Crypt> CREATOR = new Creator<Crypt>() {
        @Override
        public Crypt createFromParcel(Parcel in) {
            return new Crypt(in);
        }

        @Override
        public Crypt[] newArray(int size) {
            return new Crypt[size];
        }
    };

    public byte getUcAlgType() {
        return ucAlgType;
    }

    public void setUcAlgType(byte ucAlgType) {
        this.ucAlgType = ucAlgType;
    }

    public byte getUcEcbOrCbc() {
        return ucEcbOrCbc;
    }

    public void setUcEcbOrCbc(byte ucEcbOrCbc) {
        this.ucEcbOrCbc = ucEcbOrCbc;
    }

    public byte getUcKTransType() {
        return ucKTransType;
    }

    public void setUcKTransType(byte ucKTransType) {
        this.ucKTransType = ucKTransType;
    }

    public byte[] getUcKey() {
        return ucKey;
    }

    public void setUcKey(byte[] ucKey) {
        this.ucKey = ucKey;
    }

    public byte getUcIVLen() {
        return ucIVLen;
    }

    public void setUcIVLen(byte ucIVLen) {
        this.ucIVLen = ucIVLen;
    }

    public byte[] getUcIV() {
        return ucIV;
    }

    public void setUcIV(byte[] ucIV) {
        this.ucIV = ucIV;
    }

    public byte getUcKVMode() {
        return ucKVMode;
    }

    public void setUcKVMode(byte ucKVMode) {
        this.ucKVMode = ucKVMode;
    }

    public byte getUcKVDataLen() {
        return ucKVDataLen;
    }

    public void setUcKVDataLen(byte ucKVDataLen) {
        this.ucKVDataLen = ucKVDataLen;
    }

    public byte[] getpKVData() {
        return pKVData;
    }

    public void setpKVData(byte[] pKVData) {
        this.pKVData = pKVData;
    }

    public byte getUcKVLen() {
        return ucKVLen;
    }

    public void setUcKVLen(byte ucKVLen) {
        this.ucKVLen = ucKVLen;
    }

    public byte[] getpKV() {
        return pKV;
    }

    public void setpKV(byte[] pKV) {
        this.pKV = pKV;
    }

    public byte getMKeyID() {
        return MKeyID;
    }

    public void setMKeyID(byte MKeyID) {
        this.MKeyID = MKeyID;
    }

    public short getDataLen() {
        return DataLen;
    }

    public void setDataLen(short dataLen) {
        DataLen = dataLen;
    }

    public byte[] getData() {
        return Data;
    }

    public void setData(byte[] data) {
        Data = data;
    }

    public byte[] getIV() {
        return IV;
    }

    public void setIV(byte[] IV) {
        this.IV = IV;
    }

    public byte getEnterUseFlag() {
        return enterUseFlag;
    }

    public void setEnterUseFlag(byte enterUseFlag) {
        this.enterUseFlag = enterUseFlag;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public byte getMIN() {
        return MIN;
    }

    public void setMIN(byte MIN) {
        this.MIN = MIN;
    }

    public byte getMAX() {
        return MAX;
    }

    public void setMAX(byte MAX) {
        this.MAX = MAX;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }

    public byte getPkeyID() {
        return PkeyID;
    }

    public void setPkeyID(byte pkeyID) {
        PkeyID = pkeyID;
    }

    public short getUseCnt() {
        return UseCnt;
    }

    public void setUseCnt(short useCnt) {
        UseCnt = useCnt;
    }

    public byte getPinEnumLen() {
        return PinEnumLen;
    }

    public void setPinEnumLen(byte pinEnumLen) {
        PinEnumLen = pinEnumLen;
    }

    public byte[] getPinEnum() {
        return PinEnum;
    }

    public void setPinEnum(byte[] pinEnum) {
        PinEnum = pinEnum;
    }

    public byte[] getCard() {
        return Card;
    }

    public void setCard(byte[] card) {
        Card = card;
    }

    public byte getwKeyID() {
        return wKeyID;
    }

    public void setwKeyID(byte wKeyID) {
        this.wKeyID = wKeyID;
    }

    public byte getECB_CBC() {
        return ECB_CBC;
    }

    public void setECB_CBC(byte ECB_CBC) {
        this.ECB_CBC = ECB_CBC;
    }

    public byte getMac_wKeyID() {
        return mac_wKeyID;
    }

    public void setMac_wKeyID(byte mac_wKeyID) {
        this.mac_wKeyID = mac_wKeyID;
    }

    public byte getMac_mode() {
        return mac_mode;
    }

    public void setMac_mode(byte mac_mode) {
        this.mac_mode = mac_mode;
    }

    public byte getMac_ECB_CBC() {
        return mac_ECB_CBC;
    }

    public void setMac_ECB_CBC(byte mac_ECB_CBC) {
        this.mac_ECB_CBC = mac_ECB_CBC;
    }

    public short getMac_dataLen() {
        return mac_dataLen;
    }

    public void setMac_dataLen(short mac_dataLen) {
        this.mac_dataLen = mac_dataLen;
    }

    public byte[] getMac_data() {
        return mac_data;
    }

    public void setMac_data(byte[] mac_data) {
        this.mac_data = mac_data;
    }

    public byte[] getMac_IV() {
        return mac_IV;
    }

    public void setMac_IV(byte[] mac_IV) {
        this.mac_IV = mac_IV;
    }
}
