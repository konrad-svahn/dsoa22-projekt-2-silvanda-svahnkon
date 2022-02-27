import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<CharPrevalance> prev = new ArrayList<CharPrevalance>();
	private static ArrayList<CharPrevalance> prev2 = new ArrayList<CharPrevalance>();
	private static ArrayList<CharPrevalance> prev3 = new ArrayList<CharPrevalance>(); // ;)
	private static String input;
	private static LangLabel lang;
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Print.prompt();
            input = Util.testUserInput(scan);
			prev = Util.calcPrevelance(input);
			prev2 = Util.calcThreeChar(input);
			prev3 = Util.calcFirstChar(input);
			Print.visualiser(prev);
			Print.visualiser(prev2);
			Print.visualiser(prev3);
			//System.out.println(Util.profileDiferance(prev, Util.calcPrevelance("aaaaabbccd")));
			lang = Util.identifyLang(prev);
			Print.gues(lang);
        }
	}
}

