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
                        {"//;\n1;2",3}
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
        int myResult = stringConverter.convert(testInput);
        //assert
        Assume.assumeTrue(testInput == "");
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testSingleCharString()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        int myResult = stringConverter.convert(testInput);
        //assert
        Assume.assumeTrue(testInput.length() == 1);
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testNewlineDelimiter()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        int myResult = stringConverter.convert(testInput);
        //assert
        Assume.assumeTrue(testInput.contains("\n"));
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testCustomDelimiter()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        int myResult = stringConverter.convert(testInput);
        //assert
        Assume.assumeTrue(testInput.contains("//"));
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testBasicAddition()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        int myResult = stringConverter.convert(testInput);
        //assert
        Assume.assumeTrue(testInput.contains(",") && (!(testInput.contains("\n"))));
        Assert.assertEquals(expectedOutput, myResult);
    }
}
