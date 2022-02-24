import java.util.ArrayList;
import java.util.Scanner;

public class Util {
    
    // loopar tils användaren skriver in en text som är mera än 5 bokstäver
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

    // spjälkar bort sifror och special tecken ur den inskrivna strängen(tar inte bort melanslag eftersom de behövs för att veta var ett nyt ord börjar vilket är viktigt i upg3)
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

    //testar om strängen är kortare än 5 tecken 
    private static boolean isValid (String input){
        boolean valid = false;
        if (input.length() >= 5){
            valid = true;
        }
        return valid;
    } 

    //retunerar en lista på Char prevelanse objeckt som ineholer info om hur ofta en teckenserie förekomer i en sträng
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


    public static LangLabel identifyLang (ArrayList<CharPrevalance> prevalance) {
        
        
        return LangLabel.DE;
    }

    //jämför skilnaden mellan två listor på prevelansen av tecken i stvå olika strängar
    public static double profileDiferance(ArrayList<CharPrevalance> input ,ArrayList<CharPrevalance> langSample) {
        CharPrevalance[] valuesInLangSampleButNotInInput = new CharPrevalance[langSample.size()];
        boolean isInInputButNotLangSample;
        ArrayList<Double> differences = new ArrayList<Double>();
        double totalDiferense = 0;
        // läger till alla värden som fins i langSample till valuesInLangSampleButNotInInput vi tar bort dem som fins i input senare
        for (int i = 0; i < valuesInLangSampleButNotInInput.length; i++) {
            valuesInLangSampleButNotInInput[i] = langSample.get(i);
        }
        // går igenom input och jämför med langsample om sama täckenserie hittas räknas skilnaden melan deras prevelans ut och lägs till i differense
        for (int i = 0; i < input.size(); i++) {
            // en variabel som blir true om det nuvarande i värdet machar något av j värdena
            isInInputButNotLangSample = false;
            for (int j = 0; j < langSample.size(); j++) {
                if (input.get(i).getCharacter().matches(langSample.get(j).getCharacter())) {
                    differences.add(Math.abs(input.get(i).getProcentOfTotalString() - langSample.get(j).getProcentOfTotalString()));
                    //om et värde som fins i input också fins i langSample tas värde med sama index bort från valuesInLangSampleButNotInInput
                    //det här kan göras eftersom värdena i båda är ordnade i sama ordning
                    valuesInLangSampleButNotInInput[j] = null;  
                    isInInputButNotLangSample = true;
                }
            }
            //om värdet i input inte machade något av värdena i langSample är prevelansen i langSample 0 vilket betyder att skinaden är lika stor som input.get(i)'s procent värdet
            if (isInInputButNotLangSample == false) {
                differences.add(input.get(i).getProcentOfTotalString());
            }
        }
        //lägger till varge procent värde som inte fans i input till diferenses         
        for (int i = 0; i < valuesInLangSampleButNotInInput.length; i++) {
            if (valuesInLangSampleButNotInInput[i] != null) {
                //inget absolutbelop eller subtraktion behövs eftersom vi redan vet att det värdet i input är 0. vilket betyder att skinaden är lika stor som procent värdet
                differences.add(valuesInLangSampleButNotInInput[i].getProcentOfTotalString());
            }
        }
        for (int i = 0; i < differences.size(); i++) {
            totalDiferense += differences.get(i);
        }
        return totalDiferense;
    }
}
