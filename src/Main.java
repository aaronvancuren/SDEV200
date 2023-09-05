import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a binary number");
        String userInput = scanner.nextLine();
        try
        {
            System.out.println(bin2Dec(userInput));
        }
        catch (BinaryFormatException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException
    {
        try
        {
            return Integer.parseInt(binaryString, 2);
        }
        catch (Exception e)
        {
            throw new BinaryFormatException(e);
        }
    }
}

