package OOPS;

//it is data binding using methods
public class encapsulationjava {
    public static void main(String[] args) {
        //to print trainer profile
        trainers trainers = new trainers();
        //1. data add using object and reference
        trainers.name = "Pawan Sharma";
        trainers.email = "sharma@gmail.com";
        trainers.technology = "Java";

        System.out.println(trainers.name + " " + trainers.email + " " + trainers.technology);
        //2. data add using objects and method
        trainers.printprofile("Pawan Sharma","sharma@gmail.com","java");

        //3. data add using encapsulation
        //add data using getter setter
        trainers.setName("Saksham");
        trainers.setEmail("saksham@gmail.com");
        trainers.setTechnology("Java");
        System.out.println(trainers.getName() + " " + trainers.getEmail() + " " + trainers.getTechnology());
    }
}
class trainers{
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    String name;
    String email;
    String technology;

    public void printprofile(String pawanSharma, String mail, String java) {
        System.out.println(pawanSharma + " " + mail + " " + java);
    }
}