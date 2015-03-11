package com.koolob.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] rotate(int[] nums, int k) {
        if(nums.length > 1 && k > 1){
        	if(nums.length > k){
	        	int[] old = new int[nums.length];
	        	for(int i=0;i<nums.length;i++){
	        		if(i < k){
	        			old[i] = nums[nums.length-k+i];
	        		}else{
	        			old[i] = nums[i-k];
	        		}
	        	}
        	}else if(nums.length < k){
        		return rotate(nums,k-nums.length);
        	}
        }
        return nums;
    }
	
	public long reverse(long x) {
		if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
        	return 0;
        }
        String strx = String.valueOf(x);
        boolean isfu = false;
        if(strx.startsWith("-")){
        	isfu = true;
        	strx = strx.substring(1);
        }
        char[] strxs = strx.toCharArray();
        if(strxs.length == 1){
        	return x;
        }
        for(int i=0;i<= strxs.length/2-1;i++){
        	char tmp = strxs[i];
        	strxs[i] = strxs[strxs.length-1-i];
        	strxs[strxs.length-1-i] = tmp;
        }
        String res = new String(strxs);
        if(isfu){
        	res = "-"+res;
        }
        long ret = Long.parseLong(res);
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
        	return 0;
        }
        return ret;
    }
	
	public int trailingZeroes(int n) {
		if( n > Integer.MAX_VALUE || n < 5){
			return 0;
		}
		int total = 0;
		long max5 = 5;
		int mi = 1;
		while(max5 < n){
			if(max5 * 5 > n){
				break;
			}
			max5 *= 5;
			mi++;
		}
		total+=mi;
		for(int i=1;i<mi;i++){
			int give = mi-i;
			total += get5num(i)*give;
		}
		int left = n-(int)max5;
		total += trailingZeroes(left);
		return total;
	}
	private int get5num(int x){
		if(x == 1){
			return 4;
		}else{
			int ret = get5mi(x)-1;
			for(int i=x-1;i>=1;i--){
				ret -= get5num(i);
			}
			return ret;
		}
	}
	
	private int get5mi(int n){
		int ret = 1;
		for(int i=0;i<n;i++){
			ret *= 5;
		}
		return ret;
	}
	
	public int trailingZeroes2(int n) {
		if( n > Integer.MAX_VALUE || n < 5){
			return 0;
		}
		int total = 0;
		int max5 = 5;
		for(int i=0;i<=n;i+=5){
			if(i == 0){
				continue;
			}
			if(i % 5 == 0){
				if(i > max5){
					max5 *= 5;
				}
				int the = 0;
				for(int j = 5;j<=max5;j*=5){
					if(i%j == 0){
						the++;
						continue;
					}else{
						break;
					}
				}
				total += the;
			}
		}
		return total;
	}
	
	public int trailingZeroes3(int n) {
		if( n > Integer.MAX_VALUE || n < 5){
			return 0;
		}
		int ret = 0;
	    for(long i = 5;i<=n;i*=5){
	    	System.out.println(i);
	    	ret += n/i;
	    }
	    return ret;
	}
	
	public int majorityElement(int[] num) {
		int res = 0;
		Map<Integer,Integer> b = new HashMap<Integer,Integer>();
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
			if(b.containsKey(num[i])){
				int all = b.get(num[i])+1;
				b.put(num[i], all);
			}else{
				b.put(num[i], 1);
			}
			if(b.get(num[i]) > num.length/2){
				return num[i];
			}
		}
		return res;
    }

	public String convertToTitle(int n) {
		if(n < 1){
			return "";
		}
		int tail = n%26;
		int next = n/26;
		if(tail == 0){
			tail = 26;
			next = next-1;
		}
		return convertToTitle(next)+(char)(tail+64);
    }
	
	public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        
        int shortl = v1s.length > v2s.length ? v2s.length : v1s.length;
        for(int i = 0;i<shortl;i++){
        	int va = Integer.parseInt(v1s[i]);
        	int vb = Integer.parseInt(v2s[i]);
        	if(va > vb){
        		return 1;
        	}else if(va < vb){
        		return -1;
        	}else{
        		
        	}
        }
        if(v1s.length > v2s.length){
        	for(int i=shortl;i<v1s.length;i++){
        		if(Integer.parseInt(v1s[i]) > 0){
        			return 1;
        		}
        	}
        	return 0;
        }else if(v1s.length < v2s.length){
        	for(int i=shortl;i<v2s.length;i++){
        		if(Integer.parseInt(v2s[i]) > 0){
        			return -1;
        		}
        	}
        	return 0;
        }else{
        	return 0;
        }
    }
	
	public int reverseBits(long n) {
		if(n > Integer.MAX_VALUE){
//			return 0;
		}
		String old = put32(f10to2(n));
		String news = "";
		for(int i=old.length()-1;i>=0;i--){
			news += old.toCharArray()[i];
		}
		long last = f2to10(news);
		if(last > Integer.MAX_VALUE){
//			return 0;
		}
        return (int)last;
    }
	private long f2to10(String n){
		long base = 0;
		for(int i=0;i<n.length();i++){
			int o = Integer.parseInt(""+n.toCharArray()[i]);
			base += o*get2mi(i);
		}
		return base;
	}
	private long get2mi(int n){
		long ret = 1;
		for(int  i=0;i<n;i++){
			ret *= 2;
		}
		return ret;
	}
	private String put32(String n){
		while(n.length() < 32){
			n = "0"+n;
		}
		return n;
	}
	private String f10to2(long n){
		if(n == 0){
			return "0";
		}
		if(n == 1){
			return "1";
		}
		return f10to2(n/2)+n%2;
	}
}
