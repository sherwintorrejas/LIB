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
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class signup extends javax.swing.JFrame {
  private Connection con;

    public signup() {
        initComponents();
    }
public void signup(){

String name= UN.getText();
String email= EMAIL.getText();
String contact= CONTACT.getText();
String pwd= PD.getText();
String hasedpassword = BCrypt.hashpw(pwd, BCrypt.gensalt());


    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
            String sql = "insert into user(username,email,contact,password)values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, contact);
        pst.setString(4,hasedpassword );
        
       int uprcount = pst.executeUpdate();
       if(uprcount >0){
       JOptionPane.showMessageDialog(this, "SIGN UP SUCCESSFULLY");
      login in= new login();
        in.setVisible(true);
        this. dispose();
        
       }else{
       JOptionPane.showMessageDialog(this, "SIGH UP FAILED");
             
       }
       
    } catch (Exception e) {
    e.printStackTrace();
    }
    }



 public boolean validation(){
  String name= UN.getText();
String email= EMAIL.getText();
String contact= CONTACT.getText();
String pwd= PD.getText();
 if (name.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
 return false;
 }
 if(email.equals("") || !email.matches("^.+@.+\\..+$")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER VALID EMAIL");
 return false;
 }
if(contact.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER CONTACT NUMBER");
 return false;
 }     
 if(pwd.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER PASSWORD");
 return false;
 }    
     
   return true;  
 }
 public boolean duplicateuser(){
 String name = UN.getText();
   boolean isexist = false;
 try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
           PreparedStatement pst = con.prepareStatement("select * from user where username = ?");
           pst.setString(1, name);
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
           isexist = true;
           }else{
           isexist = false;
           }
           
           
     } catch (Exception e) {
         e.printStackTrace();
     }
 return isexist;
 }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PD = new rojerusan.RSPasswordTextPlaceHolder();
        jLabel7 = new javax.swing.JLabel();
        LOCK = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        UN = new app.bolivia.swing.JCTextField();
        EMAIL = new app.bolivia.swing.JCTextField();
        CONTACT = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        SIGN_UP = new necesario.RSMaterialButtonCircle();
        LOG_IN = new necesario.RSMaterialButtonCircle();

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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 40, 30));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 245, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SIGN UP");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 240, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 245, 102));
        jLabel4.setText("Please create your account");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 245, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CONTACT:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 90, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 245, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PASSWORD:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 90, 30));

        PD.setBackground(new java.awt.Color(246, 55, 55));
        PD.setBorder(null);
        PD.setForeground(new java.awt.Color(0, 0, 0));
        PD.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        PD.setOpaque(false);
        PD.setPhColor(new java.awt.Color(0, 0, 0));
        PD.setPlaceholder("ENTER PASSWORD");
        jPanel2.add(PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user (5).png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 40, 40));

        LOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOCK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock.png"))); // NOI18N
        jPanel2.add(LOCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 30, 40));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 40, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/telephone.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 40, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 40, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 245, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("EMAIL:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 30));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 245, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("USERNAME:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

        jLabel13.setForeground(new java.awt.Color(25, 20, 20));
        jLabel13.setText("_______________________________");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 200, 30));

        UN.setBackground(new java.awt.Color(246, 55, 55));
        UN.setBorder(null);
        UN.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        UN.setOpaque(false);
        UN.setPlaceholder("ENTER USERNAME");
        UN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                UNFocusLost(evt);
            }
        });
        jPanel2.add(UN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        EMAIL.setBackground(new java.awt.Color(246, 55, 55));
        EMAIL.setBorder(null);
        EMAIL.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        EMAIL.setOpaque(false);
        EMAIL.setPlaceholder("ENTER EMAIL");
        jPanel2.add(EMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        CONTACT.setBackground(new java.awt.Color(246, 55, 55));
        CONTACT.setBorder(null);
        CONTACT.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        CONTACT.setOpaque(false);
        CONTACT.setPlaceholder(" ENTER CONTACT");
        CONTACT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CONTACTKeyPressed(evt);
            }
        });
        jPanel2.add(CONTACT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel14.setForeground(new java.awt.Color(25, 20, 20));
        jLabel14.setText("_______________________________");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 200, 30));

        jLabel15.setForeground(new java.awt.Color(25, 20, 20));
        jLabel15.setText("_______________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 200, 30));

        jLabel16.setForeground(new java.awt.Color(25, 20, 20));
        jLabel16.setText("_______________________________");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 200, 30));

        SIGN_UP.setText("SIGN UP");
        SIGN_UP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIGN_UPActionPerformed(evt);
            }
        });
        jPanel2.add(SIGN_UP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 160, 50));

        LOG_IN.setText("LOGIN");
        LOG_IN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOG_INMouseClicked(evt);
            }
        });
        jPanel2.add(LOG_IN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 160, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 375, 495));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        login in= new login();
        in.setVisible(true);
        this. dispose();    
    }//GEN-LAST:event_jLabel2MouseClicked

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
      
    }//GEN-LAST:event_LOGINActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void EMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMAILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EMAILActionPerformed

    private void SIGNUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIGNUPMouseClicked

    }//GEN-LAST:event_SIGNUPMouseClicked

    private void UNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UNFocusLost
          if(duplicateuser()== true){
       JOptionPane.showMessageDialog(this, "USERNAME ALREADY EXIST");
       }
    }//GEN-LAST:event_UNFocusLost

    private void CONTACTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTACTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CONTACTActionPerformed

    private void SIGN_UPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIGN_UPActionPerformed
        if(validation()== true){
      if(duplicateuser()== false){
           signup();
      }else{
      JOptionPane.showMessageDialog(this, "USERNAME ALREADY EXIST");
      }
      }
        
      
    }//GEN-LAST:event_SIGN_UPActionPerformed

    private void LOG_INMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOG_INMouseClicked
         login in= new login();
        in.setVisible(true);
        this. dispose();
    }//GEN-LAST:event_LOG_INMouseClicked

    private void CONTACTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONTACTKeyPressed
           char c =evt.getKeyChar();
        if(Character.isLetter(c)){
        CONTACT.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        CONTACT.setEditable(true);
        }
    }//GEN-LAST:event_CONTACTKeyPressed

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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField CONTACT;
    private app.bolivia.swing.JCTextField EMAIL;
    private javax.swing.JLabel LOCK;
    private necesario.RSMaterialButtonCircle LOG_IN;
    private rojerusan.RSPasswordTextPlaceHolder PD;
    private necesario.RSMaterialButtonCircle SIGN_UP;
    private app.bolivia.swing.JCTextField UN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
