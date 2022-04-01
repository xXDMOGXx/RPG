package com.rpgmain.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class NPCController {
    private static ArrayList<NPC> npcList = new ArrayList<NPC>();
    private static int[][][] npcMap = {{{}}};
    private static final String npcInfoPath = "/com/rpgmain/resources/npcinfo.txt";
    public static String retrieveNPCData(int entityID) {
        String data = null;
        try {
            File npcInfo = new File("test.txt");
            Scanner infoReader = new Scanner(npcInfo);
            for (int i=0; i < entityID; i++) {
                data = infoReader.nextLine();
            }
            infoReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("NPC File Not Found!");
        }
        return data;
    }
    public static NPC constructNPC(int gameID, String npcData) {
        return new NPC();
    }
    public static void spawnNPC(int chunkID, int x, int y, int entityID) {
        String npcData = retrieveNPCData(entityID);

        npcList.add(constructNPC(1, npcData));
    }
    public static void damageNPC(int damage) {

    }
    public static void destroyNPC(boolean dropItems) {

    }
    public static void findNPC(int x, int y) {

    }
    public static void npcAI() {

    }
}

class NPC {
    private static int gameID;
    private static String name;
    private static int health;
    private static int[] stats;
    private static int relation;
    private static String gameIcon;
    private static String battleIcon;
    private static int[] weapon;
    private static int[] armour;

    public static int getGameID() {return gameID;}
    public static String getName() {return name;}
    public static int getHealth() {return health;}
    public static int[] getStats() {return stats;}
    public static int getRelation() {return relation;}
    public static String getGameIcon() {return gameIcon;}
    public static String getBattleIcon() {return battleIcon;}
    public static int[] getWeapon() {return weapon;}
    public static int[] getArmour() {return armour;}

    public static void setName(String newName) {name = newName;};
    public static void setHealth(int newHealth) {health = newHealth;};
    public static void setStats(int[] newStats) {stats = newStats;};
    public static void setRelation(int newRelation) {relation = newRelation;};
    public static void setGameIcon(String newGameIcon) {gameIcon = newGameIcon;};
    public static void setBattleIcon(String newBattleIcon) {battleIcon = newBattleIcon;};
    public static void setWeapon(int[] newWeapon) {weapon = newWeapon;};
    public static void setArmour(int[] newArmour) {armour = newArmour;};

    public static void changeHealth(int healthChange) {
        health += healthChange;
    };
    public static void changeStats(int statIndex, int statChange) {
        stats[statIndex] += statChange;
    };

    public static void destroy() {

    }
}
