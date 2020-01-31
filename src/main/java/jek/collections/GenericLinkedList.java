package jek.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenericLinkedList<Tip> implements List<Tip> {

    private int size;
    private LinkedListObject<Tip> first, last;

    GenericLinkedList() {
        first = last = new LinkedListObject<>(null, null);
        size = 0;
    }

    private class LinkedListObject<Tip> {

        private LinkedListObject previousObj;
        private LinkedListObject nextObj;
        private Tip obj;

        LinkedListObject(LinkedListObject previousObj, Tip obj){
            this.previousObj = previousObj;
            this.obj = obj;
            nextObj = null;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {

        for (Tip object : this)
            if(object.equals(o))
                return true;

        return false;
    }

    @Override
    public Iterator<Tip> iterator() {

        class Iterator<Tip> implements java.util.Iterator<Tip>{

            private LinkedListObject cursor;
            private int counter;

            Iterator () {
                cursor = first;
                counter = 0;
            }

            @Override
            public boolean hasNext() {
                return (counter < size);
            }

            @Override
            public Tip next() {
                Tip returnTip = (Tip)cursor.obj;
                cursor = cursor.nextObj;
                counter++;
                return returnTip;
            }
        }

        Iterator<Tip> iter = new Iterator<>();
        return iter;
    }

    @Override
    public Object[] toArray() {

        LinkedListObject current = first;
        Object[] array = new Object[size];

        for (int i = 0; i < size; i++){
            array[i] = current.obj;
            current = current.nextObj;
        }

        return array;
    }

    @Override
    public <Tip> Tip[] toArray(Tip[] a) {
        return null;
    }

    @Override
    public boolean add(Tip tip) {
        if (size == 0){
            first.obj = tip;
        } else {
            LinkedListObject<Tip> lastNew = new LinkedListObject<>(last, tip);
        last.nextObj =  lastNew;
        last = lastNew;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

       if ((indexOf(o))!=-1){
           remove(indexOf(o));
           return true;
       }

       return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Tip> c) {

        if(c == null)
            throw new NullPointerException();

        Iterator<? extends Tip> iter = c.iterator();

        while(iter.hasNext())
            add(iter.next());

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Tip> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Tip get(int index) {

        LinkedListObject<Tip> current = first;

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return first.obj;
        } else if (index == size-1){
            return last.obj;
        } else {
            while (index > 0){
                current = current.nextObj;
                index--;
            }
            Tip toReturn = current.obj;
            return toReturn;
        }
    }

    @Override
    public Tip set(int index, Tip element) {
        return null;
    }

    @Override
    public void add(int index, Tip element) {

        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();


        if (index == size) {
            add(element);
        } else if (index == 0) {
            LinkedListObject<Tip> newObj = new LinkedListObject<>(null, element);
            newObj.nextObj = first;   // isn't it better to overload constructor??
            first = newObj;
        } else {

        }

    }

    @Override
    public Tip remove(int index) {

        LinkedListObject current = first;
        LinkedListObject removed = first;

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            current = current.nextObj;
            current.previousObj = null;
            removed.nextObj = null;
            first = current;
        } else if (index == size-1) {
            removed = last;
            current = last.previousObj;
            removed.previousObj = null;
            current.nextObj = null;
        } else {
            while (index > 0){
                removed = removed.nextObj;
                index--;
            }   current = removed.previousObj;
            current.nextObj = removed.nextObj;
            current = current.nextObj;
            current.previousObj = removed.previousObj;
            removed.previousObj = null;
            removed.nextObj = null;
        }
        size--;
        return (Tip)removed.obj;
}

    @Override
    public int indexOf(Object o) {

        int index = 0;

        for(Tip object : this){
            if(object.equals(o))
                return index;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

       LinkedListObject current = last;

        for(int index = size-1; index >= 0; index--){
            if(current.obj.equals(o))
                return index;
            current = current.previousObj;
        }

        return -1;
    }

    @Override
    public ListIterator<Tip> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Tip> listIterator(int index) {
        return null;
    }

    @Override
    public List<Tip> subList(int fromIndex, int toIndex) {
        return null;
    }
}