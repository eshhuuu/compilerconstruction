 import java.util.*;
import java.util.regex.*;

    public class assignment2 {

        // Method to remove comments using regex
        public static String removeComments(String code) {
            // Remove multi-line comments
            String regex = "(?s)/\\*.*?\\*/";
            code = code.replaceAll(regex, "");

            // Remove single-line comments
            regex = "//.*?$";
            code = code.replaceAll(regex, "");

            return code;
        }

        // Method to identify tokens in the code
        public static void identifyTokens(String code) {
            // Define regex patterns for different types of tokens
            String keywordPattern = "\\b(int|float|double|char|if|else|while|for|class|public|private|static|void|return|new|try|catch|final|boolean|long|short|switch|case|default|break|continue|this|super|extends|implements|package|import)\\b";
            String numericPattern = "\\b\\d+(\\.\\d+)?\\b"; // Matches integers and floating-point numbers
            String assignmentPattern = "=";
            String operatorPattern = "[+\\-*/%&|^!<>]=?|[=]=?|[&]{2}|[|]{2}|[!]{1}|[><]=?"; // Handles assignment and logical operators
            String identifierPattern = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"; // Matches identifiers (variables, method names)

            // Combine all patterns to identify tokens
            String combinedPattern = String.format("%s|%s|%s|%s|%s", keywordPattern, numericPattern, assignmentPattern, operatorPattern, identifierPattern);

            // Create a matcher to find all tokens
            Pattern pattern = Pattern.compile(combinedPattern);
            Matcher matcher = pattern.matcher(code);

            // Print the identified tokens
            while (matcher.find()) {
                String token = matcher.group();
                if (token.matches(keywordPattern)) {
                    System.out.println("Keyword: " + token);
                } else if (token.matches(numericPattern)) {
                    System.out.println("Numeric Value: " + token);
                } else if (token.matches(assignmentPattern)) {
                    System.out.println("Assignment Operator: " + token);
                } else if (token.matches(operatorPattern)) {
                    System.out.println("Operator: " + token);
                } else if (token.matches(identifierPattern)) {
                    System.out.println("Identifier: " + token);
                }
            }
        }

        public static void main(String[] args) {
            // Sample Java code as input
            String code = """
            // This is a single-line comment
            class HelloWorld {
                /* This is a
                   multi-line comment */
                public static void main(String[] args) {
                    int a = 10;  // Variable declaration
                    int b = 20;
                    if (a < b) {
                        System.out.println("a is less than b");
                    }
                }
            }
        """;

            // Remove comments
            String codeWithoutComments = removeComments(code);
            System.out.println("Code without comments:\n" + codeWithoutComments);

            // Identify tokens
            System.out.println("\nIdentified Tokens:");
            identifyTokens(codeWithoutComments);
        }
    }


