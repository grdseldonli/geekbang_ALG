package leetcode21;



public class Solution {

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// ListNode l= new ListNode();
	
			 
			 if(l1==null) {
				 return l2;
				 
				 
			 }
			 else if(l2==null) {
				 return l1;
				 
				 
			 }
			 else if(l1.val>=l2.val) {
				 l2.next=mergeTwoLists(l1,l2.next);
				 return l2;
				 
			 }else {
				 l1.next=mergeTwoLists(l1.next,l2);
				 return l1;
				 
				 
			 }
			
				
			 
			 
		 
		 
		 
		 
	    }
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 ListNode l= new ListNode();
	}

}