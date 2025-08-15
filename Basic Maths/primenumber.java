public class primenumber {
    public static void main(String[] args) {
        int n = 13;
        int counter = 0;
        for(int i=1 ; i*i <= n; i++){
            if((n%i)==0) {
                counter ++;
                if((n/i)!=i) counter++;
            }
        }
        if(counter==2){
            System.out.println("It is a Prime number");
        }else{
                System.out.println("It is not a Prime number");
        }
    }
}
