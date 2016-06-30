/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitracomm.pa.ui;

import com.mitracomm.pa.core.MainController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MECC
 */
public class MainViewer extends javax.swing.JFrame {

    /**
     * Creates new form MainViewer
     */
    public MainViewer() {
        initComponents();
        //Set Unduh Button Invisible
        unduhButton.setVisible(false);
        progressBar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        unggahButton = new javax.swing.JLabel();
        unduhButton = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        messageLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pengolah Absen v.1.0");
        setName("mainUiFrame"); // NOI18N

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));

        unggahButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        unggahButton.setForeground(new java.awt.Color(0, 153, 153));
        unggahButton.setText("Unggah Dokumen");
        unggahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unggahButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                unggahButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                unggahButtonMouseReleased(evt);
            }
        });

        unduhButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        unduhButton.setForeground(new java.awt.Color(204, 51, 0));
        unduhButton.setText("Unduh Hasil");
        unduhButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unduhButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                unduhButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                unduhButtonMouseReleased(evt);
            }
        });

        messageLabel.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(102, 102, 102));
        messageLabel.setText("Masukan dokumen dengan format yang telah ditentukan.");
        messageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                messageLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                messageLabelMouseReleased(evt);
            }
        });

        infoLabel.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(204, 102, 0));
        infoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                infoLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                infoLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(unggahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unduhButton))
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unggahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unduhButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "ID", "Masuk", "Pulang", "Jumlah Jam"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(displayTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unduhButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unduhButtonMouseReleased
        // TODO add your handling code here:
        unduhButton.setForeground(new java.awt.Color(204, 51, 0));
    }//GEN-LAST:event_unduhButtonMouseReleased

    private void unduhButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unduhButtonMousePressed
        // TODO add your handling code here:
        unduhButton.setForeground(new java.awt.Color(153, 255, 51));
    }//GEN-LAST:event_unduhButtonMousePressed

    private void messageLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageLabelMousePressed

    private void messageLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageLabelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_messageLabelMouseReleased

    private void unggahButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unggahButtonMouseReleased
        // TODO add your handling code here:
        unggahButton.setForeground(new java.awt.Color(0, 153, 153));
    }//GEN-LAST:event_unggahButtonMouseReleased

    private void unggahButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unggahButtonMousePressed
        // TODO add your handling code here:
        unggahButton.setForeground(new java.awt.Color(255, 153, 0));
    }//GEN-LAST:event_unggahButtonMousePressed

    private void runProgressBar(){
        progressBar.setVisible(true);
        
        progressBar.setBorderPainted(true);
        
        progressBar.setIndeterminate(true);
        ComponentUI ui = null;
        progressBar.setUI((ProgressBarUI) ui);
    }
    
    private void stopProgressBar(){
          progressBar.setIndeterminate(false); 
          progressBar.setVisible(true);
    }
    private void insertResultToDisplayTable(String[][] resultData) {
        String[] columnNames = {"Nama", "ID", "Masuk", "Pulang", "Jumlah Jam"};
        DefaultTableModel dftModel = new DefaultTableModel(null, columnNames);
        displayTable.setModel(dftModel);
        
        //Activation of these codes below is for debugging onlu
        /*System.out.println("Ini na isi resultData");
        for(String[] a: resultData){
        
            for(String b : a){
                System.out.print(b+" || ");
            }
            System.out.println();
        }*/   
        
        for (String[] data : resultData) {
            dftModel.addRow(data);
        }

    }

    private void unggahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unggahButtonMouseClicked
        // TODO add your handling code here:
        String filePath = null;

        JFileChooser pathChooser = new JFileChooser();
        FileNameExtensionFilter pathChooserFilter = new FileNameExtensionFilter(".xlsx or .xls only", "xlsx", "xls");
        pathChooser.setFileFilter(pathChooserFilter);
      
        
        if (evt.getSource() == unggahButton) {
            int returnVal = pathChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                try {
                    File file = pathChooser.getSelectedFile();

                    //This is where a real application would open the file.
                    System.out.println(file.getPath());
                    filePath = file.getPath();

                    infoLabel.setText("Dokumen sedang diproses.");
                    insertResultToDisplayTable(MainController.doControlling(filePath));
                    
                    //Activated this method is for debugging only
                    //MainController.doControllingVoid(filePath);
                    
                    unduhButton.setVisible(true);
                    infoLabel.setText("Selesai!");
                    //stopProgressBar();
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainViewer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_unggahButtonMouseClicked

    private void unduhButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unduhButtonMouseClicked
        String savedFilePath = null;

        JFileChooser savedPathChooser = new JFileChooser();
        FileNameExtensionFilter pathChooserFilter = new FileNameExtensionFilter(".xlsx", "xlsx");

        savedPathChooser.setFileFilter(pathChooserFilter);
        savedPathChooser.setDialogTitle("Save Result As");
        savedPathChooser.setApproveButtonText("Save As");
        // Set the tool tip
        savedPathChooser.setApproveButtonToolTipText("Save File As");

        if (evt.getSource() == unduhButton) {
            int returnVal = savedPathChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = savedPathChooser.getSelectedFile();
                System.out.println(file.getPath());
                savedFilePath = file.getPath();
                MainController.getResultInExcel(savedFilePath+".xlsx");
                //JOptionPane.showMessageDialog(null, "Berhasil tersimpan ke "+savedFilePath);
                JOptionPane.showMessageDialog(null,  "Berhasil tersimpan ke "+savedFilePath+".xlsx", "Status", HEIGHT);
                

            }
        }
    }//GEN-LAST:event_unduhButtonMouseClicked

    private void infoLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_infoLabelMousePressed

    private void infoLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLabelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_infoLabelMouseReleased

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
            java.util.logging.Logger.getLogger(MainViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel unduhButton;
    private javax.swing.JLabel unggahButton;
    // End of variables declaration//GEN-END:variables
}

