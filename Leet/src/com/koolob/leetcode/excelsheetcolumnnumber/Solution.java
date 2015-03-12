package com.koolob.leetcode.excelsheetcolumnnumber;

public class Solution {
	
	public int titleToNumber(String s) {
        char[] tile = s.toCharArray();
        int base = 0;
        for(int i = 0;i<tile.length;i++){
        	char ti = tile[i];
        	int q = (int)ti-64;
        	int mi = tile.length-1-i;
        	int the26 = 1;
        	for(int j=0;j<mi;j++){
        		the26 *= 26;
        	}
        	base += q * the26;
        }
        return base;
    }

	public static void main(String[] args) {
		System.out.println(new Solution().titleToNumber("ZZ"));
	}

}
