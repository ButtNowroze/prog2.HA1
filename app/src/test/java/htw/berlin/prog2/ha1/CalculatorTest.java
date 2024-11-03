package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    // Teilaufgabe 01: Neu hinzugefügter Test für die Vorzeichenumkehr

    @Test
    @DisplayName("should correctly toggle the sign of a positive number")
    void testTogglePositiveSign() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressNegativeKey(); // Vorzeichen umkehren

        String expected = "-5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should correctly toggle the sign of a negative number")
    void testToggleNegativeSign() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressNegativeKey(); // Vorzeichen auf negativ setzen
        calc.pressNegativeKey(); // Vorzeichen zurück auf positiv setzen

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //Teilaufgabe 02: Neue Tests für Fehlerkategorie

    @Test
    @DisplayName("should display error when trying to divide by zero using equals key")
    void testDivisionByZeroWithEquals() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey(); // Division durch Null

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should throw exception when trying to calculate square root of a negative number")
    void testSquareRootNegativeException() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressNegativeKey(); // Negative Zahl
        calc.pressUnaryOperationKey("√"); // Quadratwurzel von negativ

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

