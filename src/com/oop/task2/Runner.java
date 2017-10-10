package com.oop.task2;
/*
Create LinkedList Class with methods:
get(i)
put(i)
delete(i)
indexOf(el) - first element = el
size()
 */
public class Runner {
    public static void main(String[] args) {
        LinkedListCustom<Integer> list = new LinkedListCustom();
        list.print();
        System.out.println("get(10) " + list.get(10));
        System.out.println("delete(1) " + list.delete(1));
        System.out.println("indexOf(1) " + list.indexOf(1));
        System.out.println("put(2, 9) " + list.put(2, 9));
        list.print();
        System.out.println("size() " + list.size());
        System.out.println("put(0, 9) " + list.put(0, 9));
        list.print();
        System.out.println("size() " + list.size());
        System.out.println("get(0) " + list.get(0));
        System.out.println("indexOf(9) " + list.indexOf(9));
        System.out.println("delete(2) " + list.delete(2));
        System.out.println("delete(0) " + list.delete(0));
        list.print();
        System.out.println("size() " + list.size());
        System.out.println("delete(0) " + list.delete(0));

        list.put(0,0);
        list.put(1, 100);
        list.put(2, 200);
        list.print();
        list.put(0, -100);
        list.put(2, 500);
        list.put(5, 50);
        list.put(5, 5);
        list.put(9, 900);
        list.print();
        System.out.println("size() " + list.size());
        System.out.println("get(0) " + list.get(0));
        System.out.println("get(6) " + list.get(6));
        System.out.println("get(7) " + list.get(7));
        System.out.println("get(2) " + list.get(2));
        System.out.println("indexOf(-100) " + list.indexOf(-100));
        System.out.println("indexOf(100) " + list.indexOf(100));
        System.out.println("indexOf(50) " + list.indexOf(50));
        System.out.println("indexOf(900) " + list.indexOf(900));
        System.out.println("delete(2) " + list.delete(2));
        System.out.println("delete(0) " + list.delete(0));
        System.out.println("delete(6) " + list.delete(6));
        System.out.println("delete(2) " + list.delete(2));
        list.print();
        System.out.println("size() " + list.size());
        System.out.println("deleting all...");
        while (list.delete(0) == true) {}
        list.print();
        System.out.println("size() " + list.size());
    }
}
