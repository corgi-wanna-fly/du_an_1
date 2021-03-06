/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDIView;

import DAO.FormDAO;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author xuant
 */
public class MDI extends javax.swing.JFrame {

    /**
     * Creates new form MDI
     */
    public MDI() {
        initComponents();
    }

    private void showDetail() {
        SignIn signIn = new SignIn(dskMain);
        signIn.setVisible(true);
        dskMain.add(signIn);
        FormDAO.centerJIF(dskMain, signIn);
        try {
            signIn.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("desk.jpg"));
        Image img = icon.getImage();
        dskMain = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuStart = new javax.swing.JMenu();
        mnuQuit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm thi tiếng Anh Poly");
        setMinimumSize(new java.awt.Dimension(1106, 743));
        setResizable(false);

        javax.swing.GroupLayout dskMainLayout = new javax.swing.GroupLayout(dskMain);
        dskMain.setLayout(dskMainLayout);
        dskMainLayout.setHorizontalGroup(
            dskMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        dskMainLayout.setVerticalGroup(
            dskMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        getContentPane().add(dskMain, java.awt.BorderLayout.CENTER);

        mnuStart.setText("Start");
        mnuStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuStartMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuStart);

        mnuQuit.setText("Quit");
        mnuQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuQuitMouseClicked(evt);
            }
        });
        mnuQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQuitActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuQuit);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuStartMouseClicked
        showDetail();
    }//GEN-LAST:event_mnuStartMouseClicked

    private void mnuQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuQuitActionPerformed
       
    }//GEN-LAST:event_mnuQuitActionPerformed

    private void mnuQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuQuitMouseClicked
         int i = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn thoát?");
        if(i != JOptionPane.YES_OPTION){
            return;
        }
        else{
            this.dispose();
        }
    }//GEN-LAST:event_mnuQuitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI().setVisible(true);
            }
        });
    }

    public JDesktopPane getDskMain() {
        return dskMain;
    }

    public void setDskMain(JDesktopPane dskMain) {
        this.dskMain = dskMain;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskMain;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuQuit;
    private javax.swing.JMenu mnuStart;
    // End of variables declaration//GEN-END:variables
}
