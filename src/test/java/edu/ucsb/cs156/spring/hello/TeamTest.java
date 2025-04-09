package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        teamA.addMember("member1"); 
        teamA.addMember("member2"); 
        assertTrue(teamA.equals(teamA));
        
        Team sameteam = new Team("TeamA");
        sameteam.addMember("member1"); 
        sameteam.addMember("member2"); 

        assertTrue(teamA.equals(sameteam));
        assertTrue(sameteam.equals(teamA));
        
        Object obj = new Object();
        assertFalse(teamA.equals(obj));

        Team differentTeam = new Team("differentTeam"); 
        assertFalse(teamA.equals(differentTeam));

        differentTeam.addMember("member3"); 
        differentTeam.addMember("member4"); 
        assertFalse(team.equals(differentTeam));
    }

}
