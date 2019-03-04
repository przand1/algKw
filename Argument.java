package algkw;

public class Argument {
  private int nm;
  private int dnm;

  public Argument(int nm, int dnm) {
    this.nm = nm;
    this.dnm = dnm;
  }

  // public void add(Argument A) {
  //   this.nm += A.getNm();
  //   this.dnm += A.getDnm();
  // }
  // public void sub(Argument A) {
  //   this.nm -= A.getNm();
  //   this.dnm -= A.getDnm();
  // }
  public static Argument add(Argument A,Argument B) {
    int newNm = A.getNm()*B.getDnm() + B.getNm()*A.getDnm();
    int newDnm = A.getDnm()*B.getDnm();
    return new Argument(newNm,newDnm);
  }
  public static Argument sub(Argument A,Argument B) {
    int newNm = A.getNm()*B.getDnm() - B.getNm()*A.getDnm();
    int newDnm = A.getDnm()*B.getDnm();
    return new Argument(newNm,newDnm);
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

	public Argument() {
		super();
	}
}
