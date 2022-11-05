package ba.unsa.etf.rpr.t3;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static ba.unsa.etf.rpr.t3.City.*;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @org.junit.jupiter.api.Test
    void add() throws WrongNameException {
        PhoneBook pb = new PhoneBook();
        pb.Add("Ben Affleck", new InternationalNumber("+1", "23 45-67-89"));
        pb.Add("Hasan Hasanovic", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Sinan Sakic", new TelephoneNumber(SARAJEVO, "123-456"));
        try {
            assertEquals("033/123-456", pb.GetPhoneNum("Sinan Sakic"));
        } catch (WrongNameException e) {
            throw new RuntimeException(e);
        }
        TelephoneNumber num1 = new TelephoneNumber(SARAJEVO, "123-456");
        assertEquals("Sinan Sakic", pb.GetName(num1));

    }

    @org.junit.jupiter.api.Test
    void firstLetter() {
        PhoneBook pb = new PhoneBook();
        pb.Add("Merima Hadzic", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Lejla Alibegovic", new TelephoneNumber(SARAJEVO, "123-656"));
        pb.Add("Ivan Milanovic", new MobilePhoneNumber(61, "321-645"));
        pb.Add("Milan Ivanic", new MobilePhoneNumber(64, "987-654"));
        pb.Add("Brad Pitt", new InternationalNumber("+1", "23 45-67-89"));
        assertEquals( "1. Ivan Milanovic - 061/321-645", pb.FirstLetter('I'));
    }

    @org.junit.jupiter.api.Test
    void comingFrom() {
        PhoneBook pb = new PhoneBook();
        pb.Add("Ivan Milanovic", new TelephoneNumber(SARAJEVO, "123-456"));
        pb.Add("Merima Hadzic", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Lejla Alibegovic", new TelephoneNumber(SARAJEVO, "123-656"));
        pb.Add("Milan Ivanic", new MobilePhoneNumber(64, "987-654"));
        pb.Add("Dwayne Johnson", new InternationalNumber("+1", "23 45-67-89"));
        Set<String> set = pb.ComingFrom(SARAJEVO);
        String result = "";
        for (String ime: set) {
            result += ime + ",";
        }
        assertEquals("Ivan Milanovic,Lejla Alibegovic,Merima Hadzic,", result);
    }

    @org.junit.jupiter.api.Test
    void numbersFrom() {
        PhoneBook pb = new PhoneBook();
        pb.Add("Ivan Milanovic", new TelephoneNumber(SARAJEVO, "123-456"));
        pb.Add("Merima Hadzic", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Milan Ivanovic", new TelephoneNumber(SARAJEVO, "123-656"));
        pb.Add("Lejla Alibegovic", new MobilePhoneNumber(64, "987-654"));
        pb.Add("Vin Diesel", new InternationalNumber("+1", "23 45-67-89"));
        Set<PhoneNumber> set = pb.NumbersFrom(SARAJEVO);
        String result = "";
        for (PhoneNumber num: set) {
            result += num.Print() + ",";
        }
        assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }
    }
