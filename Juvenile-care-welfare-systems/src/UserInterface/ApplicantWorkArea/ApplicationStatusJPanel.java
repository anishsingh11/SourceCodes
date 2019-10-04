/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ApplicantWorkArea;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.JobWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anish
 */
public class ApplicationStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ApplicationStatusJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;

    public ApplicationStatusJPanel(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        populateTable();
    }

    public void populateTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblJobWorkRequest.getModel();
        dtm.setRowCount(0);

        for (WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList()) {

            if (workRequest instanceof JobWorkRequest) {
                Object row[] = new Object[4];
                row[0] = workRequest.getSender();
                row[1] = workRequest.getReceiver();
                row[2] = workRequest;
                row[3] = ((JobWorkRequest) workRequest).getJob();
                dtm.addRow(row);
            }

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

        tblScrollPane = new javax.swing.JScrollPane();
        tblJobWorkRequest = new javax.swing.JTable();
        btnWithdraw = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblJobWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Receiver", "Status", "Job Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJobWorkRequest.setMinimumSize(new java.awt.Dimension(375, 0));
        tblJobWorkRequest.getTableHeader().setReorderingAllowed(false);
        tblScrollPane.setViewportView(tblJobWorkRequest);

        add(tblScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 73, 480, 178));

        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });
        add(btnWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 269, -1, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("View Application Status");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 250, 27));

        btnBack2.setText("Back");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblJobWorkRequest.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to withdraw your application?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                WorkRequest workRequest = (WorkRequest) tblJobWorkRequest.getValueAt(selectedRow, 2);
                if (workRequest.getStatus().equals("")) {
                    userAccount.getWorkQueue().getWorkRequestList().remove(workRequest);
                    JOptionPane.showMessageDialog(null, "Job application withdrawn successfully", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Job application is already processed", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                populateTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblJobWorkRequest;
    private javax.swing.JScrollPane tblScrollPane;
    // End of variables declaration//GEN-END:variables
}
