package com.rpgmain.controllers;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::startGame);
    }

    private static void startGame() {
        WindowController.startWindow(new MainMenuPanel());
    }

    public static void newGame() {
        WindowController.changeWindow(new MainGameContainerPanel());
    }

    public static void saveGame(int saveSlot) {

    }

    public static void loadGame(int saveSlot) {
        System.out.println(saveSlot);
    }

    public static void changeSetting(int settingPos, int value) {

    }
}
