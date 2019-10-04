/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GuestWorkArea;

import java.awt.CardLayout;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nikita
 */
public class SMSJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SMSJPanel
     */
    private JPanel userProcessContainer;

    public SMSJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrom = new javax.swing.JLabel();
        txtFldFrom = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtFldSubject = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        btnSendEmail = new javax.swing.JButton();
        lblTo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMessage = new javax.swing.JTextArea();
        lblSubject1 = new javax.swing.JLabel();
        passFld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrom.setText("Your Email:");
        add(lblFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 131, -1, -1));
        add(txtFldFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 128, 292, -1));

        lblMessage.setText("Message:");
        add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 283, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 19, -1, -1));

        txtFldSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldSubjectActionPerformed(evt);
            }
        });
        add(txtFldSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 167, 292, -1));

        lblPassword.setText("Password:");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 200, -1, -1));

        btnSendEmail.setText("Send");
        btnSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendEmailActionPerformed(evt);
            }
        });
        add(btnSendEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 556, -1, -1));

        lblTo.setText("To:");
        add(lblTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 90, -1, -1));

        txtAreaMessage.setColumns(20);
        txtAreaMessage.setLineWrap(true);
        txtAreaMessage.setRows(5);
        txtAreaMessage.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAreaMessage);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 326, 613, 192));

        lblSubject1.setText("Subject:");
        add(lblSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 167, -1, -1));
        add(passFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 200, 292, -1));

        jLabel1.setText("NGO number");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 90, -1, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Send a SMS");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 270, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFldSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldSubjectActionPerformed

    private void btnSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendEmailActionPerformed
        try {
            // TODO add your handling code here:

            sendEmail();
        } catch (MessagingException ex) {
            passFld.setText("");
            JOptionPane.showMessageDialog(null, "SMS could not be sent. "
                    + "Please check your credentials and mail settings ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnSendEmailActionPerformed

    public void sendEmail() throws MessagingException {

        String to = "8577072476@tmomail.net";
        String from = txtFldFrom.getText();
        char[] passwordCharArray = passFld.getPassword();
        String password = String.valueOf(passwordCharArray);
        String message = txtAreaMessage.getText();
        String subject = txtFldSubject.getText();

        if (from.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter value in from field", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter value in password field", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // validate email
        String regex = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)";
        Pattern emailPattern = Pattern.compile(regex);
        Matcher toMatcher = emailPattern.matcher(to);
        Matcher fromMatcher = emailPattern.matcher(from);

        if (!toMatcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid email address in to field", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!fromMatcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid email address in from field", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        // System.out.println("Mail Server Properties have been setup successfully..");

        MimeMessage generateMailMessage;

        // Step2
        // System.out.println("\n\n 2nd ===> get Mail Session..");
        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        generateMailMessage.setSubject(subject);
        String emailBody = message + "<br><br> Regards, <br>NGO Child Care System";
        generateMailMessage.setContent(emailBody, "text/html");

        System.out.println("Mail Session has been created successfully..");

        // Step3
        // System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", from, password);
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
        JOptionPane.showMessageDialog(null, "SMS sent successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

        txtFldFrom.setText("");
        txtFldSubject.setText("");
        passFld.setText("");
        txtAreaMessage.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSubject1;
    private javax.swing.JLabel lblTo;
    private javax.swing.JPasswordField passFld;
    private javax.swing.JTextArea txtAreaMessage;
    private javax.swing.JTextField txtFldFrom;
    private javax.swing.JTextField txtFldSubject;
    // End of variables declaration//GEN-END:variables
}
