import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class testSuite {

    //arrange
    @Parameterized.Parameters(name = "{index}: {0} = {1}")
    public static Collection<Object[]> conversionData() {
        return Arrays.asList(new Object[][]
                {
                        {"", 0}, {"1", 1}, {"3", 3}, {"1,2", 3}, {"3,5", 8}
                });
    }

    @Parameterized.Parameter
    public String testInput;

    @Parameterized.Parameter(1)
    public int expectedOutput;

    @Test
    public void testStringToInt() {
        //arrange
        Calculator convertString = new Calculator();
        //act
        int myResult = convertString.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }
}
