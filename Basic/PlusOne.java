public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; 
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        int[] result1 = plusOne(digits1);
        printArray(result1); 

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = plusOne(digits2);
        printArray(result2); 

        int[] digits3 = {9};
        int[] result3 = plusOne(digits3);
        printArray(result3); 
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
