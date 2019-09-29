package com.example.jnidemo;

/**
 * 动态注册native方法 ,native中的方法名不需要遵循命名格式
 */
public class JNITools2 {

	static {
		System.loadLibrary("native-lib");
	}

	public static native double add2(int a, int b);

	public static native double sub2(int a, int b);

	public static native double mul2(int a, int b);

	public static native double div2(int a, int b);

}
