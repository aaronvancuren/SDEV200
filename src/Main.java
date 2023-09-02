import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("[ \n]");
        int[] sides = new int[3];
        for (int i = 0; i < sides.length; i++)
        {
            System.out.printf("Enter side %d of the triangle...\n", i + 1);
            if (scanner.hasNextInt())
            {
                sides[i] = scanner.nextInt();
            }
        }
        scanner.reset();

        System.out.println("Enter a fill color for the triangle...");
        String color = "";
        if (scanner.hasNext())
        {
            color = scanner.next();
        }

        System.out.println("Is the triangle filled (true/false)?");
        boolean isFilled = false;
        if (scanner.hasNextBoolean())
        {
            isFilled = scanner.nextBoolean();
        }

        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        triangle.setColor(color);
        triangle.setFilled(isFilled);

        System.out.println(triangle);
        System.out.printf("Area: %f Perimeter: %f Color: %s Filled: %s", triangle.getArea(), triangle.getPerimeter(),
                          triangle.getColor(), triangle.isFilled());
    }
}