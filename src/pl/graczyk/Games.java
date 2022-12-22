package pl.graczyk;

import java.util.*;

public class Games {
    static Scanner scn = new Scanner(System.in);
    static Random rand = new Random();
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
        System.out.println(GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI + " - " + GamesMenu.WPISYWANIE_POPRAWNEJ_ODPOWIEDZI.getChoice());
    }
}

    public static void testGame(List<Flashcard> n) {
        boolean streak = true;
        do {
            Flashcard question = currentQuestion(n);
            String definition = question.getText();
            String answer = question.getMeaning();
            System.out.println(definition);
            List<String> answers = new ArrayList<>();
            answers.add(question.getMeaning());
            do {
                Flashcard fakeAnswer = n.get(rand.nextInt(n.size()));
                if (!answers.contains(fakeAnswer.getMeaning()))
                    answers.add(fakeAnswer.getMeaning());
            } while (answers.size() <= 3);

            Collections.shuffle(answers);
            int answerNum = answers.indexOf(answer);
            for (int j = 1; j < answers.size()+1; j++) {
                System.out.print(j + "-" + answers.get(j-1) + "   ");
            }
            int usersAnswer = scn.nextInt();
            streak = checkAnswer(String.valueOf(usersAnswer), String.valueOf(answerNum + 1), streak);
        } while (streak);
    }



    public static void anagramGame(List<Flashcard> n) {
        boolean streak = true;
       do {
           Flashcard question = currentQuestion(n);
           String definition = question.getText();
          List<String> anagram = new ArrayList<>(List.of(definition.split("")));
           Collections.shuffle(anagram);
           String questionAnagram = anagram.toString();
           System.out.println(questionAnagram);
           String usersAnswer = scn.nextLine();
           streak = checkAnswer(usersAnswer, definition, streak);

       }
       while (streak);
    }
    public static void typeTheWordGame(List<Flashcard> n) {
        boolean streak = true;
        do {
            Flashcard question = currentQuestion(n);
            String definition = question.getText();
            System.out.println(definition);
            String answer = question.getMeaning();
            String usersAnswer = scn.nextLine();
            streak = checkAnswer(usersAnswer, answer, streak);

        }
        while (streak);
        }


    private static boolean checkAnswer(String usersAnswer, String answer, boolean streak) {
        if (usersAnswer.equals(answer)) {
            System.out.println("Brawo!");
        } else {
            System.out.println("przegrana");
            streak = false;
        }
    return streak;}

    private static Flashcard currentQuestion(List<Flashcard> n) {
        Flashcard question = n.get(rand.nextInt(n.size()));
        String definition = question.getText();
        String answer = question.getMeaning();
        return new Flashcard(definition, answer);}
}

