package rpg_lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int AXE_DAMAGE = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int LOSES_DURABILITY_PER_ATTACK = 1;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - LOSES_DURABILITY_PER_ATTACK;
    private static final int BROKEN_AXE_DURABILITY = 0;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects(){
        this.axe = new Axe(AXE_DAMAGE, AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_DAMAGE, BROKEN_AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testWhetherAxeLosesDurabilityWhenAttack() {
        axe.attack(dummy);

        Assert.assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void testAttackWithBrokenAxe() {

        brokenAxe.attack(dummy);
    }

}