package com.koolob.leetcode.singlenumberll;


public class Solution {

	public int singleNumber(int[] A) {
		
        java.util.Arrays.sort(A);
        int ret = 0;
        int cur = 0;
        while(cur < A.length){
        	ret = A[cur];
        	if(cur == A.length-1){
        		break;
        	}else if(A[cur] == A[cur+1]){
        		cur = cur+3;
        	}else{
        		break;
        	}
        }
        return ret;
    }
	public int singleNumber2(int[] A) {
        int ret = 0;
        java.util.Set<Integer> tmp = new java.util.HashSet<Integer>();
        for(int i=0;i<A.length;i++){
        	if(tmp.contains(A[i])){
        		tmp.remove(A[i]);
        	}else{
        		tmp.add(A[i]);
        	}
        }
        ret = tmp.iterator().next();
        return ret;
    }
	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber2(new int[]{5,2,4,5,2,6,6}));

	}

}
