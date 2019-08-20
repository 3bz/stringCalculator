import org.junit.Assert;
import org.junit.Test;

public class testSuite {
    @Test
    public void testStringReturnsZero()
    {
        //arrange
        Calculator convertString = new Calculator();
        //act
        int myResult = convertString.convert("");
        //assert
        Assert.assertEquals(0, myResult);
    }

    @Test
    public void testStringReturnsOne()
    {
        //arrange
        Calculator convertString = new Calculator();
        //act
        int myResult = convertString.convert("1");
        //assert
        Assert.assertEquals(1, myResult);
    }

    @Test
    public void testStringReturnsThree()
    {
        //arrange
        Calculator convertString = new Calculator();
        //act
        int myResult = convertString.convert("3");
        //assert
        Assert.assertEquals(3, myResult);
    }
}
