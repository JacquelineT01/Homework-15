package org.example;

public class Arrays {

    //Task 1.1
    public static void main(String[] args) {
        int[] myArray = new int[5];

        myArray[2] = 42;

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        //Task 1.2

        String[] stringArray = new String[5];
        stringArray[1] = "Good Day!";

        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }

        //Task 2

        String str = "Hello Everyone!";
        char[] charArray = str.toCharArray();
        char targetChar = 'f';

        boolean foundWithForLoop = false;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == targetChar) {
                foundWithForLoop = true;
                break;
            }
        }

        if (foundWithForLoop) {
            System.out.println("Using a for loop: The character '" + targetChar + "' occurs at least once in the string.");
        } else {
            System.out.println("Using a for loop: The character '" + targetChar + "' does not occur in the string.");
        }


        boolean foundWithWhileLoop = false;
        int i = 0;

        while (i < charArray.length && !foundWithWhileLoop) {
            if (charArray[i] == targetChar) {
                foundWithWhileLoop = true;
            }
            i++;
        }

        if (foundWithWhileLoop) {
            System.out.println("Using a while loop: The character '" + targetChar + "' occurs at least once in the string.");
        } else {
            System.out.println("Using a while loop: The character '" + targetChar + "' does not occur in the string.");
        }
    }
}











