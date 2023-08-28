public class Main
{
    private final static double[] feetMeasurements = {1.0d, 2.0d, 3.0d, 4.0d, 5.0d, 6.0d, 7.0d, 8.0d, 9.0d, 10.0d};
    private final static double[] meterMeasurements = {20.0d, 25.0d, 30.0d, 35.0d, 40.0d, 45.0d, 50.0d, 55.0d, 60.0d,
                                                       65.0d};

    public static void main(String[] args)
    {
        printMenu("Feet", "Meters", "Meters", "Feet");
        System.out.printf("-".repeat(40).concat("%n"));
        for (int i = 0; i < 10; i++)
        {
            printMenu(String.valueOf(feetMeasurements[i]),
                      String.format("%.3f", UnitConversion.footToMeter(feetMeasurements[i])),
                      String.valueOf(meterMeasurements[i]),
                      String.format("%.3f", UnitConversion.meterToFoot(meterMeasurements[i])));
        }
    }

    private static void printMenu(String columnOne, String columnTwo, String columnThree, String columnFour)
    {
        System.out.printf("%-8s %-8s %-4s %-8s %-8s%n", columnOne, columnTwo, "|", columnThree, columnFour);
    }
}