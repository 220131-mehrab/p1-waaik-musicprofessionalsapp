import com.revature.waaik.musicprofessionalsapp.Pros;
import com.revature.waaik.musicprofessionalsapp.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserClassTest {

    @Test
    public void UserClassConstructorTest(){

        User actual = new User(0, "Waaik123", "waaik123@mail.com", "xyz123", 575939489);

        Assertions.assertEquals(1, actual.getUserId());
        Assertions.assertEquals("Waaik123", actual.getUserName());
        Assertions.assertEquals("waaik123@mail.com", actual.getUserEmail());
        Assertions.assertEquals("xyz123", actual.getUserPassword());
        Assertions.assertEquals(575939489, actual.getUserCreditCard());
    }

    @Test
    public void ProClassSetterTest(){

        User actual = new User();

        actual.setUserId(1);
        actual.setUserName("Waaik123");
        actual.setUserEmail("waaik123@mail.com");
        actual.setUserPassword("xyz123");
        actual.setUserCreditCard(57593489);

        Assertions.assertEquals(1, actual.getUserId());
        Assertions.assertEquals("Waaik123", actual.getUserName());
        Assertions.assertEquals("waaik123@mail.com", actual.getUserEmail());
        Assertions.assertEquals("xyz123", actual.getUserPassword());
        Assertions.assertEquals(57593489, actual.getUserCreditCard());
    }

    @Test
    public void ProClassToStringTest(){

        User actual = new User(1, "Waaik123", "waaik123@mail.com", "xyz123", 57593489);

        User expected = new User(2, "Waaik123", "waaik123@mail.com", "xyz123", 57593489);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

}
