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
}
