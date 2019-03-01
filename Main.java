package algkw;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    // zadanie 1
    Complex A = new Complex(1,5);
    Complex B = new Complex(3,-4);
    Complex C = Complex.add(A,B);
    Complex D = Complex.sub(A,B);
    System.out.println(C);
    System.out.println(D);
    System.out.println();
    A.setReal(10);A.setImg(-7);
    B.setReal(-13);B.setImg(4);
    C = Complex.add(A,B);
    D = Complex.sub(A,B);
    System.out.println(C);
    System.out.println(D);
    System.out.println();
    A.setReal(-1);A.setImg(-6);
    B.setReal(-1);B.setImg(7);
    C = Complex.add(A,B);
    D = Complex.sub(A,B);
    System.out.println(C);
    System.out.println(D);
    System.out.println();

    // zadanie 2
    A.setReal(0);A.setImg(5);
    B.setReal(3);B.setImg(0);
    C = Complex.mul(A,B);
    D = Complex.div(A,B);
    System.out.println(C);
    System.out.println(D);
    System.out.println();
    A.setReal(1);A.setImg(-8);
    B.setReal(-3);B.setImg(-1);
    C = Complex.mul(A,B);
    D = Complex.div(A,B);
    System.out.println(C);
    System.out.println(D);
    System.out.println();

  }
}
