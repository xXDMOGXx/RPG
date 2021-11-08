package com.rpgmain.controllers;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;

public class WindowController {
    private static final JFrame frame = new JFrame("Generic RPG");

    public static void StartWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void MainMenu() {
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(75, 0, 70, 0)));

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

        panel.add(Box.createRigidArea(new Dimension(1248, 0)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 150)));
        panel.add(Box.createVerticalGlue());
        panel.add(playButton);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(Box.createVerticalGlue());
        panel.add(loadButton);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(Box.createVerticalGlue());
        panel.add(settingsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(Box.createVerticalGlue());
        panel.add(quitButton);

        frame.setSize(1248, 720);
        frame.add(panel);
        frame.pack();
        frame.repaint();

        playButton.addActionListener(e -> {
        });
        loadButton.addActionListener(e -> LoadMenu());
        settingsButton.addActionListener(e -> {
        });
        quitButton.addActionListener(e -> frame.dispose());
    }

    public static void LoadMenu() {
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(75, 0, 370, 0)));

        JLabel title = new JLabel("Load Menu");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("Main Menu");
        menuButton.setPreferredSize(new Dimension(300, 75));
        menuButton.setMaximumSize(menuButton.getPreferredSize());
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(1248, 0)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 150)));
        panel.add(Box.createVerticalGlue());
        panel.add(menuButton);

        frame.setSize(1248, 720);
        frame.add(panel);
        frame.pack();
        frame.repaint();

        menuButton.addActionListener(e -> MainMenu());
    }
}

