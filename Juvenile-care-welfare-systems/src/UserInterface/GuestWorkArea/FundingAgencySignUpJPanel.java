/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GuestWorkArea;

import Business.Agency.Agency;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.City;
import Business.Network.Country;
import Business.Network.State;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.AgencyWorkRequest;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ashwin
 */
public class FundingAgencySignUpJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private Enterprise enterprise;
    private DB4OUtil dB4OUtil;

    /**
     * Creates new form FundingAgencySignUPJPanel
     */
    public FundingAgencySignUpJPanel(JPanel userProcessContainer, EcoSystem system, DB4OUtil dB4OUtil) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
        populateCountry();
        populateState();
        populateCity();
        populateEnterpriseType();
    }

    private void populateCountry() {
        cbCountry.removeAllItems();
        for (Country c : system.getNetworkList()) {
            cbCountry.addItem(c);
        }
    }

    private void populateState() {
        cbState.removeAllItems();
        if (cbCountry.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                if (c.equals(cbCountry.getSelectedItem())) {
                    for (State s : c.getStateList()) {
                        cbState.addItem(s);
                    }
                }
            }
        }
    }

    private void populateCity() {
        cbCity.removeAllItems();
        if (cbState.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                for (State s : c.getStateList()) {
                    if (s.equals(cbState.getSelectedItem())) {
                        for (City city : s.getCityList()) {
                            cbCity.addItem(city);
                        }
                    }
                }
            }
        }
    }

    public void populateEnterpriseType() {
        cbNGOName.removeAllItems();
        if (cbCity.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                for (State s : c.getStateList()) {
                    for (City city : s.getCityList()) {
                        if (city.equals(cbCity.getSelectedItem())) {
                            for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                                cbNGOName.addItem(e);
                            }
                        }
                    }
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

        lblHeader = new javax.swing.JLabel();
        lblBudget = new javax.swing.JLabel();
        lblAgencyName = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblCity = new javax.swing.JLabel();
        txtAgencyName = new javax.swing.JTextField();
        txtBudget = new javax.swing.JTextField();
        cbCountry = new javax.swing.JComboBox<>();
        cbState = new javax.swing.JComboBox<>();
        cbCity = new javax.swing.JComboBox<>();
        lblEnterpriseType = new javax.swing.JLabel();
        cbNGOName = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Sign Up As Funding Agency");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 250, 24));

        lblBudget.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBudget.setText("Budget:");
        add(lblBudget, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 96, 20));

        lblAgencyName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAgencyName.setText("Agency Name:");
        add(lblAgencyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 96, 20));

        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCountry.setText("Country:");
        add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 96, 27));

        lblState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblState.setText("State:");
        add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 96, 27));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        lblCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCity.setText("City:");
        add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 96, 27));
        add(txtAgencyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 150, -1));
        add(txtBudget, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 150, -1));

        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });
        add(cbCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 150, -1));

        cbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStateActionPerformed(evt);
            }
        });
        add(cbState, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 150, -1));

        cbCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCityActionPerformed(evt);
            }
        });
        add(cbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 150, -1));

        lblEnterpriseType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEnterpriseType.setText("NGO Name:");
        add(lblEnterpriseType, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 80, 20));
        add(cbNGOName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 150, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblWarning.setForeground(new java.awt.Color(255, 0, 51));
        lblWarning.setText("* Budget currency is considered to be in US Dollar");
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:

        enterprise = (Enterprise) cbNGOName.getSelectedItem();
        AgencyWorkRequest request = new AgencyWorkRequest();
        String agencyName = txtAgencyName.getText();
        String budgetStr = txtBudget.getText();

        if (agencyName.equals("") || budgetStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter values for both agency name and budget", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // validate username
        String regex = "^[a-z A-Z]+$";
        Pattern namePattern = Pattern.compile(regex);
        Matcher nameMatcher = namePattern.matcher(agencyName);

        regex = "^[0-9]+$";
        Pattern intPattern = Pattern.compile(regex);
        Matcher intMatcher = intPattern.matcher(budgetStr);

        if (!intMatcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid characters in budget, enter only numbers", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!nameMatcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid characters in agency name", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int budget = Integer.parseInt(budgetStr);

        Agency agency = new Agency();
        agency.setName(agencyName);
        agency.setAmount(budget);
        agency.setCountry(cbCountry.getSelectedItem().toString());
        agency.setState(cbState.getSelectedItem().toString());
        agency.setCity(cbCity.getSelectedItem().toString());
        agency.setStatus(true);

        request.setAgency(agency);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ManagerOrganization) {
                organization.getWorkQueue().getWorkRequestList().add(request);
            }
        }

        JOptionPane.showMessageDialog(null, "Sign up request successfully submitted", "Information", JOptionPane.INFORMATION_MESSAGE);
        txtAgencyName.setText("");
        txtBudget.setText("");
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStateActionPerformed
        // TODO add your handling code here:
        populateCity();
    }//GEN-LAST:event_cbStateActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
        populateState();
    }//GEN-LAST:event_cbCountryActionPerformed

    private void cbCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCityActionPerformed
        // TODO add your handling code here:
        populateEnterpriseType();
    }//GEN-LAST:event_cbCityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<Object> cbCity;
    private javax.swing.JComboBox<Object> cbCountry;
    private javax.swing.JComboBox cbNGOName;
    private javax.swing.JComboBox<Object> cbState;
    private javax.swing.JLabel lblAgencyName;
    private javax.swing.JLabel lblBudget;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEnterpriseType;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTextField txtAgencyName;
    private javax.swing.JTextField txtBudget;
    // End of variables declaration//GEN-END:variables
}
