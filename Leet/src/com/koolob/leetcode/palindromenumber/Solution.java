package com.koolob.leetcode.palindromenumber;

public class Solution {
	
	public boolean isPalindrome(int x) {
        String strx = ""+x;
        if(strx.length() == 1){
        	return true;
        }
        for(int i=0;i<strx.length()/2;i++){
        	if(strx.charAt(i) != strx.charAt(strx.length()-1-i)){
        		return false;
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(123454321));
	}

}
