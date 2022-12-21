package pl.graczyk;

public class WinningStreak {
private    String question;
private    int streak;

    public WinningStreak(String question, int streak) {
        this.question = question;
        this.streak = streak;
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
}

