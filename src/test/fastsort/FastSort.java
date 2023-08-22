package test.fastsort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FastSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 6, 1, 3, 5};

        FastSort fastSort = new FastSort();
        if (!fastSort.isSorted(array)) {
            fastSort.sortArray(array);
        }

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public int[] sortArray(int[] nums) {
        if(isSorted(nums))
            sort(nums, 0, nums.length - 1);
        return nums;
    }

    public boolean isSorted (int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }

    private void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, high);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}