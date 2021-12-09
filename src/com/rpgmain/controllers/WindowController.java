package com.rpgmain.controllers;

import com.rpgmain.misc.Settings;

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
    public static String currentWindow;

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
    int baseSize = Settings.tileSize;
    public MainMenuPanel() {
        initUI();
        this.setName("Main Menu");
    }

    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(baseSize, 0, baseSize/2, 0)));

        JLabel title = new JLabel("Generic RPG Game");
        title.setPreferredSize(new Dimension(baseSize*7, baseSize));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton newButton = new JButton("New Game");
        newButton.setPreferredSize(new Dimension(baseSize*7, baseSize*2));
        newButton.setMaximumSize(newButton.getPreferredSize());
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loadButton = new JButton("Load");
        loadButton.setPreferredSize(new Dimension(baseSize*7, baseSize*2));
        loadButton.setMaximumSize(loadButton.getPreferredSize());
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setPreferredSize(new Dimension(baseSize*7, baseSize*2));
        settingsButton.setMaximumSize(settingsButton.getPreferredSize());
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(baseSize*7, baseSize*2));
        quitButton.setMaximumSize(quitButton.getPreferredSize());
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(baseSize*26, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, baseSize*3)));
        add(Box.createVerticalGlue());
        add(newButton);
        add(Box.createRigidArea(new Dimension(0, baseSize/2)));
        add(Box.createVerticalGlue());
        add(loadButton);
        add(Box.createRigidArea(new Dimension(0, baseSize/2)));
        add(Box.createVerticalGlue());
        add(settingsButton);
        add(Box.createRigidArea(new Dimension(0, baseSize/2)));
        add(Box.createVerticalGlue());
        add(quitButton);

        newButton.addActionListener(e -> MainController.newGame());
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
    int baseSize = Settings.tileSize;
    private final Image circle;
    public MainGamePanel() {
        initUI();
        this.setName("Game Player");
        circle = new ImageIcon(Objects.requireNonNull(MainGamePanel.class.getResource("/com/rpgmain/resources/circle.jpg"))).getImage();
    }
    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(baseSize, 0, baseSize*13, 0)));

        JLabel title = new JLabel("Image Test");
        title.setPreferredSize(new Dimension(baseSize*7, baseSize));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(baseSize*19, 0)));
        add(title);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(circle, 0, 0, this);
    }
}

class SideMenuPanel extends JPanel {
    int baseSize = Settings.tileSize;
    public SideMenuPanel() {
        initUI();
        this.setName("Side Settings");
    }
    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(baseSize, 0, baseSize*11, 0)));

        JLabel title = new JLabel("Side Menu");
        title.setPreferredSize(new Dimension(baseSize*7, baseSize));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        backButton.setMaximumSize(backButton.getPreferredSize());
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(baseSize*7, 0)));
        add(title);
        add(Box.createVerticalGlue());
        add(backButton);

        backButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}

class LoadMenuPanel extends JPanel {
    int baseSize = Settings.tileSize;
    public LoadMenuPanel() {
        initUI();
        this.setName("Main Load");
    }

    private void initUI() {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);
        setBorder(new EmptyBorder(new Insets(baseSize, 0, baseSize/2, 0)));

        JLabel title = new JLabel("Load Menu");
        title.setPreferredSize(new Dimension(baseSize*7, baseSize));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save1Button = new JButton("Save Slot 1");
        save1Button.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        save1Button.setMaximumSize(save1Button.getPreferredSize());
        save1Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save2Button = new JButton("Save Slot 2");
        save2Button.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        save2Button.setMaximumSize(save2Button.getPreferredSize());
        save2Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save3Button = new JButton("Save Slot 3");
        save3Button.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        save3Button.setMaximumSize(save3Button.getPreferredSize());
        save3Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save4Button = new JButton("Save Slot 4");
        save4Button.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        save4Button.setMaximumSize(save4Button.getPreferredSize());
        save4Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("Back");
        menuButton.setPreferredSize(new Dimension(baseSize*7, baseSize*2));
        menuButton.setMaximumSize(menuButton.getPreferredSize());
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(baseSize*26, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, baseSize*2)));
        add(Box.createVerticalGlue());
        add(save1Button);
        add(Box.createVerticalGlue());
        add(save2Button);
        add(Box.createVerticalGlue());
        add(save3Button);
        add(Box.createVerticalGlue());
        add(save4Button);
        add(Box.createRigidArea(new Dimension(0, baseSize/2)));
        add(Box.createVerticalGlue());
        add(menuButton);

        save1Button.addActionListener(e -> MainController.loadGame(1));
        save2Button.addActionListener(e -> MainController.loadGame(2));
        save3Button.addActionListener(e -> MainController.loadGame(3));
        save4Button.addActionListener(e -> MainController.loadGame(4));
        menuButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}

class SettingsMenuPanel extends JPanel {
    int baseSize = Settings.tileSize;
    public SettingsMenuPanel() {
        initUI();
        this.setName("Main Settings");
    }

    private void initUI() {
        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(mainLayout);
        setBorder(new EmptyBorder(new Insets(baseSize, 0, baseSize/2, 0)));

        JPanel panel = new JPanel();
        BoxLayout subLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(subLayout);
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.setPreferredSize(new Dimension(baseSize*7, baseSize*8));
        jScrollPane.setMaximumSize(jScrollPane.getPreferredSize());
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane.getViewport().add(panel);

        JLabel title = new JLabel("Settings Menu");
        title.setPreferredSize(new Dimension(baseSize*7, baseSize));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton audioToggle = new JButton("Play Audio");
        audioToggle.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        audioToggle.setMaximumSize(audioToggle.getPreferredSize());
        audioToggle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton runToggle = new JButton("Always Run");
        runToggle.setPreferredSize(new Dimension(baseSize*6, baseSize*2));
        runToggle.setMaximumSize(runToggle.getPreferredSize());
        runToggle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(baseSize*7, baseSize*2));
        backButton.setMaximumSize(backButton.getPreferredSize());
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(audioToggle);
        panel.add(runToggle);

        add(Box.createRigidArea(new Dimension(baseSize*26, 0)));
        add(title);
        add(Box.createRigidArea(new Dimension(0, baseSize*2)));
        add(Box.createVerticalGlue());
        add(jScrollPane);
        add(Box.createRigidArea(new Dimension(0, baseSize/2)));
        add(Box.createVerticalGlue());
        add(backButton);

        audioToggle.addActionListener(e -> MainController.changeSetting(0, 2));
        runToggle.addActionListener(e -> MainController.changeSetting(0, 2));
        backButton.addActionListener(e -> WindowController.changeWindow(new MainMenuPanel()));
    }
}
