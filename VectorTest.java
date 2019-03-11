package algkw;

import java.io.*;

public class VectorTest {
  public static void main(String[] args) {
    Complex[] c1 = new Complex[]{new Complex(2,3),new Complex(0,-2),new Complex(5,0),new Complex(0,1)};
    Complex[] c2 = new Complex[]{new Complex(0,-1),new Complex(-1,0),new Complex(3,-1),new Complex(-1,-1)};
    Vector v = new Vector(c1);
    Vector w = new Vector(c2);
    System.out.println(v);
    System.out.println(w);
    System.out.println("SUMA:");
    System.out.println(Vector.add(v,w));
    System.out.println("MNOŻENIE "+v+" PRZEZ "+c1[0]+":");
    System.out.println(Vector.mul(v,c1[0]));
    System.out.println("ILOCZYN SKALARNY:");
    System.out.println(Vector.dot(v,w));
    System.out.println("NORMA:");
    System.out.println(Vector.norm(v));
  }
}
