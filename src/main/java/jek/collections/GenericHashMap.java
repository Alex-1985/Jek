package jek.collections;


import java.util.*;

public class GenericHashMap<Key, Value> implements Map<Key, Value> {


    GhmObj[] entrys;
    double loadFact;
    int capacity;
    int size;


    public GenericHashMap () {
        loadFact = 0.75;
        capacity = 16;
        entrys = new GhmObj[capacity];
        size = 0;
    }

    public GenericHashMap ( int capacity) {

        this.capacity = capacity;

    }

    public GenericHashMap(int capacity, double loadFact) {

        this.loadFact = loadFact;
        this.capacity = capacity;
    }


    class GhmObj<Key, Value> {

        private Key key;
        private Value value;
        private GhmObj next;


        public GhmObj (Key key, Value value) {

            this.key = key;
            this.value = value;

            }

        public boolean hasNext(){return next != null;}


        public Object getKey() {
            return key;
        }


        public Value getValue() {
            return value;
        }


        public Value setValue(Value value) {
            Value temp = this.value;
            this.value = value;
            return temp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GhmObj<?, ?> ghmObj = (GhmObj<?, ?>) o;
            return Objects.equals(key, ghmObj.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

    }


    private int indexFor(int hashCode){
        return hashCode & (capacity -1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object key) {

        int index = indexFor(Objects.hash(key));

        if (entrys[index] != null)
            if (entrys[index].getKey().equals(key)) return true;
            else if (entrys[index].hasNext()) {
                GhmObj current = entrys[index];
                while (current.hasNext()) {
                    if (current.getKey().equals(key)) return true;
                    current = current.next;
                }
            }
                return false;
    }

    @Override
    public boolean containsValue(Object value) {

        return false;
    }

    @Override
    public Value get(Object key) {

        int index = indexFor(Objects.hash(key));

        if(entrys[index] != null){

            if(entrys[index].getKey().equals(key)) return (Value)entrys[index].getValue();

            if (entrys[index].hasNext()){
                GhmObj current = entrys[index];
                while(current.hasNext()){
                    if(current.next.getKey().equals(key)) return (Value) current.next.getValue();
                    current = current.next;
                }
            }
        }
        return null;
    }

    @Override
    public Value put(Key key, Value value) {


        GhmObj<Key, Value> objToPut = new GhmObj<>(key, value);

        int indexObjToPut = indexFor(objToPut.hashCode());

        if ( entrys[indexObjToPut]!=null) {

            if(objToPut.getKey().equals(entrys[indexObjToPut].getKey())) {
                Value tempZnachenie = (Value) entrys[indexObjToPut].getValue();
                entrys[indexObjToPut].setValue(objToPut.getValue());
                return tempZnachenie;
            }

            objToPut.next = entrys[indexObjToPut];
        }

        entrys[indexObjToPut] = objToPut;
        size++;
        return null;
    }

    @Override
    public Value remove(Object key) {

        int index = indexFor(Objects.hash(key));
        Value returnVal;


        if (entrys[index] != null){

            if(key.equals(entrys[index].getKey())) {
                returnVal = (Value) entrys[index].getValue();
                if (entrys[index].hasNext()){
                    entrys[index] = entrys[index].next;
                }
                entrys[index] = null;
                return returnVal;

            } else {
                GhmObj current = entrys[index];
                while(current.hasNext() && !current.next.getKey().equals(key)) current = current.next;
                if (current.next.hasNext()) current.next = current.next.next;
                else current.next = null;
            }
        }


        return null;
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> m) {

    }

    @Override
    public void clear() {
        GhmObj[] entrys2 = new GhmObj[capacity];
        entrys = entrys2;
        size = 0;
    }

    @Override
    public Set<Key> keySet() {

        Set<Key> set = new HashSet();

        for (GhmObj stp : entrys){
            if (stp!=null){
                if(stp.hasNext()){
                    GhmObj linked = stp;
                    while(linked.hasNext()){
                        set.add((Key)linked.next.getKey());
                        linked = linked.next;
                    }
                }
                set.add((Key)stp.getKey());
            }
        }
        return set;
    }

    @Override
    public Collection<Value> values() {
        return null;
    }

    @Override
    public Set<Entry<Key, Value>> entrySet() {
        return null;
    }
}
