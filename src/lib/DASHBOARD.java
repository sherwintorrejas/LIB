/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;
import java.awt.Color;
import internalpage.*;
import internalpage.dashabord;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
/**
 *
 * @author User
 */
public class DASHBOARD extends javax.swing.JFrame {

    /**
     * Creates new form DASHBOARD
     */
    public DASHBOARD() {
        initComponents();
    }
  Color navcolor = new Color(178,34,34);
    Color headcolor = new Color(153,153,255);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DH = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        AB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        AS = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        IB = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        RB = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        VR = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        VIB = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        VL = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LO = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("bg.jpg"));
        Image img=icon.getImage();
        maindesk = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),getHeight(),this);

            }

        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(178, 34, 34));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DH.setBackground(new java.awt.Color(178, 34, 34));
        DH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DHMouseExited(evt);
            }
        });
        DH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DASHBOARD");
        DH.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 11, 110, -1));

        jPanel1.add(DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 21, 190, 40));

        AB.setBackground(new java.awt.Color(178, 34, 34));
        AB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ABMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ABMouseExited(evt);
            }
        });
        AB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADD BOOK");
        AB.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 11, 102, -1));

        jPanel1.add(AB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, -1));

        AS.setBackground(new java.awt.Color(178, 34, 34));
        AS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ASMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ASMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ASMouseExited(evt);
            }
        });
        AS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADD STUDENT");
        AS.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 11, 128, -1));

        jPanel1.add(AS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 190, 40));

        IB.setBackground(new java.awt.Color(178, 34, 34));
        IB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IBMouseExited(evt);
            }
        });
        IB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ISSUE BOOK");
        IB.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, 129, -1));

        jPanel1.add(IB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 257, 190, 40));

        RB.setBackground(new java.awt.Color(178, 34, 34));
        RB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RBMouseExited(evt);
            }
        });
        RB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("RETURN BOOK");
        RB.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, 129, -1));

        jPanel1.add(RB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 190, -1));

        VR.setBackground(new java.awt.Color(178, 34, 34));
        VR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VRMouseExited(evt);
            }
        });
        VR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("VIEW RECORDS");
        VR.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, 129, -1));

        jPanel1.add(VR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 363, 190, -1));

        VIB.setBackground(new java.awt.Color(178, 34, 34));
        VIB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VIBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VIBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VIBMouseExited(evt);
            }
        });
        VIB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("VIEW ISSUED BOOK");
        VIB.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 158, -1));

        jPanel1.add(VIB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 416, 190, -1));

        VL.setBackground(new java.awt.Color(178, 34, 34));
        VL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VLMouseExited(evt);
            }
        });
        VL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VIOLATOR'S LIST");
        VL.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 158, -1));

        jPanel1.add(VL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 469, 190, -1));

        LO.setBackground(new java.awt.Color(178, 34, 34));
        LO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOMouseExited(evt);
            }
        });
        LO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("LOGOUT");
        LO.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 158, -1));

        jPanel1.add(LO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 522, 190, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("--------MANAGE---------");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 190, 30));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-----CIRCULATION-----");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 213, 190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 593));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        exit.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close (2).png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });

        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize-sign (2).png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 775, Short.MAX_VALUE)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 0, 865, 50));

        javax.swing.GroupLayout maindeskLayout = new javax.swing.GroupLayout(maindesk);
        maindesk.setLayout(maindeskLayout);
        maindeskLayout.setHorizontalGroup(
            maindeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        maindeskLayout.setVerticalGroup(
            maindeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(maindesk, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 865, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setBackground(headcolor);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setBackground(navcolor);
    }//GEN-LAST:event_exitMouseExited

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void DHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DHMouseEntered
          DH.setBackground(headcolor);
    }//GEN-LAST:event_DHMouseEntered

    private void DHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DHMouseExited
       DH.setBackground(navcolor);
    }//GEN-LAST:event_DHMouseExited

    private void ABMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMouseEntered
       AB.setBackground(headcolor);
    }//GEN-LAST:event_ABMouseEntered

    private void ABMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMouseExited
         AB.setBackground(navcolor);
    }//GEN-LAST:event_ABMouseExited

    private void ASMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASMouseEntered
        AS.setBackground(headcolor);
    }//GEN-LAST:event_ASMouseEntered

    private void IBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IBMouseEntered
      IB.setBackground(headcolor);
    }//GEN-LAST:event_IBMouseEntered

    private void IBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IBMouseExited
      IB.setBackground(navcolor);
    }//GEN-LAST:event_IBMouseExited

    private void ASMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASMouseExited
       AS.setBackground(navcolor);
    }//GEN-LAST:event_ASMouseExited

    private void RBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBMouseEntered
       RB.setBackground(headcolor);
    }//GEN-LAST:event_RBMouseEntered

    private void RBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBMouseExited
        RB.setBackground(navcolor);
    }//GEN-LAST:event_RBMouseExited

    private void VRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VRMouseEntered
        VR.setBackground(headcolor);
    }//GEN-LAST:event_VRMouseEntered

    private void VRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VRMouseExited
        VR.setBackground(navcolor);
    }//GEN-LAST:event_VRMouseExited

    private void VIBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIBMouseEntered
        VIB.setBackground(headcolor);
    }//GEN-LAST:event_VIBMouseEntered

    private void VIBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIBMouseExited
      VIB.setBackground(navcolor);
    }//GEN-LAST:event_VIBMouseExited

    private void VLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VLMouseEntered
       VL.setBackground(headcolor);
    }//GEN-LAST:event_VLMouseEntered

    private void VLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VLMouseExited
     VL.setBackground(navcolor);
    }//GEN-LAST:event_VLMouseExited

    private void LOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOMouseEntered
        LO.setBackground(headcolor);
    }//GEN-LAST:event_LOMouseEntered

    private void LOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOMouseExited
       LO.setBackground(navcolor);
    }//GEN-LAST:event_LOMouseExited

    private void DHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DHMouseClicked
        maindesk.removeAll();
        dashabord dh = new dashabord();
        maindesk.add(dh).setVisible(true); 
    }//GEN-LAST:event_DHMouseClicked

    private void ABMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABMouseClicked
      maindesk.removeAll();
        addbook ab =new addbook();
        maindesk.add(ab).setVisible(true);
    }//GEN-LAST:event_ABMouseClicked

    private void ASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASMouseClicked
           maindesk.removeAll();
        addstudent as =new addstudent();
        maindesk.add(as).setVisible(true);
    }//GEN-LAST:event_ASMouseClicked

    private void IBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IBMouseClicked
        maindesk.removeAll();
        issuebook as =new issuebook();
        maindesk.add(as).setVisible(true);
    }//GEN-LAST:event_IBMouseClicked

    private void LOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOMouseClicked
         int a = JOptionPane.showConfirmDialog(null,"ARE YOU SURE YOU WANT TO LOGOUT?");
        if(a == JOptionPane.YES_OPTION){
            login in = new login ();
            in.setVisible(true);
            this.dispose();}
    }//GEN-LAST:event_LOMouseClicked

    private void RBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBMouseClicked
        maindesk.removeAll();
        returnbook as =new returnbook();
        maindesk.add(as).setVisible(true);
    }//GEN-LAST:event_RBMouseClicked

    private void VRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VRMouseClicked
        maindesk.removeAll();
        vewrecs as =new vewrecs();
        maindesk.add(as).setVisible(true);
    }//GEN-LAST:event_VRMouseClicked

    private void VIBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIBMouseClicked
          maindesk.removeAll();
        vewisbook as =new vewisbook();
        maindesk.add(as).setVisible(true);
    }//GEN-LAST:event_VIBMouseClicked

    private void VLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VLMouseClicked
          maindesk.removeAll();
        VIOLATION as =new VIOLATION();
        maindesk.add(as).setVisible(true);
    }//GEN-LAST:event_VLMouseClicked

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
            java.util.logging.Logger.getLogger(DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DASHBOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DASHBOARD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AB;
    private javax.swing.JPanel AS;
    private javax.swing.JPanel DH;
    private javax.swing.JPanel IB;
    private javax.swing.JPanel LO;
    private javax.swing.JPanel RB;
    private javax.swing.JPanel VIB;
    private javax.swing.JPanel VL;
    private javax.swing.JPanel VR;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    public javax.swing.JDesktopPane maindesk;
    private javax.swing.JLabel minimize;
    // End of variables declaration//GEN-END:variables
}
