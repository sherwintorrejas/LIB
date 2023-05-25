/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalpage;
import CONFIG.DBCONNECTOR;
import com.toedter.calendar.DateUtil;
import com.sun.javafx.collections.IntegerArraySyncer;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.print.*;
import java.text.*; 
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
public class VIOLATION extends javax.swing.JInternalFrame {
private Connection con;
DefaultTableModel model;
    /**
     * Creates new form dashabord
     */
    public VIOLATION() {
        initComponents();
        viewdetails();

          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
    }
 public void viewdetails(){
   long l = System.currentTimeMillis();
  Date todayDate = new Date(l);
        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
             PreparedStatement pst = con.prepareStatement("select * from issued_bookdet where DUE < ? and STATUS = ?");
             pst.setDate(1, todayDate);
             pst.setString(2, "PENDING");
             
             ResultSet rs = pst.executeQuery();
             
             while(rs.next()){
                 String id = rs.getString("ISSUED_ID");
             String isbn = rs.getString("ISBN");
             String studentid = rs.getString("ID");
             String issuedate = rs.getString("ISSUED");
             String duedate = rs.getString("DUE");
             String status = rs.getString("STATUS");
             
             Object [] obj = {id,isbn,studentid,issuedate,duedate,status};
             model = (DefaultTableModel) DETAILS.getModel();
             model.addRow(obj);
           
             }
             
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }
    public void cleartable(){
    DefaultTableModel model =(DefaultTableModel)DETAILS.getModel();
    model.setRowCount(0);
     
    
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DETAILS = new rojeru_san.complementos.RSTableMetro();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 140));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DETAILS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISSUED ID", "ISBN", "STUDENT ID", "ISSUED DATE", "DUE DATE", "STATUS"
            }
        ));
        DETAILS.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        DETAILS.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        DETAILS.setFuenteFilas(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        DETAILS.setFuenteFilasSelect(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        DETAILS.setFuenteHead(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        DETAILS.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(DETAILS);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 810, 370));

        rSMaterialButtonCircle1.setText("PRINT");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 110, 40));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 870, 450));

        jLabel16.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yellow-card (3).png"))); // NOI18N
        jLabel16.setText("VIOLATION LIST");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 320, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        MessageFormat head = new MessageFormat("VIOLATORS");
        MessageFormat FOOT = new MessageFormat("Page{0, number , integer}");

        try {
            DETAILS.print(JTable.PrintMode.NORMAL, head, FOOT);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "cannot print");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro DETAILS;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    // End of variables declaration//GEN-END:variables
}
