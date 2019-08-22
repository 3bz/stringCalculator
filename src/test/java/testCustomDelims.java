import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class testCustomDelims {

    //arrange
    @Parameterized.Parameters(name = "{index}: {0} = {1}")
    public static Collection<Object[]> conversionData() {
        return Arrays.asList(new Object[][]
                {
                        {"//;\n1;2", 3}, {"//[***]\n1***2***3", 6},
                        {"//[*][%]\n1*2%3", 6}, {"//[***][#][%]\n1***2#3%4", 10},
                        {"//[*1*][%]\n1*1*2%3", 6}
                });
    }

    @Parameterized.Parameter
    public String testInput;

    @Parameterized.Parameter(1)
    public int expectedOutput;

    @Test
    public void testCustomDelimiter() {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("//") && (!(testInput.contains("*"))));
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testAnySizeDelim() {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("***") && ( !(testInput.contains("%"))) );
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testMultipleDelims()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("//[*][%]\n1*2%3"));
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testManyLargerDelims()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("//[***][#][%]\n1***2#3%4"));
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }

    @Test
    public void testDelimContainingNumber()
    {
        //arrange
        Calculator stringConverter = new Calculator();
        //act
        Assume.assumeTrue(testInput.contains("//[*1*][%]\n1*1*2%3"));
        int myResult = stringConverter.convert(testInput);
        //assert
        Assert.assertEquals(expectedOutput, myResult);
    }
}