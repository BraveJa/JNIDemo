package com.example.jnidemo;

/**
 * 静态注册
 */
public class JNITools {

	static {
		System.loadLibrary("native-lib");
	}
	public static native double add(int a, int b);

	public static native double sub(int a, int b);

	public static native double mul(int a, int b);

	public static native double div(int a, int b) ;

}
