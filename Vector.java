package algkw;

import java.lang.IllegalArgumentException;
import java.util.Random;
import java.util.Arrays;

public class Vector {
  private Complex[] cords;

  public Vector(int n) {
    Random rand = new Random();
    cords = new Complex[n];
    for (int i = 0;i < n ;i++ ) {
      cords[i] = new Complex(rand.nextInt()*rand.nextDouble(), rand.nextInt()*rand.nextDouble());
    }
  }
  public Vector(Complex[] cords) {
    this.cords = cords;
  }

  public static Vector add(Vector v, Vector w) {
    Complex[] c1 = Arrays.copyOf(v.getCords(),v.getCords().length);
    Complex[] c2 = Arrays.copyOf(w.getCords(),w.getCords().length);
    int l = c1.length;
    if (l != c2.length) {
      throw new IllegalArgumentException("Vectors can't differ in length.");
    }
    Complex[] newCords = new Complex[l];
    for (int i = 0;i < l ; i++ ) {
      newCords[i] = Complex.add(c1[i],c2[i]);
    }
    return new Vector(newCords);
  }

  public static Vector mul(Vector v, Complex c) {
    int l = v.getCords().length;
    Complex[] newCords = Arrays.copyOf(v.getCords(),l);
    for (int i = 0;i < l ; i++ ) {
      newCords[i].mul(c);
    }
    return new Vector(newCords);
  }
  public static Complex dot(Vector v, Vector w) {
    Complex[] c1 = Arrays.copyOf(v.getCords(),v.getCords().length);
    Complex[] c2 = Arrays.copyOf(w.getCords(),w.getCords().length);
    int l = c1.length;
    if (l != c2.length) {
      throw new IllegalArgumentException("Vectors can't differ in length.");
    }
    Complex C = new Complex(0,0);
    for (int i = 0;i < l ; i++ ) {
      C.add(Complex.mul(c1[i],c2[i].conjugate()));
    }
    return C;
  }
  public static Complex norm(Vector v) {
    return new Complex(Math.sqrt(Vector.dot(v,v).getReal()),0);
  }

  public Complex[] getCords() {
    return cords;
  }
  public void setCords(Complex cords[]) {
    this.cords = cords;
  }

	@Override
	public String toString() {
    String s = "Vector [ ";
    for (Complex c : cords) {
      s += (c+", ");
    }
		return s + " ]";
	}
}
