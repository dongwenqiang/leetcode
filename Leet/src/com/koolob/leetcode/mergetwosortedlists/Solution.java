package com.koolob.leetcode.mergetwosortedlists;

public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 != null){
			return l2;
		}else if(l1 != null && l2 == null){
			return l1;
		}else if(l1 == null && l2 == null){
			return null;
		}else{
			ListNode ret = null;
			if(l1.val > l2.val){
				ret = new ListNode(l2.val);
				ret.next = mergeTwoLists(l1,l2.next);
			}else if(l1.val < l2.val){
				ret = new ListNode(l1.val);
				ret.next = mergeTwoLists(l1.next,l2);
			}else{
				ret = new ListNode(l1.val);
				ret.next = new ListNode(l2.val);
				ret.next.next = mergeTwoLists(l1.next,l2.next);
			}
			return ret;
        }
    }
	
	public static void main(String[] args){
	}
}
