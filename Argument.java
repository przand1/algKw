package algkw;

public class Argument {
  private int nm;
  private int dnm;

  public Argument(int nm, int dnm) {
    this.nm = nm;
    this.dnm = dnm;
  }

  public static Argument add(Argument A,Argument B) {
    int newNm = A.getNm()*B.getDnm() + B.getNm()*A.getDnm();
    int newDnm = A.getDnm()*B.getDnm();
    int gcd = GCD(newNm,newDnm);
    if (gcd > 1) {
      newNm = newNm / gcd;
      newDnm = newDnm / gcd;
    }
    return new Argument(newNm,newDnm);
  }
  public static Argument sub(Argument A,Argument B) {
    int newNm = A.getNm()*B.getDnm() - B.getNm()*A.getDnm();
    int newDnm = A.getDnm()*B.getDnm();
    int gcd = GCD(newNm,newDnm);
    if (gcd > 1) {
      newNm = newNm / gcd;
      newDnm = newDnm / gcd;
    }
    return new Argument(newNm,newDnm);
  }

  private static int GCD(int a, int b) {
    if (b==0) return a;
    return GCD(b,a%b);
  }

	public int getNm() {
		return nm;
	}

	public void setNm(int nm) {
		this.nm = nm;
	}

	public int getDnm() {
		return dnm;
	}

	public void setDnm(int dnm) {
		this.dnm = dnm;
	}
}
