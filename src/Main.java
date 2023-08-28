import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        long userInput = -1;
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.println("Enter a credit card number as a long integer:");
            if (scanner.hasNextLong())
            {
                userInput = scanner.nextLong();
                if (String.valueOf(userInput).length() > 16 || String.valueOf(userInput).length() < 13)
                {
                    userInput = -1;
                    System.out.println("Credit card number must be between 13 and 16 digits long.");
                }
            }

            scanner.reset();
        } while (userInput == -1);
        scanner.close();

        if (CreditCardValidation.isValid(userInput))
        {
            System.out.println(userInput + " is valid");
        }
        else
        {
            System.out.println(userInput + " is invalid");
        }
    }
}