package jek.fibbonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibbonacci {

   static List<Long> mem = new ArrayList<>();


    public static long getFibboNumRecursion(int n){

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
        return (getFibboNumRecursion(n-2) + getFibboNumRecursion(n-1));
        }
    }
    public static long getFibboNum(int n) {

        long a = 0;
        long b = 1;

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }else {
            for (int i=0; i<n; i++) {
                a +=b;
                b = a-b;
            }
            return a;
        }
    }
    public static long getFibboNumMemoization(int n, List mem) {

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {

            if (mem.size()>=n-1)
                return (Long)mem.get(n-2);


            long fib = getFibboNumMemoization(n-2, mem) + getFibboNumMemoization(n-1, mem);
            mem.add(fib);

            return fib;
        }
    }

    public static void main (String[] args) {

        System.out.println(getFibboNumRecursion(25));

        System.out.println(getFibboNum(50));

        System.out.println(getFibboNumMemoization(50, mem));


    }
}
