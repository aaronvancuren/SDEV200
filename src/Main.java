import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            String fileName = getFileName();
            String fileContent = getFileContent(fileName);
            Stack<Character> openingGroupingSymbols = new Stack<>();
            for (int i = 0; i < fileContent.length(); i++)
            {
                char c = fileContent.charAt(i);
                if (c == '(' || c == '[' || c == '{')
                {
                    openingGroupingSymbols.add(c);
                }
                else if (c == ')')
                {
                    if ('(' != openingGroupingSymbols.pop())
                    {
                        throw new Exception("Invalid pairing of '()' grouping symbols.");
                    }
                }
                else if (c == ']')
                {
                    if ('[' != openingGroupingSymbols.pop())
                    {
                        throw new Exception("Invalid pairing of '[]' grouping symbols.");
                    }
                }
                else if (c == '}')
                {
                    if ('{' != openingGroupingSymbols.pop())
                    {
                        throw new Exception("Invalid pairing of '{}' grouping symbols.");
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(e.hashCode());
        }

        System.out.println("Valid pairing of grouping symbols.");
    }

    public static String getFileName()
    {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        do
        {
            System.out.print("Enter a source-code file name: ");
            fileName = scanner.next();
            if (!fileName.endsWith(".java"))
            {
                fileName = "";
                System.out.println("Invalid file type. Must be a java file.");
            }
        } while (fileName.equals(""));
        scanner.close();

        return fileName;
    }

    public static String getFileContent(String fileName) throws FileNotFoundException
    {
        // Scanner for reading found file
        Scanner fileReader = new Scanner(new File("./src/", fileName));
        String fileContent = "";
        while (fileReader.hasNextLine())
        {
            fileContent = fileContent.concat(fileReader.nextLine());
        }
        fileReader.close();

        /*
         * Removes whitespace
         * Removes content in quotes (Strings) because we are only concerned about grouping symbols relevant to the compiler.
         */
        fileContent = fileContent.replaceAll("\\s", "").replaceAll("\"(.*?)\"", "").replaceAll("'(.*?)'", "");

        return fileContent;
    }
}