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
import java.text.*; 
import java.awt.print.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
public class vewrecs extends javax.swing.JInternalFrame {
private Connection con;
DefaultTableModel model;
    /**
     * Creates new form dashabord
     */
    public vewrecs() {
        initComponents();
        viewdetails();

          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
    }
  public void viewdetails(){
        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from xample");
             
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
    
    
  public void search(){
  java.util.Date uidate= isdate.getDate();
  java.util.Date uddate=ddate.getDate();
  
  Long l1= uidate.getTime();
  long l2=uddate.getTime();
  
  
  java.sql.Date sidate = new java.sql.Date(l1);
  java.sql.Date sddate = new java.sql.Date(l2);
  
      try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
           String sql = "select * from xample where ISSUED BETWEEN ? and ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setDate(1, sidate);
          pst.setDate(2, sddate);
          ResultSet rs = pst.executeQuery();
          if(rs.next() == false){
          JOptionPane.showMessageDialog(this, "NO RECORDS FOUND");
          
          }else{
          
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
          }  
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

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DETAILS = new rojeru_san.complementos.RSTableMetro();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();
        ddate = new com.toedter.calendar.JDateChooser();
        isdate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VIEWALL = new necesario.RSMaterialButtonCircle();
        SEARCH = new necesario.RSMaterialButtonCircle();

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
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DETAILS.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        DETAILS.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        DETAILS.setFuenteFilas(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        DETAILS.setFuenteFilasSelect(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        DETAILS.setFuenteHead(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        DETAILS.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(DETAILS);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 810, 290));

        rSMaterialButtonCircle1.setText("PRINT");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 130, 40));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 870, 360));

        jLabel16.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return (3).png"))); // NOI18N
        jLabel16.setText("VIEW RECORDS");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 320, 80));

        ddate.setDateFormatString("MM/ dd/ yy");
        jPanel1.add(ddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 200, 30));

        isdate.setDateFormatString("MM/ dd/ yy");
        jPanel1.add(isdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 200, 30));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DUE DATE:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 150, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ISSUE DATE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 150, 30));

        VIEWALL.setBackground(new java.awt.Color(0, 102, 102));
        VIEWALL.setText("VIEW ALL");
        VIEWALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWALLActionPerformed(evt);
            }
        });
        jPanel1.add(VIEWALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 150, 50));

        SEARCH.setBackground(new java.awt.Color(0, 102, 102));
        SEARCH.setText("SEARCH");
        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });
        jPanel1.add(SEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHActionPerformed
       if(isdate.getDate() != null && ddate.getDate() != null){ 
          cleartable();
        search();
      }else{
      JOptionPane.showMessageDialog(this, "PLEASE SELECT DATE");
      }
    }//GEN-LAST:event_SEARCHActionPerformed

    private void VIEWALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWALLActionPerformed
         cleartable();
     viewdetails();
    }//GEN-LAST:event_VIEWALLActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        MessageFormat head = new MessageFormat("RECORDS");
        MessageFormat FOOT = new MessageFormat("Page{0, number , integer}");

        try {
            DETAILS.print(JTable.PrintMode.NORMAL, head, FOOT);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "cannot print");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro DETAILS;
    private necesario.RSMaterialButtonCircle SEARCH;
    private necesario.RSMaterialButtonCircle VIEWALL;
    private com.toedter.calendar.JDateChooser ddate;
    private com.toedter.calendar.JDateChooser isdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    // End of variables declaration//GEN-END:variables
}
