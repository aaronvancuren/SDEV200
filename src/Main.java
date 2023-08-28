import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        System.out.print("Enter list1: ");
        populateArray(m1);

        System.out.print("Enter list2: ");
        populateArray(m2);

        if (equals(m1, m2))
        {
            System.out.println("The two arrays are identical");
        }
        else
        {
            System.out.println("The two arrays are not identical");
        }
    }

    /*
     * Prompts the user to fill an array with values. User must enter values seperated by a space in a single line.
     */
    public static void populateArray(int[][] array)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("[ \n]");
        for (int row = 0; row < array.length; row++)
        {
            for (int column = 0; column < array[row].length; column++)
            {
                array[row][column] = scanner.nextInt();
            }
        }
    }

    /*
     * Ensures the arrays are identical by having the same unordered contents.
     */
    public static boolean equals(int[][] m1, int[][] m2)
    {
        if (m1.length != m2.length)
        {
            return false;
        }

        for (int row = 0; row < m1.length; row++)
        {
            Arrays.sort(m1[row]);
            Arrays.sort(m2[row]);
            if (m1[row].length != m2[row].length || !Arrays.equals(m1[row], m2[row]))
            {
                return false;
            }
        }

        return true;
    }
}