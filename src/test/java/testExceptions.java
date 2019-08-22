import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class testExceptions {

    @Test
    public void testNegativeWithStringReturn()
    {
        Calculator strCalc = new Calculator();
        String[] testArray = {"-1", "2", "-3"};
        String actual = strCalc.cannotAddNegatives(testArray);
        Assert.assertEquals("Negatives are not allowed: -1 -3 ", actual);

    }
}