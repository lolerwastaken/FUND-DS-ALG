// Given. Do not modify.
// A node in a singly-linked list of ints.
class ListNode {
    int data;
    ListNode nextNode;

    ListNode(int theElement) {
        this(theElement, null);
    }

    ListNode(int theElement, ListNode n) {
        data = theElement;
        nextNode = n;
    }
}
