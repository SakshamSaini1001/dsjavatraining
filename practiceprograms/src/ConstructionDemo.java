public class ConstructionDemo {
    public static void main(String[] args) {
        //call constructor object
        MyClass myClass = new MyClass(5,8);
        System.out.println("c = " + myClass.c);
        System.out.println("d = " + myClass.d);
    }
}

class MyClass{

    //parameter constructor
    public MyClass(int a, int b) {
        c = a;
        this.d = b;
        System.out.println(c+d);
    }
    int c,d;
}