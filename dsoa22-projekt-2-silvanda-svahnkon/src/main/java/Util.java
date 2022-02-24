import java.util.ArrayList;
import java.util.Scanner;

public class Util {
    
    public static String testUserInput (Scanner scanAction) {  
        boolean warning = false; 
        while (true){
            if (warning){Print.warning();}
            warning = true;
            if (scanAction.hasNext()){String input = scanAction.nextLine();
                input = proccesString(input);
                if (isValid(input)) {
                    return input;
                }
            }
        }
    }

    private static String proccesString (String input) {
        String output ="";
        String temp;
        for (int i = 0; i < input.length(); i++) {
            temp = String.valueOf(input.charAt(i));
            if (!temp.matches("\\p{Punct}|\\d|[¤]")) {
                output = output + temp;
            }
        }
        return output;
    }

    private static boolean isValid (String input){
        boolean valid = false;
        if (input.length() >= 5){
            valid = true;
        }
        return valid;
    } 

    public static ArrayList<CharPrevalance> calcPrevelance(String input) {
        ArrayList<CharPrevalance> prevalance = new ArrayList<CharPrevalance>();
        boolean alredyBenAdded;
        String tempS;
        int tempI;
        for (int i = 0; i < input.length(); i++) {
            tempS = String.valueOf(input.charAt(i));
            alredyBenAdded = false;
            if (prevalance.size() <= 0) {
                prevalance.add(new CharPrevalance(tempS, 1, input.length()));
            } else if (tempS.matches("\\s")) {

            } else {
                for (int j = 0; j < prevalance.size(); j++) {
                    if (tempS.matches(prevalance.get(j).getCharacter())) {
                        tempI = prevalance.get(j).getAmount();
                        tempI += 1;
                        prevalance.get(j).setAmount(tempI);
                        alredyBenAdded = true;
                    } 
                }
                if (!alredyBenAdded) {
                    prevalance.add(new CharPrevalance(tempS, 1, input.length()));
                }
            }   
        }
        return prevalance;
    }
}
