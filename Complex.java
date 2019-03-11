package algkw;

import java.lang.IllegalArgumentException;

public class Complex {
  private double real;
  private double img;
  private double modulus;
  private Argument argument;

  public Complex(double real, double img) {
    setReal(real);
    setImg(img);
    setModulus( Math.sqrt( real*real + img*img ) );
  }
  public Complex(double modulus,Argument argument) {
    setModulus(modulus);
    setArgument(argument);
  }
  public Complex(Complex a) {
    this(a.getReal(),a.getImg());
    if(a.getArgument() != null)
      setArgument(a.getArgument());//TODO zmień na kopiowanie!
      setModulus(this.getModulus());
  }

  // DODAWANIE
  //statyczne - tworzy nowy Complex będący sumą dwóch podanych
  public static Complex add(Complex a,Complex b) {
    return new Complex(a.getReal()+b.getReal(), a.getImg()+b.getImg());
  }
  //ta instancja = ta instancja + inny Complex
  public void add(Complex a) {
    this.real += a.getReal();
    this.img += a.getImg();
  }
  // ODEJMOWANIE
  public static Complex sub(Complex a,Complex b) {
    return new Complex(a.getReal()-b.getReal(), a.getImg()-b.getImg());
  }
  public void sub(Complex a) {
    this.real -= a.getReal();
    this.img -= a.getImg();
  }

  // MNOŻENIE
  //statyczne - tworzy nowy Complex będący iloczynem dwóch podanych
  public static Complex mul(Complex a, Complex b) {
    if (a.getArgument() == null && b.getArgument() == null) {
      double newR = newRealMul(a,b);
      double newI = newImgMul(a,b);
      return new Complex(newR,newI);
    }
    else return new Complex(a.getModulus()*b.getModulus(), Argument.add(a.getArgument(),b.getArgument()));
  }
  //ta instancja = ta instancja * inny Complex
  public void mul(Complex a) {
    this.real = newRealMul(this,a);
    this.img = newImgMul(this,a);
  }
  //prywatne metody obliczające współczynniki
  private static double newRealMul(Complex a, Complex b) {
    return a.getReal()*b.getReal() - a.getImg()*b.getImg();
  }
  private static double newImgMul(Complex a, Complex b) {
    return a.getImg()*b.getReal() + a.getReal()*b.getImg();
  }

  // SPRZĘŻENIE
  //na tej instancji
  public void conjugateSelf() {
    setImg( -1 * getImg());
  }
  //zwraca sprzężoną kopię siebie
  public Complex conjugate() {
    Complex a = new Complex(this);
    a.conjugateSelf();
    return a;
  }

  //DZIELENIE
  //statyczne - tworzy nowy Complex będący ilorazem dwóch podanych
  public static Complex div(Complex a, Complex b) {
    if (a.getArgument() == null && b.getArgument() == null) {
      checkZero(b);
      double newR = newRealDiv(a, b);
      double newI = newImgDiv(a, b);
      return new Complex(newR,newI);
    }
    else
      return new Complex(a.getModulus()/b.getModulus(), Argument.sub(a.getArgument(),b.getArgument()));
  }
  //ta instancja = ta instancja / inny Complex
  public void div(Complex a) {
    checkZero(a);
    this.real = newRealDiv(this,a);
    this.img = newImgDiv(this,a);
  }
  //prywatne metody obliczające współczynniki
  private static double newRealDiv(Complex a, Complex b) {
    double A = a.getReal();
    double B = a.getImg();
    double C = b.getReal();
    double D = b.getImg();
    return (A*C + B*D) / (C*C + D*D);
  }
  private static double newImgDiv(Complex a, Complex b) {
    double A = a.getReal();
    double B = a.getImg();
    double C = b.getReal();
    double D = b.getImg();
    return (B*C - A*D) / (C*C + D*D);
  }
  //oraz sprawdzenie, czy dzielnik nie jest zerem
  private static void checkZero(Complex b) {
    if (b.getReal()==0 && b.getImg()==0) {
      throw new IllegalArgumentException("Can't divide by 0");
    }
  }

  // POTĘGOWANIE
  public Complex pow(int n) {
    Complex C = new Complex(this);
    C.setModulus( Math.pow(this.getModulus(), n) );
    C.setArgument( new Argument( n*this.getArgument().getNm(), this.getArgument().getDnm() ) );
    return C;
  }

  public static Complex[] copyArray(Complex[] arr) {
    int n = arr.length;
    Complex[] newArr = new Complex[n];
    for (int i = 0;i < n ; i++ ) {
      newArr[i] = new Complex(arr[i]);
    }
    return newArr;
  }



  public double getReal() {
    return real;
  }
  public double getImg() {
    return img;
  }
  public double getModulus() {
    return modulus;
  }
  public Argument getArgument() {
    return argument;
  }
  public void setReal(double real) {
    this.real = real;
  }
  public void setImg(double img) {
    this.img = img;
  }
  public void setModulus(double modulus) {
    this.modulus = modulus;
  }
  public void setArgument(Argument argument) {
    this.argument = argument;
  }

  @Override
  public String toString() {
    if (argument != null) {
      return getModulus()+"(cos("+getArgument().getNm()+"PI/"+getArgument().getDnm()+") + i*sin("+getArgument().getNm()+"PI/"+getArgument().getDnm()+"))";
    }
    if (getImg()==0) {
      return String.valueOf(getReal());
    }
    else if(getReal()==0) {
      return getImg()+"i";
    }
    else {
      return getImg() < 0 ? getReal()+" "+getImg()+"i" : getReal()+" + "+getImg()+"i";
    }
  }
}
