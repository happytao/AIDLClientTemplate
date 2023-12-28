package com.sunyard.vi218asu806.appserver.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class TimeT implements Parcelable {
    byte mStatus;
    char year;
    byte month;
    byte day;
    byte hour;
    byte minute;
    byte second;

    int nTrackLen1;		// > 0, the length of track. =0 no data <0, track error
    int nTrackLen2;
    int nTrackLen3;

    byte[] strTrackData1;
    byte[] strTrackData2;
    byte[] strTrackData3;

    public TimeT(){}

    protected TimeT(Parcel in) {
        mStatus = in.readByte();
        year = (char) in.readInt();
        month = in.readByte();
        day = in.readByte();
        hour = in.readByte();
        minute = in.readByte();
        second = in.readByte();
        nTrackLen1 = in.readInt();
        nTrackLen2 = in.readInt();
        nTrackLen3 = in.readInt();
        strTrackData1 = in.createByteArray();
        strTrackData2 = in.createByteArray();
        strTrackData3 = in.createByteArray();
    }

    public static final Creator<TimeT> CREATOR = new Creator<TimeT>() {
        @Override
        public TimeT createFromParcel(Parcel in) {
            return new TimeT(in);
        }

        @Override
        public TimeT[] newArray(int size) {
            return new TimeT[size];
        }
    };

    public int getnTrackLen1() {
        return nTrackLen1;
    }

    public void setnTrackLen1(int nTrackLen1) {
        this.nTrackLen1 = nTrackLen1;
    }

    public int getnTrackLen2() {
        return nTrackLen2;
    }

    public void setnTrackLen2(int nTrackLen2) {
        this.nTrackLen2 = nTrackLen2;
    }

    public int getnTrackLen3() {
        return nTrackLen3;
    }

    public void setnTrackLen3(int nTrackLen3) {
        this.nTrackLen3 = nTrackLen3;
    }

    public byte[] getStrTrackData1() {
        return strTrackData1;
    }

    public void setStrTrackData1(byte[] strTrackData1) {
        this.strTrackData1 = strTrackData1;
    }

    public byte[] getStrTrackData2() {
        return strTrackData2;
    }

    public void setStrTrackData2(byte[] strTrackData2) {
        this.strTrackData2 = strTrackData2;
    }

    public byte[] getStrTrackData3() {
        return strTrackData3;
    }

    public void setStrTrackData3(byte[] strTrackData3) {
        this.strTrackData3 = strTrackData3;
    }
//public void TimeT() {}


    public byte getmStatus() {
        return mStatus;
    }

    public void setmStatus(byte mStatus) {
        this.mStatus = mStatus;
    }

    public char getYear() {
        return year;
    }

    public void setYear(char year) {
        this.year = year;
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    public byte getHour() {
        return hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinute() {
        return minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeByte(mStatus);
        dest.writeInt((int) year);
        dest.writeByte(month);
        dest.writeByte(day);
        dest.writeByte(hour);
        dest.writeByte(minute);
        dest.writeByte(second);
        dest.writeInt(nTrackLen1);
        dest.writeInt(nTrackLen2);
        dest.writeInt(nTrackLen3);
        dest.writeByteArray(strTrackData1);
        dest.writeByteArray(strTrackData2);
        dest.writeByteArray(strTrackData3);
    }
}
