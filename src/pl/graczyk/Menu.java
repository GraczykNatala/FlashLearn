package pl.graczyk;

public enum Menu {
    STWÓRZ_NOWY_ZESTAW(1), PRZEGLĄDAJ_ZESTAWY(2);

    private int choice;

    Menu(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }
}


