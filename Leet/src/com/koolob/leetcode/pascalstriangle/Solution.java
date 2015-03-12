package com.koolob.leetcode.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
        	return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i=1;i<=numRows;i++){
        	if(i == 1){
        		List<Integer> line = new ArrayList<Integer>();
        		line.add(1);
        		ret.add(line);
        	}
        	if(i == 2){
        		List<Integer> line = new ArrayList<Integer>();
        		line.add(1);
        		line.add(1);
        		tmp.add(2);
        		ret.add(line);
        	}
        	if( i >= 3){
        		List<Integer> line = new ArrayList<Integer>();
        		for(int j = 0;j<i;j++){
        			if(j == 0){
        				line.add(1);
        			}else if(j == i-1){
        				line.add(1);
        				int nextline = line.get(j-1)+1;
        				tmp.add(nextline);
        			}else{
        				int lastline = tmp.get(j-1);
        				line.add(lastline);
        				int nextline = line.get(j-1)+lastline;
        				tmp.set(j-1, nextline);
        			}
        		}
        		ret.add(line);
        	}
        }
        return ret;
    }
	

	public static void main(String[] args) {
		List<List<Integer>> ret = new Solution().generate(10);
		for(List<Integer> line : ret){
			for(int i:line){
				System.out.print(i+" ");
			}
			System.out.print("\n");
		}
	}

}
