package org.example.module;

import java.io.*;
import java.util.*;


public class Sorting {
    int Max_Sequential  = 100_000;
    int Max_n           = 100_000_000;

    int A[];
    int n               = 0;
    long time           = 0;

    n = Integer.parseInt(args[0]);
    if (n < 0 || n > Max_n) {
        System.out.println("Use 1 <= n <= " + Max_n);
        System.exit(1);
    }
    A = new int[n];

    sequentialSorting sS = new sequentialSorting();
    logarithmicSorting lS = new logarithmicSorting();

    if (n <= Max_Sequential) {
        // Selection sort
        randomize(A);
        time = System.currentTimeMillis();
        sS.selectionSort(A);
        time = System.currentTimeMillis() - time;
        System.out.printf("Selection sort\t: %6.3f s\n", time / 1000.0);

        // Insertion sort
        randomize(A);
        time = System.currentTimeMillis();
        sS.insertionSort(A);
        time = System.currentTimeMillis() - time;
        System.out.printf("Insertion sort\t: %6.3f s\n", time / 1000.0);

        // Bubble sort
        randomize(A);
        time = System.currentTimeMillis();
        sS.bubbleSort(A);
        time = System.currentTimeMillis() - time;
        System.out.printf("Bubble sort\t: %6.3f s\n", time / 1000.0);
    }
    else
        System.out.println("O(n²) sorting to slow for n: " + n);

    // Shell sort
    randomize(A);
    time = System.currentTimeMillis();
    sS.shellSort(A);
    time = System.currentTimeMillis() - time;
    System.out.printf("Shell sort\t: %6.3f s\n", time / 1000.0);

    // Quicksort
    randomize(A);
    time = System.currentTimeMillis();
    sS.Quicksort(A);
    time = System.currentTimeMillis() - time;
    System.out.printf("Quicksort\t: %6.3f s\n", time / 1000.0);

    randomize(A);
    time = System.currentTimeMillis();
    sS.mergeSort(A);
    time = System.currentTimeMillis() - time;
    System.out.printf("Merge sort\t: %6.3f s\n", time / 1000.0);

    public static void randomize(int A[]) {
        Random r = new Random();
        int n = A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n2);
        }
    }
}
