package org.example;

import org.example.module.Methods;
import org.example.module.Sorting;

public class Main {
    public static void main(String[] args) {
        //Sorting sort = new Sorting();
        //sort.Sorting(500);

        Methods methode = new Methods();

        int n = 50;
        int A[];
        //n = Integer.parseInt(args[0]); // Må åpnes sammen med scanner


        A = new int[n];
        methode.insertionSort(A);
        methode.quickSort(A, 0, n - 1);
        methode.mergeSort(A, 0, n - 1);
        methode.radix(A, 5);

    }
}
