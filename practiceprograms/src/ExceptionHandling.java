public class ExceptionHandling {
    //TO CONTROL THE ERRORS IN PROGRAMS
    public static void main(String[] args) {

        //HOW TO CONTROL EXCEPTION
        //DIVIDE BY ZERO
        try {
            System.out.println(200/0);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        //NULL POINTER OR VALUE EXCEPTION
        String name = null;
        try {
            System.out.println(name.length());
        }
        catch(Exception e) {
            System.out.println(e);
        }

        //NUMBER FORMAT EXCEPTION
        String fullname = "Saksham Saini";
        try {
            int z = Integer.parseInt(fullname);
            System.out.println(z);
        }
        catch (Exception e)
        {
        System.out.println(e);
    }

        //OUT OF BOUNDS EXCEPTION
        int array[] = {1,2,3,4};
        try {
            System.out.println(array[4]);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("finally");
        }
}
}
