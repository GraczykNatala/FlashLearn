package pl.graczyk.games;

import pl.graczyk.Flashcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestGame implements Game {


    @Override
    public void runGame(List<Flashcard> n) {
        boolean streak = true;
        do {
            Flashcard question = currentQuestion(n);
            String definition = question.getText();
            String answer = question.getMeaning();
            System.out.println(definition);
            List<String> answers = new ArrayList<>();
            answers.add(question.getMeaning());
            do {
                Flashcard fakeAnswer = n.get(rand.nextInt(n.size()));
                if (!answers.contains(fakeAnswer.getMeaning()))
                    answers.add(fakeAnswer.getMeaning());
            } while (answers.size() <= 3);

            Collections.shuffle(answers);
            int answerNum = answers.indexOf(answer);
            for (int j = 1; j < answers.size()+1; j++) {
                System.out.print(j + "-" + answers.get(j-1) + "   ");
            }
            int usersAnswer = scn.nextInt();
            streak = checkAnswer(String.valueOf(usersAnswer), String.valueOf(answerNum + 1), streak);
        } while (streak);


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
