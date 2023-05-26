/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalpage;
import CONFIG.DBCONNECTOR;
import com.sun.javafx.collections.IntegerArraySyncer;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.beans.*;
import javax.swing.*;
import java.text.*; 
import java.awt.print.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
public class issuebook extends javax.swing.JInternalFrame {
private Connection connection;
    /**
     * Creates new form dashabord
     */
    public issuebook() {
        initComponents();
        
gslip();
          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
     ISSUEDATE.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.setTime((Date) evt.getNewValue());
                if (selectedDate.before(currentDate)) {
                    ISSUEDATE.setDate(currentDate.getTime());
                     DUEDATE.setDate(currentDate.getTime());
                }
            }
     
     });
     
    }
  private void getbookdet(){
 int bookid= Integer.parseInt(isbn.getText());
 try{
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
  PreparedStatement pst = connection.prepareStatement("SELECT * FROM book_details where ISBN =?");
  pst.setInt(1, bookid);
  ResultSet rs = pst.executeQuery();
  
  if(rs.next()){
  i_bn.setText(rs.getString("ISBN"));
  T_TLE.setText(rs.getString("TITTLE"));
  GEN_RE.setText(rs.getString("GENRE"));
  ED_D.setText(rs.getString("EDITION"));
  QUANT.setText(rs.getString("QUANTITY"));
   bookerror.setText("");
  }else{
  bookerror.setText("INVALID ISBN");
  }
 }catch (SQLException ex){
 ex.printStackTrace();
 
 }
 }
 //get student details
 private void getstudentdet(){
 int sid= Integer.parseInt(studentid.getText());
 try{
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
  PreparedStatement pst = connection.prepareStatement("SELECT * FROM student_details where ID =?");
  pst.setInt(1, sid);
  ResultSet rs = pst.executeQuery();
  
  if(rs.next()){
  id.setText(rs.getString("ID"));
  nme.setText(rs.getString("NAME"));
  lnme.setText(rs.getString("LASTNAME"));
  course.setText(rs.getString("COURSE"));
  yr.setText(rs.getString("YEAR"));
  contact.setText(rs.getString("CONTACT"));
  studenterror.setText("");
  }else{
  studenterror.setText("INVALID STUDENT ID");
          }
 }catch (SQLException ex){
 ex.printStackTrace();
 }
 }
 
 
 
 public void gslip(){

 slip.setText("*****************************************************\n");
 slip.setText(slip.getText()+"-------------------BORROWERS SLIP--------------------\n");
 slip.setText(slip.getText()+"*****************************************************\n");
 
 Date date = new Date();  // or replace with your own date object

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Replace with your desired format
        String formattedDate = dateFormat.format(date);
 

  slip.setText(slip.getText()+"\nDATE: "+formattedDate+"\n");
 slip.setText(slip.getText()+"\nISBN: "+isbn.getText()+"\n");
 slip.setText(slip.getText()+"\nSTUDENT ID: "+ studentid.getText()+"\n");
 slip.setText(slip.getText()+"\nISSUED DATE: "+  ISSUEDATE.getDate()+"\n");
 slip.setText(slip.getText()+"\nDUE DATE: "+  DUEDATE.getDate()+"\n");
 
 
 slip.setText(slip.getText()+"\nSIGNATURE:\n\n");
 slip.setText(slip.getText()+"\n____________\t_____________\n");
 slip.setText(slip.getText()+"LIBRARIAN\t\tBORROWER\n");
 
 
 
 
 }
    //print
 public void print(){
 
     try {
         slip.print();
     } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "print failed"+e);
     }
 
 
 
 
 }
         
         
 //issue book
 public boolean issuebook(){
     boolean isissued = false;
 int bookid= Integer.parseInt(isbn.getText());
  int sid= Integer.parseInt(studentid.getText());
  String bookname= T_TLE.getText();
  String studentname=nme.getText();
  String studentlastname=lnme.getText();
 
  java.util.Date uissueddate= ISSUEDATE.getDate();
  java.util.Date uduedate=DUEDATE.getDate();
  
  Long l1= uissueddate.getTime();
  long l2=uduedate.getTime();
  
  java.sql.Date sissueddate = new java.sql.Date(l1);
  java.sql.Date sduedate = new java.sql.Date(l2);
  
     try {
     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
     String sql = "insert into issued_bookdet(ISBN,ID,ISSUED,DUE,STATUS) values(?,?,?,?,?)";
     
     PreparedStatement pst = connection.prepareStatement(sql);
  pst.setInt(1, bookid);
  pst.setInt(2, sid);
  pst.setDate(3, sissueddate);
  pst.setDate(4, sduedate);
  pst.setString(5, "PENDING");
  
 
  int rowCount= pst.executeUpdate();
  if(rowCount > 0){
   isissued = true;
  }else{
  isissued = false;
  }

     } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
     
     }
  return isissued;
 }

 //UPDATE BOOK QUANT
 
 public void updatebookquant(){
 int bookid= Integer.parseInt(isbn.getText());
     try {
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
          String sql = "update book_details set QUANTITY = QUANTITY - 1 where ISBN =?";
          PreparedStatement pst = connection.prepareStatement(sql);
          pst.setInt(1, bookid);
          
        int rowcount = pst.executeUpdate();
          
          if(rowcount>0){
          JOptionPane.showMessageDialog(this, "BOOK QUANTITY UPDATED");
          int initialcount = Integer.parseInt(QUANT.getText());
          QUANT.setText(Integer.toString(initialcount - 1));
          }else{
          JOptionPane.showMessageDialog(this, "BOOK QUANTITY FAILED TO UPDATED");
          }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
 
 //CHECK IF BOOK IS ISSUED OR NOT
 public boolean alreadyissued(){
 
 boolean alreadyissued = false;
  int bookid= Integer.parseInt(isbn.getText());
  int sid= Integer.parseInt(studentid.getText());
  
     try {
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
          String sql = "select * from issued_bookdet where ISBN = ? and ID = ? and STATUS =?";
          PreparedStatement pst = connection.prepareStatement(sql);
          
        pst.setInt(1, bookid);
        pst.setInt(2, sid);
        pst.setString(3, "PENDING");
          
            ResultSet rs = pst.executeQuery();
        if(rs.next()){
        alreadyissued = true;
        }else{
        alreadyissued = false;
        }
        
        
     } catch (Exception e) {
         e.printStackTrace();
     }
 return alreadyissued;
 }
  public boolean validation(){
String isb = isbn.getText();
String studenti = studentid.getText();
 if (isb.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER ISBN");
 return false;
 }
 if(studenti.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER LASTNAME");
 return false;
 }     
 if(ISSUEDATE.getDate() == null){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER ISSUED DATE");
 return false;
 }    
 if(DUEDATE.getDate() == null){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER DUE DATE");
 return false;
 }  
   return true;  
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        nme = new javax.swing.JLabel();
        lnme = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        yr = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        studenterror = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        i_bn = new javax.swing.JLabel();
        T_TLE = new javax.swing.JLabel();
        GEN_RE = new javax.swing.JLabel();
        ED_D = new javax.swing.JLabel();
        QUANT = new javax.swing.JLabel();
        bookerror = new javax.swing.JLabel();
        isbn = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        DUEDATE = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        ISSUEDATE = new com.toedter.calendar.JDateChooser();
        studentid = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        slip = new javax.swing.JTextArea();
        print = new rojerusan.RSMaterialButtonCircle();

        jPanel1.setBackground(new java.awt.Color(0, 58, 140));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID:");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 100, 32));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NAME:");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 100, 32));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("LASTNAME:");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 100, 32));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("COURSE:");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 100, 32));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("YEAR:");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 100, 32));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CONTACT:");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, 32));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graduation (1).png"))); // NOI18N
        jLabel2.setText("STUDENT DETAILS");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, 40));

        id.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        id.setForeground(new java.awt.Color(0, 255, 204));
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 150, 30));

        nme.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        nme.setForeground(new java.awt.Color(0, 255, 204));
        nme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(nme, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 150, 30));

        lnme.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        lnme.setForeground(new java.awt.Color(0, 255, 204));
        lnme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(lnme, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 150, 30));

        course.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        course.setForeground(new java.awt.Color(0, 255, 204));
        course.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 150, 30));

        yr.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        yr.setForeground(new java.awt.Color(0, 255, 204));
        yr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(yr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 150, 30));

        contact.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        contact.setForeground(new java.awt.Color(0, 255, 204));
        contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 150, 30));

        studenterror.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        studenterror.setForeground(new java.awt.Color(51, 255, 204));
        studenterror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 250, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 540));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book (9).png"))); // NOI18N
        jLabel8.setText("BOOK DETAILS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, 40));

        jLabel9.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ISBN:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        jLabel10.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("BOOK TITTLE:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 130, 30));

        jLabel11.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("GENRE:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 110, 30));

        jLabel12.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("EDITION:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 280, 120, 30));

        jLabel16.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("QUANTITY:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 330, 120, 30));

        i_bn.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        i_bn.setForeground(new java.awt.Color(102, 255, 102));
        i_bn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(i_bn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, 30));

        T_TLE.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        T_TLE.setForeground(new java.awt.Color(102, 255, 102));
        T_TLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(T_TLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 150, 30));

        GEN_RE.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        GEN_RE.setForeground(new java.awt.Color(102, 255, 102));
        GEN_RE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(GEN_RE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 150, 30));

        ED_D.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        ED_D.setForeground(new java.awt.Color(102, 255, 102));
        ED_D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(ED_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 150, 30));

        QUANT.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        QUANT.setForeground(new java.awt.Color(102, 255, 102));
        QUANT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(QUANT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 150, 30));

        bookerror.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        bookerror.setForeground(new java.awt.Color(255, 0, 0));
        bookerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 250, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 280, 540));

        isbn.setBackground(new java.awt.Color(0, 58, 140));
        isbn.setBorder(null);
        isbn.setForeground(new java.awt.Color(153, 255, 153));
        isbn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        isbn.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        isbn.setOpaque(false);
        isbn.setPlaceholder("ENTER ISBN");
        isbn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                isbnFocusLost(evt);
            }
        });
        isbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                isbnKeyPressed(evt);
            }
        });
        jPanel1.add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        jLabel13.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book (8).png"))); // NOI18N
        jLabel13.setText("ISSUE BOOK");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 250, 80));

        jLabel14.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ISBN:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 90, 30));

        jLabel15.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("STUDENT ID:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 110, 40));

        jLabel17.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ISSUE DATE");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 140, 30));

        DUEDATE.setDateFormatString("MM/ dd/ yy");
        DUEDATE.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jPanel1.add(DUEDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 220, 30));

        jLabel18.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("DUE DATE");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 140, 30));

        ISSUEDATE.setDateFormatString("MM/ dd/ yy");
        ISSUEDATE.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jPanel1.add(ISSUEDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 220, 30));

        studentid.setBackground(new java.awt.Color(0, 58, 140));
        studentid.setBorder(null);
        studentid.setForeground(new java.awt.Color(153, 255, 153));
        studentid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentid.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        studentid.setOpaque(false);
        studentid.setPlaceholder("ENTER STUDENT ID");
        studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentidFocusLost(evt);
            }
        });
        studentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentidKeyPressed(evt);
            }
        });
        jPanel1.add(studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(153, 0, 0));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 230, 40));

        jLabel19.setForeground(new java.awt.Color(25, 20, 20));
        jLabel19.setText("_______________________________");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 210, 40));

        jLabel20.setForeground(new java.awt.Color(25, 20, 20));
        jLabel20.setText("_______________________________");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 210, 40));

        slip.setColumns(20);
        slip.setRows(5);
        jScrollPane1.setViewportView(slip);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 300, 90));

        print.setBackground(new java.awt.Color(153, 0, 0));
        print.setText("print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 230, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      if(validation()==true){
          if(QUANT.getText().equals("0")){
        JOptionPane.showMessageDialog(this, "BOOK IS NOT AVAILABLE");
    }else{
    
    
        if(alreadyissued() == false){
     
        if(issuebook()== true){
        JOptionPane.showMessageDialog(this, "BOOK ISSUED SUCCESSFULLY");
            gslip();
        updatebookquant();
       
        }else{
        JOptionPane.showMessageDialog(this, "CAN'T ISSUED BOOK");
      
         }
     }else{
     JOptionPane.showMessageDialog(this, "THIS STUDENT ALREADY HAVE THIS BOOK");
     alreadyissued();
     }
}
      }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void isbnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_isbnFocusLost
       if(!isbn.getText().equals("")){
       getbookdet();
       }
    }//GEN-LAST:event_isbnFocusLost

    private void studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentidFocusLost
        if(!studentid.getText().equals("")){
       getstudentdet();
       }
    }//GEN-LAST:event_studentidFocusLost

    private void isbnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnKeyPressed
               char c =evt.getKeyChar();
        if(Character.isLetter(c)){
        isbn.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        isbn.setEditable(true);
        }
    }//GEN-LAST:event_isbnKeyPressed

    private void studentidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentidKeyPressed
               char c =evt.getKeyChar();
        if(Character.isLetter(c)){
        studentid.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        studentid.setEditable(true);
        }
    }//GEN-LAST:event_studentidKeyPressed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
      print();
    }//GEN-LAST:event_printActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DUEDATE;
    private javax.swing.JLabel ED_D;
    private javax.swing.JLabel GEN_RE;
    private com.toedter.calendar.JDateChooser ISSUEDATE;
    private javax.swing.JLabel QUANT;
    private javax.swing.JLabel T_TLE;
    private javax.swing.JLabel bookerror;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel course;
    private javax.swing.JLabel i_bn;
    private javax.swing.JLabel id;
    private app.bolivia.swing.JCTextField isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lnme;
    private javax.swing.JLabel nme;
    private rojerusan.RSMaterialButtonCircle print;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JTextArea slip;
    private javax.swing.JLabel studenterror;
    private app.bolivia.swing.JCTextField studentid;
    private javax.swing.JLabel yr;
    // End of variables declaration//GEN-END:variables
}
