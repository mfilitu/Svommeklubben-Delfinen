import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassiveMemberTest {

    @Test
    void getFee() {
        Register register = new Register();
        PassiveMember bobby = new PassiveMember("Bodil", 24);

        register.addMember(bobby);

        double fee = bobby.getFee();

        assertEquals(500, fee);
    }

    @Test
    void pay() {
        PassiveMember bobby = new PassiveMember("Bodil", 24);

        assertFalse(bobby.isPaid());
        bobby.pay();
        assertTrue(bobby.isPaid());
        double balance = bobby.getAccountBalance();


        assertEquals(0, balance);
    }
}