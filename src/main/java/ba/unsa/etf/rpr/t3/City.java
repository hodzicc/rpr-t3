package ba.unsa.etf.rpr.t3;

public enum City {
   Sarajevo("033"), Tuzla("032"), Zenica("034"), Livno("034"), Mostar("036"), Bihać("037");
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
