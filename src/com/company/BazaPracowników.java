package com.company;

import java.util.*;


//TODO ta klasa wymaga refactoru- czyszczenia kodu
public class BazaPracowników {

    static Pracownik sprawdzany;

    public static List<Pracownik> listaPracowników = new ArrayList<Pracownik>();

    static Scanner input = new Scanner(System.in);

    static int id = 0;

    static int generatorID(){
        return id++;
    }


    //TODO wyczyść tą metodę
    public static void addPracownik() {

        int id=0;
        System.out.println("Podaj imię");
        String imię = input.next();
        System.out.println("Podaj nazwisko");
        String nazwisko = input.next();
        id = generatorID();
        System.out.println("Podaj adres pracownika");
        String adres = input.next();
        System.out.println("Podaj numer oddziału");
        int nrOddziału = input.nextInt();
        System.out.println("Podaj adres oddziału");
        String adresOddziału = input.next();
        System.out.println("Podaj stanowisko z listy: HANDLOWIEC, KSIĘGOWY, PREZES");
        Stanowisko stanowisko = Stanowisko.valueOf(input.next());
        if (stanowisko.equals(Stanowisko.HANDLOWIEC)) {

            //TODO daj to do osobnej metod np. addHandlowiec
            System.out.println("Podaj wielkość premii za sprzedaż");
            int premiaZasprzedaż = input.nextInt();
            sprawdzany = (new Handlowiec(imię, nazwisko, id, adres, new Oddział(nrOddziału, adresOddziału), stanowisko, premiaZasprzedaż));
            if(!listaPracowników.isEmpty()) {
                for (Pracownik x : listaPracowników) {
                    if (x.getImię().equals(sprawdzany.getImię()) & x.getNazwisko().equals(sprawdzany.getNazwisko()) & x.getAdres().equals(sprawdzany.getAdres())) {
                        System.out.println("Osoba o takich danych jest już w bazie.");
                        break;
                    } else {
                        listaPracowników.add(sprawdzany);
                        System.out.println("Dodano pracownika: " + listaPracowników.get(listaPracowników.size() - 1) + " do bazy.");
                        break;
                    }
                }
            }else {
                listaPracowników.add(sprawdzany);
                System.out.println("Dodano pracownika: " + listaPracowników.get(listaPracowników.size() - 1) + " do bazy.");
            }

        }
        else if (stanowisko.equals(Stanowisko.KSIĘGOWY)) {
            //TODO daj to do osobnej metod np. addKsięgowy
            System.out.println("Podaj wielkość premii za brak błędów");
            int premiaZaBrakBłędów = input.nextInt();
            sprawdzany = (new Księgowy(imię, nazwisko, id, adres, new Oddział(nrOddziału, adresOddziału), stanowisko, premiaZaBrakBłędów));
            if(!listaPracowników.isEmpty()) {
                for (Pracownik x : listaPracowników) {
                    if (x.getImię().equals(sprawdzany.getImię()) & x.getNazwisko().equals(sprawdzany.getNazwisko()) & x.getAdres().equals(sprawdzany.getAdres())) {
                        System.out.println("Osoba o takich danych jest już w bazie.");
                        break;
                    } else {
                        listaPracowników.add(sprawdzany);
                        System.out.println("Dodano pracownika: " + listaPracowników.get(listaPracowników.size() - 1) + " do bazy.");
                        break;
                    }
                }
            }else {
                listaPracowników.add(sprawdzany);
                System.out.println("Dodano pracownika: " + listaPracowników.get(listaPracowników.size() - 1) + " do bazy.");}
        }
        else if (stanowisko.equals(Stanowisko.PREZES)) {

            //TODO daj to do osobnej metod np. addPrezes
            System.out.println("Podaj wielkość dywidendy");
            int dywidenda = input.nextInt();
            sprawdzany = (new Prezes(imię, nazwisko, id, adres, new Oddział(nrOddziału, adresOddziału), stanowisko, dywidenda));
            if(!listaPracowników.isEmpty()) {
                //TODO ten FOR  powtarza się  3 razy

                for (Pracownik x : listaPracowników) {
                    if (x.getImię().equals(sprawdzany.getImię()) & x.getNazwisko().equals(sprawdzany.getNazwisko()) & x.getAdres().equals(sprawdzany.getAdres())) {
                        System.out.println("Osoba o takich danych jest już w bazie.");
                        break;
                    } else {
                        listaPracowników.add(sprawdzany);
                        System.out.println("Dodano pracownika: " + listaPracowników.get(listaPracowników.size() - 1) + " do bazy.");
                        break;
                    }
                }
            }else {

                //TODO te dwie linijki powtarzają się  4 razy
                listaPracowników.add(sprawdzany);
                System.out.println("Dodano pracownika: " + listaPracowników.get(listaPracowników.size() - 1) + " do bazy.");}
        }
        System.out.println();
    }

