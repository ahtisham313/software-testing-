/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.removeduplicates;

/**
 *
 * @author DELL
 */

  import java.util.Arrays;
public class RemoveDuplicates {
 public static void main(String[] args) {
 int[] array = {1, 1, 2, 2, 3, 4, 4, 5};
 int newLength = removeDuplicates(array);
 System.out.println("Array after removing duplicates: " + 
Arrays.toString(Arrays.copyOf(array, newLength)));
 }
 public static int removeDuplicates(int[] array) {
 if (array.length == 0) return 0;
 int j = 0;
 for (int i = 1; i < array.length; i++) {
 if (array[i] != array[j]) {
 j++;
 array[j] = array[i];
 }
 }
 return j + 1;
 }
}
