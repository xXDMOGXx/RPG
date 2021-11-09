package com.rpgmain.controllers;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WindowController {
    private static final JFrame frame = new JFrame("Generic RPG");
    // Window Size is 1248 x 720

    public static void startWindow(JPanel panel) {
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void changeWindow(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.pack();
        frame.repaint();
    }

    public static void closeWindow() {
        frame.dispose();
    }
}

class MainMenuPanel extends JPanel {
    public MainMenuPanel() {
        initUI();
    }

    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 70, 0)));

        JLabel title = new JLabel("Generic RPG Game");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton newButton = new JButton("New Game");
        newButton.setPreferredSize(new Dimension(300, 75));
        newButton.setMaximumSize(newButton.getPreferredSize());
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loadButton = new JButton("Load");
        loadButton.setPreferredSize(new Dimension(300, 75));
        loadButton.setMaximumSize(loadButton.getPreferredSize());
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setPreferredSize(new Dimension(300, 75));
        settingsButton.setMaximumSize(settingsButton.getPreferredSize());
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(300, 75));
        quitButton.setMaximumSize(quitButton.getPreferredSize());
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(1248, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, 150)));
        add(Box.createVerticalGlue());
        add(newButton);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(Box.createVerticalGlue());
        add(loadButton);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(Box.createVerticalGlue());
        add(settingsButton);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(Box.createVerticalGlue());
        add(quitButton);

        newButton.addActionListener(e -> MainController.newGame());
        loadButton.addActionListener(e -> WindowController.changeWindow(new LoadMenuPanel()));
        settingsButton.addActionListener(e -> WindowController.changeWindow(new SettingsMenuPanel()));
        quitButton.addActionListener(e -> WindowController.closeWindow());
    }
}

class MainGamePanel extends JPanel {
    public MainGamePanel() {
        initUI();
    }

    private void initUI() {
    }
}

class LoadMenuPanel extends JPanel {
    public LoadMenuPanel() {
        initUI();
    }

    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 70, 0)));

        JLabel title = new JLabel("Load Menu");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save1Button = new JButton("Save Slot 1");
        save1Button.setPreferredSize(new Dimension(300, 75));
        save1Button.setMaximumSize(save1Button.getPreferredSize());
        save1Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save2Button = new JButton("Save Slot 1");
        save2Button.setPreferredSize(new Dimension(300, 75));
        save2Button.setMaximumSize(save2Button.getPreferredSize());
        save2Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save3Button = new JButton("Save Slot 1");
        save3Button.setPreferredSize(new Dimension(300, 75));
        save3Button.setMaximumSize(save3Button.getPreferredSize());
        save3Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save4Button = new JButton("Save Slot 1");
        save4Button.setPreferredSize(new Dimension(300, 75));
        save4Button.setMaximumSize(save4Button.getPreferredSize());
        save4Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("Back");
        menuButton.setPreferredSize(new Dimension(300, 75));
        menuButton.setMaximumSize(menuButton.getPreferredSize());
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(1248, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, 150)));
        add(Box.createVerticalGlue());
        add(save1Button);
        add(Box.createVerticalGlue());
        add(save2Button);
        add(Box.createVerticalGlue());
        add(save3Button);
        add(Box.createVerticalGlue());
        add(save4Button);
        add(Box.createVerticalGlue());
        add(menuButton);

        save1Button.addActionListener(e -> MainController.playGame(1));
        save2Button.addActionListener(e -> MainController.playGame(2));
        save3Button.addActionListener(e -> MainController.playGame(3));
        save4Button.addActionListener(e -> MainController.playGame(4));
        menuButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}

class SettingsMenuPanel extends JPanel {
    public SettingsMenuPanel() {
        initUI();
    }

    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 370, 0)));

        JLabel title = new JLabel("Settings Menu");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("Main Menu");
        menuButton.setPreferredSize(new Dimension(300, 75));
        menuButton.setMaximumSize(menuButton.getPreferredSize());
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(1248, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, 150)));
        add(Box.createVerticalGlue());
        add(menuButton);

        menuButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}
