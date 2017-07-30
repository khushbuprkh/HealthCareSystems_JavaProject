/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Receptionist;

import Business.Department.Department;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NewOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author khushbu
 */
public class ManageAppointmentsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    private Enterprise enterprise;
    private NewOrganization organization;
    /**
     * Creates new form ManageAppointments
     */
    public ManageAppointmentsJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, NewOrganization organization ,EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        this.enterprise = enterprise;
        this.organization=organization;
        populateDepartment();
    }

    public void populateDepartment() {
        departmentjComboBox.removeAllItems();
        for (Department department : enterprise.getDepartmentDirectory().getDepartmentList()) {
            departmentjComboBox.addItem(department);
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

        departmentjComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        bookAppointmentjButton = new javax.swing.JButton();

        departmentjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        departmentjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Select adepartment");

        bookAppointmentjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bookAppointmentjButton.setText(">>Book Appointment");
        bookAppointmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAppointmentjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(departmentjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(bookAppointmentjButton)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(departmentjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(bookAppointmentjButton)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bookAppointmentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAppointmentjButtonActionPerformed
        // TODO add your handling code here:
          Department department = (Department) departmentjComboBox.getSelectedItem();
        BookAppointmentsJPanel bookAppointmentsJPanel = new BookAppointmentsJPanel(userProcessContainer,account,enterprise,organization ,department,system);
        userProcessContainer.add("ManageEnterpriseJPanel", bookAppointmentsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_bookAppointmentjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookAppointmentjButton;
    private javax.swing.JComboBox departmentjComboBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}