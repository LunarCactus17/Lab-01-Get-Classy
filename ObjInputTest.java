public class ObjInputTest  {
public static void main(String[] args) {

    SafeInputObj pipe = new SafeInputObj(); 



    String name = pipe.getNonZeroLenString("Enter your name: ");
    System.out.println("Hello, " + name + "!");

    int age = pipe.getRangedInt("Enter your age (18-65): ", 18, 65);
    System.out.println("You are " + age + " years old.");

    double weight = pipe.getDouble("Enter your weight (in kg): ");
    System.out.println("Your weight is " + weight + " kg.");

    boolean confirmed = pipe.getYNConfirm("Do you want to continue? ");
    if (confirmed) {
        System.out.println("Continuing...");
    } else {
        System.out.println("Exiting...");
    }

    // You can use other methods of SafeInputObj similarly
}
}
