package pl.graczyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List sets = new ArrayList<Flashcard>();
    public static void main(String[] args) {

        menu();


    }

    private static void menu() {
        System.out.println(Menu.STWÓRZ_NOWY_ZESTAW + " - " + Menu.STWÓRZ_NOWY_ZESTAW.getChoice());
        System.out.println(Menu.PRZEGLĄDAJ_ZESTAWY + " - " + Menu.PRZEGLĄDAJ_ZESTAWY.getChoice());
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();
        if (choice == Menu.STWÓRZ_NOWY_ZESTAW.getChoice() ) {

            sets.add(createSet());
            Main.menu();
        }
        else if (choice == Menu.PRZEGLĄDAJ_ZESTAWY.getChoice()) {
            System.out.println("Twoje zasoby");
            showAllSets(sets);
            scn.nextLine();
            System.out.println("Wybierz zestaw");
            String chosenSet = scn.next();
            int chosen = 0;
            if (sets.contains(chosenSet)) {
                chosen = sets.indexOf(chosenSet);
                sets.get(chosen);
            }
            System.out.println("Wybrano: " + sets.get(chosen));

            scn.close();
        }

    }

    private static void showAllSets(List sets) {
        System.out.println(sets.size());
        for (int i = 0; i < sets.size();) {
            System.out.println(sets.get(i));
            i++;
        }
    }

    private static FlashcardSet createSet() {

        Scanner scn = new Scanner(System.in);
        System.out.println("Podaj nazwę nowego zestawu");
        String setName = scn.next();
        ArrayList<Flashcard> n = new ArrayList<>();
        FlashcardSet fs = new FlashcardSet(setName, n);
        System.out.println("Stworzono zestaw: " + setName );
        System.out.println("Ile elementów chcesz dodać?");
        int amount = scn.nextInt();
        List<Flashcard> l = new ArrayList<>();
        for (int i = 0; i < amount; ) {
            l.add(i,createFlashcard());
            i++;
        }
        FlashcardSet fcs = new FlashcardSet(setName,l );
        System.out.println(fcs);

        return fcs;
    }

    private static Flashcard createFlashcard() {
        Scanner scn = new Scanner(System.in);
        System.out.println("podaj słowo");
        String text = scn.next();
        System.out.println("Podaj znaczenie");
        String meaning = scn.next();
        Flashcard fc = new Flashcard(text, meaning);
        return fc;
    }
}
