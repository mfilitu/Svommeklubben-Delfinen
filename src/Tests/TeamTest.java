package Tests;

import org.junit.jupiter.api.Test;
import Code.*;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
        public void testAddSeniorMember() {
            Team team = new Team("Delfinen");
            ActiveMember senior = new ActiveMember("Philip", 22);

            team.addToTeam(senior);

            String teamAsString = team.toString();
            assertTrue(teamAsString.contains("Philip"));
            assertTrue(teamAsString.contains("Seniorhold"));
        }

    }
