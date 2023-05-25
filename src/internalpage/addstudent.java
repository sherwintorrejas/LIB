/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalpage;
import CONFIG.DBCONNECTOR;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.*; 
import java.awt.print.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import net.proteanit.sql.DbUtils;

public class addstudent extends javax.swing.JInternalFrame {
DefaultTableModel model;
private Connection con;


    /**
     * Creates new form dashabord
     */
    public addstudent() {
        initComponents();
         displayData();
          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
    }
     public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: ");
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
        public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
    
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
          
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
    
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    
public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

public int FileChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/images", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    
    
    
    
    public void img(){
    JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                
                
                
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/images/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            System.out.println(""+destination);
                            browse.setVisible(true);
                            browse.setText("REMOVE");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "FILE ERROR"+ex);
                    }
                }
    
}
    
  public void reset(){
  ID.setText("");
      EN.setText("");
   ELN.setText("");
   EC.setText("");
   EY.setText("");
   ECT.setText("");
   image.setIcon(null);
   }
    public void search(String str){
    model = (DefaultTableModel) studentdet.getModel();
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    studentdet.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
      public void displayData(){
        try{
       
            DBCONNECTOR dbc = new DBCONNECTOR();
            ResultSet rs = dbc.getData("SELECT * FROM student_details");
            studentdet.setModel(DbUtils.resultSetToTableModel(rs));
       DefaultTableModel model = (DefaultTableModel) studentdet.getModel();
    String[] columnIdentifiers = {"ID", "Name", "Lastname", "Course","Year","Contact"};
    model.setColumnIdentifiers(columnIdentifiers);
    
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
        }
    
     }
    public void filltable () throws SQLException{
        try{
            DBCONNECTOR dbc = new DBCONNECTOR();
            ResultSet rs = dbc.getData("SELECT * FROM student_details");
            studentdet.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException ex){
         System.out.println("Error Message: "+ex);
       
        
        }
    
    }
    
     public boolean validation(){
  String name= EN.getText();
String lastname= ELN.getText();
String course= EC.getText();
String year= EY.getText();
String contact= ECT.getText();
 if (name.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER NAME");
 return false;
 }
 if(lastname.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER LASTNAME");
 return false;
 }
if(course.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER COURSE");
 return false;
 }     
 if(year.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YEAR");
 return false;
 }    
   if(contact.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER CONTACT");
 return false;
 } 
    if(image.getIcon()==null){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER PHOTO");
 return false;
 }
   return true;  
 }
     public void add(){
     int result=0;
         try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
            String sql = "INSERT INTO student_details ( NAME, LASTNAME, COURSE, YEAR, CONTACT, IMAGE)values (?,?,?,?,?,?)"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, EN.getText());
            ps.setString(2, ELN.getText());
            ps.setString(3, EC.getText());
            ps.setString(4, EY.getText());
            ps.setString(5, ECT.getText());
            ps.setString(6, destination);
            ps.executeUpdate();
             result = 1;
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING); 
               if(result == 1){
               JOptionPane.showMessageDialog(null, "Successfully Save!");
              displayData();
               reset();
           }else{
                System.out.println("Saving Data Failed!");
           }    
             
        JOptionPane.showMessageDialog(this, "ADDED SUCCESSFULLY");
            }catch(Exception e){
                System.err.println("Cannot connect to database: " + e.getMessage());
     
     
     }
     }
     public void update(){
         int result=0;
         try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
         int row = studentdet.getSelectedRow();
         String value = (studentdet.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE student_details SET NAME=?, LASTNAME=?, COURSE=?, YEAR=?, CONTACT=?, IMAGE=? where ID="+value;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, EN.getText());
            ps.setString(2, ELN.getText());
            ps.setString(3, EC.getText());
            ps.setString(4, EY.getText());
            ps.setString(5, ECT.getText());
            ps.setString(6, destination);
            ps.executeUpdate();
        imageUpdater(oldpath, path);
           
           File existingFile = new File(oldpath);
            if (existingFile.exists()) {
                existingFile.delete();
            }
           
           JOptionPane.showMessageDialog(null, "Successfully Updated!");
           }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Database Connection Error!"+e);
           }
     }
     
  
     public void table(){
     int row = studentdet.getSelectedRow();
     int cc = studentdet.getSelectedColumn();
    ImageIcon format;
     String tc = studentdet.getModel().getValueAt(row, 0).toString();
             try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ba", "root", "");
             String sql = "select * from student_details where ID="+tc+"";
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            int id=rs.getInt("ID");
            String name=rs.getString("NAME");
            String lname=rs.getString("LASTNAME");
            String cors=rs.getString("COURSE");
            String yr=rs.getString("YEAR");
            String cont=rs.getString("CONTACT");
           String im = rs.getString("IMAGE");
           format = new ImageIcon(im);
           Image m = format.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
            image.setIcon(new ImageIcon(m));
                ID.setText(""+id);
                EN.setText(name);
                ELN.setText(lname);
                EC.setText(cors);
                EY.setText(yr);
                ECT.setText(cont);
                
         
            }
             ps.close();
             rs.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
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
        jLabel1 = new javax.swing.JLabel();
        EN = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ELN = new app.bolivia.swing.JCTextField();
        EC = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EY = new app.bolivia.swing.JCTextField();
        DELETE = new necesario.RSMaterialButtonCircle();
        ADD = new necesario.RSMaterialButtonCircle();
        UPDATE = new necesario.RSMaterialButtonCircle();
        ECT = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        line1 = new javax.swing.JLabel();
        line2 = new javax.swing.JLabel();
        line3 = new javax.swing.JLabel();
        line4 = new javax.swing.JLabel();
        line5 = new javax.swing.JLabel();
        ID = new app.bolivia.swing.JCTextField();
        image = new javax.swing.JLabel();
        browse = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        search = new app.bolivia.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentdet = new rojeru_san.complementos.RSTableMetro();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 140));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID:");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 32));

        EN.setBackground(new java.awt.Color(204, 0, 0));
        EN.setBorder(null);
        EN.setForeground(new java.awt.Color(153, 255, 153));
        EN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EN.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        EN.setOpaque(false);
        EN.setPlaceholder("ENTER NAME");
        jPanel10.add(EN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, -1));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NAME:");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 120, 32));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("LASTNAME:");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 120, 32));

        ELN.setBackground(new java.awt.Color(204, 0, 0));
        ELN.setBorder(null);
        ELN.setForeground(new java.awt.Color(153, 255, 153));
        ELN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ELN.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        ELN.setOpaque(false);
        ELN.setPlaceholder("ENTER LASTNAME");
        jPanel10.add(ELN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, -1));

        EC.setBackground(new java.awt.Color(204, 0, 0));
        EC.setBorder(null);
        EC.setForeground(new java.awt.Color(153, 255, 153));
        EC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EC.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        EC.setOpaque(false);
        EC.setPlaceholder("ENTER COURSE");
        EC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ECKeyTyped(evt);
            }
        });
        jPanel10.add(EC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 180, -1));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("COURSE:");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 120, 32));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("YEAR:");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 120, 32));

        EY.setBackground(new java.awt.Color(204, 0, 0));
        EY.setBorder(null);
        EY.setForeground(new java.awt.Color(153, 255, 153));
        EY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EY.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        EY.setOpaque(false);
        EY.setPlaceholder("ENTER YEAR");
        EY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EYKeyPressed(evt);
            }
        });
        jPanel10.add(EY, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 180, -1));

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel10.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 459, 100, 50));

        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel10.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 459, 100, 50));

        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        jPanel10.add(UPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 459, 100, 50));

        ECT.setBackground(new java.awt.Color(204, 0, 0));
        ECT.setBorder(null);
        ECT.setForeground(new java.awt.Color(153, 255, 153));
        ECT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ECT.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        ECT.setOpaque(false);
        ECT.setPlaceholder("ENTER CONTACT");
        ECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ECTActionPerformed(evt);
            }
        });
        ECT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ECTKeyPressed(evt);
            }
        });
        jPanel10.add(ECT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 180, -1));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CONTACT:");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 110, 32));

        jLabel20.setForeground(new java.awt.Color(25, 20, 20));
        jLabel20.setText("_______________________________");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 210, 140));

        line.setForeground(new java.awt.Color(25, 20, 20));
        line.setText("__________________________");
        line.setToolTipText("");
        jPanel10.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 200, 30));

        line1.setForeground(new java.awt.Color(25, 20, 20));
        line1.setText("__________________________");
        line1.setToolTipText("");
        jPanel10.add(line1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 30));

        line2.setForeground(new java.awt.Color(25, 20, 20));
        line2.setText("__________________________");
        line2.setToolTipText("");
        jPanel10.add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 30));

        line3.setForeground(new java.awt.Color(25, 20, 20));
        line3.setText("__________________________");
        line3.setToolTipText("");
        jPanel10.add(line3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 30));

        line4.setForeground(new java.awt.Color(25, 20, 20));
        line4.setText("__________________________");
        line4.setToolTipText("");
        jPanel10.add(line4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 200, 30));

        line5.setForeground(new java.awt.Color(25, 20, 20));
        line5.setText("__________________________");
        line5.setToolTipText("");
        jPanel10.add(line5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 30));

        ID.setBackground(new java.awt.Color(204, 0, 0));
        ID.setBorder(null);
        ID.setForeground(new java.awt.Color(153, 255, 153));
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        ID.setOpaque(false);
        ID.setPlaceholder("ENTER ID");
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        jPanel10.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 32));

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        image.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imageKeyPressed(evt);
            }
        });
        jPanel10.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 90, 100));

        browse.setText("BROWSE");
        jPanel10.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 110, 50));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 540));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/graduation.png"))); // NOI18N
        jLabel2.setText("ADD STUDENT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 350, 60));

        search.setBorder(null);
        search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        search.setPlaceholder("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 340, 20));

        studentdet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Lastname", "Course", "Year", "Contact"
            }
        ));
        studentdet.setFont(new java.awt.Font("Yu Gothic UI", 1, 10)); // NOI18N
        studentdet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentdetMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentdet);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 550, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle2.setText("PRINT");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        if(validation()== true){
      add();
        }
    }//GEN-LAST:event_ADDActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
      if(validation()== true){
     update();
        }
      
    }//GEN-LAST:event_UPDATEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
     int rowIndex = studentdet.getSelectedRow();
       if(rowIndex < 0){
           JOptionPane.showMessageDialog(null, "Please select a data first");
       }else{
            TableModel model = studentdet.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String ID = value.toString();
             int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
                    if(a==JOptionPane.YES_OPTION){  
                            DBCONNECTOR dbc = new DBCONNECTOR();
                            dbc.deleteData(Integer.parseInt(ID));
                            displayData();
                            reset();
                            JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULL");
                    }    
       }
    }//GEN-LAST:event_DELETEActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void ECTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ECTKeyPressed
      char c =evt.getKeyChar();
        if(Character.isLetter(c)){
        EC.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        EC.setEditable(true);
        } 
    }//GEN-LAST:event_ECTKeyPressed

    private void ECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ECTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ECTActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
      String seachst = search.getText();
        search(seachst);
    }//GEN-LAST:event_searchKeyReleased

    private void ECKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ECKeyTyped

    }//GEN-LAST:event_ECKeyTyped

    private void EYKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EYKeyPressed
        char c =evt.getKeyChar();
        if(Character.isLetter(c)){
            EY.setEditable(false);
            JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
            EY.setEditable(true);

        }
    }//GEN-LAST:event_EYKeyPressed

    private void studentdetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentdetMouseClicked
       table();
    }//GEN-LAST:event_studentdetMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        MessageFormat head = new MessageFormat("BOOKS");
        MessageFormat FOOT = new MessageFormat("Page{0, number , integer}");

        try {
            studentdet.print(JTable.PrintMode.NORMAL, head, FOOT);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "cannot print");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void imageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imageKeyPressed
        img();
    }//GEN-LAST:event_imageKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private necesario.RSMaterialButtonCircle ADD;
    private necesario.RSMaterialButtonCircle DELETE;
    private app.bolivia.swing.JCTextField EC;
    private app.bolivia.swing.JCTextField ECT;
    private app.bolivia.swing.JCTextField ELN;
    private app.bolivia.swing.JCTextField EN;
    private app.bolivia.swing.JCTextField EY;
    private app.bolivia.swing.JCTextField ID;
    private necesario.RSMaterialButtonCircle UPDATE;
    private rojerusan.RSMaterialButtonCircle browse;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel line;
    private javax.swing.JLabel line1;
    private javax.swing.JLabel line2;
    private javax.swing.JLabel line3;
    private javax.swing.JLabel line4;
    private javax.swing.JLabel line5;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField search;
    private rojeru_san.complementos.RSTableMetro studentdet;
    // End of variables declaration//GEN-END:variables

public String destination = "";
    File selectedFile;
    public String oldpath;
    String path;
}
