package com.dataStructures;

/*
complexity to add is constant: O(1)

1 node element would be:
Head --> 3 | Null (next)
Tail --> 3 | Null (next)

2 nodes elements would be:
Head --> 5 | -> 3 (next)
Tail --> 3 | Null (next)

3 nodes elements would be:
Head --> 7 | -> 5 (next) | -> 3 (next)
Tail -->  3 | null
 */
public class LinkedListNode<T> {
    private T Value;
    private LinkedListNode<T> Next;
    private LinkedListNode<T> Prev;

    public LinkedListNode(T value) {
        Value = value;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }

    public LinkedListNode<T> getNext() {
        return Next;
    }

    public void setNext(LinkedListNode<T> next) {
        Next = next;
    }

    public LinkedListNode<T> getPrev() {
        return Prev;
    }

    public void setPrev(LinkedListNode<T> prev) {
        Prev = prev;
    }

    public static void printList(LinkedListNode node) {
        //TODO
    }
}

class RunLinkdListNode {

    public static void main(String[] args) {
        //TODO
    }

}