package jek.collections;

import java.util.*;

public class IntArrayList implements List {

    private int end;
    private Object[] ial;

    public IntArrayList() {
        ial = new Object[10];
        end = 0;
    }

    @Override
    public int size() {

        return end;
    }

    @Override
    public boolean isEmpty() {
        return (end == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (Object search : ial)
            if (search.equals(o))
                return true;

        return false;
    }

    /* вот запилил итератор, но еще не особо прочекал его, бо уже иду спать(
    * я еще перепроверю, и то шо ты в комментах написал тож поправлю.
    * но наверн уже на выхах, бо в чтв и птнц дохуя работаю.
    * пис.
    *  */

    @Override
    public Iterator iterator() {
        class MyIterator implements ListIterator {

            private int cursorNext;
            private int cursorPrevious;
            private int lastCall;

            MyIterator() {
                cursorNext = 0;
                cursorPrevious = -1;
                lastCall = -1;
            }

            @Override
            public boolean hasNext() {
                return (cursorNext < end);
            }

            @Override
            public Object next() {
                if(cursorNext == end)
                    throw new NoSuchElementException();

                lastCall = cursorNext;
                Object next = ial[cursorNext++];
                cursorPrevious++;
                return next;
            }

            @Override
            public boolean hasPrevious() {
                return (cursorPrevious>0);
            }

            @Override
            public Object previous() {
                if(cursorPrevious == -1)
                    throw new NoSuchElementException();

                lastCall = cursorPrevious;
                Object previous = ial[cursorPrevious--];
                cursorNext--;
                return previous;
            }

            @Override
            public int nextIndex() {
                return cursorNext;
            }

            @Override
            public int previousIndex() {
                return cursorPrevious;
            }

            @Override
            public void remove() {
                if (lastCall == -1)
                    throw new IllegalStateException();

                if (lastCall < end-1)
                        System.arraycopy(ial, lastCall+1, ial, lastCall, end-lastCall-1);

                ial[--end] = null;
                lastCall = -1;
                cursorNext--;
                cursorPrevious--;
            }

            @Override
            public void set(Object o) {
                if (lastCall == -1)
                    throw new IllegalStateException();

                    ial[lastCall] = o;
                }

            @Override
            public void add(Object o) {
                if(end == ial.length) {
                    Object[] ial2 = new Object[ial.length*2];
                    System.arraycopy(ial, 0, ial2, 0, ial.length);
                    ial = ial2;
                }
                if (cursorNext != 0){
                    System.arraycopy(ial, cursorNext, ial, cursorNext+1, end-cursorNext-1);
                    cursorNext++;
                    ial[++cursorPrevious] = o;
                }
                   lastCall = -1;
            }
        }
        MyIterator iter = new MyIterator();
        return iter;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if(end == ial.length) {                             //чекаем, если конец равен длинне
            Object[] ial2 = new Object[ial.length*2];       //создаем новый массив и копируем
            System.arraycopy(ial, 0, ial2, 0, ial.length);
            ial = ial2;                                     //присваиваем ссылку старому парню
        }
        ial[end++] = o;                                     //добавляем обьект, увеличиваем конец
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {

        if (index >= end || index < 0)
            throw new IndexOutOfBoundsException("ты пытаешься получить то, чего у тебя нет!");

        return ial[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {

        if (index >= end || index < 0)
            throw new IndexOutOfBoundsException("ты пытаешься удалить то, чего у тебя нет!");

        Object removed = ial[index];

        if (index < end-1)
            System.arraycopy(ial, index+1, ial, index, end-index-1);

        ial[--end] = null;
        return removed;
    }


    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < end; i++)
            if (ial[i].equals(o))
                return i;

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        for(int i = end-1; i >= 0; i--)
            if (ial[i].equals(o))
                return i;

        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
