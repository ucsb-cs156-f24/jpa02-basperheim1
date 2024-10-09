package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_method_returns_correct_value(){
        
        // Our overrided equals method should return true if the same object is passed as a parameter
        assert(team.equals(team));

        int x = 5; 
        assert(!team.equals(x));

        Team t1 = new Team("test-team");
        Team t2 = new Team("wrong-team");
        Team t3 = new Team("test-team");

        t3.addMember("ben");

        // Checks for equality of teams with varying names and members 
        assert(t1.equals(team));
        assert(!t2.equals(team));
        assert(!t3.equals(team));
    }

    @Test
    public void hash_method_returns_correct_value(){

        // Tests to ensure that two equivalent teams have the same hashCode
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");

        assertEquals(t1.hashCode(), 130294);
        assertEquals(t1.hashCode(), t2.hashCode());


    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
