package pl.graczyk;

import pl.graczyk.games.*;

import java.io.*;
import java.util.*;

import static pl.graczyk.Menu.showMenu;

public class Main  {
    private static final Scanner scan = new Scanner(System.in);
    static Map<String, List<Flashcard> > FlashcardSets = new HashMap<>();
    public static void main(String[] args)  {




        ExampleSet.createExampleSet();
        menu();
    }

    private static void menu() {
        showMenu();

        int choice = scan.nextInt();
        if (choice == Menu.STWÓRZ_NOWY_ZESTAW.ordinal()) {
            createSet();
            Main.menu();
        } else if (choice == Menu.PRZEGLĄDAJ_ZESTAWY.ordinal()) {
            showAllSets();
            scan.nextLine();
            System.out.println("Wybierz zestaw");
            String chosenSet = scan.next();
            if (!FlashcardSets.containsKey(chosenSet))
            {System.out.println("Nie ma takiego zestawu");
               Main.menu();
            } else {

                System.out.println("Wybrano: " + FlashcardSets.get(chosenSet));

                GamesMenu.showGames();
                int chosenGame = scan.nextInt();
                    if (chosenGame == GamesMenu.TEST.ordinal()) {
                        new TestGame().runGame(FlashcardSets.get(chosenSet));
                        Main.menu();
                    }
                else if (chosenGame == GamesMenu.ANAGRAM.ordinal()) {
                     new AnagramGame().runGame(FlashcardSets.get(chosenSet));
                        Main.menu();
                }
                else if (chosenGame == GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.ordinal()) {
                     new TypeTheWordGame().runGame(FlashcardSets.get(chosenSet));
                        Main.menu();
                }
            }
        }
        else if (choice == Menu.WYJDŹ.ordinal()) {
            scan.close();



        }
    }


    private static void showAllSets() {
            System.out.println(FlashcardSets.keySet());
    }

    private static void createSet() throws InputMismatchException{
        System.out.println("Podaj nazwę nowego zestawu");
        String setName = scan.next();
        System.out.println("Stworzono zestaw: " + setName );
        System.out.println("Ile elementów chcesz dodać?");

       try {
           int amount = scan.nextInt();
           FlashcardSets.put(setName, fillFcList(amount));
       } catch (InputMismatchException e) {
           System.out.println("Musisz podać liczbę");
           createSet();
       }

    }

    private static List fillFcList(int amount) {
        List<Flashcard> FlachcardList = new ArrayList<>();
        for (int i = 0; i < amount; ) {
            Flashcard fc = new Flashcard();
            FlachcardList.add(i,fc.createFlashcard());
            i++;
        }
    return FlachcardList; }
}
