public class practice {
    static int fib(int n){
        if(n<=1){
            return n;
        }
        int last=fib(n-1);
        int slast=fib(n-2);
        return last+slast;
    }
    public static void main(String[] args) {
        int n =6;
        System.out.println("Fibonacci number of "+n+"th position is "+fib(n));
    }
}


