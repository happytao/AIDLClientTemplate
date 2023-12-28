package com.sunyard.vi218asu806.appserver.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author liubo
 * @Date 2021/8/27
 * @功能描述：
 */
public class PinContext implements Parcelable {
    public byte[] prompt;
    public byte[] font;
    public byte[] background;

    protected PinContext(Parcel in) {
        prompt = in.createByteArray();
        font = in.createByteArray();
        background = in.createByteArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(prompt);
        dest.writeByteArray(font);
        dest.writeByteArray(background);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PinContext> CREATOR = new Creator<PinContext>() {
        @Override
        public PinContext createFromParcel(Parcel in) {
            return new PinContext(in);
        }

        @Override
        public PinContext[] newArray(int size) {
            return new PinContext[size];
        }
    };
}
