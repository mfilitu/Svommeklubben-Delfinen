package Tests;

import org.junit.jupiter.api.Test;
import Code.*;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
        public void testAddSeniorMember() {

            //Arrange

            Team team = new Team("Delfinen");
            ActiveMember senior = new ActiveMember("Philip", 22);


            //Act

            team.addToTeam(senior);

            //Assert

            String teamAsString = team.toString();
            assertTrue(teamAsString.contains("Philip"));
            assertTrue(teamAsString.contains("Seniorhold"));
        }

    }
