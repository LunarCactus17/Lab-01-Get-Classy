public class ObjInputTest  {
    public static void main(String[] args) {
        // Create a SafeInputObj instance (using default System.in)
        SafeInputObj pipe = new SafeInputObj();

        // Get non-zero length string
        String name = pipe.getNonZeroLenString("Enter your name: ");

        // Get ranged integer
        int age = pipe.getRangedInt("Enter your age (18-65): ", 18, 65);


        // Get unconstrained integer
        int id = pipe.getInt("Enter your ID number: ");


        // Get ranged double
        double weight = pipe.getRangedDouble("Enter your weight (in kg) [40-150]: ", 40, 150);


        // Get unconstrained double
        double height = pipe.getDouble("Enter your height (in meters): ");


        // Get Y/N confirmation
        boolean continueFlag = pipe.getYNConfirm("Do you want to continue? ");


        // Get string matching regex (example: phone number)
        String phone = pipe.getRegExString("Enter your phone number (format: XXX-XXX-XXXX): ", "\\d{3}-\\d{3}-\\d{4}");

    }
}
