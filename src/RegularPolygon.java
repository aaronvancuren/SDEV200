public class RegularPolygon
{
    // Number of sides in the polygon
    private int n = 3;

    // Length of the sides
    private double side = 1;

    // x-coordinate of the polygon's center
    private double x = 0;

    // y-coordinate of the polygon's center
    private double y = 0;

    // Default Constructor
    RegularPolygon() {}

    // Create polygon with the specified number of sides and length of side, centered at (0, 0)
    RegularPolygon(int numberOfSides, double sideLength)
    {
        n = numberOfSides;
        side = sideLength;
    }

    // Creates a polygon with the specified number of sides, length of side, and x- and y-coordinates
    RegularPolygon(int numberOfSides, double sideLength, double x, double y)
    {
        n = numberOfSides;
        side = sideLength;
        this.x = x;
        this.y = y;
    }

    public int getNumberOfSides()
    {
        return n;
    }

    public void setNumberOfSides(int numberOfSides)
    {
        n = numberOfSides;
    }

    public double getSideLength()
    {
        return side;
    }

    public void setSideLength(double sideLength)
    {
        side = sideLength;
    }

    public double getXCoordinate()
    {
        return x;
    }

    public void setXCoordinate(double x)
    {
        this.x = x;
    }

    public double getYCoordinate()
    {
        return y;
    }

    public void setYCoordinate(double y)
    {
        this.y = y;
    }

    // return the perimeter of the polygon
    public double getPerimeter()
    {
        return n * side;
    }

    // Returns the area of the polygon
    public double getArea()
    {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}
