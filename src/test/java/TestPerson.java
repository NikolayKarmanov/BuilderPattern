import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPerson {

    @Test
    public void thereIsNotName() {
        Assertions.assertThrows(IllegalStateException.class, () -> new PersonBuilder().setSurname("Карманов").build());
    }

    @Test
    public void thereIsNotSurname() {
        Assertions.assertThrows(IllegalStateException.class, () -> new PersonBuilder().setName("Николай").build());
    }

    @Test
    public  void ageTest() {
        Person person = new PersonBuilder().setName("Николай").setSurname("Карманов").build();
        Assertions.assertFalse(person.hasAge());
        Assertions.assertThrows(IllegalArgumentException.class, () -> person.setAge(-100));
        person.setAge(36);
        Assertions.assertTrue(person.hasAge());
    }

    @Test
    public void childTest() {
        Person person = new PersonBuilder().setName("Николай").setSurname("Карманов").setAge(36).setCity("Заинск").build();
        Person son = person.newChildBuilder().setName("Тимофей").build();
        Assertions.assertEquals(person.getSurname(), son.getSurname());
        Assertions.assertEquals(person.getCity(), son.getCity());
    }
}
