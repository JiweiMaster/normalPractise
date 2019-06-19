//
// Created by 18099 on 2019/6/19.
//

#include "Hello.h"
#include "stdio.h"
JNIEXPORT jstring JNICALL Java_com_jiwei_viwepagerfragmentsample_jni_JniUtils_Hello(JNIEnv * env, jclass jclass){
    return env->NewStringUTF("Hello World From JNI!!!!!");
}


