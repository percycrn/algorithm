import java.util.Scanner;

//LCM = lowest common multiple
//求三个数的LCM
public class LCM {
    //两个数的最小公倍数
    static private int LCM(int a, int b) {
        int temp, mul = a * b;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return mul / a;
    }

    public static void main(String[] args) {
        int a, b, c, ab;
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        ab = LCM(a, b);
        System.out.println(LCM(ab, c));
    }
}
