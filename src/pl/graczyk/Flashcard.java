package pl.graczyk;

import java.util.Objects;
import java.util.Scanner;

public class Flashcard {
    private String text;
    private String meaning;

    public Flashcard(String text, String meaning) {
        this.text = text;
        this.meaning = meaning;
    }

    public Flashcard() {

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

     Flashcard createFlashcard() {
        Scanner scn = new Scanner(System.in);
        System.out.println("podaj słowo");
        String text = scn.next();
        System.out.println("Podaj znaczenie");
        String meaning = scn.next();
        Flashcard fc = new Flashcard(text, meaning);
        return fc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return Objects.equals(text, flashcard.text) && Objects.equals(meaning, flashcard.meaning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, meaning);
    }
}

