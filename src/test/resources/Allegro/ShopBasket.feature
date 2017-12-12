Feature: Sprawdzenie poprawności działania funkcji koszyka

  Scenario: Dodawanie przedmiotów do koszyka
    When Wejść na stronę allegro.pl
    And Dodać do koszyka dwie sztuki dowolnego produktu polecanego na stronie głównej
    And Wejść w kategorię Elektronika / "Laptopy"
    And Wybrać w filtrach cenę do 1000 zł i dodać do koszyka drugi laptop w wynikowej listy
    Then Sprawdzić czy użytkownik został przeniesiony na widok koszyka
    And Sprawdzić czy ceny, ilości dodanych produktów oraz sumaryczna wartość koszyka są poprawne