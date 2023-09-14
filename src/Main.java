import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main
{
    /*
     * some comment with keywords abstract static new extends import
     */

    // another comment with keywords double do catch null
    public static void main(String[] args)
    {
        try
        {
            String fileName = getFileName();
            File file = new File("./src/", fileName);
            System.out.println(file.exists() ? "The number of keywords in " + fileName + " is " + countKeywords(file)
                                             : "File " + fileName + " does not exist");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(e.hashCode());
        }
    }

    public static String getFileName()
    {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        do
        {
            System.out.print("Enter a Java source file that is saved in the src directory: ");
            fileName = scanner.next();
            if (!fileName.endsWith(".java"))
            {
                fileName = "";
                System.out.println("Invalid file type. Must be a java file. (Ex. main.java)");
            }
        } while (fileName.equals(""));
        scanner.close();

        return fileName;
    }

    public static int countKeywords(File file) throws Exception
    {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                                  "const", "continue", "default", "do", "double", "else", "enum", "extends", "false",
                                  "final", "finally", "float", "for", "goto", "if", "implements", "import",
                                  "instanceof", "int", "interface", "long", "native", "new", "null", "package",
                                  "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                                  "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try",
                                  "void", "volatile", "while"};

        Set<String> keywordSet = new HashSet<>(List.of(keywordString));

        int count = 0;
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
        {
            String line = input.nextLine().trim();

            /*
             * Ignore any lines that begin with characters related to comments
             */
            if (line.startsWith("/") || line.startsWith("*"))
            {
                continue;
            }

            /*
             * Removes any String content because we are only concerned about keywords relevant to the compiler.
             */
            line = line.trim().replaceAll("\"(.*?)\"", "").replaceAll("'(.*?)'", "").replaceAll(";", "");

            /*
             * Reads each word/chuck of the line
             */
            Scanner lineInput = new Scanner(line);
            while (lineInput.hasNext())
            {
                String word = lineInput.next();
                if (keywordSet.contains(word))
                {
                    count++;
                    // Uncomment if you'd like to see the captured keywords
                    // System.out.println(count + ". " + word);
                }
            }
        }

        return count;
    }
}