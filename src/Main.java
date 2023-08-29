public class Main
{
    public static void main(String[] args)
    {
        RegularPolygon defaultPolygon = new RegularPolygon();
        System.out.printf("Default Polygon\nPerimeter: %f\nArea: %f\n\n", defaultPolygon.getPerimeter(),
                          defaultPolygon.getArea());

        RegularPolygon defaultCoordinatePolygon = new RegularPolygon(6, 4);
        System.out.printf("Default Coordinate Polygon\nPerimeter: %f\nArea: %f\n\n",
                          defaultCoordinatePolygon.getPerimeter(), defaultCoordinatePolygon.getArea());

        RegularPolygon customPolygon = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.printf("Custom Polygon\nPerimeter: %f\nArea: %f", customPolygon.getPerimeter(),
                          customPolygon.getArea());
    }
}