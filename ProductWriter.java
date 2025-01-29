import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.cvs");
        Scanner in = new Scanner(System.in);
        ArrayList<String> productList= new ArrayList<>();
        String name = "";
        String description = "";
        double cost = 0;
        boolean done = false;

        do{
            name = SafeInput.getNonZeroLenString(in,"Enter the name of product");
            description = SafeInput.getNonZeroLenString(in,"Enter the description for this product");
            cost = SafeInput.getRangedDouble(in,"Enter the cost for this product",0,10000);
            Product product = new Product(name,description,cost);
            productList.add(product.toCSV());
            done = SafeInput.getYNConfirm(in,"Are you done?");
        }while(!done);

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            for(String rec : productList)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
