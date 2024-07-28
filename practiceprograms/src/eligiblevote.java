import java.util.Scanner;

public class eligiblevote {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print(name + " ");
        String val = (age > 18)?"you can vote":"you can't vote";
        System.out.println(val);
    }
}