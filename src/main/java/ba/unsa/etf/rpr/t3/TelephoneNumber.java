package ba.unsa.etf.rpr.t3;

import static java.util.Objects.hash;

public class TelephoneNumber extends PhoneNumber {
    private String num;
    private City city;
    private TelephoneNumber(City city, String num){
           this.city=city;
           this.num=num;
    }
    public City getCity(){
        return this.city;
    }
    public String getNum(){
        return this.num;
    }

    @Override
    public String Print() {
        return new StringBuilder().append(this.city).append("/").append(this.num).toString();
    }

    @Override
    public int hashCode() {
        return hash(city,num);
    }
}
