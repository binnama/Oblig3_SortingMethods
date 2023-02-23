
package org.example.module;

import java.util.*;

/*
1. Innstikksortering (insertion sort)
2. Quicksort
3. Flettesrotering (merge sort)
4. Radixsortering
*/

public class Methods {

    int Max_Sequential  = 100_000;

    int A[];
    int n               = 0;
    long time           = 0;

  public void insertionSort(int A[]) {
          //randomize(A);
          time = System.currentTimeMillis();

          int n = A.length;
          //System.out.println("Testing insert: " + n);
          int key;

          for (int i = 1; i < n; i++) {
              key = A[i];
              int j = i;

              while (j > 0 && A[j - 1] > key) {
                  A[j] = A[j - 1];
                  j--;
              }
              A[j] = key;
          }

          time = System.currentTimeMillis() - time;
          System.out.printf("Insertion sort\t: %6.3f s\n", time / 1000.0);
      }

    public void quickSort(int A[], int min, int max) {

        //randomize(A);
        int indexofpartition;

        if (max - min > 0) {
            indexofpartition = findPartition(A, min, max);
            quickSort(A, min, indexofpartition - 1);
            quickSort(A, indexofpartition + 1, max);
        }
    }

    public void mergeSort(int[] A, int min, int max) {

        //randomize(A);
        if (min == max)
            return;

        int [] temp;
        int index1, left, right;
        int size = max - min + 1;
        int mid = (min + max) / 2;

        temp = new int [size];

        mergeSort(A, min, mid);
        mergeSort(A, min + 1, max);

        for (index1 = 0; index1 < size; index1++)
            temp[index1] = A[min + index1];

        left = 0;
        right = mid - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min)
                if (left <= mid - min)
                    if (temp[left] > temp[right])
                        A[index1 + min] = temp[right++];
                    else
                        A[index1 + min] = temp[left++];
                else
                    A[index1 + min] = temp[right++];
            else
                A[index1 + min] = temp[left++];
        }
    }

    public void radix(int[] A, int maxSiffer) {

        randomize(A);
        int tenInM = 1;
        int n = A.length;

        Queue<Integer> [] Q = (Queue<Integer>[]) (new Queue[10]);

        for (int i = 0; i < 10; i++) {
            Q[i] = new LinkedList();
        }

        for (int m = 0; m < maxSiffer; m++) {
            for (int i = 0; i < n; i++) {
                int siffer = (A[i] / tenInM) % 10;
                Q[siffer].add(new Integer(A[i]));
            }

            int j = 0;
            for (int i = 0; i < 10; i++) {
                while (!Q[i].isEmpty()){
                    A[j++] = (int) Q[i].remove();
                }
            }

            tenInM *= 10;
        }
    }

    private int findPartition (int[] A, int min, int max) {
        int left, right;
        int temp, partitionelement;

        partitionelement = A[min];

        left = min;
        right = max;

        while (left < right) {
            while (A[left] <= partitionelement && left < right)
                left++;
            while (A[right] > partitionelement)
                right--;
            if (left < right) {
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        temp = A[min];
        A[min] = A[right];
        A[right] = temp;

        return right;
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