package org.example.module;

import java.io.*;
import java.util.*;

public class Sorting {

    public void Sorting(int x) {

        int Max_Sequential  = 100_000;
        int Max_n           = 100_000_000;

        int A[];
        int n               = 0;
        long time           = 0;

        n = x;
        if (n < 0 || n > Max_n) {
            System.out.println("Use 1 <= n <= " + Max_n);
            System.exit(1);
        }
        A = new int[n];

        methods sort = new methods();

        if (n <= Max_Sequential) {

            // Insertion sort
            randomize(A);
            time = System.currentTimeMillis();
            sort.insertionSort(A);
            time = System.currentTimeMillis() - time;
            System.out.printf("Insertion sort\t: %6.3f s\n", time / 1000.0);
        }
        else
            System.out.println("O(n²) sorting to slow for n: " + n);

        // Quicksort
        randomize(A);
        time = System.currentTimeMillis();
        sort.quickSort(A, 0, n - 1);
        time = System.currentTimeMillis() - time;
        System.out.printf("Quicksort\t: %6.3f s\n", time / 1000.0);

        // Merge sort
        randomize(A);
        time = System.currentTimeMillis();
        sort.mergeSort(A, 0, n - 1);
        time = System.currentTimeMillis() - time;
        System.out.printf("Merge sort\t: %6.3f s\n", time / 1000.0);
    }

    public static void randomize(int A[]) {
        Random r = new Random();
        int n = A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n2);
        }
    }
}
