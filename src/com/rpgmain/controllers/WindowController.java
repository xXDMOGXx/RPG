package com.rpgmain.controllers;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.util.Objects;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Image;
import java.awt.Graphics;

public class WindowController {
    private static final JFrame frame = new JFrame("Generic RPG");
    public static String currentWindow = "";
    // Window Size is 1248 x 720

    public static void startWindow(JPanel panel) {
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        currentWindow = panel.getName();
    }

    public static void changeWindow(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.pack();
        frame.repaint();
        currentWindow = panel.getName();
    }

    public static void closeWindow() {
        frame.dispose();
    }
}

class MainMenuPanel extends JPanel {
    public MainMenuPanel() {
        initUI();
        this.setName("Main Menu");
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

        newButton.addActionListener(e -> Main.newGame());
        loadButton.addActionListener(e -> WindowController.changeWindow(new LoadMenuPanel()));
        settingsButton.addActionListener(e -> WindowController.changeWindow(new SettingsMenuPanel()));
        quitButton.addActionListener(e -> WindowController.closeWindow());
    }
}

class MainGameContainerPanel extends JPanel {
    public MainGameContainerPanel() {
        initUI();
        this.setName("Game Container");
    }

    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(boxlayout);

        add(new SideMenuPanel());
        add(new MainGamePanel());
    }
}

class MainGamePanel extends JPanel {
    private final Image circle;
    public MainGamePanel() {
        initUI();
        this.setName("Game Player");
        circle = new ImageIcon(Objects.requireNonNull(MainGamePanel.class.getResource("/com/rpgmain/resources/circle.jpg"))).getImage();
    }
    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 595, 0)));

        JLabel title = new JLabel("Image Test");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(912, 0)));
        add(title);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(circle, 0, 0, this);
    }
}

class SideMenuPanel extends JPanel {
    public SideMenuPanel() {
        initUI();
        this.setName("Side Settings");
    }
    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 520, 0)));

        JLabel title = new JLabel("Side Menu");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(300, 75));
        backButton.setMaximumSize(backButton.getPreferredSize());
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(336, 0)));
        add(title);
        add(Box.createVerticalGlue());
        add(backButton);

        backButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}

class LoadMenuPanel extends JPanel {
    public LoadMenuPanel() {
        initUI();
        this.setName("Main Load");
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

        JButton save2Button = new JButton("Save Slot 2");
        save2Button.setPreferredSize(new Dimension(300, 75));
        save2Button.setMaximumSize(save2Button.getPreferredSize());
        save2Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save3Button = new JButton("Save Slot 3");
        save3Button.setPreferredSize(new Dimension(300, 75));
        save3Button.setMaximumSize(save3Button.getPreferredSize());
        save3Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save4Button = new JButton("Save Slot 4");
        save4Button.setPreferredSize(new Dimension(300, 75));
        save4Button.setMaximumSize(save4Button.getPreferredSize());
        save4Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("Back");
        menuButton.setPreferredSize(new Dimension(300, 75));
        menuButton.setMaximumSize(menuButton.getPreferredSize());
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(1248, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(Box.createVerticalGlue());
        add(save1Button);
        add(Box.createVerticalGlue());
        add(save2Button);
        add(Box.createVerticalGlue());
        add(save3Button);
        add(Box.createVerticalGlue());
        add(save4Button);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(Box.createVerticalGlue());
        add(menuButton);

        save1Button.addActionListener(e -> Main.loadGame(1));
        save2Button.addActionListener(e -> Main.loadGame(2));
        save3Button.addActionListener(e -> Main.loadGame(3));
        save4Button.addActionListener(e -> Main.loadGame(4));
        menuButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}

class SettingsMenuPanel extends JPanel {
    public SettingsMenuPanel() {
        initUI();
        this.setName("Main Settings");
    }

    private void initUI() {
        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(mainLayout);
        setBorder(new EmptyBorder(new Insets(75, 0, 70, 0)));

        JPanel panel = new JPanel();
        BoxLayout subLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(subLayout);
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setPreferredSize(new Dimension(300, 350));
        jScrollPane.setMaximumSize(jScrollPane.getPreferredSize());
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane.getViewport().add(panel);

        JLabel title = new JLabel("Settings Menu");
        title.setPreferredSize(new Dimension(300, 50));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton audioToggle = new JButton("Play Audio");
        audioToggle.setPreferredSize(new Dimension(200, 75));
        audioToggle.setMaximumSize(audioToggle.getPreferredSize());
        audioToggle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton runToggle = new JButton("Always Run");
        runToggle.setPreferredSize(new Dimension(200, 75));
        runToggle.setMaximumSize(runToggle.getPreferredSize());
        runToggle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(300, 75));
        backButton.setMaximumSize(backButton.getPreferredSize());
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(audioToggle);
        panel.add(runToggle);

        add(Box.createRigidArea(new Dimension(1248, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(Box.createVerticalGlue());
        add(jScrollPane);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(Box.createVerticalGlue());
        add(backButton);

        audioToggle.addActionListener(e -> Main.changeSetting(0, 2));
        runToggle.addActionListener(e -> Main.changeSetting(0, 2));
        backButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}
