package pl.graczyk.games;

import pl.graczyk.Flashcard;

import java.util.List;

public class TypeTheWordGame implements Game{
    @Override
    public Game runGame(List<Flashcard> n) {
        boolean streak = true;
        do {
            Flashcard question = currentQuestion(n);
            String definition = question.getText();
            System.out.println(definition);
            String answer = question.getMeaning();
            String usersAnswer = scn.nextLine();
            streak = checkAnswer(usersAnswer, answer, streak);

        }
        while (streak);
        return null;
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
