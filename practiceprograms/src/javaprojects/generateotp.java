package dsjavatraining;

import java.util.Random;

public class generateotp {
    public static void main(String[] args) {
        Random random = new Random();
        int otp = random.nextInt(100000);
        System.out.println("your otp is :" + otp);
    }
}
