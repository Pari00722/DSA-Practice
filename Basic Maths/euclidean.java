public class euclidean {
    public static int GCD(int a,int b){
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
            if(a==0){
                return b;
            }else{
                return a;
            }
    }
    public static void main(String[] args) {
        int a=10, b=52;
        System.out.println("GCD of "+a+" & "+b+" is: "+GCD(a,b));
    }
}
