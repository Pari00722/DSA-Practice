public class countdigit {
    int count(int n){
        int cnt=0;
        while(n>0){
            cnt=cnt+1;
            n=n/10;
        }
        return cnt;
    }
   public static void main(String args[]){
    int n = 456798;
    countdigit obj=new countdigit();
    int digits=obj.count(n);
    System.out.println("number of digits: "+digits);
   } 
}

//time complecity of this program- O(log10(n))

