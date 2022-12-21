package pl.graczyk;

import java.util.List;

public class ExampleSet {

    static List<Flashcard> createExampleSet() {

        Flashcard t1 = new Flashcard("Take off", "Startować");
        Flashcard t2 = new Flashcard("Aisle seat", "Miejsce od środka");
        Flashcard t3 = new Flashcard("Hand luggage", "Bagaż podręczny");
        Flashcard t4 = new Flashcard("Fasten the belt", "zapiąc pasy");
        Flashcard t5 = new Flashcard("Duty-free shop", "sklep bezcłowy");
        Flashcard t6 = new Flashcard("Board the plane", "Wejść na pokład");
        Flashcard t7 = new Flashcard("Gate", "Bramka");
        Flashcard t8 = new Flashcard("Departures board", "Tablica odlotów");
        Flashcard t9 = new Flashcard("Check in", "zameldować się");
        List<Flashcard> testFC =  List.of(t1,t2,t3,t4,t5,t6,t7,t8,t9);
        Main.FlashcardSets.put("testOne", testFC);
        WinningStreak ws = new WinningStreak();
        ws.createWinningStreak(testFC);


    return testFC;}
}
