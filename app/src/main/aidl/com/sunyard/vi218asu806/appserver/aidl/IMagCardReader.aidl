// IMagCardReader.aidl
package com.sunyard.vi218asu806.appserver.aidl;

parcelable TimeT;

// Declare any non-default types here with import statements

interface IMagCardReader {
    byte sysCmdOpenMagcard();
    TimeT sysCmdReadMagcard(in int timeout);
    byte sysCmdCloseMagcard();
}