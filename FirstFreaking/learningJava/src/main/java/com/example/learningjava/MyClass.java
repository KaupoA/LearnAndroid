package com.example.learningjava;

public class MyClass {

    public static void main(String[] args) {

        System.out.println("New Class");

        String name = "Kaupo";

        System.out.println(name);

        int age = 24;

        age = 20;
        age = 28;

        System.out.println(age);

        int moneyInMyWallet = 500;
        int soldWheels = 250;
        int boughtTyres = 200;

        moneyInMyWallet = moneyInMyWallet + soldWheels;

        moneyInMyWallet = moneyInMyWallet - boughtTyres;

        System.out.println(moneyInMyWallet);

        // This is single-line comment
        /* This is multi-line comment
        That
        is
        totally
        right!
         */

        // Booleans

        String dog = "Holden";

        int dogAge = 2;

        double pie = 3.14;

        boolean isCute = true;

        // If Statements

        if (isCute) {

            System.out.println("Holden is cute!");

        } else {

            System.out.println("Impossibru!");

        }

        if (age != 18) {

            System.out.println("You are not 18!");

        } else {

            System.out.println("You are 18!");

        }

        // 1. Make a boolean variable that is equal to false
        boolean turnOn = false;

        // 2. Make an if statement that prints hello, if the above boolean is true
        if (turnOn) {

            System.out.println("Hello!");

        }

        // 3. Make an int variable and use it in an if-else statement
        int goproPrice = 250;

        if (goproPrice <= 250) {

            System.out.println("GoPro is on sale!");

        } else {

            System.out.println("GoPro isn't on sale!");

        }

        // 4. (optional) Use an if statement to see if two strings are equal to each other
        String firstName = "Kaupo";

        String lastName = "Aun";

        if (firstName == lastName) {

            System.out.println("You have identical first and last name!");

        } else {

            System.out.println("Your first and last names are different!");

        }

        // Arrays

        String[] names = new String[]{"Birgit", "Kaupo", "Holden", "Helmut"};

        int[] ages = new int[]{4, 12, 65, 23, 86, 342, 8765, names.length};

        boolean[] myBools = new boolean[]{true, false, false, true, false, true, true};

        System.out.println(names[0]);

        System.out.println(ages[4]);

        System.out.println(myBools[4]);

        // Length of the array

        System.out.println(myBools.length);

        // Get the last item of the array

        System.out.println(myBools[myBools.length - 1]);

        // 1. Make an array of Doubles

        double[] doubleNumbers = new double[]{4.13, 3.14, 2.56, 4, 765.34, 13, 2341};

        // 2. Make an array of ints and then create an if statement that prints "BIG"
        // if the array is longer than 10 ints.

        int[] muchInt = new int[]{12, 45, 764, 42, 978, 865, 134, 12567, 343, 4532, 87};

        if (muchInt.length > 10) {

            System.out.println("BIG");

        }

        // Loops

        for (int i = 0; i < 5; i++) {

            System.out.println("5 korda " + i);

        }

        String[] familyMembers = new String[]{"Birgit", "Kaupo", "Holden", "Helmut"};

        for (int i = 0; i < familyMembers.length; i++) {

            System.out.println(familyMembers[i]);

        }

        // 1. Make a loop that prints something 5 times

        for (int i = 0; i < 5; i++) {

            System.out.println("Veel 5 korda");

        }

        // 2. Make an array of ints and loop through each item in the array
        // to add all the ints together and print out that number

        int[] numbers = new int[]{4, 6, 12};

        int total = 0;

        for (int i = 0; i < numbers.length; i++) {

            total = total + numbers[i];

        }

        System.out.println(total);

        // Functions

        // 1. Make a function that prints your favourite song title

        songTitle();

        // 2. Make a function that takes a first and last name as parameters and prints out the full name

        firstLastName("Kaupo ", "Aun");

        // 3. Make the above function to return the full name instead of printing it

        System.out.println(returnFirstLastName("Kaupo ", "Aun"));

    }

    public static void songTitle() {

        System.out.println("Fallen Leaves");

    }

    public static void firstLastName(String firstName, String lastName) {

        System.out.println(firstName + lastName);

    }

    public static String returnFirstLastName(String firstName, String lastName) {

        return firstName + lastName;

    }

}
