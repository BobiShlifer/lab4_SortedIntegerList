package com.company;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class SortedIntegerList {
    private final LinkedList<Integer> sortedList;
    private final boolean repeat;
    private int size;

    public SortedIntegerList(boolean repeat) {
        this.sortedList = new LinkedList<Integer>();
        this.repeat = repeat;
        this.size = 0;
    }

    public SortedIntegerList( SortedIntegerList list){

        repeat = list.repeat;
        this.sortedList = new LinkedList<Integer>(list.sortedList);
        size = this.sortedList.size();
    }
    public SortedIntegerList add(int value) {
        if (size == 0) {
            sortedList.addFirst(value);
            size++;
            return this;
        }
        ListIterator<Integer> it = sortedList.listIterator();
        while (it.hasNext()) {
            int tmp = it.next();
            if ((value == tmp) && !repeat)
                return this;
            if (value < tmp) {
                it.previous();
                it.add(value);
                size++;
                return this;
            }
        }
        sortedList.addLast(value);
        size++;
        return this;
    }

     public SortedIntegerList remove(int value) {
        if (size == 0) return this;
        ListIterator<Integer> it = sortedList.listIterator();
        while (it.hasNext()) {
            int tmp = it.next();
            if (value == tmp) {
                it.remove();
                size--;
                return this;
            }
        }
        return this;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Integer> it = sortedList.listIterator();
        str.append("[");
        while (it.hasNext()){
            str.append(it.next());
            if(it.hasNext())
                str.append(" ");
        }
        str.append("]" + " size: " + this.size + ";" + " repeat: " + this.repeat + ";");
        return str.toString();
    }

    public boolean equals(SortedIntegerList list){
        if (list == this)
            return true;
        if (!(list instanceof SortedIntegerList))
            return false;
        if (!(this.size == list.size))
            return false;
        ListIterator<Integer> it1 = this.sortedList.listIterator();
        ListIterator<Integer> it2 = list.sortedList.listIterator();
        while (it1.hasNext()){
            if ((Integer) it1.next() !=(Integer) it2.next())
            return false;
        }
        return true;
    }

    public SortedIntegerList intersection (SortedIntegerList list) {
        SortedIntegerList res = new SortedIntegerList(true);
        SortedIntegerList listCopy = new SortedIntegerList(list);
        ListIterator<Integer> it1 = this.sortedList.listIterator();
              while(it1.hasNext()) {
                   int tmp = it1.next();
                   ListIterator<Integer> it2 = listCopy.sortedList.listIterator();
                   while(it2.hasNext()){
                       int tmp2 = it2.next();
                         if (tmp2 == tmp) {
                             res.add(tmp);
                             listCopy.remove(tmp);
                             break;
                         }
                 }
            }
        return res;
    }

}
