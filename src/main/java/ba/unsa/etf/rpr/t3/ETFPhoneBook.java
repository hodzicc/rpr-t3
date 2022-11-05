package ba.unsa.etf.rpr.t3;

/**
 * Hello world!
 *
 */
public class ETFPhoneBook
{
    public static void main( String[] args )
    {
        PhoneBook Pbook = new PhoneBook();
        MobilePhoneNumber number= new MobilePhoneNumber(61,"291-673");
        Pbook.Add("Amna",number);
        String ime = Pbook.GetName(number);
        System.out.println(Pbook.GetPhoneNum(ime));
        System.out.println(ime);

    }
}
