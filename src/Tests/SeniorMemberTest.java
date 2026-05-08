package Tests;

import org.junit.jupiter.api.Test;
import Code.*;

import static org.junit.jupiter.api.Assertions.*;

class SeniorMemberTest {

    @Test
    void getNormalFee() {
        Register register = new Register();
        ActiveMember bobby = new SeniorMember("Bobby", 55);

        register.addMember(bobby);

        double fee = bobby.getFee();

        assertEquals(1600, fee);

    }

    @Test
    void getUlraSeniorFee() {
        Register register = new Register();
        ActiveMember bobby = new SeniorMember("Bobby", 69);

        register.addMember(bobby);

        double fee = bobby.getFee();

        assertEquals(1200, fee);
    }
}