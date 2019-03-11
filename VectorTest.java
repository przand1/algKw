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

    System.out.println("-------------------------------");
    Complex[] c3 = new Complex[]{new Complex(0,1/Math.sqrt(2)),new Complex(0,-1/Math.sqrt(2))};
    Vector x = new Vector(c3);
    System.out.println(x);
    System.out.println(Vector.dot(x,x));
    System.out.printf("%.5g%n\n",Vector.dot(x,x).getReal());

    System.out.println("-------------------------------");
    Complex[] c4 = new Complex[]{new Complex(0.5,0.5),new Complex(0.5,0.5)};
    Vector xx = new Vector(c4);
    System.out.println(xx);
    System.out.println(Vector.dot(xx,xx));
    System.out.printf("%.5g%n\n",Vector.dot(xx,xx).getReal());

    System.out.println("-------------------------------");
    Complex[] c5 = new Complex[]{new Complex(Math.cos(45),Math.sin(45)),new Complex(1,0)};
    Vector xxx = new Vector(c5);
    System.out.println(xxx);
    System.out.println(Vector.dot(xxx,xxx));
    System.out.printf("%.5g%n\n",Vector.dot(xxx,xxx).getReal());
  }
}
