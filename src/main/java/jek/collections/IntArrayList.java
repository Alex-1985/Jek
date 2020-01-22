package jek.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    public boolean isEmpty() { return (end == 0); }

    @Override
    public boolean contains(Object o) {
        for (Object search : ial)
            if (search.equals(o))
                return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
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
