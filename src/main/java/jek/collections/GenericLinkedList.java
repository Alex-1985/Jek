package jek.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenericLinkedList<Tip> implements List<Tip> {

    private int size;
    private LinkedListObject<Tip> first, last, current;

    GenericLinkedList() {
        current = first = last = new LinkedListObject<Tip>(null, null);
        size = 0;
    }

    private class LinkedListObject<T> {

        private LinkedListObject previousObj;
        private LinkedListObject nextObj;
        private T obj;

        LinkedListObject(LinkedListObject previousObj, T obj){
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

        int index = 0;

        while (index < size){
            if (current.obj.equals(o)){
                current = first;
                return true;}
            current = current.nextObj;
            index++;}

        current = first;
        return false;
    }

    @Override
    public Iterator<Tip> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {

        Object[] array = new Object[size];

        for (int i = 0; i < size; i++){
            array[i] = current.obj;
            current = current.nextObj;
        }

        current = first;
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
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

        int index = 0;

        while (index < size){
            if (current.obj.equals(o)){

            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Tip> c) {
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
            current = first;
            return toReturn;
        }
    }

    @Override
    public Tip set(int index, Tip element) {
        return null;
    }

    @Override
    public void add(int index, Tip element) {

    }

    @Override
    public Tip remove(int index) {

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
        current = first;
        return (Tip)removed.obj;
}

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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