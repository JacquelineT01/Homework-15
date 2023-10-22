package org.example;

public class ArithmeticMeanCalculator {


//Task 3
    public static void main(String[] args) {
        int[] numbers = {5, 20, 30, 40, 50};

        int sum = 0;
        int count = numbers.length;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        int average = (int) sum / count;

        System.out.println("Sum of elements: " + sum);
        System.out.println("Number of elements: " + count);
        System.out.println("Arithmetic Mean (Average): " + average);

        //Task 4
        int largest = numbers[0];

        for (int number : numbers) {
            largest = Math.max(largest, number);
        }
        System.out.println("Largest element: " + largest);


    }

}

