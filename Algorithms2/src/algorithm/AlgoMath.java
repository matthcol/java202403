package algorithm;

public class AlgoMath {

    public static int pgcd(int a, int b){
        while (a != b){
            if (a > b){
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static long fibo(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // recursive call
            return fibo(n-2) + fibo(n-1);
        }
    }

    public static long fiboOpt(int n){
        long prec2 = 0;
        long prec1 = 1;
        long next = -1; // dummy initialization
        if (n == 0) {
            return prec2;
        }
        if (n == 1){
            return prec1;
        }
        for (int i = 2; i <= n; i++){
            next = prec2 + prec1;
            prec2 = prec1;
            prec1 = next;
        }
        return next;
    }
}

