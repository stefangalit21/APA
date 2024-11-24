import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int n = 20;

        long startTime = System.nanoTime();
        //     int result1 = Fibo.fibo(n);
        long endTime = System.nanoTime();
        double duration1 = (endTime - startTime) / 1_000_000_000.0;
        //   System.out.printf("The First algorithm for %d elements using recursion result: %d --- %.9f seconds\n", n, result1, duration1);
        startTime = System.nanoTime();
        BigInteger result2 = Fibo.fibo22(n);
        endTime = System.nanoTime();
        double duration2 = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("The Second algorithm for %d elements using iteration result: %s --- %.9f seconds\n", n, result2.toString(), duration2);
        System.out.printf("Time execution : %.9f\n",  duration2);
        startTime = System.nanoTime();
        BigInteger result3 = Fibo.fibo33(n);
        endTime = System.nanoTime();
        double duration3 = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("The Third algorithm for %d elements using matrix exponentiation result: %s --- %.9f seconds\n", n, result3.toString(), duration3);
        System.out.printf("Time execution : %.9f", duration3);
    }

}
