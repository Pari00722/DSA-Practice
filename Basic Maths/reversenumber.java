public class reversenumber {
    public int reverseNumber(int num){
        int revNum = 0;
        while(num > 0){
            int lastDigit = num % 10;
            revNum = (revNum*10) + lastDigit;
            num = num / 10;
        }
        return revNum;
    }
    public static void main(String[] args) {
        reversenumber number = new reversenumber();
        int n = 56458;
        int result = number.reverseNumber(n);
        System.out.println("The Reversed number of "+n+" is "+result);
    }
}
