public class armstrong {
    public boolean ArmStrongNum(int n){
        int duplicate = n;
        int sum = 0;
        int reversenumber = 0;
        while(n>0){
            int lastDigit=n%10;
            sum = sum + (lastDigit*lastDigit*lastDigit);
            n = n/10;
            reversenumber = (reversenumber*10)+lastDigit;
        }
        return sum == duplicate;
    }
    public static void main(String[] args) {
        armstrong obj = new armstrong();
        int n = 1634;
        boolean result = obj.ArmStrongNum(n);

        if(result){
            System.out.println(n+" is an Armstrong number");
        }
        else{
            System.out.println(n+" is not an Armstrong number");
        }
    }
}
