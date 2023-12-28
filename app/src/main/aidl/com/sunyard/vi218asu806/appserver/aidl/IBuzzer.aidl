// IBuzzer.aidl
package com.sunyard.vi218asu806.appserver.aidl;

// Declare any non-default types here with import statements

interface IBuzzer {
    int sysBeep();
    int sysBeef(in byte mode,in int dlyTimeMs);

    byte sysCmdBeep(in int times,in int pwm,in int lastTime,in int toggle);
}