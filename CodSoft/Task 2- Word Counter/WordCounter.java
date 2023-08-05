import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word Counter");
        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");
        int option = scanner.nextInt();

        String text = "";
        if (option == 1) {
            System.out.println("Enter your text:");
            scanner.nextLine(); // Consume the newline left by nextInt()
            text = scanner.nextLine();
        } else {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            text = readTextFromFile(filePath);
        }

        String[] words = text.split("\\s+|\\p{Punct}");
        int wordCount = words.length;

        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("and");
        stopWords.add("in");
        stopWords.add("of");

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (!stopWords.contains(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Total word count: " + wordCount);
        System.out.println("Total unique words: " + wordFrequency.size());
        System.out.println("Word frequency: " + wordFrequency);
    }

    private static String readTextFromFile(String filePath) {
        // Implement the file reading logic here
        // Return the contents of the file as a String
        return ""; // Replace this with actual file reading logic
    }
}
