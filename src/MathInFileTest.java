import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MathInFileTest {
    private static final String INPUT_FILE = "operations.txt";
    private static final String OUTPUT_FILE = "out.txt";

    public static void main(String[] args) {
        File file = new File(INPUT_FILE);
        File outputFile = new File(OUTPUT_FILE);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            String inLine = null;
            while ((inLine=br.readLine()) != null){
                Scanner in = new Scanner(inLine);
                in.useLocale(Locale.US);
                double a = in.nextDouble();
                String operation = in.next("[\\+\\-*/%]");
                double b = in.nextDouble();
                double result = calculate(a, b, operation);

                String msg = inLine + " = " + result + "\n";

                System.out.print(msg);
                bw.write(msg);
                bw.flush();
            }

        } catch (IOException | InputMismatchException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static double calculate(double a, double b, String op){
        switch (op){
            case "+" :
                return a + b;
            case "-" :
                return a - b;
            case "*" :
                return a * b;
            case "/" :
                return a / b;
            default:
                throw new IllegalArgumentException("Nie znana operacja");
        }
    }
}
