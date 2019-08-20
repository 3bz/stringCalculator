public class Calculator {
    public Calculator()
    {}

    public int convert(String toBeConverted)
    {
        if ( (! (toBeConverted.equals("")) && toBeConverted.length() < 2) )
            return Integer.parseInt(toBeConverted);

        String[] applyNewLineCommaDelim = toBeConverted.split("[\\n*]|[,*]");

        if (applyNewLineCommaDelim[0].equals("//;"))
        {
            String customDelimiter = applyNewLineCommaDelim[0].replaceFirst("//", "");
            String inputToConvert = applyNewLineCommaDelim[1];

            String[] result = inputToConvert.split(customDelimiter);
            return sumOfValues(result);
        }

        if (applyNewLineCommaDelim[0].matches("[0-9]"))
            return sumOfValues(applyNewLineCommaDelim);

        return 0;
    }

    public int sumOfValues(String[] inputToSum)
    {
        int result = 0;

        for (int i = 0; i < inputToSum.length; i++)
            result += Integer.parseInt(inputToSum[i]);

        return result;
    }

//    public String inputWithCustomDelimiter(String customDelimiter, String inputWithDelim)
//    {
//        String inputStrippedOfDelim = inputWithDelim.replaceFirst(customDelimiter, "");
//
//    }
}
