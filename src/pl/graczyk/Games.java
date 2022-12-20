package pl.graczyk;

public enum Games {
    TEST(1),
    ANAGRAM(2),
    WPISYWANIE_POPRAWNEJ_ODPOWIEDZI(3),
    LUKI(4);

    private int choice;


    Games(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }
}
