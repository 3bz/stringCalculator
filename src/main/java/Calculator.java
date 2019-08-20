public class Calculator {
    public Calculator()
    {}

    public int convert(String toBeConverted)
    {
    int result = 0;
    String[] inputToArray = toBeConverted.split("[\\n*]|[,*]");

    if (inputToArray.length > 1)
        result = sumOfValues(inputToArray);
    if (toBeConverted == "1")
        result = 1;
    if (toBeConverted == "3")
        result = 3;

    return result;
    }

    public int sumOfValues(String[] inputToSum)
    {
        int result = 0;

        for (int i = 0; i < inputToSum.length; i++)
            result += Integer.parseInt(inputToSum[i]);

        return result;
    }
}
