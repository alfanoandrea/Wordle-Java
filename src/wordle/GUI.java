package wordle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class GUI extends javax.swing.JFrame {

    private JLabel[][] griglia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private SquareGridPanel jPanelGriglia;
    private javax.swing.JLabel lblConsentito;
    private ModernTextField txtParola;
    private JButton btnNuovaPartita;

    public GUI() {
        initComponents();
        mioInitComponents();
        setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/icon.png"));
        setIconImage(icon.getImage());

        setPreferredSize(new Dimension(500, 700));
        setMinimumSize(new Dimension(400, 600));
        pack();
    }

    public void mioInitComponents() {
        Color sfondoGriglia = new Color(18, 18, 19);
        Color coloreCella = new Color(58, 58, 60);
        Font fontCella = new Font("Arial", Font.BOLD, 32);

        griglia = new JLabel[6][5];
        jPanelGriglia.removeAll();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                JLabel cella = new JLabel();
                cella.setOpaque(true);
                cella.setBackground(coloreCella);
                cella.setForeground(Color.WHITE);
                cella.setFont(fontCella);
                cella.setHorizontalAlignment(SwingConstants.CENTER);
                cella.setVerticalAlignment(SwingConstants.CENTER);
                cella.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
                griglia[i][j] = cella;
                jPanelGriglia.add(cella);
            }
        }

        getContentPane().setBackground(sfondoGriglia);
        jPanel1.setBackground(sfondoGriglia);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setBackground(new Color(30, 30, 32));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel2.setForeground(Color.LIGHT_GRAY);
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lblConsentito.setForeground(Color.LIGHT_GRAY);

        txtParola.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtParola.setBackground(new Color(40, 40, 42));
        txtParola.setForeground(Color.WHITE);
        txtParola.setCaretColor(Color.WHITE);
        txtParola.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        txtParola.setSelectionColor(new Color(83, 141, 78, 120));

        setLocationRelativeTo(null);
        setResizable(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelGriglia = new SquareGridPanel(6, 5, 5);
        jLabel2 = new javax.swing.JLabel("Parola:");
        txtParola = new ModernTextField();
        lblConsentito = new javax.swing.JLabel();


        btnNuovaPartita = new JButton("Restart") {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 22, 22);
                super.paintComponent(g);
            }
            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(new Color(83, 141, 78));
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 22, 22);
            }
        };
        btnNuovaPartita.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnNuovaPartita.setBackground(new Color(40, 40, 42));
        btnNuovaPartita.setForeground(Color.WHITE);
        btnNuovaPartita.setFocusPainted(false);
        btnNuovaPartita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnNuovaPartita.setContentAreaFilled(false);
        btnNuovaPartita.setOpaque(false);
        btnNuovaPartita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuovaPartita.setMargin(new Insets(8, 36, 8, 36));

        btnNuovaPartita.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNuovaPartita.setBackground(new Color(60, 60, 62));
                btnNuovaPartita.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNuovaPartita.setBackground(new Color(40, 40, 42));
                btnNuovaPartita.repaint();
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(new java.awt.BorderLayout());

        JPanel topPanel = new JPanel(new java.awt.BorderLayout());
        topPanel.setOpaque(false);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48));
        jLabel1.setText("WORDLE");
        jLabel1.setOpaque(true);
        topPanel.add(jLabel1, java.awt.BorderLayout.CENTER);
        topPanel.add(btnNuovaPartita, java.awt.BorderLayout.EAST);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(topPanel, java.awt.BorderLayout.NORTH);
        jPanel1.add(jPanelGriglia, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new java.awt.GridBagLayout());
        bottomPanel.setOpaque(false);
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = java.awt.GridBagConstraints.EAST;
        bottomPanel.add(jLabel2, gbc);
        gbc.gridx = 1; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        bottomPanel.add(txtParola, gbc);
        gbc.gridx = 2; gbc.weightx = 0; gbc.fill = java.awt.GridBagConstraints.NONE;
        bottomPanel.add(lblConsentito, gbc);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }

    private static class SquareGridPanel extends JPanel {
        private final int rows, cols, gap;

        public SquareGridPanel(int rows, int cols, int gap) {
            super(null);
            this.rows = rows;
            this.cols = cols;
            this.gap = gap;
        }

        @Override
        public void doLayout() {
            int width = getWidth();
            int height = getHeight();
            int cellSize = Math.min((width - (cols + 1) * gap) / cols, (height - (rows + 1) * gap) / rows);
            int x0 = (width - (cellSize * cols + gap * (cols + 1))) / 2;
            int y0 = (height - (cellSize * rows + gap * (rows + 1))) / 2;
            int idx = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (idx < getComponentCount()) {
                        int x = x0 + gap + j * (cellSize + gap);
                        int y = y0 + gap + i * (cellSize + gap);
                        getComponent(idx).setBounds(x, y, cellSize, cellSize);
                        idx++;
                    }
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            int cellSize = 60;
            return new Dimension(cols * cellSize + (cols + 1) * gap, rows * cellSize + (rows + 1) * gap);
        }
    }

    private static class ModernTextField extends JTextField {
        public ModernTextField() {
            super();
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(40, 40, 42));
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(new Color(83, 141, 78));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 18, 18);
        }

        @Override
        public Insets getInsets() {
            return new Insets(8, 16, 8, 16);
        }
    }

    // Getter e setter
    public JPanel getjPanel1() { return jPanel1; }
    public void setjPanel1(JPanel jPanel1) { this.jPanel1 = jPanel1; }
    public JLabel[][] getGriglia() { return griglia; }
    public void setGriglia(JLabel[][] griglia) { this.griglia = griglia; }
    public JPanel getjPanelGriglia() { return jPanelGriglia; }
    public void setjPanelGriglia(JPanel jPanelGriglia) { this.jPanelGriglia = (SquareGridPanel) jPanelGriglia; }
    public JLabel getLblConsentito() { return lblConsentito; }
    public void setLblConsentito(JLabel lblConsentito) { this.lblConsentito = lblConsentito; }
    public JTextField getTxtParola() { return txtParola; }
    public void setTxtParola(JTextField txtParola) { this.txtParola = (ModernTextField) txtParola; }
    public JButton getBtnNuovaPartita() { return btnNuovaPartita; }
}