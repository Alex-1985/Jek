package jek.collections;

import java.util.List;

public class PerformanceTesting {

    private static String[] helpArr = {"1111", "2222", "3333", "4444", "5555", "6666", "7777",
            "8888", "9999", "0000", "11111", "22222", "33333", "44444", "55555", "66666", "77777",
            "88888", "99999", "00000"};

    public static long addTesting(List list, int howMany, String position) {
        long beforeTest = System.currentTimeMillis();

        if(position.equals("end")){
        for (int i=0; i<howMany; i++)
            for(int j=0; j < helpArr.length; j++)
                list.add(helpArr[j]);
        } else {
            for (int i=0; i<howMany; i++)
                for(int j=0; j < helpArr.length; j++)
                    list.add(list.size()/2, helpArr[j]);
        }

        long afterTest = System.currentTimeMillis();
        return (afterTest - beforeTest);
    }

    public static long removeTesting(List list, int howMany, String position) {
        long beforeTest = System.currentTimeMillis();

        if (position.equals("end")){
        for (int i = 0; i < howMany; i++)
            list.remove(list.size()-1);
        } else {
            for (int i = 0; i < howMany; i++)
                list.remove(list.size()/2);
        }

        long afterTest = System.currentTimeMillis();
        return (afterTest - beforeTest);
    }

    public static long getFromMid(List list) {
        long beforeTest = System.currentTimeMillis();

        for(int i=0; i<5000; i++)
            list.get(list.size()/2+i);

        long afterTest = System.currentTimeMillis();
        return (afterTest - beforeTest);
    }




    public static void main (String[] args) {
        GenericLinkedList linkedList = new GenericLinkedList();
        IntArrayList arrayList = new IntArrayList();

        System.out.println("Добавляем в конец 100к х 20 елементов: " );
        System.out.println("Linked List: " + addTesting(linkedList, 100000, "end"));
        System.out.println("Array List: " + addTesting(arrayList, 100000, "end"));


        System.out.println("Удаляем из конца 100к х 19 елементов: " );
        System.out.println("Linked List: " + removeTesting(linkedList, 100000*19,
                "end"));
        System.out.println("Array List: " + removeTesting(arrayList, 100000*19,
                "end"));

        System.out.println("Добавляем в середину 5к х 20 елементов: " );
        System.out.println("Linked List: " + addTesting(linkedList, 5000, "mid"));
        System.out.println("Array List: " + addTesting(arrayList, 5000, "mid"));

        System.out.println("Удаляем из середины 100к елементов: ");
        System.out.println("Linked List: " + removeTesting(linkedList, 100000,
                "mid"));
        System.out.println("Array List: " + removeTesting(arrayList, 100000,
                "mid"));

        System.out.println("Достаем-чекаем(get) из середины 5к елементов: ");
        System.out.println("Linked List: " + getFromMid(linkedList));
        System.out.println("Array List: " + getFromMid(arrayList));


        System.out.println(linkedList.size());
        System.out.println(arrayList.size());
    }
}
