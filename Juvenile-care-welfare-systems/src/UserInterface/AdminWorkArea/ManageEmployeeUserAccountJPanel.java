/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.UserAccount.*;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anish
 */
public class ManageEmployeeUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;

    public ManageEmployeeUserAccountJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateOrganization();
        populateEmployee();
        populateRole();
        populateTable();
    }

    private void populateOrganization() {
        cbOrg.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (!(organization instanceof AdminOrganization)) {
                cbOrg.addItem(organization);
            }
        }
    }

    private void populateEmployee() {

        cbEmp.removeAllItems();
        Organization org = (Organization) cbOrg.getSelectedItem();
        if (org != null) {
            for (Employee employee : org.getEmployeeDirectory().getEmployeeList()) {
                cbEmp.addItem(employee);
            }
        }

    }

    private void populateRole() {
        cbRole.removeAllItems();
        Organization org = (Organization) cbOrg.getSelectedItem();
        if (org != null) {
            for (Role role : org.getSupportedRole()) {
                if (!(role instanceof AdminRole)) {
                    cbRole.addItem(role);
                }
            }
        }
    }

    private void populateTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblUserAcc.getModel();

        dtm.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                if (!ua.getRole().getName().equals(Role.RoleType.Applicant.getValue())) {
                    Object row[] = new Object[2];
                    row[0] = ua;
                    row[1] = ua.getRole();
                    dtm.addRow(row);
                }

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
        tblUserAcc = new javax.swing.JTable();
        btnDeleteAcc = new javax.swing.JButton();
        lblOrg = new javax.swing.JLabel();
        cbOrg = new javax.swing.JComboBox();
        lblEmp = new javax.swing.JLabel();
        cbEmp = new javax.swing.JComboBox();
        lblRole = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox();
        lblUserName = new javax.swing.JLabel();
        txtFldUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtFldPassword = new javax.swing.JTextField();
        btnAddAccount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUserAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserAcc.setMinimumSize(new java.awt.Dimension(375, 0));
        tblScrollPane.setViewportView(tblUserAcc);
        if (tblUserAcc.getColumnModel().getColumnCount() > 0) {
            tblUserAcc.getColumnModel().getColumn(1).setResizable(false);
        }

        add(tblScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 500, 170));

        btnDeleteAcc.setText("Delete Account");
        btnDeleteAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccActionPerformed(evt);
            }
        });
        add(btnDeleteAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        lblOrg.setText("Organization");
        add(lblOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        cbOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrgActionPerformed(evt);
            }
        });
        add(cbOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 146, -1));

        lblEmp.setText("Employee");
        add(lblEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 80, -1));

        cbEmp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmpActionPerformed(evt);
            }
        });
        add(cbEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 146, -1));

        lblRole.setText("Role");
        add(lblRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 61, -1));

        cbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 146, -1));

        lblUserName.setText("User Name");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));
        add(txtFldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 146, -1));

        lblPassword.setText("Password");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 70, -1));
        add(txtFldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 146, -1));

        btnAddAccount.setText("Add Account");
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountActionPerformed(evt);
            }
        });
        add(btnAddAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manage User Account");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 270, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void cbOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrgActionPerformed

        populateEmployee();
        populateRole();
    }//GEN-LAST:event_cbOrgActionPerformed

    private void btnDeleteAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblUserAcc.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the user account?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                UserAccount ua = (UserAccount) tblUserAcc.getValueAt(selectedRow, 0);

                if (ua.getRole().getName().equals("Admin Type")) {
                    JOptionPane.showMessageDialog(null, "You are not authorized to delete admin", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                enterprise.getUserAccountDirectory().deleteUserAccount(ua);
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.equals(ua)) {
                            organization.getUserAccountDirectory().deleteUserAccount(ua);
                            break;
                        }
                    }
                }

                populateTable();
                JOptionPane.showMessageDialog(null, "User account deleted successfully", "Warning", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteAccActionPerformed

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountActionPerformed
        // TODO add your handling code here:

        try {
            String userName = txtFldUserName.getText();
            String password = txtFldPassword.getText();
            Organization organization = (Organization) cbOrg.getSelectedItem();
            Employee employee = (Employee) cbEmp.getSelectedItem();
            Role role = (Role) cbRole.getSelectedItem();

            if (!userName.equals("") && !password.equals("")) {

                // validate username
                String regex = "^[a-z A-Z]+$";
                Pattern namePattern = Pattern.compile(regex);
                Matcher unameMatcher = namePattern.matcher(userName);

                if (!unameMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid characters in user name", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (password.length() > 10) {
                    JOptionPane.showMessageDialog(null, "Password should not have more than 10 characters", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                } else if (password.length() < 4) {
                    JOptionPane.showMessageDialog(null, "Password should have 4 to 10 characters", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // check if username is unique
                if (system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                    if (role.getName() == "Manager Type") {
                        // dont add manager is already exists
                        if (!organization.getUserAccountDirectory().checkIfManagerExists(organization)) {
                            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            system.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                            JOptionPane.showMessageDialog(null, "User account added successfully", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Manager already already exists", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                        enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                        system.getUserAccountDirectory().createUserAccount(userName, password, employee, role);

                        JOptionPane.showMessageDialog(null, "User account added successfully", "Warning", JOptionPane.WARNING_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "User name already exists", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                populateTable();
                txtFldPassword.setText("");
                txtFldUserName.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Enter values for all field", "Warning", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter values for all field", "Warning", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_btnAddAccountActionPerformed

    private void cbEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEmpActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteAcc;
    private javax.swing.JComboBox cbEmp;
    private javax.swing.JComboBox cbOrg;
    private javax.swing.JComboBox cbRole;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTable tblUserAcc;
    private javax.swing.JTextField txtFldPassword;
    private javax.swing.JTextField txtFldUserName;
    // End of variables declaration//GEN-END:variables
}
