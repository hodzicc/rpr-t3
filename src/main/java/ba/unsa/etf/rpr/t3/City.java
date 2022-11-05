package ba.unsa.etf.rpr.t3;

public enum City {
   SARAJEVO("033"), TUZLA("032"), ZENICA("034"), LIVNO("034"), MOSTAR("036"), BIHAC("037");
  //  SARAJEVO("Sarajevo"), TUZLA("Tuzla"), ZENICA("Zenica"), LIVNO("Livno"), MOSTAR("Mostar");
    private String s;

    City(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
