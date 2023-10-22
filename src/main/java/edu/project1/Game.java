package edu.project1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
  private static Result start(int maxMistakes) {
    Scanner scanner = new Scanner(System.in);
    String word = Dictionary.WORDS[ThreadLocalRandom.current().nextInt(Dictionary.WORDS.length)];
    word = word.toLowerCase();
    for (int mistake = 0; mistake < maxMistakes; mistake++) {
      System.out.println("Guess a letter:");
      char c = (char) scanner.nextByte();
        if(word.)
    }
  }

  public static void main(String[] args) {}

  private enum Result {
    WIN,
    LOSE
  }
}
