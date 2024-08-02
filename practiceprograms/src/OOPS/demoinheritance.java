package OOPS;

public class demoinheritance extends calci{
    public static void main(String[] args) {
        calci calci = new calci();
        System.out.println("addition " + calci.add(4,2));
        System.out.println("subtraction "+ calci.sub(4,2));
        System.out.println("Multiplication " + calci.mul(4,2));
        System.out.println("Division " + calci.div(4,2));
    }
}

class calci{
    int add(int a, int b){
        return a+b;
    }
    int sub(int a, int b){
        return a-b;
    }
    int mul(int a, int b){
        return a*b;
    }
    int div(int a, int b){
        return a/b;
    }
}
