package com.oop.task2;

public class LinkedListCustom<T extends Comparable> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListCustom() {
    }

    public T get(int i) {
        if(i >= size || i < 0) {
            return null;  // RETURN
        }
        Node<T> current = head;
        int index = 0;
        while (index < i && current != null) {
            index++;
            current = current.getNext();
        }
        return current.value;  // RETURN
    }

    public boolean put(int i, T element) {
        boolean res = false;
        if(i > size || i < 0) {
            res = false;
        } else if(i == 0) {  // INSERT INTO HEAD
            res = insertIntoHead(element);
        } else if(i == size) { // INSERT AFTER TAIL
            res = insertNextAfterTail(element);
        } else if(i == size-1)  { // INSERT INTO TAIL
            res = insertIntoTail(element);
        } else { 
            Node<T> current = head.getNext();
            int index = 1;
            while (index < i) {
                index++;
                current = current.getNext();
            }
            Node<T> newNode = new Node<>(element);
            Node<T> previous =  current.getPrevious();
            if(previous != null) {
                previous.setNext(newNode);
                newNode.setPrevious(previous);
            } else {
                head = newNode;
            }
            newNode.setNext(current);
            current.setPrevious(newNode);
            size++;
            res = true;
        }
        return res;
    }
    private boolean insertIntoHead(T element) {
        Node<T> newNode = new Node<>(element);
        if(size == 0) {
            head = tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    private boolean insertIntoTail(T element) {
        Node<T> newNode = new Node<>(element);
        if(size == 0) {
            head = tail = newNode;
        } else {
            Node<T> previous = tail.getPrevious();
            if(previous != null) {
                previous.setNext(newNode);
                newNode.setPrevious(previous);
            }
            newNode.setNext(tail);
            tail.setPrevious(newNode);
        }
        size++;
        return true;
    }

    private boolean insertNextAfterTail(T element) {
        if(size>0) {
            Node<T> newTail = new Node<>(element);
            tail.setNext(newTail);
            newTail.setPrevious(tail);
            tail = newTail;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int i) {
        boolean res = false;
        if(i >= size || i < 0) {
            res = false;
        } else if(i == 0) {
            res = deleteHead();
        } else if(i==size-1) {
            res = deleteTail();
        } else {
            Node<T> current = head.getNext();
            int index = 1;
            while (index < i && current != null) {
                index++;
                current = current.getNext();
            }
            if(index == i) {
                Node<T> previous =  current.getPrevious();
                Node<T> next = current.getNext();
                previous.setNext(next);
                next.setPrevious(previous);
                current.setPrevious(null);
                current.setNext(null);
                size--;
                res = true;
            }
        }
        return res;
    }

    private boolean deleteHead() {
        if(size<0) {
            return false;
        }
        Node<T> next = head.getNext();
        if(next != null) {
            next.setPrevious(null);
            head = next;
            size--;
        } else {
            head = null;
            tail = null;
            size = 0;
        }
        return true;
    }

    private boolean deleteTail() {
        if(size<0) {
            return false;
        }
        Node<T> previous= tail.getPrevious();
        if(previous != null) {
            previous.setNext(null);
            tail = previous;
            size--;
        } else {
            head = null;
            tail = null;
            size = 0;
        }
        return true;
    }

    public int indexOf(T element) { // first element = el
        int position = -1;
        if(size > 0) {
            int ind = 0;
            Node<T> current = head;
            do {
                if (current.value.equals(element)) {
                    position = ind;  // FOUND POSITION
                    break;
                }
                ind++;
            } while ( (current = current.getNext()) != null);
        }
        return position;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.print("[ ");
        for(Node<T> current = head; current!=null; current = current.getNext()) {
            System.out.print(current.value + "; ");
        }
        System.out.print("]\n");
    }

    private class Node<T extends Comparable> {
        private T value;
        private Node previous;
        private Node next;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

        boolean hasPrevious() {
            return previous != null;
        }

        Node getPrevious() {
            return previous;
        }

        void setPrevious(Node previous) {
            this.previous = previous;
        }

        boolean hasNext() {
            return next != null;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }
}
