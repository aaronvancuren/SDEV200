import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate
{
    private int year;
    private int month;
    private int day;

    public MyDate()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);
    }

    public MyDate(long elapsedTime)
    {
        year = 1970;
        month = 0;
        day = 1;
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDate(long elapsedTime)
    {
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + elapsedTime);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);
    }
}
