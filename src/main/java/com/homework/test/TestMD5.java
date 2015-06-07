package com.homework.test;

import org.apache.commons.codec.digest.DigestUtils;


public class TestMD5 {

	public static void main(String[] args) {
	String password = "123456";
	String hash_password = DigestUtils.md5Hex(password);
	System.out.println("hash_password = "+ hash_password);
	}
}
