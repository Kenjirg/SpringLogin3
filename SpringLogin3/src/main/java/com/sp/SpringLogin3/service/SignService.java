package com.sp.SpringLogin3.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.conf.PropertyDefinitions.ZeroDatetimeBehavior;
import com.sp.SpringLogin3.entities.User;
import com.sp.SpringLogin3.repository.UserRepository;

@Service
public class SignService {

	@Autowired
	private UserRepository userRepository;

	public Boolean signUp(User user) {// 註冊會員
		System.out.println("svc signUp");
		// ckEmail
		if (!emailVali(user.getEmail())) {
			System.out.println("email錯誤");
			return false;
		}
		// encode
		System.out.println(user);
		if (user.getPassword() != "") {
			String enc = encode(user.getPassword());
			user.setPassword(enc);
		}
		System.out.println(user);
		// DAO
		return userRepository.createUser(user);
	}

	private Boolean emailVali(String email) {// 檢查email
		String regexEmail = "^\\w{1,10}@[a-zA-Z0-9]{2,10}\\.[a-zA-Z]{2,10}(\\.[a-zA-Z]{2,10})?$";
//		String test = "aaa@somewhere.com";
		return email.matches(regexEmail);
	}

	private String encode(String str) {
		String result = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			byte[] bArray1 = str.getBytes();
			mDigest.update(bArray1);
			byte[] bArray2 = mDigest.digest();
			result = bArrToStr(bArray2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	private String bArrToStr(byte[] b) {
		char[] dgs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] cArray = new char[b.length * 2];

		int i = 0;
		for (byte z : b) {
			cArray[i++] = dgs[z >>> 4 & 0xf];
			cArray[i++] = dgs[z & 0xf];
		}

		String s = new String(cArray);
		return s;
	}

	@Test
	public void test() {
		String regexEmail = "^\\w{1,10}@[a-zA-Z0-9]{2,10}\\.[a-zA-Z]{2,10}(\\.[a-zA-Z]{2,10})?$";
		String test = "aaa@somewhere.com";
		System.out.println(test.matches(regexEmail));

	}
}
