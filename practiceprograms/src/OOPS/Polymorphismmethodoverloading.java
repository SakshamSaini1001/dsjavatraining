package OOPS;

public class Polymorphismmethodoverloading {
    public static void main(String[] args) {
        //method calling
        // 8 bytes
       // 16 bytes
        System.out.println("m1 " + add(5,6)+ " m2 " +add(2.5,9.3));
    }

    private static double add(double v, double v1) {
        return v+v1;
    }

    private static int add(int i, int i1) {
        return i + i1 ;
    }
}
