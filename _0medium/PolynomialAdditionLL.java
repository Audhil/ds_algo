package _0medium;

//  https://www.youtube.com/watch?v=RV7AEnH1EAc
//  https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists/

//  3x^8 + 5x^7 - 2x^6 + 8x^4 -> node is represented as 3(coef)|8(exponential)|address of next node
//  4x^7 + 5x^6 - x^3 + 7x^2 - 3 -> node is represented as 4(coef)|7(exponential)|address of next node
public class PolynomialAdditionLL {

    private static class ListNode {
        int coef, exponential;
        ListNode next;

        public ListNode(int coef, int exponential, ListNode next) {
            this.coef = coef;
            this.exponential = exponential;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "coef=" + coef +
                    ", exponential=" + exponential +
//                    ", next=" + next +
                    '}';
        }
    }

    //  p1 - polynomial 1, p2 - polynomial 2
    public static ListNode sumPolynomials(ListNode p1, ListNode p2) {
        if (p1 == null || p2 == null)
            return p1 != null ? p1 : p2;
        ListNode p = p1;
        ListNode q = p2;

        ListNode temp = new ListNode(0, 0, null);
        ListNode curr = temp;
        while (p != null && q != null) {
            if (p.exponential == q.exponential) {
                temp.next = new ListNode(p.coef + q.coef, p.exponential, null);
                p = p.next;
                q = q.next;
            } else if (p.exponential > q.exponential) {
                temp.next = new ListNode(p.coef, p.exponential, null);
                p = p.next;
            } else {
                temp.next = new ListNode(q.coef, q.exponential, null);
                q = q.next;
            }
            temp = temp.next;
        }
        if (p != null)
            temp.next = p;
        if (q != null)
            temp.next = q;
        return curr.next;
    }

    private static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
//        System.out.println("p1:");
        ListNode p1 = new ListNode(3, 8, new ListNode(5, 7, new ListNode(-2, 6, new ListNode(8, 4, null))));
//        printLL(p1);
//        System.out.println("p2:");
        ListNode p2 = new ListNode(4, 7, new ListNode(5, 6, new ListNode(-1, 3, new ListNode(7, 2, new ListNode(-3, 0, null)))));
//        printLL(p2);
        ListNode sumIs = sumPolynomials(p1, p2);
        printLL(sumIs);
    }
}
