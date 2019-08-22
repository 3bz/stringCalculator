import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Calculator {
    public Calculator()
    {}

    public int convert(String toBeConverted) {
        if ( (toBeConverted.length() == 1) )
            return Integer.parseInt(toBeConverted);

        String[] applyNewLineCommaDelimiter = toBeConverted.split("[\\n]|[,]");

        if ( (checkArrayContainsAnyNegativeValue(applyNewLineCommaDelimiter)) )
            cannotAddNegatives(applyNewLineCommaDelimiter);

        if (applyNewLineCommaDelimiter[0].contains("//") )
            return userSuppliedCustomDelimiter(applyNewLineCommaDelimiter);

        if (applyNewLineCommaDelimiter[0].matches("[0-9]+"))
            return sumOfValues(applyNewLineCommaDelimiter);

        return 0;
    }

    public int sumOfValues(String[] inputToSum) {
        int result = 0;
        for (int i = 0; i < inputToSum.length; i++)
        {
            if( !inputToSum[i].equals("") )
            {
                int aNumber = Integer.parseInt(inputToSum[i]);
                if ( aNumber < 1000)
                result += aNumber;
            }
        }
        return result;
    }

    public int userSuppliedCustomDelimiter(String [] delimiterAndInput) {
        String customDelimiter = delimiterAndInput[0].replaceFirst("//", "");
        String inputToConvert = delimiterAndInput[1];

        if (customDelimiter.contains("1") )
            return customNumberDelimiter(customDelimiter, inputToConvert);

        if (customDelimiter.contains("["))
            return customDelimiterLength(customDelimiter, inputToConvert);

        String[] result = inputToConvert.split(customDelimiter);
        return sumOfValues(result);
    }

    public int customDelimiterLength(String customDelim, String inputToConvert)
    {
        String stripDelimiter = customDelim.replaceFirst("[\\[]", "");
        String newDelimiter = stripDelimiter.replaceFirst("]", "");

        String[] result = inputToConvert.split("[" + newDelimiter + "]+");
        return sumOfValues(result);
    }

    public int customNumberDelimiter(String customDelim, String inputToConvert)
    {
        String withEscapedMetacharacter = customDelim.replace("*", "\\*");
        String withReplacedOpenBrackets = withEscapedMetacharacter.replaceAll("\\[", "");
        String concatEachDelim = withReplacedOpenBrackets.replaceAll("]", "|");
        String[] result = inputToConvert.split(concatEachDelim);
        return sumOfValues(result);
    }

    public boolean checkArrayContainsAnyNegativeValue(String[] arrayToAssess)
    {
        boolean containsNegative = false;
        for (int i = 0; i < arrayToAssess.length; i++)
        {
            if (arrayToAssess[i].contains("-"))
                containsNegative = true;
        }
        return containsNegative;
    }

    public String cannotAddNegatives(String[] arrayWithNegativeValues) {
        String errorMsg = "Negatives are not allowed: ";
        for (int i = 0; i < arrayWithNegativeValues.length; i++)
        {
            if (arrayWithNegativeValues[i].contains("-"))
                errorMsg += arrayWithNegativeValues[i] + " ";
        }
        return errorMsg;
    }

}
