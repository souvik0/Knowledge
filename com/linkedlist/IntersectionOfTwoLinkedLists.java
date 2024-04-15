package com.linkedlist;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        Node<Integer> commonNode = new Node<Integer>(7);

        Node<Integer> list1 = new Node<Integer>(1);
        list1.next = new Node<Integer>(2);
        list1.next.next = new Node<Integer>(3);
        list1.next.next.next = commonNode;

        Node<Integer> list2 = new Node<Integer>(4);
        list2.next = new Node<Integer>(5);
        list2.next.next = commonNode;

        System.out.println("Intersection point: " + getIntersectionNode(list1, list2).data);
    }

    public static Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        // Move pointer of the longer list forward by the difference in lengths
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Traverse both lists until they intersect
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; // or headB; they both point to the intersection node
    }

    // Method to calculate the length of a linked list
    public static int length(Node<Integer> head) {
        int len = 0;
        Node<Integer> current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }
}
