package pl.graczyk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();


    }

    private static void menu() {
        System.out.println(Menu.STWÓRZ_NOWY_ZESTAW + " - " + Menu.STWÓRZ_NOWY_ZESTAW.getChoice());
        System.out.println(Menu.PRZEGLĄDAJ_ZESTAWY + " - " + Menu.PRZEGLĄDAJ_ZESTAWY.getChoice());
        Scanner scn = new Scanner(System.in);

    }
}
