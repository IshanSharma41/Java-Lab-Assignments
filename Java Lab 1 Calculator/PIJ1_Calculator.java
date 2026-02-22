import java.util.Scanner;
public class PIJ1_Calculator {
    public int num1, num2, opr;
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
        PIJ1_Calculator c = new PIJ1_Calculator();
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter first no.: ");
        c.num1= scan.nextInt();
        System.out.println("Enter second no.: ");
        c.num2= scan.nextInt();

        do {
        System.out.println("1. Addition  2. Subtraction  3. Multiplication 4. Division 5. Modulus: ");
        c.opr=scan.nextInt();

        switch (c.opr) {
            case 1:
                System.out.println("Result: " + addNums(c.num1, c.num2));
                break;
            case 2:
                System.out.println("Result: " + subtractNums(c.num1, c.num2));
                break;
            case 3:
                System.out.println("Result: " + multiplyNums(c.num1, c.num2));
                break;
            case 4:
                System.out.println("Result: " + divideNums(c.num1, c.num2));
                break;
            case 5:
                System.out.println("Result: " + modNums(c.num1, c.num2));
                break;
        } 
    } while (c.opr!=0);
    }
}
