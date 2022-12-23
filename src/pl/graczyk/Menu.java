package pl.graczyk;

public enum Menu {
    STWÓRZ_NOWY_ZESTAW,
    PRZEGLĄDAJ_ZESTAWY,
    WYJDŹ;



    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }


    public static void showMenu() {
        System.out.println(Menu.STWÓRZ_NOWY_ZESTAW + " - " + Menu.STWÓRZ_NOWY_ZESTAW.ordinal());
        System.out.println(Menu.PRZEGLĄDAJ_ZESTAWY + " - " + Menu.PRZEGLĄDAJ_ZESTAWY.ordinal());
        System.out.println(Menu.WYJDŹ + " - " + Menu.WYJDŹ.ordinal());
    }

}


