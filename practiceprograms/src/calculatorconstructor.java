import java.util.Scanner;

public class calculatorconstructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        int a = sc.nextInt();
        System.out.println("Enter second number");
        int b = sc.nextInt();
        System.out.println(" Enter 1 for addition \n Enter 2 for subtraction \n Enter 3 for multiplication \n Enter 4 for division");
        int choice = sc.nextInt();
        Calculator calculator = new Calculator(a,b,choice);
    }
}
class Calculator {
    int a, b, k;

    public Calculator(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.k = c;
        if(k==1){
            System.out.println("The sum is "+(a+b));
        }
        else if(k==2){
            System.out.println("The difference is "+(a-b));
        }
        else if(k==3){
            System.out.println("The product is "+(a*b));
        }
        else if(k==4){
            System.out.println("The division is "+(a/b));
        }
        else {
            System.out.println("Invalid input");
        }
    }
}
