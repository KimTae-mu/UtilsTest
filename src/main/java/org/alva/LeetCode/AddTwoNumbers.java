package org.alva.LeetCode;

import org.alva.LeetCode.Reference.ListNode;
import org.junit.Test;

/**
 * <一句话描述>,
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <详细介绍>,
 *  * Example:
 *  *
 *  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  * Output: 7 -> 0 -> 8
 *  * Explanation: 342 + 465 = 807.
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class AddTwoNumbers {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;

        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return sentinel.next;
    }

    private ListNode addTwoNumber2(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int cur = 0;

        while (l1 != null || l2 != null || cur != 0) {
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + cur;
            cur = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;

            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }
        return head.next;
    }

    private ListNode addTwoNumber3(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int plus = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + plus;
            plus = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (plus == 1) cur.next = new ListNode(1);
        return dummy.next;
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode rl1 = new ListNode(2);
        ListNode rl2 = new ListNode(4);
        ListNode rl3 = new ListNode(7);

        rl2.next = rl3;
        rl1.next = rl2;

        ListNode ll1 = new ListNode(5);
        ListNode ll2 = new ListNode(6);
        ListNode ll3 = new ListNode(4);

        ll2.next = ll3;
        ll1.next = ll2;

        System.out.println(addTwoNumber2(rl1, ll1));
    }
}
