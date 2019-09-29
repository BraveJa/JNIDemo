//
// Created by Administrator on 2019/9/29.
//

#ifndef JNIDEMO_CALCULATE_H
#define JNIDEMO_CALCULATE_H


#include <jni.h>

jdouble addNumber(JNIEnv *env, jclass clazz, jint a, jint b);

jdouble subNumber(JNIEnv *env, jclass clazz, jint a, jint b);

jdouble mulNumber(JNIEnv *env, jclass clazz, jint a, jint b);

jdouble divNumber(JNIEnv *env, jclass clazz, jint a, jint b);


#endif //JNIDEMO_CALCULATE_H
