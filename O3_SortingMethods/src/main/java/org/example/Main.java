package org.example;

import org.example.module.Methods;

public class Main {
    public static void main(String[] args) {

        int Max_n           = 100_000_000;
        int Max_Sequential  = 100_000;

        int A[];
        int n = 100000;
        long time           = 0;

        if (n < 0 || n > Max_n) {
            System.out.println("Use 1 <= n <= " + Max_n);
            System.exit(1);
        }
        A = new int[n];

        Methods methode = new Methods();

        //n = Integer.parseInt(args[0]); // Må åpnes sammen med scanner

        /* Insert: */
        System.out.println("Insert: ");
        if (n <= Max_Sequential) {
            methode.randomize(A);
            methode.insertionSort(A);
        }
        else
            System.out.println("O(n²) sorting to slow for n: " + n);


        /*Quick: */
        System.out.println("Quick: ");
        methode.randomize(A);
        time = System.currentTimeMillis();
        methode.quickSort(A, 0, n - 1);
        time = System.currentTimeMillis() - time;
        System.out.printf("Quicksort\t: %6.3f s\n", time / 1000.0);

        /*Merge: */
        System.out.println("Merge: ");
        methode.randomize(A);
        time = System.currentTimeMillis();
        methode.mergeSort(A, 0, n - 1);
        time = System.currentTimeMillis() - time;
        System.out.printf("Merge sort\t: %6.3f s\n", time / 1000.0);

        /*Radix: */
        System.out.println("Radix: ");
        methode.randomize(A);
        time = System.currentTimeMillis();
        methode.radix(A, 5);
        time = System.currentTimeMillis() - time;
        System.out.printf("Radix sort\t: %6.3f s\n", time / 1000.0);
    }
}
