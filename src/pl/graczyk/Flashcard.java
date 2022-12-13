package pl.graczyk;

public class Flashcard {
    String text;
    String meaning;

    public Flashcard(String text, String meaning) {
        this.text = text;
        this.meaning = meaning;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return  text + "-" +
                meaning;
    }
}

