package com.example.task2ft;

public class TxtCounter {
        public static int countLetters(String input) {
                return input.length();
        }

        public static int countWords(String input) {
                String[] words = input.split("\\W+");
                int wordCount = 0;
                for (String word : words) {
                        if (!word.isEmpty() && word.matches("[a-zA-Z]+")) {
                                wordCount++;
                        }
                }
                return wordCount;
        }
}
