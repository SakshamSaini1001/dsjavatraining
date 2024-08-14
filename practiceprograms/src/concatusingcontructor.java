import java.util.Scanner;

public class concatusingcontructor {
    public static void main(String[] args) {
        System.out.println("enter first name");
        Scanner sc = new Scanner(System.in);
        String fName = sc.nextLine();
        System.out.println("enter last name");
        String lName = sc.nextLine();
        MyClass1 myClass1 = new MyClass1(fName,lName);
        System.out.println(myClass1.c + myClass1.d);
    }
}
class MyClass1{
    String c,d;

    public MyClass1(String a, String b) {
        this.c = a;
        this.d = b;
        //System.out.println(c + " " + d);
    }
}