package Tests;

import Code.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuniorMemberTest {

    @Test
    void getFee() {
        Register register = new Register();
        ActiveMember bobby = new JuniorMember("Bo", 15);

        register.addMember(bobby);

        double fee = bobby.getFee();

        assertEquals(1000, fee);
    }
}