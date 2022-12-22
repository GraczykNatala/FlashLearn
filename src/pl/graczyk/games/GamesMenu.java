package pl.graczyk.games;

public enum GamesMenu {
    TEST(1),
    ANAGRAM(2),
    WPISYWANIE_POPRAWNEJ_ODPOWIEDZI(3);

    private final int choice;


    GamesMenu(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }


    public static void showGames() {
        System.out.println(GamesMenu.TEST + " - " + GamesMenu.TEST.getChoice());
        System.out.println(GamesMenu.ANAGRAM + " - " + GamesMenu.ANAGRAM.getChoice());
        System.out.println(GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI + " - " +GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.getChoice());
    }
}
