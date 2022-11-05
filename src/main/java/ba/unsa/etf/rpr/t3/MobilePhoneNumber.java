package ba.unsa.etf.rpr.t3;

import static java.util.Objects.hash;

public class MobilePhoneNumber extends PhoneNumber{
    private int mobileNetwork;
    private String num;
    public MobilePhoneNumber(int mobileNetwork, String num)
    {
        this.mobileNetwork=mobileNetwork;
        this.num=num;
    }

    public String Print() {
        return new StringBuilder().append("0").append(this.mobileNetwork).append("/").append(this.num).toString();
    }

    public int hashCode() {
        return hash(mobileNetwork,num);
    }


}
