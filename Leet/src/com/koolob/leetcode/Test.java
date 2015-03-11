package com.koolob.leetcode;

import java.math.BigInteger;

public class Test {
	
	public static void main(String[] args) {
		int o = 25000;
		BigInteger res = new BigInteger("1");
		while(o > 0){
			res = res.multiply(new BigInteger(""+o));
			o--;
		}
		System.out.println(res.toString());
	}

}
