package doyoCodingtest.DoyoProgrammers.Solution0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 정수 배열 array가 매개변수로 주어질 때,
 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 **/

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numElements = Integer.parseInt(reader.readLine());
        //배열선언하는 방법(입력받은 값의 배열)
        int[] numbers =  new int[numElements];

        // Read elements into the array
        for (int i = 0; i < numElements; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        // Find largest element and its index
        int largestValue = findLargest(numbers);
        int indexOfLargest = findIndexOfLargest(numbers);

        // Print result
        System.out.println("The largest value is " + largestValue + " and its index is " + indexOfLargest + ".");
    }


    // Method to find the largest element in the array
    private static int findLargest(int[] numbers) {
        int largest = numbers[0];
        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    // Method to find the index of the largest element
    private static int findIndexOfLargest(int[] numbers) {
        int indexOfLargest = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[indexOfLargest]) {
                indexOfLargest = i;
            }
        }
        return indexOfLargest;
    }
}

