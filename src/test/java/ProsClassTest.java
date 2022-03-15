import com.revature.waaik.musicprofessionalsapp.Pros;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProsClassTest {

    @Test
    public void ProsClassConstructorTest(){

        Pros actual = new Pros(1, "Scoota", "Engineer", "mail@mail.com", "555-555-5555", 200);

        Assertions.assertEquals(1, actual.getProId());
        Assertions.assertEquals("Scoota", actual.getName());
        Assertions.assertEquals("Engineer", actual.getProfession());
        Assertions.assertEquals("mail@mail.com", actual.getEmail());
        Assertions.assertEquals("555-555-5555", actual.getPhoneNumber());
        Assertions.assertEquals(200, actual.getFee());

    }

    @Test
    public void ProClassSetterTest(){

        Pros actual = new Pros();

        actual.setProId(1);
        actual.setName("Scoota");
        actual.setEmail("mail@mail.com");
        actual.setProfession("Engineer");
        actual.setPhoneNumber("555-555-5555");
        actual.setFee(200);

        Assertions.assertEquals(1, actual.getProId());
        Assertions.assertEquals("Scoota", actual.getName());
        Assertions.assertEquals("mail@mail.com", actual.getEmail());
        Assertions.assertEquals();
    }
}
