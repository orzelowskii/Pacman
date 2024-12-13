# Pacman

##Opis projektu
Ten projekt to implementacja klasycznej gry Pacman w języku Java. Aplikacja wykorzystuje bibliotekę Swing do tworzenia interfejsu użytkownika oraz graficznej reprezentacji gry. Celem gry jest zdobycie jak największej liczby punktów poprzez zbieranie kropek i unikanie duchów.

## Funkcje projektu
- Menu główne: Możliwość wyboru rozpoczęcia nowej gry, przeglądania najlepszych wyników oraz wyjścia z aplikacji.
- Generowanie labiryntu: Automatyczne tworzenie planszy gry z użyciem algorytmu generującego labirynt.
- Interakcja gracza: Sterowanie Pacmanem za pomocą klawiatury (strzałki) oraz zbieranie punktów.
- Przeciwnicy (duchy): Cztery duchy sterowane wątkami, poruszające się po planszy.
- System punktacji: Gracz zdobywa punkty za zjadanie kropek. Wynik końcowy jest zapisywany w tabeli wyników.
- Timer i licznik żyć: Gra śledzi czas oraz liczbę żyć Pacmana. Gra kończy się, gdy Pacman straci wszystkie życia.

## Struktura kodu
1. MenuFrame.java
- Obsługuje interfejs menu głównego i pozwala na wybór akcji (nowa gra, tabela wyników, wyjście).

2. GameFrame.java
- Obsługuje główną rozgrywkę, w tym sterowanie Pacmanem, aktualizację punktacji oraz interakcję z duchami.

3. MazeGenerate.java
- Odpowiada za losowe generowanie labiryntu.

4. Pacman.java
- Klasa zawierająca metodę main, która inicjalizuje całą aplikację.

5. Duchy i kolizje
- Klasy Ghost1, Ghost2, Ghost3, Ghost4 obsługują logikę poruszania się duchów.
- Kolizje są sprawdzane w osobnym wątku, który zarządza zakończeniem gry w przypadku złapania Pacmana przez ducha.
