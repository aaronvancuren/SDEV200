public class BinaryFormatException extends Exception
{
    public BinaryFormatException()
    {
        super("Not a binary string");
    }

    public BinaryFormatException(Exception e)
    {
        super("Not a binary string", e);
    }

    public BinaryFormatException(String message)
    {
        super(message);
    }
}
