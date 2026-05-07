import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void isSeniorMember() {
        ActiveMember bo = new SeniorMember("Bo", 19);


        assertTrue(bo.isSeniorMember());
        assertFalse(bo.isJuniorMember());
    }

    @Test
    void isJuniorMember() {
        ActiveMember bob = new JuniorMember("Bob", 17);


        assertTrue(bob.isJuniorMember());
        assertFalse(bob.isSeniorMember());
    }

    @Test
    void getAge() {
        ActiveMember bob = new JuniorMember("Bob", 17);


        int age = bob.getAge();

        assertEquals(17, age);
    }

    @Test
    void getName() {
        ActiveMember bob = new JuniorMember("Bob", 17);


        String name = bob.getName();

        assertEquals("Bob", name);
    }
}