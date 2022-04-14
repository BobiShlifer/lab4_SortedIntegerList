package com.company;

public class Main {
    public static void main(String[] args) {

        SortedIntegerList list1 = new SortedIntegerList(true);
        list1.add(5).add(6).add(1).add(5).add(-1).add(1).add(5).add(5).add(90);

        SortedIntegerList list2 = new SortedIntegerList(false);
        list2.add(5).add(6).add(1).add(5).add(-1).add(1).add(1).add(0);

        SortedIntegerList list3 = new SortedIntegerList(true);
        list3.add(5).add(6).add(1).add(5).add(-1).add(1).add(5).add(5).add(90);

        SortedIntegerList list4 = new SortedIntegerList(true);
        list4.add(70).add(-1).add(90).add(0).add(1).add(1).add(5).add(5).add(5);


       System.out.println("TEST - 1. Check repeat list:");
        System.out.println("list1 -> " + list1);

        System.out.println("TEST - 2. Check not repeat list:");
        System.out.println("list2 -> " + list2);

        System.out.println("TEST - 3. Check equals:");
        System.out.println("list1 -> " + list1 + " list2 -> " + list2 + " list3 -> " + list3 + " list4 -> " + list4);
        System.out.print("list1 == list2 - ");
        System.out.println( list1.equals(list2));
        System.out.print("list1 == list1 - ");
        System.out.println( list1.equals(list1));
        System.out.print("list1 == list3 - ");
        System.out.println( list1.equals(list3));
        System.out.print("list3 == list4 - ");
        System.out.println( list3.equals(list4));

        System.out.println("TEST - 4. Check remove (all elements have been removed):");
        list2.remove(-1).remove(1).remove(5).remove(6).remove(0);
        System.out.println(list2);

        System.out.println("TEST - 5. Check impossible remove:");
        list2.remove(0);
        System.out.println(list2);

        System.out.println("TEST - 6. Check intersection:");
        SortedIntegerList res = new SortedIntegerList(true);
        System.out.println("list1 -> " + list1);
        System.out.println("list4 -> " + list4);
        res = list1.intersection(list4);
        System.out.println("Intersection list: " + res);

    }
}