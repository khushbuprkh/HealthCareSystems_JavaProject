/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Receptionist;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NewOrganization;
import Business.Patient.Patient;
import Business.Role.PatientRole;
import static java.time.Clock.system;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author khushbu
 */
public class PatientUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientUserAccountJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private NewOrganization organization;
    private Patient patient;
    private EcoSystem system;
    
    public PatientUserAccountJPanel(JPanel userProcessContainer, Enterprise enterprise, NewOrganization organization, Patient patient, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.patient = patient;
        this.system = system;
        userNamejLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userNamejTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordjTextField = new javax.swing.JTextField();
        submitjButton = new javax.swing.JButton();
        userNamejLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("User Name");

        userNamejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        userNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNamejTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Password");

        passwordjTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        submitjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });

        userNamejLabel.setForeground(new java.awt.Color(255, 51, 51));
        userNamejLabel.setText("*User Name exists");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(userNamejLabel))
                            .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(submitjButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNamejLabel))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(submitjButton)
                .addGap(97, 97, 97))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNamejTextFieldActionPerformed
        // TODO add your handling code here:

//        popData();
    }//GEN-LAST:event_userNamejTextFieldActionPerformed

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        // TODO add your handling code here:
        String userName = userNamejTextField.getText();
        String password = passwordjTextField.getText();
        boolean check = enterprise.getUserAccountDirectory().checkIfUserNameExists(userName);
        if (check) {
            enterprise.getUserAccountDirectory().createUserAccountPatient(userName, password, patient, new PatientRole());
            JOptionPane.showMessageDialog(null, "User Account Created!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            userNamejLabel.setVisible(false);
            userNamejTextField.setText("");
            passwordjTextField.setText("");
        } else {
            userNamejLabel.setVisible(true);
        }
    }//GEN-LAST:event_submitjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField passwordjTextField;
    private javax.swing.JButton submitjButton;
    private javax.swing.JLabel userNamejLabel;
    private javax.swing.JTextField userNamejTextField;
    // End of variables declaration//GEN-END:variables
}