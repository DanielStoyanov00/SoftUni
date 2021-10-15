package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 5;
    private static final int DUMMY_HEALTH_FOR_DEAD_DUMMY_TEST = 0;
    private static final int EXPECTED_HEALTH_AFTER_ATTACK = DUMMY_HEALTH - ATTACK_POINTS;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void initializeTestDummy() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadDummy = new Dummy(DUMMY_HEALTH_FOR_DEAD_DUMMY_TEST, DUMMY_EXPERIENCE);
    }


    @Test
    public void testWhetherDummyLosesHealthAfterAttack() {
        dummy.takeAttack(ATTACK_POINTS);

        Assert.assertEquals(EXPECTED_HEALTH_AFTER_ATTACK, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsException() {

        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesExperience() {

        Assert.assertEquals(DUMMY_EXPERIENCE, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyWhetherGivesExperienceWhenIsAlive() {

        dummy.giveExperience();
    }


}