package pl.graczyk.games;

import pl.graczyk.Flashcard;

import java.util.*;

public interface Game {
   Random rand = new Random();
    Scanner scn = new Scanner(System.in);

     void runGame(List<Flashcard> n) throws InputMismatchException;




    default boolean checkAnswer(String usersAnswer, String answer, boolean streak) {
        if (usersAnswer.equals(answer)) {
            System.out.println("Brawo!");
        } else {
            System.out.println("przegrana");
            streak = false;
        }
        return streak;}

     default Flashcard currentQuestion(List<Flashcard> n) {
        Flashcard question = n.get(rand.nextInt(n.size()));
        String definition = question.getText();
        String answer = question.getMeaning();
        return new Flashcard(definition, answer);}
}

