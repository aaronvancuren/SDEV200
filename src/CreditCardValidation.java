public class CreditCardValidation
{
    /**
     * Return true if the card number is valid
     */
    public static boolean isValid(long number)
    {
        // True if valid credit card type (Visa, Master, American Express, Discover)
        if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number,
                                                                                                               6))
        {
            // True if sum is divisible by 10
            return Integer.sum(sumOfDoubleEvenPlace(number), sumOfOddPlace(number)) % 10 == 0;
        }

        return false;
    }

    /**
     * Get the result from Step 2
     */
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String numberStringValue = String.valueOf(number);
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
        {
            int doubledNumber = 2 * Integer.parseInt(numberStringValue.substring(i, i + 1));
            sum += getDigit(doubledNumber);
        }

        return sum;
    }

    /**
     * Return this number if it is a single digit, otherwise,
     * return the sum of the two digits
     */
    public static int getDigit(int number)
    {
        if (getSize(number) == 2)
        {
            String numberStringValue = String.valueOf(number);
            return Integer.sum(Integer.parseInt(numberStringValue.substring(0, 1)),
                               Integer.parseInt(numberStringValue.substring(1, 2)));
        }

        return number;
    }

    /**
     * Return sum of odd-place digits in number
     */
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String numberStringValue = String.valueOf(number);
        for (int i = getSize(number) - 1; i >= 1; i -= 2)
        {
            sum += Integer.parseInt(numberStringValue.substring(i, i + 1));
        }

        return sum;
    }

    /**
     * Return true if the number d is a prefix for number
     */
    public static boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }

    /**
     * Return the number of digits in d
     */
    public static int getSize(long d)
    {
        return String.valueOf(d).length();
    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number.
     */
    public static long getPrefix(long number, int k)
    {
        if (getSize(number) < k)
        {
            return number;
        }

        return Long.parseLong(String.valueOf(number).substring(0, k));
    }
}
