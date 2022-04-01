package com.rpgmain.controllers;

public class RuntimeController {
    public static void start() {
    }
    public static void stop() {

    }
    private static void update() {
        PlayerController.playerInput();
        NPCController.npcAI();
    }
}