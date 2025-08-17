import java.util.*;
public class divisors {
    public static void main(String[] args) {
       int n = 36;
       List<Integer>divisors=new ArrayList<>();
       
       for(int i=1;i*i<=n;i++){
        if(n%i==0){
            divisors.add(i);
            if((n/i)!=i){
                divisors.add(n/i);
            }
        }
       }
       Collections.sort(divisors);
       System.out.println("Divisors of "+n+" : "+divisors);
    }
}