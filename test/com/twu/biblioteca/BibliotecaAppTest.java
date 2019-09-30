package com.twu.biblioteca;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    @Test
    public void testWelcomeMessageIsGenerated() {
        BibliotecaApp app = new BibliotecaApp();
        String output = app.generateWelcomeMessage();
        assertThat(output, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void testMainMenuIsGenerated() {
        BibliotecaApp app = new BibliotecaApp();
        String output = app.generateMenu();
        assertThat(output, is("1 - List of books"));
    }

    @Test
    public void testParseUserInputValidOption() {
        assertThat(BibliotecaApp.parseUserInput("1"), is(1));
    }

    @Test(expected = InvalidOptionException.class)
    public void testParseUserInputInvalidOption() {
        BibliotecaApp.parseUserInput("A");
    }

    @Test(expected = InvalidOptionException.class)
    public void testParseUserInputInvalidOptionNegativeNumber() {
        BibliotecaApp.parseUserInput("-1");
    }

}
