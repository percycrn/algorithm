package d_fourthexp;

/*
 *
 * @程序名: ReverseString.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-25
 * @修改日期: 2017-10-25
 *
 */

import java.util.Scanner;

// 编写一个方法用于验证指定的字符串是否为反转字符，返回true和false。请用递归算法实现。（反转字符串样式为"abcdedcba"）
public class ReverseString {
    private static int lengthOfArray;
    private static boolean flag = true;

    private static void checkReverseString(char[] arr, int i) {
        if (i < lengthOfArray / 2) {
            return;
        }
        if (arr[i - 1] == arr[lengthOfArray - i]) {
            checkReverseString(arr, i - 1);
        } else {
            flag = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        char[] arr = str.toCharArray();
        lengthOfArray = arr.length;
        checkReverseString(arr,lengthOfArray);
        System.out.println(flag);
    }
}
