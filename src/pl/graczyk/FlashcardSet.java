package pl.graczyk;

import java.util.List;

public class FlashcardSet {

    String name;
    List<Flashcard> n;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flashcard> getN() {
        return n;
    }

    public void setN(List<Flashcard> n) {
        this.n = n;
    }

    public FlashcardSet(String name, List<Flashcard> n) {
        this.name = name;
        this.n = n;


    }

    @Override
    public String toString() {
        return "zestaw " +
                name + ": "
                + n ;
    }
}

