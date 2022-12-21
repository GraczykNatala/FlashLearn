package pl.graczyk;

import java.util.*;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    static final Map<String, List<Flashcard> > FlashcardSets = new HashMap<>();
    public static void main(String[] args) {

        ExampleSet.createExampleSet();
        menu();

    }


    private static void menu() {
        System.out.println(Menu.STWÓRZ_NOWY_ZESTAW + " - " + Menu.STWÓRZ_NOWY_ZESTAW.getChoice());
        System.out.println(Menu.PRZEGLĄDAJ_ZESTAWY + " - " + Menu.PRZEGLĄDAJ_ZESTAWY.getChoice());
        System.out.println(Menu.WYJDŹ + " - " + Menu.WYJDŹ.getChoice());
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
                System.out.println("Wybrano: " + chosenSet + FlashcardSets.get(chosenSet));
                showGames();
                int chosenGame = scan.nextInt();
                    if (chosenGame == Games.TEST.getChoice()) {
                        testGame( FlashcardSets.get(chosenSet));
                    }
            }

        }
        else if (choice == Menu.WYJDŹ.getChoice()) {
            scan.close();
        }

    }

    private static void testGame(List<Flashcard> n) {
        Random rand = new Random();
        int points = 0;

        for (int i = points; i < n.size(); i++) {
            Flashcard question = n.get(rand.nextInt(n.size()));
            String definition = question.getText();
            System.out.println(definition);
            System.out.println("odpowiedzi");
            List<String> answers = new ArrayList<>();
            answers.add(question.getMeaning());
            do {
                Flashcard answer = n.get(rand.nextInt(n.size()));
                if (!answers.contains(answer.getMeaning()))
                    answers.add(answer.getMeaning());
            } while (answers.size() <= 3);
            Collections.shuffle(answers);
            for (int j = 0; j < answers.size(); j++) {
                System.out.print(j);
                System.out.println(answers.get(j) + "   ");
            }
            int usersAnswer = scan.nextInt();
            if (usersAnswer == answers.indexOf(question.getMeaning())) {
                System.out.println("BRAWO!");
                points +=1;
            }
        }
    }



    private static void showGames() {
        System.out.println(Games.TEST + " - " + Games.TEST.getChoice());
        System.out.println(Games.ANAGRAM + " - " + Games.ANAGRAM.getChoice());
        System.out.println(Games.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI + " - " + Games.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.getChoice());
        System.out.println(Games.LUKI + " - " + Games.LUKI.getChoice());
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
