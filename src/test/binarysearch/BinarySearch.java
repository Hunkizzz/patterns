package test.binarysearch;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class BinarySearch {


    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int middle = left + (right - left) / 2;

            if(arr[middle] == x)
                return middle;

            if(arr[middle] < x)
                left = middle + 1;

            if(arr[middle] > x)
                right = middle - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();
        try (IntStream stream = IntStream.range(1, 100)) {
            stream.boxed().forEach(a -> list.add(a.intValue()));
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);

        System.out.println(binarySearch(array, 1));
    }

}
