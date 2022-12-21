package pl.graczyk;

import java.util.ArrayList;
import java.util.List;

public class WinningStreak {
private    String question;
private    int streak;

    public WinningStreak(String question, int streak) {
        this.question = question;
        this.streak = streak;
    }
    public WinningStreak() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    @Override
    public String toString() {
        return question + " " +
                 streak;
    }

    public  List<WinningStreak> createWinningStreak(List<Flashcard> fcList) {
        List<WinningStreak> setWinningStreak = new ArrayList<>(fcList.size());
        for (Flashcard o : fcList) {
            String question = o.getText();
            WinningStreak ws = new WinningStreak(question, 3);
            setWinningStreak.add(ws);
        }

        return setWinningStreak;
    }
}

