package j_tenthexp;

import java.io.*;

public class OptimalMatrixMultiply {
    private static int[][] com;

    public static void main(String[] args) {
        LinkedList bracket = new LinkedList();
        LinkedList linkedList = new LinkedList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("F:\\30 IntelliJ IDEA JavaSrc\\algorithm\\src\\j_tenthexp\\matrix")));
            String check;
            while ((check = reader.readLine()) != null) {
                String[] a = check.split(" ");
                linkedList.add(Integer.valueOf(a[0]), Integer.valueOf(a[1]));
            }
            System.out.println("matrix: ");
            linkedList.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int quantity = linkedList.getSize();
        int[][] min = new int[quantity + 1][quantity + 1];
        com = new int[quantity + 1][quantity + 1];
        for (int distance = 1; distance < quantity; distance++) {
            for (int i = 1; i <= quantity - distance; i++) {
                int j = i + distance;
                min[i][j] = linkedList.get(i).height * linkedList.get(i + 1).height * linkedList.get(i + 1).width
                        + min[i + 1][j];
                com[i][j] = i;
                for (int k = i; k <= distance; k++) {
                    int temp = min[i][k] + min[k + 1][j]
                            + linkedList.get(i).height * linkedList.get(k + 1).height * linkedList.get(j).width;
                    if (temp < min[i][j]) {
                        min[i][j] = temp;
                        com[i][j] = k;
                        bracket.add(i, j);
                    }
                }
            }
        }
        System.out.print("Optimal Matrix Multiplication: ");
        System.out.println(min[1][quantity]);
        combine(1, quantity);
    }

    private static void combine(int i, int j) {
        System.out.print("(");
        if (i != com[i][j]) {
            combine(i, com[i][j]);
        } else {
            System.out.print("M" + i + "*");
        }
        if (j != com[i][j] + 1) {
            combine(com[i][j] + 1, j);
        } else {
            System.out.print("M" + j);
        }
        System.out.print(")");
    }
}
