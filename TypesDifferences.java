

import java.awt.Point;

public class TypesDifferences {
    public static void main(String[] args) {
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println("Primitive type y: " + y);

        Point p1 = new Point(1, 2);
        Point p2 = p1;
        p1.x = 3;
        System.out.println("Reference type p2.x: " + p2.x);
    }

}
 