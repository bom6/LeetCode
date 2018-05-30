class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val =x;
	}
}
class AddTwoNumbers{

	public static void main(String[] args){
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode l1 = head1;
		ListNode l2 = head2;
		
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(6);
		l1.next.next.next = new ListNode(3);
		printList(head1.next);

		l2.next = new ListNode(8);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(2);
		printList(head2.next);

		ListNode result = AddTwoNumbers(l1,l2);
		printList(result.next);
	}
	private static void printList(ListNode head){
		while(head != null){
			System.out.print(head.val +"\t");
			head = head.next;
		}
		System.out.println();
	}
	private static ListNode AddTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0); //used to link to the head of the result of the linked list
		ListNode l3 = dummy;
		int carry = 0;
		while(l1 != null && l2 != null){
			int digitValue = (l1.val +l2.val+carry)%10;
			carry  =(l1.val +l2.val+carry)/10;
			ListNode newNode = new ListNode(digitValue);
			l3.next = newNode;
			l3 = newNode;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			int digitValue = (l1.val+carry)%10;
			carry =  (l1.val+carry)/10;
			ListNode newNode = new ListNode(digitValue);
			l3.next = newNode;
			l3 = newNode;
			l1 = l1.next;
		}
		while(l2 != null){
			int digitValue = (l2.val+carry)%10;
			carry =  (l2.val+carry)/10;
			ListNode newNode = new ListNode(digitValue);
			l3.next = newNode;
			l3 = newNode;
			l2 = l2.next;
		}

		if(carry != 0){
			ListNode newNode = new ListNode(carry);
			l3.next = newNode;
			l3 = newNode;
		}
		return dummy.next;
	}
}