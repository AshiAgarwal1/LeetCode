/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;
        int i=1;
        int prevCriticalpt=0;
        int firstCriticalpt=0;
        int minDist=Integer.MAX_VALUE;
        while(curr.next!=null){
            //critical pt
            if((curr.val<prev.val && curr.val<curr.next.val)||(curr.val>prev.val && curr.val>curr.next.val)){
                if(prevCriticalpt==0){
                    //first critical pt
                    firstCriticalpt=i;
                    prevCriticalpt=i;
                }
                else{
                    minDist=Math.min(minDist,i-prevCriticalpt);
                    prevCriticalpt=i;
                }
            }
            i++;
            prev=curr;
            curr=curr.next;
        }
        if(minDist==Integer.MAX_VALUE) return new int[]{-1,-1};
        return new int[]{minDist,prevCriticalpt-firstCriticalpt};
    }
}