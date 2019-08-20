public class Calculator {
    public Calculator()
    {}

    public int convert(String toBeConverted)
    {
        if ( (toBeConverted.length() == 1) )
            return Integer.parseInt(toBeConverted);

        String[] applyNewLineCommaDelimiter = toBeConverted.split("[\\n*]|[,*]");

        if (applyNewLineCommaDelimiter[0].contains("//") )
            return userSuppliedCustomDelimiter(applyNewLineCommaDelimiter);

        if (applyNewLineCommaDelimiter[0].matches("[0-9]"))
            return sumOfValues(applyNewLineCommaDelimiter);

        return 0;
    }

    public int sumOfValues(String[] inputToSum)
    {
        int result = 0;
        for (int i = 0; i < inputToSum.length; i++)
            result += Integer.parseInt(inputToSum[i]);

        return result;
    }

    public int userSuppliedCustomDelimiter(String [] delimiterAndInput)
    {
        String customDelimiter = delimiterAndInput[0].replaceFirst("//", "");
        String inputToConvert = delimiterAndInput[1];

        String[] result = inputToConvert.split(customDelimiter);
        return sumOfValues(result);
    }
}
