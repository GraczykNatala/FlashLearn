package pl.graczyk;

import java.util.*;

public class Main {
    private static Map<String, List<Flashcard> > FlashcardSets = new HashMap<>();
    public static void main(String[] args) {

        createTest();
        menu();


    }

    private static void createTest() {
        Flashcard t1 = new Flashcard("Take off", "Startować");
        Flashcard t2 = new Flashcard("Aisle seat", "Miejsce od środka");
        Flashcard t3 = new Flashcard("Hand luggage", "Bagaż podręczny");
        Flashcard t4 = new Flashcard("Fasten the belt", "zapiąc pasy");
        Flashcard t5 = new Flashcard("Duty-free shop", "sklep bezcłowy");
        Flashcard t6 = new Flashcard("Board the plane", "Wejść na pokład");
        Flashcard t7 = new Flashcard("Gate", "Bramka");
        Flashcard t8 = new Flashcard("Departures board", "Tablica odlotów");
        Flashcard t9 = new Flashcard("Check in", "zameldować się");
        List testFC =  List.of(t1,t2,t3,t4,t5,t6,t7,t8,t9);
        FlashcardSets.put("testOne", testFC);

    }

    private static void menu() {
        System.out.println(Menu.STWÓRZ_NOWY_ZESTAW + " - " + Menu.STWÓRZ_NOWY_ZESTAW.getChoice());
        System.out.println(Menu.PRZEGLĄDAJ_ZESTAWY + " - " + Menu.PRZEGLĄDAJ_ZESTAWY.getChoice());
        System.out.println(Menu.WYJDŹ + " - " + Menu.WYJDŹ.getChoice());
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();
        if (choice == Menu.STWÓRZ_NOWY_ZESTAW.getChoice() ) {

            createSet();
            Main.menu();
        }
        else if (choice == Menu.PRZEGLĄDAJ_ZESTAWY.getChoice()) {
            System.out.println("Twoje zasoby");
            showAllSets(FlashcardSets);
            scn.nextLine();
            System.out.println("Wybierz zestaw");
            String chosenSet = scn.next();
            if (!FlashcardSets.containsKey(chosenSet))
            {System.out.println("Nie ma takiego zestawu");
                Main.menu();
            } else {
                System.out.println("Wybrano: " + chosenSet + FlashcardSets.get(chosenSet));
            }

        }
        else if (choice == Menu.WYJDŹ.getChoice()) {
            scn.close();
        }

    }

    private static void showAllSets(Map FlashcardSet) {
            System.out.println(FlashcardSets.keySet());

    }

    private static void createSet() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Podaj nazwę nowego zestawu");
        String setName = scn.next();
        System.out.println("Stworzono zestaw: " + setName );
        ArrayList<Flashcard> n = new ArrayList<>();
        System.out.println("Ile elementów chcesz dodać?");
        int amount = scn.nextInt();
        List<Flashcard> l = new ArrayList<>();
        for (int i = 0; i < amount; ) {
            Flashcard fc = new Flashcard();
            l.add(i,fc.createFlashcard());
            i++;
        }
        FlashcardSets.put(setName, l);
    }

}
