package org.example;

import org.example.module.Methods;

import java.util.Scanner;

// https://big-o.io/

public class Main {
    public static void main(String[] args) {

        int A[];
        long time           = 0;
        int sort            = 1;

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
                        time = System.currentTimeMillis();
                        methode.randomize(A);
                        methode.insertionSort(A);
                        time = System.currentTimeMillis() - time;
                        System.out.println("  n      t(ms)   t/n*n");
                        System.out.printf("%6d %6d  %9.4e\n", n, time, (float)time / ((float)n * n));
                    } else
                        System.out.println("O(n²) sorting to slow for n: " + n);
                }

                /*Quick: */
                if (mode == 2) {
                    methode.randomize(A);
                    time = System.currentTimeMillis();
                    methode.quickSort(A, 0, n - 1);
                    time = System.currentTimeMillis() - time;
                    System.out.println("  n      t(ms)   t/n*log(n)");
                    System.out.printf("%6d %6d  %9.4e\n", n, time, (float)time / ((float)n * Math.log(n)));
                }

                /*Merge: */
                if (mode == 3) {
                    methode.randomize(A);
                    time = System.currentTimeMillis();
                    methode.mergeSort(A, 0, n - 1);
                    time = System.currentTimeMillis() - time;
                    System.out.println("  n      t(ms)   t/n*log(n)");
                    System.out.printf("%6d %6d  %9.4e\n", n, time, (float)time / ((float)n * Math.log(n)));
                }

                /*Radix: */
                if (mode == 4) {
                    System.out.println("Please insert max amount of siffers: ");
                    int siff = scanner.nextInt();
                    methode.randomize(A);
                    time = System.currentTimeMillis();
                    methode.radix(A, siff);
                    time = System.currentTimeMillis() - time;
                    System.out.printf("Radix sort: %6.3f s\n", time/1000.0);
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
