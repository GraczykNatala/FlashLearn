package pl.graczyk;

import java.util.*;

public class Games {
    static Scanner scn = new Scanner(System.in);
    static Random rand = new Random();
public enum GamesMenu {
    TEST(1),
    ANAGRAM(2),
    WPISYWANIE_POPRAWNEJ_ODPOWIEDZI(3),
    LUKI(4);

    private int choice;


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
        System.out.println(GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI + " - " + GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.getChoice());
        System.out.println(GamesMenu.LUKI + " - " + GamesMenu.LUKI.getChoice());
    }
}

    public static void testGame(List<Flashcard> n) {
        boolean streak = true;
        do {
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
            int usersAnswer = scn.nextInt();
            if (usersAnswer == answers.indexOf(question.getMeaning())) {
                System.out.println("BRAWO!");
            }
            else {
                System.out.println("przegrałeś");
                streak = false;
            }
        } while (streak);
    }
    public static void anagramGame(List<Flashcard> n) {
        boolean streak = true;
       do {
           Flashcard question = n.get(rand.nextInt(n.size()));
           String definition = question.getText();
           String anagramOneWord = definition.replace(" ", "").trim();
          List<String> anagram = new ArrayList<>(List.of(definition.split("")));
           Collections.shuffle(anagram);
           String questionAnagram = anagram.toString();
           System.out.println(questionAnagram);
           String answer = scn.nextLine();
           if (answer.equals(definition)) {
               System.out.println("Brawo!");
           } else {
               System.out.println("przegrana");
               streak = false;
           }
       }
       while (streak);
    }
    public static void typeTheWordGame(List<Flashcard> n) {
        boolean streak = true;
        do {
            Flashcard question = n.get(rand.nextInt(n.size()));
            String definition = question.getText();
            System.out.println(definition);
            String answer = question.getMeaning();
            String usersAnswer = scn.nextLine();
            if (usersAnswer.equals(answer)) {
                System.out.println("Brawo!");
            } else {
                System.out.println("przegrana");
                streak = false;
            }
        }
        while (streak);
        }

}

