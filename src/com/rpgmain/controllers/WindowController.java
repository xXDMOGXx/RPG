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

    public static void StartWindow(JPanel panel) {
        frame.setSize(1248, 720);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void ChangeWindow(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.pack();
        frame.repaint();
    }

    public static void CloseWindow() {
        frame.dispose();
    }
}

class MainMenuPanel extends JPanel{
    public MainMenuPanel() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 70, 0)));

        JLabel title = new JLabel("Generic RPG Game");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(300, 75));
        playButton.setMaximumSize(playButton.getPreferredSize());
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        add(playButton);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(Box.createVerticalGlue());
        add(loadButton);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(Box.createVerticalGlue());
        add(settingsButton);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(Box.createVerticalGlue());
        add(quitButton);

        playButton.addActionListener(e -> {});
        loadButton.addActionListener(e -> WindowController.ChangeWindow(new LoadMenuPanel()));
        settingsButton.addActionListener(e -> WindowController.ChangeWindow(new SettingsMenuPanel()));
        quitButton.addActionListener(e -> WindowController.CloseWindow());
    }
}

class LoadMenuPanel extends JPanel{
    public LoadMenuPanel() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 370, 0)));

        JLabel title = new JLabel("Load Menu");
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

        menuButton.addActionListener(e -> WindowController.ChangeWindow(new MainMenuPanel()));
    }
}

class SettingsMenuPanel extends JPanel{
    public SettingsMenuPanel() {
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

        menuButton.addActionListener(e -> WindowController.ChangeWindow(new MainMenuPanel()));
    }
}
