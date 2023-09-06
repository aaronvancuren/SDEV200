import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("[ \n]");
        System.out.print("Enter the first rational number: ");

        BigInteger firstNumerator = BigInteger.valueOf(scanner.nextInt());
        BigInteger firstDenominator = BigInteger.valueOf(scanner.nextInt());
        Rational firstRational = new Rational(firstNumerator, firstDenominator);

        System.out.print("Enter the second rational number: ");
        BigInteger secondNumerator = BigInteger.valueOf(scanner.nextInt());
        BigInteger secondDenominator = BigInteger.valueOf(scanner.nextInt());
        Rational secondRational = new Rational(secondNumerator, secondDenominator);

        Rational addRational = firstRational.add(secondRational);
        System.out.printf("%d/%d + %d/%d = %d/%d", firstNumerator, firstDenominator, secondNumerator, secondDenominator,
                          addRational.getNumerator(), addRational.getDenominator()).println();

        Rational subtractRational = firstRational.subtract(secondRational);
        System.out.printf("%d/%d - %d/%d = %d/%d", firstNumerator, firstDenominator, secondNumerator, secondDenominator,
                          subtractRational.getNumerator(), subtractRational.getDenominator()).println();

        Rational multiplyRational = firstRational.multiply(secondRational);
        System.out.printf("%d/%d * %d/%d = %d/%d", firstNumerator, firstDenominator, secondNumerator, secondDenominator,
                          multiplyRational.getNumerator(), multiplyRational.getDenominator()).println();

        Rational divideRational = firstRational.divide(secondRational);
        System.out.printf("%d/%d / %d/%d = %d/%d", firstNumerator, firstDenominator, secondNumerator, secondDenominator,
                          divideRational.getNumerator(), divideRational.getDenominator()).println();

        System.out.printf("%d/%d is %.19f", secondNumerator, secondDenominator, secondRational.doubleValue());

    }
}