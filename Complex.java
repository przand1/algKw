package algkw;

import java.lang.IllegalArgumentException;

public class Complex {
  private double real;
  private double img;
  //private double phi;

  public Complex(double real, double img) {
    this.setReal(real);
    this.setImg(img);
  }
  public Complex(Complex a) {
    this(a.getReal(),a.getImg());
  }

  // DODAWANIE
  //statyczne - tworzy nowy Complex będący sumą dwóch podanych
  public static Complex add(Complex a,Complex b) {
    return new Complex(a.getReal()+b.getReal(), a.getImg()+b.getImg());
  }
  //ta instancja = ta instancja + inny Complex
  public void add(Complex a) {
    this.real += a.getReal();
    this.img += b.getImg();
  }

  // MNOŻENIE
  //statyczne - tworzy nowy Complex będący iloczynem dwóch podanych
  public static Complex mul(Complex a, Complex b) {
    double newR = newRealMul(Complex a, Complex b);
    double newI = newImgMul(Complex a, Complex b);
    return new Complex(newR,newI);
  }
  //ta instancja = ta instancja * inny Complex
  public void mul(Complex a) {
    this.real = newRealMul(this,a);
    this.img = newImgMul(this,a);
  }
  //prywatne metody obliczające współczynniki
  private static newRealMul(Complex a, Complex b) {
    return a.getReal()*b.getReal() - a.getImg()*b.getImg();
  }
  private static newImgMul(Complex a, Complex b) {
    return a.getImg()*b.getReal() + a.getReal()*b.getImg();
  }

  // SPRZĘŻENIE
  //na tej instancji
  public void conjugate() {
    a.setImg( -1 * a.getImg());
  }
  //zwraca sprzężoną kopię siebie
  public Complex conjugate() {
    Complex a = new Complex(this);
    a.conjugate();
    return a;
  }

  //DZIELENIE
  //statyczne - tworzy nowy Complex będący ilorazem dwóch podanych
  public static Complex div(Complex a, Complex b) {
    checkZero(b);
    double newR = newRealDiv(Complex a, Complex b);
    double newI = newImgDiv(Complex a, Complex b);
    return new Complex(newR,newI);
  }
  //ta instancja = ta instancja / inny Complex
  public void div(Complex a) {
    checkZero(a);
    this.real = newRealDiv(this,a);
    this.img = newImgDiv(this,a);
  }
  //prywatne metody obliczające współczynniki
  private static newRealDiv(Complex a, Complex b) {
    double A = a.getReal();
    double B = a.getImg();
    double C = b.getReal();
    double D = b.getImg();
    return (A*C + B*D) / (C*C + D*D);
  }
  private static newImgDiv(Complex a, Complex b) {
    double A = a.getReal();
    double B = a.getImg();
    double C = b.getReal();
    double D = b.getImg();
    return (B*C - A*D) / (C*C + D*D);
  }
  //oraz sprawdzenie, czy dzielnik nie jest zerem
  private void checkZero(Complex b) {
    if (b.getReal()==0 && b.getImg()==0) {
      throw new IllegalArgumentException("Can't divide by 0");
    }
  }

  // MODUŁ
  public double Modulus() {
    return Math.sqrt( real*real + img*img );
  }

  //TODO postać trygonometryczna



  public double getReal() {
    return real;
  }
  public double getImg() {
    return img;
  }
  public void setReal(double real) {
    this.real = real;
  }
  public void setImg(double img) {
    this.img = img;
  }
}
