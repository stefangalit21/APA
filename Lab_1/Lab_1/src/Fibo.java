import jdk.jfr.Unsigned;

import java.math.BigInteger;

public class Fibo {
    public static int fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static int fibo2(int n) {
        int i = 0;
        int j = 1;
        for (int k = 1; k < n; k++) {
            j = i + j;
            i = j - i;
        }
        return j;
    }

    public static long fibo3(long n) {

        long i = 1;
        long j = 0;
        long k = 0;
        long h = 1;
        long t;
        while (n > 0) {
            if (n % 2 != 0) {
                t = j * h;
                j = i * h + j * k + t;
                i = i * k + t;

            }
            t = h * h;
            h = 2 * k * h + t;
            k = k * k + t;
            n /= 2;
        }
        return j;
    }

    public static BigInteger fibo33(int n) {
        if (n == 0) return BigInteger.ZERO;
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}}; // Identity matrix
        BigInteger[][] fibMatrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        n = n - 1;

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrices(result, fibMatrix);
            }
            fibMatrix = multiplyMatrices(fibMatrix, fibMatrix);
            n /= 2;
        }
        return result[0][0];
    }

    // Helper method for matrix multiplication with BigInteger
    private static BigInteger[][] multiplyMatrices(BigInteger[][] a, BigInteger[][] b) {
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0])
                        .add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1])
                        .add(a[0][1].multiply(b[1][1]))},

                {a[1][0].multiply(b[0][0])
                        .add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1])
                        .add(a[1][1].multiply(b[1][1]))}
        };
    }

    public static BigInteger fibo22(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        return b;
    }
}
