// IMyAidlInterfaceTest.aidl
package com.sunyard.vi218asu806.appserver.aidl;

// Declare any non-default types here with import statements

interface IMyAidlInterfaceTest {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void test();
}