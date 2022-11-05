package ba.unsa.etf.rpr.t3;

import static java.util.Objects.hash;

public class InternationalNumber extends PhoneNumber{
    private String state;
    private String num;
    InternationalNumber(String state, String num){
        this.state=state;
        this.num=num;
    }
    public String Print() {
        return new StringBuilder().append(this.state).append("/").append(this.num).toString();
    }

    public int hashCode() {
        return hash(state,num);
    }
}
