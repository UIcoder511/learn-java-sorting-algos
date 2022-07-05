class Node {

  int value;
  Node next;

  Node(int value) {
    this.value = value;
    next = null;
  }

  Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }
}

public class LinkedList {

  Node head = null;

  private Node findLastNode(Node head) {
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    return curr;
  }

  void add(int value) {
    Node n = new Node(value);
    if (head == null) {
      head = n;
    } else {
      findLastNode(head).next = n;
    }
  }

  private Node insertSortedList(Node newListHead, Node nodeToAdd) {
    //if inserting at first position

    if (newListHead == null || newListHead.value > nodeToAdd.value) {
      nodeToAdd.next = newListHead;

      return nodeToAdd;
    }
    Node curr = newListHead;

    while (curr.next != null && curr.next.value < nodeToAdd.value) {
      curr = curr.next;
    }

    //inserting inbetween //if inserting at last position
    nodeToAdd.next = curr.next;
    curr.next = nodeToAdd;
    return newListHead;
  }

  void inertionSortLinkedlist() {
    if (head == null || head.next == null) return;
    Node newlist = null, curr = head;
    while (curr != null) {
      //saving next before because original next will be lost after fn execution
      Node next = curr.next;
      newlist = insertSortedList(newlist, curr);
      curr = next;
    }

    head = newlist;
  }

  void print() {
    Node curr = head;
    StringBuilder sb = new StringBuilder();
    while (curr != null) {
      sb.append((curr == head ? "" : " -> ") + curr.value);
      curr = curr.next;
    }

    Utils.coverStringWithDash(sb.toString());
  }
}
