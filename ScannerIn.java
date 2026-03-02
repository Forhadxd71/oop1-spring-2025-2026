import java.util.Scanner;

public class ScannerIn {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        byte age = Scan.nextByte();
        System.out.println("Age: "+age);

        String Name = Scan.nextLine().trim().toLowerCase();
        System.out.println("Name: "+ Name);

        Scan.close();
    }
    
}
