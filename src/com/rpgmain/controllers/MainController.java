package com.rpgmain.controllers;

import javax.swing.*;

public class MainController {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainController::StartGame);
    }

    private static void StartGame() {
        WindowController.StartWindow(new MainMenuPanel());
    }
}
