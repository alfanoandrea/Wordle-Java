package wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("Wordle - Seleziona lingua");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 390);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/icon.png"));
        setIconImage(icon.getImage());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(18, 18, 19));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titolo = new JLabel("WORDLE");
        titolo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titolo.setFont(new Font("Segoe UI", Font.BOLD, 48));
        titolo.setForeground(Color.WHITE);
        titolo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        mainPanel.add(titolo);

        JLabel sottotitolo = new JLabel("Scegli la lingua / Choose language");
        sottotitolo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sottotitolo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        sottotitolo.setForeground(Color.LIGHT_GRAY);
        sottotitolo.setBorder(BorderFactory.createEmptyBorder(0, 0, 18, 0));
        mainPanel.add(sottotitolo);

        JPanel flagPanel = new JPanel();
        flagPanel.setOpaque(false);
        flagPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        // Carica e ridimensiona le immagini delle bandiere
        ImageIcon iconIta = new ImageIcon(new ImageIcon(getClass().getResource("/img/it.png"))
                .getImage().getScaledInstance(80, 54, Image.SCALE_SMOOTH));
        ImageIcon iconEng = new ImageIcon(new ImageIcon(getClass().getResource("/img/gb.png"))
                .getImage().getScaledInstance(80, 54, Image.SCALE_SMOOTH));

        // Bottone ITA
        JButton btnIta = new JButton(iconIta);
        btnIta.setPreferredSize(new Dimension(90, 64));
        btnIta.setFocusPainted(false);
        btnIta.setContentAreaFilled(false);
        btnIta.setBorder(BorderFactory.createLineBorder(new Color(83, 141, 78), 2, true));
        btnIta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIta.setToolTipText("Italiano");
        btnIta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnIta.setBorder(BorderFactory.createLineBorder(new Color(181, 159, 59), 3, true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnIta.setBorder(BorderFactory.createLineBorder(new Color(83, 141, 78), 2, true));
            }
        });

        // Bottone ENG
        JButton btnEng = new JButton(iconEng);
        btnEng.setPreferredSize(new Dimension(90, 64));
        btnEng.setFocusPainted(false);
        btnEng.setContentAreaFilled(false);
        btnEng.setBorder(BorderFactory.createLineBorder(new Color(83, 141, 78), 2, true));
        btnEng.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEng.setToolTipText("English");
        btnEng.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEng.setBorder(BorderFactory.createLineBorder(new Color(181, 159, 59), 3, true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnEng.setBorder(BorderFactory.createLineBorder(new Color(83, 141, 78), 2, true));
            }
        });

        flagPanel.add(btnIta);
        flagPanel.add(btnEng);
        mainPanel.add(flagPanel);

        // Crediti
        JPanel creditsPanel = new JPanel();
        creditsPanel.setOpaque(false);
        creditsPanel.setLayout(new BoxLayout(creditsPanel, BoxLayout.Y_AXIS));
        creditsPanel.setBorder(BorderFactory.createEmptyBorder(32, 0, 10, 0));

        JLabel creditsTitle = new JLabel("Autori");
        creditsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsTitle.setFont(new Font("Segoe UI", Font.BOLD, 17));
        creditsTitle.setForeground(new Color(181, 159, 59));

        JLabel credits1 = new JLabel("Alfano Andrea");
        credits1.setAlignmentX(Component.CENTER_ALIGNMENT);
        credits1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        credits1.setForeground(Color.LIGHT_GRAY);

        JLabel credits2 = new JLabel("Spina Mattia");
        credits2.setAlignmentX(Component.CENTER_ALIGNMENT);
        credits2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        credits2.setForeground(Color.LIGHT_GRAY);

        JLabel credits3 = new JLabel("Venturi Bruno");
        credits3.setAlignmentX(Component.CENTER_ALIGNMENT);
        credits3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        credits3.setForeground(Color.LIGHT_GRAY);

        creditsPanel.add(creditsTitle);
        creditsPanel.add(Box.createVerticalStrut(6));
        creditsPanel.add(credits1);
        creditsPanel.add(credits2);
        creditsPanel.add(credits3);

        mainPanel.add(creditsPanel);

        add(mainPanel);

        // Listener per i bottoni
        btnIta.addActionListener(e -> apriWordle("IT"));
        btnEng.addActionListener(e -> apriWordle("EN"));
    }

    private void apriWordle(String lingua) {
        WordleModel model = new WordleModel(lingua);
        GUI gui = new GUI();
        WordleController controller = new WordleController(gui, model);
        dispose();
    }
}