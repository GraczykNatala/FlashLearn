package pl.graczyk.games;

import pl.graczyk.Flashcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnagramGame implements Game {
    @Override
    public void runGame(List<Flashcard> n) {
        boolean streak = true;
        do {
            Flashcard question = currentQuestion(n);
            String definition = question.getText();
            List<String> anagram = new ArrayList<>(List.of(definition.split("")));
            Collections.shuffle(anagram);
            String questionAnagram = anagram.toString();
            System.out.println(questionAnagram);
            String usersAnswer = scn.nextLine();
            streak = checkAnswer(usersAnswer, definition, streak);

        }
        while (streak);

    }

    @Override
    public boolean checkAnswer(String usersAnswer, String answer, boolean streak) {
        return Game.super.checkAnswer(usersAnswer, answer, streak);
    }

    @Override
    public Flashcard currentQuestion(List<Flashcard> n) {
        return Game.super.currentQuestion(n);
    }
}

