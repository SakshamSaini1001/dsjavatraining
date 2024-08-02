package OOPS;

public class inheritancejava {
    public static void main(String[] args) {
    Parents parents = new Parents();
    parents.printparent();
    parents.printgrandparent();
    }
}
class Parents extends GrandParents{
    void printparent(){
        System.out.println("I'm Parent");
    }
}
class GrandParents{
    void printgrandparent(){
        System.out.println("I'm GrandParent");
    }
}