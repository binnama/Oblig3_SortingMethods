package org.example;

import org.example.module.Methods;

import java.util.Scanner;

// https://big-o.io/

public class Main {
    public static void main(String[] args) {

        int A[];
        long time           = 0;
        int sort            = 1;
        float C             = 0;
        float totC          = 0;
        int testRuns        = 5;

        while (sort == 1){
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Please choose the lenght of the array: ");
                int n = scanner.nextInt();

                System.out.println("Please choose the method you would like to test: ");
                System.out.println("1: Insert\n" +
                        "2: Quick\n" +
                        "3: Merge\n" +
                        "4: Radix\n" +
                        "5: Exit");
                int mode = scanner.nextInt();

                System.out.println("Please choose waht sortingmethod you want to use: ");
                System.out.println("1. Sort and time\n" +
                        "2. Estimated Big-Oh");
                int sorter = scanner.nextInt();

                int Max_n = 100_000_000;
                int Max_Sequential = 100_000;

                if (n < 0 || n > Max_n) {
                    System.out.println("Use 1 <= n <= " + Max_n);
                    System.exit(1);
                }
                A = new int[n];

                Methods methode = new Methods();

                if (mode < 1 || mode > 5)
                    System.out.println("Please choose a number between 1 and 5");

                /* Insert: */
                if (mode == 1) {
                    if (n <= Max_Sequential) {
                        if (sorter == 1){
                            methode.randomize(A);
                            time = System.currentTimeMillis();
                            methode.insertionSort(A);
                            time = System.currentTimeMillis() - time;
                            System.out.printf("Insert sort\t: %6.3f s\n", time / 1000.0);
                        }
                        if (sorter == 2) {
                           for (int i = 0; i < testRuns; i++) {
                               methode.randomize(A);
                               time = System.currentTimeMillis();
                               methode.insertionSort(A);
                               time = System.currentTimeMillis() - time;
                               C = (float)time / ((float)n * n);
                               totC += C;
                           }
                            float avC = totC / testRuns;
                            System.out.println("Insert have a constant C that is " + avC + " for n = " + n);
                        }
                    } else
                        System.out.println("O(n??) sorting to slow for n: " + n);
                }

                /*Quick: */
                if (mode == 2) {
                    if (sorter == 1) {
                        methode.randomize(A);
                        time = System.currentTimeMillis();
                        methode.quickSort(A, 0, n - 1);
                        time = System.currentTimeMillis() - time;
                        System.out.printf("Quick sort\t: %6.3f s\n", time/1000.0);
                    }
                    if (sorter == 2) {
                        for (int i = 0; i < testRuns; i++) {
                            methode.randomize(A);
                            time = System.currentTimeMillis();
                            methode.quickSort(A, 0, n - 1);
                            time = System.currentTimeMillis() - time;
                            C = (float) ((float)time / ((float)n * Math.log(n)));
                            totC += C;
                        }
                        float avC = totC / testRuns;
                        System.out.println("Quick have a constant C that is " + avC + " for n = " + n);
                    }
                }

                /*Merge: */
                if (mode == 3) {
                    if (sorter == 1) {
                        methode.randomize(A);
                        time = System.currentTimeMillis();
                        methode.mergeSort(A);
                        time = System.currentTimeMillis() - time;
                        System.out.printf("Merge sort: %6.3f s\n", time/1000.0);
                    }
                    if (sorter == 2) {
                        for (int i = 0; i < testRuns; i++) {
                            methode.randomize(A);
                            time = System.currentTimeMillis();
                            methode.mergeSort(A);
                            time = System.currentTimeMillis() - time;
                            C = (float) ((float) time / ((float) n * Math.log(n)));
                            totC += C;
                        }
                        float avC = totC / testRuns;
                        System.out.println("Merge have a constant C that is " + avC + " for n = " + n);
                    }
                }

                /*Radix: */
                if (mode == 4) {
                    System.out.println("Please insert max amount of siffers: ");
                    int siff = scanner.nextInt();
                    if (sorter == 1) {
                        methode.randomize(A);
                        time = System.currentTimeMillis();
                        methode.radix(A, siff);
                        time = System.currentTimeMillis() - time;
                        System.out.printf("Radix sort: %6.3f s\n", time/1000.0);
                    }
                    if (sorter == 2) {
                        for (int i = 0; i < testRuns; i++) {
                            methode.randomize(A);
                            time = System.currentTimeMillis();
                            methode.radix(A, siff);
                            time = System.currentTimeMillis() - time;
                            C = (float) time / n;
                            totC += C;
                        }
                        float avC = totC / testRuns;
                        System.out.println("Radix have a constant C that is " + avC + " for n = " + n);
                    }
                }

                if (mode == 5) {
                    System.out.println("\nGoodbye");
                    sort = 0;
                }
            } catch (Exception e) {
                System.out.println("Please write a number");
            }
        }
    }
}
