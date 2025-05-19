import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AthleteTest.
 *
 * @author  Laura,Danush and Kenny-Jhon
 * @version 1.0
 */
public class AthleteTest
{
    /**
     * Default constructor for test class AthleteTest
     */
    public AthleteTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void creatingNewAthlete()
    {
        Athlete athlete1 = new Athlete("lau", Gender.FEMALE, 60, 165, 2020);
        assertNotNull(athlete1.getName());
        assertEquals(60, athlete1.getWeight(), 0.1);
        athlete1.getAthleteInfo();
    }
}

