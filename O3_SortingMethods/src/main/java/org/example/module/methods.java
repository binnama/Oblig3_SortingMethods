
package org.example.module;

import java.io.*;
import java.util.*;

/*
1. Innstikksortering (insertion sort)
2. Quicksort
3. Flettesrotering (merge sort)
4. Radixsortering
*/

public class methods {

   void insertionSort(int A[]) {
        int n = A.length;
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
    }

    void quickSort(int A[], int min, int max) {

        int indexofpartition;

        if (max - min > 0) {
            indexofpartition = findPartition(A, min, max)
            quickSort(A, min, indexofpartition - 1);
            quickSort(A, indexofpartition + 1, max);
        }
    }

    void mergesort(int[] A, int min, int max) {

       if (min ==max)
           return;

       int [] temp;
       int index1, left, right;
       int size = max - min + 1;
       int mid = (min + max) / 2;

       temp = new int [size];

       mergesort(A, min, mid);
       mergesort(A, min + 1, max);

       for (index1 = 0; index1 < size; index1++)
           temp[index1] = A[min + index1];

       left = 0;
       right = mid - min +1;
       for (index1 = 0; index1 < size; index1++) {
           if (right <= max - min)
               if (left <= mid - min)
                   if (temp[left] > temp[right])
                       A[index1 + min] = temp[right++];
                    else
                        A[index1 + min] = temp[left++];
               else
                   A[index1 + min] = temp[right];
           else
               A[index1 + min] = temp[left++];
       }
    }

    void radix(int[] A) {

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
}
