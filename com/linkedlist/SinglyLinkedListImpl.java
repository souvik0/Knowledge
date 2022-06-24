package com.linkedlist;

public class SinglyLinkedListImpl<T> {

    public Node<T> start, end; // Start & end pointer of linked list
    public int size;

    public SinglyLinkedListImpl() {
        start = end = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmptyList() {
        if (start == null || getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getTotalNodes(Node<T> start) {
        int counter = 0;
        Node<T> current = start;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public int getTotalIntegerNodes(Node<Integer> start) {
        int counter = 0;
        Node<Integer> current = start;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public void insertAtFirst(T data) {
        Node<T> nptr = new Node<T>(data);
        // if the list is empty
        if (isEmptyList()) {
            start = end = nptr;
        } else {
            nptr.next = start;
            start = nptr;
        }
        size++;
    }

    public void insertAtLast(T data) {
        Node<T> nptr = new Node<T>(data);
        // if the list is empty
        if (isEmptyList()) {
            start = end = nptr;
        } else {
            end.next = nptr;
            end = nptr;
        }
        size++;
    }

    public void insertAtAnyPosition(T data, int position) {
        Node<T> nptr = new Node<T>(data);
        int relativePos = position -1;
        Node<T> ptr = start; // ptr is a temporary moving pointers
        for (int i = 0 ; i < getSize(); i++) {
             if (i == relativePos) {
                 Node<T> tmp = ptr.next;
                 ptr.next = nptr;
                 nptr.next = tmp;
                 break;
             } else {
                 ptr = ptr.next;
             }
        }
        size++;
    }

    public T findMiddleElement(Node<T> start) {
        Node<T> fastPointer = start;
        Node<T> slowPointer = start;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer.data;
    }

    /* Argument n to find out position */
    public T nthElementFromLast(int n) {
        Node<T> fastPointer = start;
        Node<T> slowPointer = start;

        for (int i = 0; i < n; i++) {
             fastPointer = fastPointer.next;
        }

        // moving fastPointer from n to End
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer.data;
    }

    public T nthElementFromFirst(int n) {
        Node<T> fastPointer = start;
        Node<T> slowPointer = start;

        for (int i = 0; i < getSize()-n-1; i++) {
             fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer.data;
    }

    public boolean ifLoopExist() {
        Node<T> fastPointer = start;
        Node<T> slowPointer = start;
        boolean loopExist = false;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                loopExist = true;
            }
        }

        return loopExist;
    }

    public T detectFirstLoopNode() {
        Node<T> fastPointer = start;
        Node<T> slowPointer = start;
        boolean ifLoopExist = false;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                ifLoopExist = true;
            }
        }

        if (ifLoopExist) {
           slowPointer = start;
           while (fastPointer != slowPointer) {
               fastPointer = fastPointer.next;
               slowPointer = slowPointer.next;
           }
        }

        return slowPointer.data;
    }

    public boolean deleteLoopNode() {
        Node<T> fastPointer = start;
        Node<T> slowPointer = start;
        boolean ifLoopExist = false;
        boolean deleted = false;

        while (fastPointer != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                ifLoopExist = true;
            }
        }

        if (ifLoopExist) {
           slowPointer = start;
           while (fastPointer != slowPointer) {
               fastPointer = fastPointer.next;
               slowPointer = slowPointer.next;
           }
           // Breaking the list
           if (fastPointer.next != null) {
               fastPointer.next = null;  // Breaking the list
               deleted = true;
           }
        }

        return deleted;
    }

    public void deleteFromAnyPosition(int position) {
        int relativePos = position - 1;
        // deleting node from 1st position

        if (relativePos == 0) {
           start = start.next;
           size--;
        }

        //delete from last position 
        else if (relativePos == getSize()-1) {
            Node<T> t = start;
            Node<T> s = start;
            while (t != end) {
                t = s;
                s = s.next;
            }
            end = t;
            end.next = null;
            size--;
        }

        // deleting from any middle position
        else {
            Node<T> ptr = start;
            for (int i = 0; i < getSize(); i++) {
                 if (i == relativePos) {
                     Node<T> tmp = ptr.next;
                     ptr.next = tmp.next;
                     break;
                 } else {
                     ptr = ptr.next;
                 }
            }
            size --;
        }
    }

    public Node<T> reverseLinkedListWithRecusrion(Node<T> start) {
        Node<T> restNode = null;
        //If the list is empty or having only one node
        if (start == null || start.next == null) {
            return start;
        } else {
            Node<T> nextNode = start.next;
            // To point start node at the end
            start.next = null;

            if (nextNode != null) {
                restNode = reverseLinkedListWithRecusrion(nextNode);
            }
            // Last node should always points to start node
            nextNode.next = start;
            // restNode is the new Head of reversed list
            return restNode;
        }
    }

    // Consider a linked list 5->6->7
    public Node<T> reverseLinkedListInPairs(Node<T> start) {
        if (start == null || start.next == null) {
            return start;
        } else {
            //nextNode points to 6 & start points to 5
            Node<T> nextNode = start.next;
            // establish a connection between start(5) & 7 node
            start.next = nextNode.next;
            //make nextNode as new head
            nextNode.next = start;
            //Recursively calling for next pairs
            if (start.next != null) {
                start.next = reverseLinkedListInPairs(start.next);
            }
            // As nextNode becomes new head. So return nextNode
            return nextNode;
        }
    }

    public Node<T> rotateLinkedListByKPosition(int k) {
        Node<T> current = start;

        if (k == 0) {
            return current;
        } else {
            if (isEmptyList()) {
                return null;
            }
            // move current node up to k position to point out kth Node
            int counter = 0;
            while (counter++ < k && current != null) {
                current = current.next;
            }
            Node<T> kthNode = current.next;

            // Move current node up to last but one of linked list
            while (current.next != null) {
                current = current.next;
            }

            // Last Node points back to start node
            current.next = start;
            // Start node should be next node of kth Node to move k position
            start = kthNode.next;
            // kth Node should point to null to to break the list at this point & make kthNode as last node
            kthNode.next = null;

            return start;
        }
    }

    // This problem is similar to reverse in pairs or rotate in pairs
    // Here only difference is swapping will take place based on value of k
    public Node<T> rotateLinkedListInGroupOfK(Node<T> start, int k) {
        if (isEmptyList()) {
            return null;
        }

        Node<T> current = start;
        Node<T> previous = null;
        int counter = 0;

        // Iterate through the list and move/insert each node to the
        // front of the resultant list (like a push of the node)
        while (counter++ < k && current != null) {
            Node<T> nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        while (current != null) {
            start.next = rotateLinkedListInGroupOfK(current, k);
        }

        /* previous node is the head node of every group of k nodes
           So, previous node becomes head node of first group of k nodes also 
        */
        return previous;
    }

    public boolean ifLinkedListIsPalindrome(Node<T> start) {
        boolean isListPalindrome = true;
        T middleNodeData = findMiddleElement(start);
        Node<T> middleNode = new Node<T>(middleNodeData);
        //Breaking the list in two parts
        Node<T> secondPartStart = middleNode.next;
        middleNode.next = null;
        // Finding out reverse head of the 2nd part of list
        Node<T> reverseSecondPartStart = reverseLinkedListWithRecusrion(secondPartStart);

        while (start != null && reverseSecondPartStart != null) {
            if (start.data == reverseSecondPartStart.data) {
                start = start.next;
                reverseSecondPartStart = reverseSecondPartStart.next;
                continue;
            } else {
                isListPalindrome = false;
                break;
            }
        }

        return isListPalindrome;
    }

    // Sorting the composite list in ascending order
    public Node<Integer> mergeTwoSinglySortedLinkedList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> mergedHead = null;

        if (head1 == null) {
            mergedHead = head2;
        } else if (head2 == null) {
            mergedHead = head1;
        } else if (head1.data < head2.data) {
            mergedHead = head1;
            mergedHead.next = mergeTwoSinglySortedLinkedList(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeTwoSinglySortedLinkedList(head1, head2.next);
        }

        return mergedHead;
    }

    // To get intersection node of two linked list
    public Node<T> getIntersectionNode(Node<T> head1, Node<T> head2) {
        int totalNodesFromList1 = getTotalNodes(head1);
        int totalNodesFromList2 = getTotalNodes(head2);

        if (totalNodesFromList1 > totalNodesFromList2) {
            int diff = totalNodesFromList1 - totalNodesFromList2;
            return getIntersectionNode(diff, head1, head2);
        } else if (totalNodesFromList2 > totalNodesFromList1) {
            int diff = totalNodesFromList2 - totalNodesFromList1;
            return getIntersectionNode(diff, head2, head1);
        } else {
            System.out.println("Both the list are of same size");
        }

        return null;
    }

    // Here haed1 is the starting point of bigger list always head1 is holding larger list
    public Node<T> getIntersectionNode(int diff, Node<T> firstHead, Node<T> secondHead) {
        Node<T> current1 = firstHead;
        Node<T> current2 = secondHead;

        for (int i = 0; i < diff ; i++) {
             current1 = current1.next;
        }

        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1;
            } else {
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        return null;
    }

    // Class Level variable for 2 numbers addition problem
    Node<Integer> newHead = null;
    int carry = 0;

	public Node<Integer> addTwoNumbersInLinkedList(Node<Integer> head1, Node<Integer> head2) {
        int totalNodesFromList1 = getTotalIntegerNodes(head1);	
        int totalNodesFromList2 = getTotalIntegerNodes(head2);

        // Motive is to keep on adding 0 at the starting of the list whose length is smaller
        if (totalNodesFromList1 > totalNodesFromList2) {
            int diff = totalNodesFromList1 - totalNodesFromList2;
            while (diff > 0) {
               Node<Integer> zeroNode = new Node<Integer>(0);
               zeroNode.next = head2;
               head2 = zeroNode;
               diff--;
            }
        }

        if (totalNodesFromList2 > totalNodesFromList1) {
            int diff = totalNodesFromList2 - totalNodesFromList1;
            while (diff > 0) {
               Node<Integer> zeroNode = new Node<Integer>(0);
               zeroNode.next = head1;
               head1 = zeroNode;
               diff--;
            }
        }

        newHead = addBackRecursion(head1, head2);

        // If there is any last carry. Add carry node with the summation result
        if (carry != 0) {
            Node<Integer> carryNode = new Node<Integer>(carry);
            carryNode.next = newHead;
            newHead = carryNode;
        }

        return newHead;
    }

     public Node<Integer> addBackRecursion(Node<Integer> head1, Node<Integer> head2) {
         if (head1 == null && head2 == null) {
            return null;
         }

         // Using implicit stack for one by one nodes addition
         addBackRecursion(head1.next, head2.next);

         // Maximum sum will be 18
         int sum = head1.data + head2.data + carry;

         if (sum >= 10) {
             carry = 1;
             sum = sum % 10;
         } else {
             carry = 0;
         }

         Node<Integer> sumNode = new Node<Integer>(sum);

         if (newHead == null) {
             newHead = sumNode;
         } else {
             sumNode.next = newHead;
             newHead = sumNode;
         }

         // Returning summation node which is Head node of resultant linked list also
         return newHead;
     }
}
