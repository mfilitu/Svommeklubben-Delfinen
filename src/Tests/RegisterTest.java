package Tests;

import org.junit.jupiter.api.Assertions;
import Code.*;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @org.junit.jupiter.api.Test
    void addMember() {
        Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 18);

        register.addMember(bo);

        String name = register.getMemberList().getFirst().getName();

        assertEquals("Bo", name);
    }

    @org.junit.jupiter.api.Test
    void getMemberList() {
        Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 17);
        ActiveMember bob = new ActiveMember("Bob", 1);
        PassiveMember bobby = new PassiveMember("Bobby", 55);


        register.addMember(bo);
        register.addMember(bob);
        register.addMember(bobby);

        int arraySize = register.getMemberList().size();

        assertEquals(3, arraySize);
    }

    @org.junit.jupiter.api.Test
    void addFeeToAll() {
        Register register = new Register();
        ActiveMember bo = new SeniorMember("Bo", 19);
        ActiveMember bob = new JuniorMember("Bob", 1);
        PassiveMember bobby = new PassiveMember("Bobby", 69);


        register.addMember(bo);
        register.addMember(bob);
        register.addMember(bobby);

        Assertions.assertFalse(bo.isPaid());
        Assertions.assertFalse(bob.isPaid());
        Assertions.assertFalse(bobby.isPaid());

        bo.pay();
        bob.pay();
        bobby.pay();

        Assertions.assertTrue(bo.isPaid());
        Assertions.assertTrue(bob.isPaid());
        Assertions.assertTrue(bobby.isPaid());

        register.AddFeeToAllMembers();

        Assertions.assertFalse(bo.isPaid());
        Assertions.assertFalse(bob.isPaid());
        Assertions.assertFalse(bobby.isPaid());

        int arraySize = register.getMemberList().size();

        assertEquals(3, arraySize);
    }
}