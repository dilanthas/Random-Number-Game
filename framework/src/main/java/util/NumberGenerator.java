package util;

import java.util.Random;

public class NumberGenerator {

    public static int getRandomNumber(int min , int max){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        int number = r.nextInt((max - min) + 1) + min;
        System.out.println("Your number is :"+number);
        return number;
    }

}
