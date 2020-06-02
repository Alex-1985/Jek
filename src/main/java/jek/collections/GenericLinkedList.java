package jek.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class GenericLinkedList<Tip> implements List<Tip> {

    private int size;
    private LinkedListObject<Tip> first, last;

    GenericLinkedList() {
        first = last = new LinkedListObject<Tip>(null, null);
        size = 0;
    }

    private class LinkedListObject<Tip> {

        private LinkedListObject previousObj;
        private LinkedListObject nextObj;
        private Tip obj;

        LinkedListObject(LinkedListObject previousObj, Tip obj){
            this.previousObj = previousObj;
            this.obj = obj;
            //nextObj = null;
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
        if (o == null) { throw new NullPointerException("The query item is null"); }

        for (Tip object : this) {
            if(object.equals(o)) { return true; }
        }

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
        if (tip == null) { throw new NullPointerException("The query item is null"); }

        if (size == 0){
            first.obj = tip;
        } else {
        last.nextObj =  new LinkedListObject<>(last, tip);
        last = last.nextObj;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) { throw new NullPointerException("The query item is null"); }

        if (o.equals(first.obj)) {
            first = first.nextObj;
            first.previousObj = null;
            size--;
            return true;
        }

        if (o.equals(last.obj)) {
            last = last.previousObj;
            last.nextObj = null;
            size--;
            return true;
        }

        LinkedListObject current = first.nextObj;
        while (current.nextObj != null) {
            if(current.obj.equals(o)) {
                current.previousObj.nextObj = current.nextObj;
                current.nextObj.previousObj = current.previousObj;
                size--;
                return true;
            }
            current = current.nextObj;
        }

       return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        if (c == null) { throw new NullPointerException("The query item is null"); }

        Iterator iter = c.iterator();

        while (iter.hasNext()){
            if(!contains(iter.next()))
                return false;
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Tip> c) {

        if(c == null) { throw new NullPointerException("The query item is null"); }

        Iterator<? extends Tip> iter = c.iterator();

        while(iter.hasNext())
            add(iter.next());

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Tip> c) {

        if(c == null) { throw new NullPointerException("The query item is null"); }
        if (index < 0 || index > size) { throw new IndexOutOfBoundsException(); }

        Iterator<? extends Tip> iter = c.iterator();

        while(iter.hasNext())
            add(index++, iter.next());

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

        if (index >= size || index < 0) { throw new IndexOutOfBoundsException(); }

        if (index == 0) {
            return first.obj;
        } else if (index == size-1){
            return last.obj;
        } else {
            LinkedListObject<Tip> current = first;
            while (index > 0){
                current = current.nextObj;
                index--;
            }

            return current.obj;
        }
    }

    @Override
    public Tip set(int index, Tip element) {

        if (element == null) { throw new NullPointerException("The query item is null"); }
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }

        Tip toReturn;

        if (index == 0) {
            toReturn = first.obj;
            first.obj = element;
        } else if (index == size-1) {
            toReturn = last.obj;
            last.obj = element;
        } else {
            LinkedListObject current = first;

            while (index > 0) {
                current = current.nextObj;
                index--;
            }
            toReturn = (Tip) current.obj;
            current.obj = element;
        }

        return toReturn;
    }

    @Override
    public void add(int index, Tip element) {

        if (element == null) { throw new NullPointerException("The query item is null"); }
        if (index > size || index < 0) { throw new IndexOutOfBoundsException(); }

        if (index == size) {
            add(element);
        } else if (index == 0) {

            first.previousObj = new LinkedListObject<>(null, element);
            first.previousObj.nextObj = first;
            first = first.previousObj;

            size++;
        } else {
            LinkedListObject current = first;
            while(index > 0){
                current = current.nextObj;
                index--;
            }

            current.previousObj.nextObj = new LinkedListObject(current.previousObj, element);
            current.previousObj.nextObj.nextObj = current;
            current.previousObj = current.previousObj.nextObj;

            size++;
        }

    }

    @Override
    public Tip remove(int index) {

        if (index >= size || index < 0) { throw new IndexOutOfBoundsException(); }

        LinkedListObject removed = first;

        if (index == 0) {   // а если этот елемент единственный??

            first = first.nextObj;
            first.previousObj = null;

        } else if (index == size-1) {
            removed = last;
            last = last.previousObj;
            last.nextObj = null;
        } else {

            while (index > 0){
                removed = removed.nextObj;
                index--;
            }

            removed.previousObj.nextObj = removed.nextObj;
            removed.nextObj.previousObj = removed.previousObj;

        }
       size--;
       return (Tip)removed.obj;
}

    @Override
    public int indexOf(Object o) {
        if (o == null) { throw new NullPointerException("The query item is null"); }

        int index = 0;

        for(Tip object : this){
            if(object.equals(o)) { return index; }
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) { throw new NullPointerException("The query item is null"); }

       LinkedListObject current = last;

        for(int index = size-1; index >= 0; index--){
            if(current.obj.equals(o)) { return index; }
            current = current.previousObj;
        }

        return -1;
    }

    @Override
    public ListIterator<Tip> listIterator() {
        ListIterator<Tip> iter = new ListIterator<>();
        return iter;
    }

    @Override
    public ListIterator<Tip> listIterator(int index) {
        return null;
    }

    @Override
    public List<Tip> subList(int fromIndex, int toIndex) {
        return null;
    }

    class ListIterator<Tip> implements java.util.ListIterator<Tip> {

        LinkedListObject next;
        LinkedListObject prev;
        LinkedListObject lastCall;
        int index;

        ListIterator(){
            next = first;
            prev = null;
            lastCall = null;
            index = 0;
        }



        @Override
        public boolean hasNext() {

            return (next != null);
        }

        @Override
        public Tip next() {

            prev = next;
            next = next.nextObj;
            index++;
            lastCall = prev;
            return (Tip)prev.obj; //didn't get why i have to downcast obj to Tip. wtf it returns 'Object'??
        }

        @Override
        public boolean hasPrevious() {
            return (prev != null);
        }

        @Override
        public Tip previous() {
            next = prev;
            prev = prev.previousObj;
            index--;
            lastCall = next;
            return (Tip)next.obj;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            if(lastCall!=null){
                next = lastCall.nextObj;
                prev = lastCall.previousObj;

                GenericLinkedList.this.remove(lastCall.obj);
                lastCall = null;
                index--;
            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public void set(Tip tip) {
            if(lastCall == null) {
                throw new IllegalStateException();
            } else {
                lastCall.obj = tip;
                lastCall = null;
            }
        }

        @Override
        public void add(Tip tip) {

        }
    }
}