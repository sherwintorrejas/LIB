/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import CONFIG.DBCONNECTOR;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class login extends javax.swing.JFrame {

private Connection con;
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }
     public boolean validatelogin(){
    String name = UN.getText();
    String pwd = PD.getText();
    
    if (name.equals("")){
    JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
   return false;
    }
    if (pwd.equals("")){
    JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
   return false;
    }
    return true;
    }
public void login(){
    String name = UN.getText();
    String pwd = PD.getText();

    try {
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
        PreparedStatement pst = con.prepareStatement("select * from user where username = '"+UN.getText()+"'");
//           pst.setString(1, name);
           ResultSet rs = pst.executeQuery();
           
          if(rs.next()){
         String hashedpassword = rs.getString("password");
            if(BCrypt.checkpw(pwd, hashedpassword)){
                 JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFULL"); 
                 DASHBOARD dsh= new DASHBOARD();
            dsh.setVisible(true);

            this.setVisible(false);
            this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
            this.dispose();
            
            }  else{
           JOptionPane.showMessageDialog(this, "INCORRECT USERNAME OR PASSWORD");
            
            }
          }   
    } catch (Exception e) {
    e.printStackTrace();
    
    }
    
    
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UN = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LOCK = new javax.swing.JLabel();
        LOGIN = new necesario.RSMaterialButtonCircle();
        LOGIN1 = new necesario.RSMaterialButtonCircle();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PD = new rojerusan.RSPasswordTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 495));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/background.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 430, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        jPanel2.setBackground(new java.awt.Color(246, 55, 55));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 40, 30));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 245, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 240, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 245, 102));
        jLabel4.setText("Please login to you account");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        UN.setBackground(new java.awt.Color(246, 55, 55));
        UN.setBorder(null);
        UN.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        UN.setOpaque(false);
        UN.setPlaceholder("ENTER USERNAME");
        jPanel2.add(UN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 245, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USERNAME:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 245, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PASSWORD:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 90, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user (5).png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 50, 40));

        LOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOCK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock.png"))); // NOI18N
        jPanel2.add(LOCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 30, 40));

        LOGIN.setText("LOGIN");
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        jPanel2.add(LOGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 160, 50));

        LOGIN1.setText("SIGN UP");
        LOGIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGIN1ActionPerformed(evt);
            }
        });
        jPanel2.add(LOGIN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 160, 50));

        jLabel13.setForeground(new java.awt.Color(25, 20, 20));
        jLabel13.setText("_______________________________");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 220, 30));

        jLabel15.setForeground(new java.awt.Color(25, 20, 20));
        jLabel15.setText("_______________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 30));

        PD.setBackground(new java.awt.Color(246, 55, 55));
        PD.setBorder(null);
        PD.setForeground(new java.awt.Color(0, 0, 0));
        PD.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        PD.setOpaque(false);
        PD.setPhColor(new java.awt.Color(0, 0, 0));
        PD.setPlaceholder("ENTER PASSWORD");
        jPanel2.add(PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 375, 495));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void PDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PDActionPerformed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
      if(validatelogin()== true){
login();
}
    }//GEN-LAST:event_LOGINActionPerformed

    private void LOGIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN1ActionPerformed
        signup UP= new signup();
        UP.setVisible(true);
        this. dispose();
    }//GEN-LAST:event_LOGIN1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOCK;
    private necesario.RSMaterialButtonCircle LOGIN;
    private necesario.RSMaterialButtonCircle LOGIN1;
    private rojerusan.RSPasswordTextPlaceHolder PD;
    private app.bolivia.swing.JCTextField UN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
