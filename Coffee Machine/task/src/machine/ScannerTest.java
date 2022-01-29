package machine;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Default delimiter is: " + s.delimiter());

        System.out.print("Unesite a: ");
        int a = s.nextInt();
        System.out.println("a = " + a);
        s.nextLine();

        System.out.print("Unesite rečenicu s1: ");
        String s1 = s.nextLine();
        System.out.println("s1 = " + s1);

        System.out.print("Unesite b: ");
        int b = s.nextInt();
        System.out.println("b = " + b);


    }
}
