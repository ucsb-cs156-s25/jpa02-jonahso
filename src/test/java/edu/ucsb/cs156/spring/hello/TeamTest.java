package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.beans.Transient;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() 
    {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() 
    {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void same_equals_correct() 
    {
        Team teamA = new Team("TeamA");
        assertEquals(true, teamA.equals(teamA)); 

        // Same name, same member
        Team sameteam = new Team("TeamA");
        assertEquals(true, teamA.equals(sameteam)); 

        // Different name, same member 
        Team differentName = new Team("differentName"); 
        assertEquals(false, teamA.equals(differentName)); 

        // Same name, different member 
        Team differentMember = new Team("TeamA"); 
        assertEquals(true, teamA.equals(differentMember)); 

        // Different name, different member 
        Team different = new Team("differentName"); 
        assertEquals(false, teamA.equals(different)); 

        teamA.addMember("member1"); 
        teamA.addMember("member2"); 
        assertEquals(true, teamA.equals(teamA));

        sameteam.addMember("member1"); 
        sameteam.addMember("member2"); 
        assertEquals(true, teamA.equals(sameteam));

        differentName.addMember("member1"); 
        differentName.addMember("member2"); 
        assertEquals(false, teamA.equals(differentName));
        
        differentMember.addMember("member3"); 
        differentMember.addMember("member4"); 
        assertEquals(false, teamA.equals(differentMember));

        different.addMember("member3"); 
        different.addMember("member4"); 
        assertEquals(false, teamA.equals(different));

        String obj = "not a team"; 
        assertEquals(false, teamA.equals(obj));
    }

    @Test
    public void hash_testing()
    {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    
    @Test 
    public void hash_expected()
    {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");
        int result = t.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }

}
