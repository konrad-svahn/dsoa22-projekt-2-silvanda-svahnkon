import java.util.ArrayList;

public class Print {

    public static void warning() {
        System.out.println("du måst sktiva in minst 5 bokstäver");
    }

    public static void prompt() {
        System.out.println("skriv text på tyska, engelska, spanska, finska, franska, italienska, norska eller svenska och programet komer att gissa vilket språk du skrev på");
    }
    
    public static void visualiser(ArrayList<CharPrevalance> prevalance) {
        for (CharPrevalance chara : prevalance) {
            System.out.println(chara.getCharacter()+" "+chara.getAmount()+" "+chara.getProcentOfTotalString());
        }
    }

}
