/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InsuranceCompany;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Insurance.Insurance;
import Business.Network.Network;
import Business.Organization.NewOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author khushbu
 */
public class AssignInsuranceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private Network network;
    private NewOrganization organization;
    private EcoSystem system;

    /**
     * Creates new form AssignInsuranceJPanel
     */
    public AssignInsuranceJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Network network, NewOrganization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        this.system = system;
        populateCombobox();
    }

    public void populateCombobox() {
        Enterprise ent = null;
        patientjComboBox.removeAllItems();
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof HospitalEnterprise) {
                ent = e;
                break;
            }
        }
        for (Patient p : ent.getPatientDirectory().getPatientDir()) {
            if (p.getInsurance().getCovrage() == 0) {
                patientjComboBox.addItem(p);
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

        patientjComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        coveragejTextField = new javax.swing.JTextField();
        addjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        expiryjDateChooser = new com.toedter.calendar.JDateChooser();

        patientjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        patientjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Patient");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Coverage");

        coveragejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        addjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addjButton.setText("Add");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Expiry Date");

        expiryjDateChooser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(patientjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(coveragejTextField)
                                    .addComponent(expiryjDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(addjButton)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(patientjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(coveragejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(expiryjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addjButton)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed
        // TODO add your handling code here:
        Date today=new Date();

        Patient p = (Patient) patientjComboBox.getSelectedItem();
        Insurance i = new Insurance();
        i.setCovrage(Integer.parseInt(coveragejTextField.getText()));
        i.setExpiryDate(expiryjDateChooser.getDate());
        i.setCompany(account);
        i.setLastModifiedDate(today);
        i.setLastModifiedby(account);
        i.setCreatedDate(today);
        p.setInsurance(i);
         JOptionPane.showMessageDialog(null, "Insurance Created", "Created", JOptionPane.INFORMATION_MESSAGE);
         populateCombobox();
         coveragejTextField.setText("");
         expiryjDateChooser.setDate(today);
    }//GEN-LAST:event_addjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addjButton;
    private javax.swing.JTextField coveragejTextField;
    private com.toedter.calendar.JDateChooser expiryjDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox patientjComboBox;
    // End of variables declaration//GEN-END:variables
}
