package pl.graczyk;

import pl.graczyk.games.*;

import java.util.*;

import static pl.graczyk.Menu.showMenu;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    public static final Map<String, List<Flashcard> > FlashcardSets = new HashMap<>();
    public static void main(String[] args) {

        ExampleSet.createExampleSet();
        menu();
    }

    private static void menu() {
        showMenu();
        int choice = scan.nextInt();
        if (choice == Menu.STWÓRZ_NOWY_ZESTAW.getChoice() ) {

            createSet();
            Main.menu();
        }
        else if (choice == Menu.PRZEGLĄDAJ_ZESTAWY.getChoice()) {
            System.out.println("Twoje zasoby");
            showAllSets();
            scan.nextLine();
            System.out.println("Wybierz zestaw");
            String chosenSet = scan.next();
            if (!FlashcardSets.containsKey(chosenSet))
            {System.out.println("Nie ma takiego zestawu");
                Main.menu();
            } else {
                System.out.println("Wybrano: " + chosenSet);

                GamesMenu.showGames();
                int chosenGame = scan.nextInt();
                    if (chosenGame == GamesMenu.TEST.getChoice()) {
                        Game test = new TestGame().runGame(FlashcardSets.get(chosenSet));

                    }
                if (chosenGame == GamesMenu.ANAGRAM.getChoice()) {
                    Game anagram = new AnagramGame().runGame(FlashcardSets.get(chosenSet));
                }
                if (chosenGame == GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.getChoice()) {
                    Game type = new TypeTheWordGame().runGame(FlashcardSets.get(chosenSet));
                }
            }

        }
        else if (choice == Menu.WYJDŹ.getChoice()) {
            scan.close();
        }

    }








    private static void showAllSets() {
            System.out.println(FlashcardSets.keySet());

    }

    private static void createSet() {
        System.out.println("Podaj nazwę nowego zestawu");
        String setName = scan.next();
        System.out.println("Stworzono zestaw: " + setName );
        System.out.println("Ile elementów chcesz dodać?");
        int amount = scan.nextInt();
        List<Flashcard> FlachcardList = new ArrayList<>();
        for (int i = 0; i < amount; ) {
            Flashcard fc = new Flashcard();
            FlachcardList.add(i,fc.createFlashcard());
            i++;
        }
        WinningStreak ws = new WinningStreak();
        ws.createWinningStreak(FlachcardList);
        FlashcardSets.put(setName, FlachcardList);

    }

}
