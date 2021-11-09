package com.rpgmain.controllers;

import javax.swing.*;

public class MainController {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainController::startGame);
    }

    private static void startGame() {
        WindowController.startWindow(new MainMenuPanel());
    }

    public static void newGame() {

    }

    public static void playGame(int saveSlot) {

    }
}
