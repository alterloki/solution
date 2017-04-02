package ru.alterloki; /**
 * Created by IntelliJ IDEA.
 * User: ashevenkov
 * Date: 20.01.15
 * Time: 16:19
 */

import java.util.Arrays;

/**
 * @author ashevenkov
 */
public class FindMiss {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindMiss().findMiss(new int[]{9, 4, 1, 2, 5, 6, 8, 7})));
    }

    private int[] findMiss(int[] arr) {
        int[] result = new int[2];
        int pointer = 0;
        int[] additional = new int[2];
        while (pointer < arr.length) {
            while (arr[pointer] != pointer + 1 && arr[pointer] > 0) {
                if (arr[pointer] > arr.length) {
                    swapAdditional(arr, pointer, additional, arr[pointer] - arr.length - 1);
                } else {
                    swap(arr, pointer, arr[pointer] - 1);
                }
            }
            pointer++;
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                result[counter++] = i + 1;
            }
        }
        for (int i = 0; i < additional.length; i++) {
            if(additional[i] == 0) {
                result[counter++] = i + arr.length + 1;
            }
        }
        return result;
    }

    private void swapAdditional(int[] arr, int pointer, int[] additional, int i) {
        int temp = arr[pointer];
        arr[pointer] = additional[i];
        additional[i] = temp;
    }

    private void swap(int[] arr, int pointer, int i) {
        int temp = arr[pointer];
        arr[pointer] = arr[i];
        arr[i] = temp;
    }

}
