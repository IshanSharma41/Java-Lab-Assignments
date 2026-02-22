import java.util.Scanner;
public class arithmeticOperators {
    public int num1, num2;
    public static int addNums(int n1, int n2) {
        return n1 + n2;
    }
    public static int subtractNums(int n1, int n2) {
        return n1 - n2;
    }
    public static int multiplyNums(int n1, int n2) {
        return n1 * n2;
    }
    public static float divideNums(int n1, int n2) {
        return (float) n1 / n2;
    }
    public static int modNums(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {

        arithmeticOperators op = new arithmeticOperators();
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter first no.: ");
        op.num1= scan.nextInt();
        System.out.println("Enter second no.: ");
        op.num2= scan.nextInt();

        int sum=op.addNums(op.num1, op.num2);
        int diff=op.subtractNums(op.num1, op.num2);
        int prod=op.multiplyNums(op.num1, op.num2);
        float div=op.divideNums(op.num1, op.num2);
        int mod=op.modNums(op.num1, op.num2);

        System.out.println("Sum: "+sum+" Difference: "+diff+" Product: "+prod+" Division: "+div+" Modulus: "+mod);
        scan.close();
    }
}

