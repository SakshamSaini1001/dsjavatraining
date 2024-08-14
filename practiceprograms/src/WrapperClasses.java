public class WrapperClasses {
    public static void main(String[] args) {
        int a = 3;
        Integer b = 5;
        String c = String.valueOf(a) + b.toString();
        System.out.println(c);
    }
}
