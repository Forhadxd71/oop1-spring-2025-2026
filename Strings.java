public class Strings {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "Java Programming";
        //System.out.println(str2 + "!");
    
    // Length of the strings
    System.out.println("String 1 Length: "+ str1.length());
    System.out.println("String 2 Length: "+ str2.length());
    // Concatenation
    String conc = str1 + " " + str2; 
    System.out.println("Concatenated String: " + conc);
    // Substring
    String sub = str2.substring(5, 16);
    System.out.println("Substring: "+ sub);
    //Replace
    String rep = str1.replace("Hello", "Try");
    System.out.println("replace: "+ rep);
    // Convert to Uppercase
    String upper = str2.toUpperCase();
    System.out.println("UpperCase: "+ upper);
    // Convert to Lowercase
    String lower = str1.toLowerCase();
    System.out.println("LowerCase: "+ lower);
    //  Trim
    String stringWithSpaces = " Trim me! ";
    String trimmedString = stringWithSpaces.trim();
    //String trimmedString = str2.trim();
    System.out.println("Trimmed String: '" + trimmedString + "'");
    // Boolean checks
    boolean startsWithHello = str1.startsWith("Hello");
    boolean endsWithProgramming = str2.endsWith("World");
    System.out.println("str1 starts with 'Hello': " + startsWithHello);
    System.out.println("str2 ends with 'World': " + endsWithProgramming);
    // Character at index
    char charAtIndex5 = str1.charAt(5);
    System.out.println("Character at index 5 of str1: " + charAtIndex5);
    // Index of substring
    int indexOfJava = str1.indexOf("World");
    System.out.println("Index of 'Java' in str1: " + indexOfJava);
    }
}
