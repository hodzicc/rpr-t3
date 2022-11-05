package ba.unsa.etf.rpr.t3;
import java.util.*;

public class PhoneBook {
    private HashMap<String,PhoneNumber> map=new HashMap<>();
    public void Add(String name, PhoneNumber num)
    {
        map.put(name,num);
    }
    public String GetPhoneNum(String name){
        PhoneNumber num = (PhoneNumber) map.get(name);
        return num.Print();
    }
    public String GetName(PhoneNumber num1){
        for(HashMap.Entry<String,PhoneNumber> entry: map.entrySet()){
            if(entry.getValue().equals(num1))
            {
                String name1= entry.getKey();
                return name1;
            }
        }
        return null;
    }
    public String FirstLetter(char s){
        int i=0;
        for(HashMap.Entry<String,PhoneNumber> entry: map.entrySet()){
            if(Character.compare(entry.getKey().charAt(0),s)==0)
            {
                System.out.println(i+". "+entry.getKey()+" - ");
                   entry.getValue().Print();
            }
        }
        return null;
    }
    public Set<String> ComingFrom(City g){
          HashSet<String> strings=new HashSet<>();
          for(HashMap.Entry<String,PhoneNumber> entry: map.entrySet()){
            if(entry.getValue() instanceof TelephoneNumber)
            {
                if(((TelephoneNumber) entry.getValue()).getCity().equals(g))
                {
                    strings.add(entry.getKey());
                }
            }
        }

          TreeSet<String> strings1=new TreeSet<String>(strings);

          return strings1;

    }
    public Set<PhoneNumber> NumbersFrom(City g){
        HashSet<PhoneNumber> numbers = new HashSet<>();
        TreeMap<String,PhoneNumber> numMap = new TreeMap<>();
        for(HashMap.Entry<String,PhoneNumber> entry: map.entrySet()){
            if(entry.getValue() instanceof TelephoneNumber)
            {
                if(((TelephoneNumber) entry.getValue()).getCity().equals(g))
                {
                   PhoneNumber num = entry.getValue();
                   numMap.put(num.Print(),num);
                }
            }
        }
        Iterator<Map.Entry<String,PhoneNumber>> it = numMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,PhoneNumber> entry = it.next();
            numbers.add(entry.getValue());
        }
        return numbers;

    }



}
