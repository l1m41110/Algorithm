package com.dataStructures;

public class Node {
    private int Value;
    private Node Next;

    public Node(int value) {
        Value = value;
    }

    public int getValue() {
        return Value;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }

    public static void printList(Node node){
        while(node != null){
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}

class RunNode {

    public static void main(String[] args) {

        Node first = new Node(3);

        Node middle = new Node(5);

        Node last = new Node(7);

        first.setNext(middle);

        middle.setNext(last);

        Node.printList(first);
    }

}
