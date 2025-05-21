package org.training.LinkedList;

import java.util.ArrayList;

public class MergeKSortedLinkedList {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */

        public ListNode mergeKLists(ArrayList<ListNode> a) {

            ListNode parent=a.get(0);
            ListNode dummyHead =new ListNode(-1);
            if(a.isEmpty()){
                return dummyHead.next;
            }
            for(int i=1; i< a.size(); i++ ){
                dummyHead.next=  mergeTwoLists(parent,a.get(i));
            }


            return dummyHead.next;

        }

        public ListNode mergeTwoLists(ListNode parent,ListNode newList ){
            ListNode dummyHead =new ListNode(-1);
            ListNode prev=dummyHead;
            dummyHead.next=parent;
            ListNode temp=newList;
             if(newList.val<parent.val) {
                 dummyHead.next=newList;
             }
            while(parent!=null && newList!=null){

                if(newList.val<parent.val){
                    newList=newList.next;
                    temp.next=parent;
                    prev.next=temp;
                    temp=newList;

                }else
                    parent=parent.next;

                prev=prev.next;

            }

            if(newList!=null){
                prev.next=newList;
            }

            return dummyHead.next;
        }


}
