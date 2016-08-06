package com.zp.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	
	public static String md5(String pwd) throws NoSuchAlgorithmException{
		
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[]output=md.digest(pwd.getBytes());
		String s=Base64.encodeBase64String(output);
		return s;
	}
	public static String createId(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString().replace("-","");
	}
}
