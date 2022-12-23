package pl.graczyk.games;

public enum GamesMenu {
    TEST,
    ANAGRAM,
    WPISYWANIE_POPRAWNEJ_ODPOWIEDZI;



    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }


    public static void showGames() {
        System.out.println(GamesMenu.TEST + " - " + GamesMenu.TEST.ordinal());
        System.out.println(GamesMenu.ANAGRAM + " - " + GamesMenu.ANAGRAM.ordinal());
        System.out.println(GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI + " - " +GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.ordinal());
    }
}
