package scenario6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static void solve(Question question) {
        // Write algorithm here
    }

    public static void main(String[] args) {
	// write your code here
        File file;
        Scanner scanner;

        try {
            file = new File("robots.mat");
            scanner = new Scanner(file);

            int i = 0;
            while (scanner.hasNextLine() && i<2) {
                i++;
                String q = scanner.nextLine();
                Question question = new Question(q);
                solve(question);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
