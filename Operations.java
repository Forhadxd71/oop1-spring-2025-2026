public class Operations {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // Addition
        int sum = a + b;
        System.out.println("Addition: " + sum);

        // Subtraction
        int difference = a - b;
        System.out.println("Subtraction: " + difference);

        // Multiplication
        int product = a * b;
        System.out.println("Multiplication: " + product);

        // Division
        int quotient = a / b;
        System.out.println("Division: " + quotient);

        // Modulus
        int remainder = a % b;
        System.out.println("Modulus: " + remainder);

        // Increment
        int c = a++;
        int d = ++b;

        System.out.println("Incremented a: " + a);
        System.out.println("Value of c (before increment): " + c);

        System.out.println("Incremented b: " + b);
        System.out.println("Value of d (after increment): " + d);

        // // Decrement
        b--;
        System.out.println("Decremented b: " + b);

        // Compound Assignment
        a += 5;
        System.out.println("a after compound assignment (a += 5): " + a);
        b *= 2;
        System.out.println("b after compound assignment (b *= 2): " + b);
    }
}
 