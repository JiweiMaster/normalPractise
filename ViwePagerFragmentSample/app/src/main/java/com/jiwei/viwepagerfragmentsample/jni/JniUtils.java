package com.jiwei.viwepagerfragmentsample.jni;

public class JniUtils {
    static {
        System.loadLibrary("hello");
    }

    public static native String Hello();
}
