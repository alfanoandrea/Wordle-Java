package wordle;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class GUI extends javax.swing.JFrame {

    
    private JLabel[][] griglia;
    public GUI() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        initComponents();
        mioInitComponents();
        setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/icon.png"));
        setIconImage(icon.getImage());
    }
    
    
    public void mioInitComponents() {
    Color sfondoGriglia = new Color(18, 18, 19);
    Color coloreCella = new Color(58, 58, 60);
    Font fontCella = new Font("Arial", Font.BOLD, 32);

    griglia = new JLabel[6][5];
    jPanelGriglia.removeAll();
    jPanelGriglia.setLayout(new java.awt.GridLayout(6, 5, 5, 5));
    jPanelGriglia.setBackground(sfondoGriglia);

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
            cella.setPreferredSize(new java.awt.Dimension(80, 80));
            griglia[i][j] = cella;
            jPanelGriglia.add(cella);
        }
    }

    getContentPane().setBackground(sfondoGriglia);
    jPanel1.setBackground(sfondoGriglia);
    jLabel1.setForeground(Color.WHITE);
    jLabel2.setForeground(Color.WHITE);
    lblConsentito.setForeground(Color.LIGHT_GRAY);
    txtParola.setFont(new Font("Segoe UI", Font.BOLD, 18));
    
}

    private void txtParolaActionPerformed(java.awt.event.ActionEvent evt) {
    // Codice aggiunto automaticamente o vuoto
    }

    @SuppressWarnings("unchecked")                       
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelGriglia = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtParola = new javax.swing.JTextField();
        lblConsentito = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48));
        jLabel1.setText("WORDLE");
        jLabel1.setOpaque(true);

        jPanelGriglia.setLayout(new java.awt.GridLayout(6, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jPanelGriglia, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanelGriglia, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabel2.setText("DIMMI LA PAROLA:");

        txtParola.setActionCommand("parola");
        txtParola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParolaActionPerformed(evt);
            }
        });

        lblConsentito.setMinimumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtParola, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblConsentito, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtParola, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblConsentito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(24, 24, 24))
        );

        pack();
    }                       

                      
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGriglia;
    private javax.swing.JLabel lblConsentito;
    private javax.swing.JTextField txtParola;                 
    

    
    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel[][] getGriglia() {
        return griglia;
    }

    public void setGriglia(JLabel[][] griglia) {
        this.griglia = griglia;
    }

    public JPanel getjPanelGriglia() {
        return jPanelGriglia;
    }

    public void setjPanelGriglia(JPanel jPanelGriglia) {
        this.jPanelGriglia = jPanelGriglia;
    }

    public JLabel getLblConsentito() {
        return lblConsentito;
    }

    public void setLblConsentito(JLabel lblConsentito) {
        this.lblConsentito = lblConsentito;
    }

    public JTextField getTxtParola() {
        return txtParola;
    }

    public void setTxtParola(JTextField txtParola) {
        this.txtParola = txtParola;
    }
    
}
