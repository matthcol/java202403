package algorithm;

public class Main {
    public static void main(String[] args) {
        int a = 15;
        int b = 21;
        int p = AlgoMath.pgcd(a, b);
        System.out.println(
                "Pgcd a=" + a
                + ", b=" + b
                + " is " + p
        );

        int n = 500;
        long f = AlgoMath.fiboOpt(n);
        System.out.println("Fibo n=" + n + " is " + f);
    }
}