import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.cvs");
        Scanner in = new Scanner(System.in);
        ArrayList<String> peopleRecordChart= new ArrayList<>();
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        boolean done = false;

        do{
            firstName = SafeInput.getNonZeroLenString(in,"Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in,"Enter the last name");
            title = SafeInput.getNonZeroLenString(in,"Enter the title");
            yearOfBirth = SafeInput.getRangedInt(in,"Enter the year of birth",1940,2010);
            Person person = new Person(firstName,lastName,title,yearOfBirth);
            peopleRecordChart.add(person.toCSV());
            done = SafeInput.getYNConfirm(in,"Are you done?");
        }while(!done);

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : peopleRecordChart)
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