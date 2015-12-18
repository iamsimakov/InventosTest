import java.util.Scanner;

public class Kamni {

    public static void main(String[] args) {
        long[] s = new long[35];
        int n;
        long c, cp = 0, min;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            s[i] = in.nextLong();
            cp = cp + s[i];
        }
        min = cp;

        for (int i = 1; i < Math.pow(2, n); i++) {
            int m = i;
            c = 0;

            for (int j = 1; j <= n; j++) {
                if (m % 2 == 1) c = c + s[j];
                m = m / 2;
            }
            if (Math.abs(2 * c - cp) < min) min = Math.abs(2 * c - cp);
        }
        System.out.print(min);
    }

}