package pl.graczyk;

public enum Menu {
    STWÓRZ_NOWY_ZESTAW(1),
    PRZEGLĄDAJ_ZESTAWY(2),
    WYJDŹ(3);

    private int choice;

    Menu(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }
}


