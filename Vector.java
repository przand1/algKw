package algkw;

import java.lang.IllegalArgumentException;

public class Vector {
  private Complex[] cords;

  public Vector(int n) {
    cords = new Complex[n];
  }
  public Vector(Complex[] cords) {
    this.cords = cords;
  }

  public static Vector add(Vector v, Vector w) {
    Complex[] c1 = v.getCords();
    Complex[] c2 = w.getCords();
    int l = v.length;
    if (l != w.length) {
      throw new IllegalArgumentException("Vectors can't differ in length.");
    }
    Complex[] newCords = new Complex[l];
    for (int i = 0;i < l ; i++ ) {
      newCords[i] = (c1[i] + c2[i]);
    }
    return new Vector(newCords);
  }

  public static Vector mul(Vector v, double n) {
    Complex[] c1 = v.getCords();
    int l = v.length;
    Complex[] newCords = new Complex[l];
    for (int i = 0;i < l ; i++ ) {
      newCords[i] = ();//TODO
    }
    return new Vector(newCords);
  }
  public Complex dot() {

  }
  public Complex norm() {

  }

  public Complex[] getCords() {
    return cords;
  }
  public void setCords(Complex cords[]) {
    this.cords = cords;
  }

}
