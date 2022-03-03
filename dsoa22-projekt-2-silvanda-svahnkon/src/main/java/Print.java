import java.util.ArrayList;

public class Print {

    public static void warning() {
        System.out.println("du måste skriva in minst 5 bokstäver");
    }

    public static void prompt() {
        System.out.println("skriv text på tyska, engelska, spanska, finska, franska, italienska, norska eller svenska och programmet kommer att gissa vilket språk du skrev på");
    }

    public static void gues(LangLabel lang) {
        System.out.println(lang.getName());
    }
    
    public static void visualiser(ArrayList<CharPrevalance> prevalance) {
        for (CharPrevalance chara : prevalance) {
            System.out.println(chara.getCharacter()+" "+chara.getAmount()+" "+chara.getProcentOfTotalString());
        }
    }

    public static void list (Language[] list) {
        System.out.println();
        System.out.println("    medeltal             analys1             analys2             analys3");
        for (Language language : list) {
            System.out.println(language.getLabel()+"  "+language.getFinalDiference()+"  "+language.getAnalys1()+"  "+language.getAnalys2()+"  "+language.getAnalys3());
        }
    }

}
