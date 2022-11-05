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
        pb.Add("Sara Sarac", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Pero Peric", new TelephoneNumber(SARAJEVO, "123-656"));
        pb.Add("Ivo Ivic", new MobilePhoneNumber(61, "321-645"));
        pb.Add("Jozo Jozic", new MobilePhoneNumber(64, "987-654"));
        pb.Add("John Smith", new InternationalNumber("+1", "23 45-67-89"));
        assertEquals( "1. Ivo Ivic - 061/321-645", pb.FirstLetter('I'));
    }

    @org.junit.jupiter.api.Test
    void comingFrom() {
        PhoneBook pb = new PhoneBook();
        pb.Add("Ivo Ivic", new TelephoneNumber(SARAJEVO, "123-456"));
        pb.Add("Sara Sarac", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Meho Mehic", new TelephoneNumber(SARAJEVO, "123-656"));
        pb.Add("Pero Peric", new MobilePhoneNumber(64, "987-654"));
        pb.Add("John Smith", new InternationalNumber("+1", "23 45-67-89"));
        Set<String> set = pb.ComingFrom(SARAJEVO);
        String result = "";
        for (String ime: set) {
            result += ime + ",";
        }
        assertEquals("Ivo Ivic,Meho Mehic,Sara Sarac,", result);
    }

    @org.junit.jupiter.api.Test
    void numbersFrom() {
        PhoneBook pb = new PhoneBook();
        pb.Add("Ivo Ivic", new TelephoneNumber(SARAJEVO, "123-456"));
        pb.Add("Sara Sarac", new TelephoneNumber(SARAJEVO, "123-156"));
        pb.Add("Meho Mehic", new TelephoneNumber(SARAJEVO, "123-656"));
        pb.Add("Pero Peric", new MobilePhoneNumber(64, "987-654"));
        pb.Add("John Smith", new InternationalNumber("+1", "23 45-67-89"));
        Set<PhoneNumber> set = pb.NumbersFrom(SARAJEVO);
        String result = "";
        for (PhoneNumber num: set) {
            result += num.Print() + ",";
        }
        assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }
    }
