import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadLangFile {
    static String readTextFile(String fileName) {
        StringBuilder retString = new StringBuilder();
        try {
            FileInputStream inStream = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
            BufferedReader buffR = new BufferedReader(reader);
            String line;
            while ((line = buffR.readLine()) != null) {    
                retString.append(line);
            }
            buffR.close();

        } catch (FileNotFoundException e) {
            System.out.println("error1: file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("error2: IOExeption");
            e.printStackTrace();
        }
        return retString.toString();
    }
}
