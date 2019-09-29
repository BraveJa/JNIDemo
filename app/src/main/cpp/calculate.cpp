//
// Created by Administrator on 2019/9/29.
//

#include <jni.h>
#include "calculate.h"
#include <android/log.h>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

jdouble addNumber(JNIEnv *env, jclass clazz, jint a, jint b) {
    return a + b;
}

jdouble subNumber(JNIEnv *env, jclass clazz, jint a, jint b) {
    return a - b;
}

jdouble mulNumber(JNIEnv *env, jclass clazz, jint a, jint b) {
    return a * b;
}

jdouble divNumber(JNIEnv *env, jclass clazz, jint a, jint b) {
    return a / b;
}


//重写JNI_ONLoad()方法
JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    //打印日志，说明已经进来了
    __android_log_print(ANDROID_LOG_DEBUG, "JNITag", "enter jni_onload");

    //判断是否能获取到env
    JNIEnv *env = nullptr;
    jint i = vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6);
    if (i != JNI_OK) {
        __android_log_print(ANDROID_LOG_DEBUG, "JNITag", "enter jni_onload error , env is NULL");

        return JNI_ERR;
    }


    //注册Native要使用到的几个方法

    const JNINativeMethod method[] =
            {
                    {"add2", "(II)D", (void *) addNumber},
                    {"sub2", "(II)D", (void *) subNumber},
                    {"mul2", "(II)D", (void *) mulNumber},
                    {"div2", "(II)D", (void *) divNumber}

            };

    //找到java类
    jclass jclazz = (*env).FindClass("com/example/jnidemo/JNITools2");


//native方法和java方法绑定
    jint ret = (*env).RegisterNatives(jclazz, method, 4);
    //如果注册失败，打印日志
    if (ret != JNI_OK) {
        __android_log_print(ANDROID_LOG_DEBUG, "JNITag",
                            "jni_register Error, method register fail");
        return JNI_ERR;
    }

    return JNI_VERSION_1_6;
}