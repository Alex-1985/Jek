package jek.collections;


import java.util.*;

public class GenericHashMap<Key, Value> implements Map<Key, Value> {


     GhmObj[] entrys;
    private double loadFact;
    private int capacity;
    private int size;


    public GenericHashMap() {

        loadFact = 0.75;
        capacity = 16;
        entrys = new GhmObj[capacity];
        size = 0;
    }

    public GenericHashMap(int capacity) {

        loadFact = 0.75;
        this.capacity = capacity;
        entrys = new GhmObj[capacity];
        size = 0;
    }

    public GenericHashMap(int capacity, double loadFact) {

        this.loadFact = loadFact;
        this.capacity = capacity;
        entrys = new GhmObj[capacity];
        size = 0;
    }

    // OUR ENTRY OBJECT CLASS

    class GhmObj<Key, Value> implements Entry {

        private Key key;
        private Value value;
        private GhmObj next;


        public GhmObj(Key key, Value value) {

            this.key = key;
            this.value = value;

        }

        public boolean hasNext() {
            return next != null;
        }


        public Key getKey() {
            return key;
        }


        public Value getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {

            Object temp = this.value;
            this.value = (Value) value;
            return temp;
        }

        @Override
        public String toString() {
            return key + ": " + value;
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


    // HASHMAP OVERRIDED METHODS:

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        int index = indexFor(Objects.hash(key), capacity);

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

        Iter iter = iterator();
        while(iter.hasNext())
            if (iter.next().getValue().equals(value))
                return true;

        return false;
    }

    @Override
    public Value get(Object key) {

        int index = indexFor(Objects.hash(key), capacity);

        if (entrys[index] != null) {

            if (entrys[index].getKey().equals(key)) return (Value) entrys[index].getValue();

            if (entrys[index].hasNext()) {
                GhmObj current = entrys[index];
                while (current.hasNext()) {
                    if (current.next.getKey().equals(key)) return (Value) current.next.getValue();
                    current = current.next;
                }
            }
        }
        return null;
    }

    @Override
    public Value put(Key key, Value value) {

        increaseSize();


        GhmObj<Key, Value> objToPut = new GhmObj<>(key, value);

        int indexObjToPut = indexFor(objToPut.hashCode(), capacity);

        if (entrys[indexObjToPut] != null) {

            if (objToPut.getKey().equals(entrys[indexObjToPut].getKey())) {
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

        decreaseSize();

        int index = indexFor(Objects.hash(key), capacity);
        Value returnVal;


        if (entrys[index] != null) {

            if (key.equals(entrys[index].getKey())) {
                returnVal = (Value) entrys[index].getValue();

                if (entrys[index].hasNext()) {entrys[index] = entrys[index].next;}

                entrys[index] = null;
                size--;
                return returnVal;

            } else {
                GhmObj current = entrys[index];
                while (current.hasNext() && !current.next.getKey().equals(key)) current = current.next;
                if (current.next.hasNext()) current.next = current.next.next;
                else current.next = null;
                size --;
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

        Iter iter = iterator();
        while (iter.hasNext()) { set.add((Key) iter.next().getKey()); }
        return set;
    }

    @Override
    public Collection<Value> values() {

        Collection<Value> coll = new ArrayList<>();

        Iter iter = iterator();
        while (iter.hasNext()) { coll.add((Value)iter.next().getValue()); }

        return coll;
    }

    @Override
    public Set<Entry<Key, Value>> entrySet() {

        Set set = new HashSet<GhmObj<Key, Value>>();


        Iter iter = iterator();
        while (iter.hasNext()) { set.add(iter.next()); }
        return set;
    }

    // PRIVATE HELP METHODS:

    private int indexFor(int hashCode, int capacity) {

        return hashCode & (capacity - 1);
    }

    private Iter iterator() {
        Iter<GhmObj> iter = new Iter<GhmObj>();
        return iter;
    }

    class Iter<GhmObj> implements Iterator<GenericHashMap.GhmObj>{

        private int currentIndex;
        private GenericHashMap.GhmObj currentObj;
        private int iterMade;


        public Iter () {

            iterMade = size;
            currentIndex = 0;
            while (entrys[currentIndex] == null && currentIndex < entrys.length) { currentIndex++; }

            currentObj = entrys[currentIndex];
        }


        @Override
        public boolean hasNext() {
            return (iterMade > 0 && currentIndex < entrys.length);
        }

        @Override
        public GenericHashMap.GhmObj next() {

            GenericHashMap.GhmObj entryToReturn = currentObj;
            iterMade --;

            if (iterMade == 0) return currentObj;

            if(currentObj.hasNext()) {
                currentObj = currentObj.next;
            } else {
                currentIndex++;
                while(entrys[currentIndex] == null && currentIndex < entrys.length) currentIndex++;
                currentObj = entrys[currentIndex];
            }

            return entryToReturn;
        }
    }

    public void increaseSize() {

        if (size() == capacity * loadFact) {

            capacity *= 2;
            rehashArr();
        }
    }

private void rehashArr() {
    GhmObj[] entrysSecond = new GhmObj[capacity];
    GhmObj temp;

    Iter<GhmObj> iter = iterator();
        while(iter.hasNext()){
            temp = iter.next();

            int index = indexFor(temp.hashCode(), capacity);

            if (entrysSecond[index] != null) { temp.next = entrysSecond[index]; }

            entrysSecond[index] = temp;
        }
    }


    private void decreaseSize() {

        if ((size <= capacity / 4) && (capacity > 16)){

            capacity /= 2;
            rehashArr();
        }
    }
}
