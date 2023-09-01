public class Main
{
    public static void main(String[] args)
    {
        MyDate firstDate = new MyDate();
        printDate(firstDate);

        System.out.println();

        MyDate secondDate = new MyDate(34355555133101L);
        printDate(secondDate);

        //MyDate exampleDate = new MyDate(561555550000L);
        //printDate(exampleDate);
    }

    private static void printDate(MyDate date)
    {
        System.out.printf("Year: %d, Month: %d, Day: %d", date.getYear(), date.getMonth(), date.getDay());
    }
}