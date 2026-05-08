package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Code.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void isSeniorMember() {
        ActiveMember bo = new SeniorMember("Bo", 19);


        Assertions.assertTrue(bo.isSeniorMember());
        Assertions.assertFalse(bo.isJuniorMember());
    }

    @Test
    void isJuniorMember() {
        ActiveMember bob = new JuniorMember("Bob", 17);


        Assertions.assertTrue(bob.isJuniorMember());
        Assertions.assertFalse(bob.isSeniorMember());
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