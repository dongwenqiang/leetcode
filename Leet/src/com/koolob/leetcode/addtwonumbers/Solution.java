package com.koolob.leetcode.addtwonumbers;

public class Solution {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode ret = null;
		String l1num = "";
		String l2num = "";
		while(l1 != null){
			l1num = ""+l1.val + l1num;
			l1 = l1.next;
		}
		while(l2 != null){
			l2num = ""+l2.val+l2num;
			l2 = l2.next;
		}
		String res =""+ (Long.parseLong(l1num)+Long.parseLong(l2num));
		ret = new ListNode(Integer.parseInt(res.substring(0,1)));
		for(int i=1;i<res.length();i++){
			ListNode tmp = ret;
			ret = new ListNode(Integer.parseInt(res.substring(i,i+1)));
			ret.next = tmp;
		}
		return ret;
    }
	

	public static void main(String[] args) {
		ListNode a2 = new ListNode(2);
		ListNode a4 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a2.next = a4;
		a4.next = a3;
		
		ListNode b5 = new ListNode(5);
		ListNode b6 = new ListNode(6);
		ListNode b4 = new ListNode(4);
		b5.next = b6;
		b6.next = b4;
		
		ListNode ret = new Solution().addTwoNumbers(a2, b5);
		while(ret != null){
			System.out.print(ret.val);
			ret = ret.next;
		}
	}

}
