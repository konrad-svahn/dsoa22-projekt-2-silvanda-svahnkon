import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<CharPrevalance> prev = new ArrayList<CharPrevalance>();
	private static String input;
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Print.prompt();
            input = Util.testUserInput(scan);
			prev = Util.calcPrevelance(input);
			Print.visualiser(prev);
        }
	}
}

