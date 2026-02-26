public class PrimitiveType {
    public static void main(String[] args) {
        // FORMULA −2^(n−1) to [2^(n−1) ]-1
        
        // integer 4 bytes
        int a = 1000;
        
        // byte 1 bytes [-128 TO 127]
        byte b = 12;
        
        // short 2 bytes 
        short s = 11213;
        
        // long 8 bytes
        /*
        -9,223,372,036,854,775,808 
        to 
        9,223,372,036,854,775,807
        */
        long l = 700_7007_750l;
        
        // float 4 bytes
        float f = 8.6f;

        // double 8 bytes
        double d = 95.85;

        // char 2 bytes
        char ch = 'A';

        // boolean 1 bit
        boolean bl = true; //Or false

        // String
        String st = "Hello!!";
        
        // Print 
        System.out.println("Integer: "+ a);
        System.out.println("Short: "+ s);
        System.out.println("Byte: "+ b);
        System.out.println("Long: "+ l);
        System.out.println("Float: "+ f);
        System.out.println("Double: "+ d);
        System.out.println("Char: "+ ch);
        System.out.println("Boolean: "+ bl);
        System.out.println("String: "+ st);
        



    }
}
