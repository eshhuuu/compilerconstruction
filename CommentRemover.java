import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CommentRemover {
    public static String removeComments(String code) {
        // Regular expression for single-line comments
        String singleLineCommentPattern = "//.*?$";
        // Regular expression for multi-line comments
        String multiLineCommentPattern = "/\\.?\\*/";
        // Combine both patterns
        String combinedPattern = singleLineCommentPattern + "|"
                + multiLineCommentPattern;
        // Create a Pattern object
        Pattern pattern = Pattern.compile(combinedPattern, Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(code);
        // Remove comments
        return matcher.replaceAll("");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Java code (end with an empty line):");
        StringBuilder codeBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            codeBuilder.append(line).append("\n");
        }
        String code = codeBuilder.toString();
        String cleanedCode = removeComments(code);
        System.out.println("\nCode without comments:");
        System.out.println(cleanedCode);
    }
}