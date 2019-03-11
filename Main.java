package algkw;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    // zadanie 1
    Complex A = new Complex(1,5);
    Complex B = new Complex(3,-4);
    Complex C = Complex.add(A,B);
    Complex D = Complex.sub(A,B);
    System.out.println(A+" + "+B+" = ");
    System.out.println(C);
    System.out.println(A+" - "+B+" = ");
    System.out.println(D);
    System.out.println();
    A.setReal(10);A.setImg(-7);
    B.setReal(-13);B.setImg(4);
    System.out.println(A+" + "+B+" = ");
    System.out.println(C);
    System.out.println(A+" - "+B+" = ");
    System.out.println(D);
    System.out.println();
    A.setReal(-1);A.setImg(-6);
    B.setReal(-1);B.setImg(7);
    System.out.println(A+" + "+B+" = ");
    System.out.println(C);
    System.out.println(A+" - "+B+" = ");
    System.out.println(D);
    System.out.println();

    // zadanie 2
    A.setReal(0);A.setImg(5);
    B.setReal(3);B.setImg(0);
    C = Complex.mul(A,B);
    D = Complex.div(A,B);
    System.out.println(A+" * "+B+" = ");
    System.out.println(C);
    System.out.println(A+" / "+B+" = ");
    System.out.println(D);
    System.out.println();
    A.setReal(1);A.setImg(-8);
    B.setReal(-3);B.setImg(-1);
    C = Complex.mul(A,B);
    D = Complex.div(A,B);
    System.out.println(A+" * "+B+" = ");
    System.out.println(C);
    System.out.println(A+" / "+B+" = ");
    System.out.println(D);
    System.out.println();

    Complex c1 = new Complex(4,new Argument(2,3));
    Complex c2 = new Complex(2,new Argument(5,6));
    System.out.println(c1+" * "+c2+" = ");
    System.out.println(Complex.mul(c1,c2));
    System.out.println();

    Complex c3 = c1.pow(4);
    System.out.println(c1+"^4 = "+c3);
    System.out.println();

    System.out.println("sprzężenie "+A);
    System.out.println(A.conjugate());

  }
}
