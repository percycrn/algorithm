package d_fourthexp;

import java.util.Scanner;

public class ReverseStringOnline {

    private static String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        scanner.close();
        System.out.println(str.equals(reverseString(str)));
    }
}