    public static void removePracownik () {
        int checkedId;
        System.out.println("Podaj id pracownika");
        checkedId = input.nextInt();
        for (Pracownik x: listaPracowników) {
            if (x.getId() == checkedId) {
                BazaPracowników.listaPracowników.remove(x);
                System.out.println("Usunięto pracownika " + x + " z bazy");
                break;
            }
            else {
                System.out.print("W bazie nie ma pracownika o podanym ID.");
                break;
            }
        }
    }

    public static void findWithID () {
        int checkedId=0;
        System.out.println("Podaj id pracownika");
        checkedId = input.nextInt();
        for (Pracownik x: listaPracowników) {
            if (x.getId() == checkedId) {
                System.out.println(x);
            }
            else {
                System.out.println("W bazie nie ma pracownika o podanym ID");
                break;
            }
        }
    }

    public static void findWithName () {
        String imię= "";
        System.out.println("Podaj imię pracownika");
        imię = input.next();
        for (Pracownik x: listaPracowników) {
            if (x.getImię().equals(imię)) {
                System.out.println(x);
            }
            else {
                System.out.println("W bazie nie ma pracownika o podanym ID");
                break;
            }
        }
    }

    public static void findWithSureName () {
        String nazwisko= "";
        System.out.println("Podaj nazwisko pracownika");
        nazwisko = input.next();
        for (Pracownik x: listaPracowników) {
            if (x.getNazwisko().equals(nazwisko)) {
                System.out.println(x);
            }
            else {
                System.out.println("W bazie nie ma pracownika o podanym ID");
                break;
            }
        }
    }

    public static void printAll () {
        if(listaPracowników.isEmpty()) {
            System.out.println("Baza pracowników jest pusta");
        }
        else
        System.out.println("Aktualna lista pracowników:");
        for (Pracownik x: listaPracowników) {
            System.out.println(x);
            break;
        }
    }

    public static void findWithPosition () {
        Stanowisko stanowisko = null;
        System.out.println("Podaj nazwisko pracownika");
        stanowisko = Stanowisko.valueOf(input.next());
        for (Pracownik x: listaPracowników) {
            if (x.getStanowisko().equals(stanowisko)) {
                System.out.println(x);
            }
        }
    }

    public static void mainMenu () {

            int menuNav;

            while (true) {

                System.out.println("=============================Baza pracówników firmy X=============================");
                System.out.println("1. Wyświetl wszystkich pracowników");
                System.out.println("2. Dodaj pracownika do bazy");
                System.out.println("3. Usuń pracownika z bazy");
                System.out.println("4. Wyszukaj pracownika");
                System.out.println("5. Wyjście");

                menuNav = input.nextInt();

                if (menuNav != 8) {

                    switch (menuNav) {
                        case 1:
                            printAll();
                            break;
                        case 2:
                            addPracownik();
                            break;
                        case 3:
                            removePracownik();
                            break;
                        case 4:
                            findnMenu();
                            break;
                        case 5:
                            System.out.println("Dziękujemy za skorzystanie z bazy. Do widzenia.");
                            return;
                    }

                } else
                    break;

        }
    }

    public static void findnMenu () {

        int menuNav;

        while (true) {

            System.out.println("1. Wyszukaj po ID");
            System.out.println("2. Wyszukaj po imieniu");
            System.out.println("3. Wyszukaj po nazwisku");
            System.out.println("4. Wyszukaj po stanowisku");
            System.out.println("0. Wyjdź");

            menuNav = input.nextInt();

            if (menuNav != 0) {

                switch (menuNav) {
                    case 1:
                        findWithID();
                        break;
                    case 2:
                        findWithName();
                        break;
                    case 3:
                        findWithSureName();
                        break;
                    case 4:
                        findWithPosition();
                        break;
                    case 0:
                        mainMenu();
                        break;
                }

            } else
                break;

        }
    }
}
