import org.junit.Assert;
import org.junit.Assume;
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
                        {"", 0}, {"1", 1}, {"3", 3}, {"1,2", 3}, {"3,5", 8},
                        {"1,2,3", 6}, {"3,5,3,9", 20}, {"1,2\n3", 6}, {"3\n5\n3,9", 20},
                        {"1000,1001,2", 2},
                });
    }

    @Parameterized.Parameter
    public String testInput;

    @Parameterized.Parameter(1)
    public int expectedOutput;

    @Test
    public void testBlankInput() {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput == "");
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testSingleCharString() {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.length() == 1);
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testNewlineDelimiter() {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("\n"));
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testBasicAddition() {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains(",") && (!(testInput.contains("\n")))
                && (!(testInput.contains("1000"))));
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testIgnoreThousandPlus()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("1000") );
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }
}
