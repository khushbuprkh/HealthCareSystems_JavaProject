/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Business.Appointments.Appointment;
import Business.Db4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.NewOrganization;
import Business.Organization.ReceptionistOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushbu
 */
public class MyAppointmentsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    private DB4OUtil dB4OUtil;
    private Enterprise enterprise;
    private NewOrganization organization;
    private Network network;

    /**
     * Creates new form MyAppointmentsJPanel
     */
    public MyAppointmentsJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Network network, NewOrganization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
        this.enterprise = enterprise;
        this.organization = organization;
        this.network = network;
        PopulateTable();
    }

    public void PopulateTable() {
        DefaultTableModel model = (DefaultTableModel) appiontmentsjTable.getModel();

        model.setRowCount(0);
        NewOrganization org = null;
        Enterprise ent = null;
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (NewOrganization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof ReceptionistOrganization) {
                        org = organization;
                        for (Appointment appointment : org.getAppointmentDirectory().getAppointmentdir()) {
                            if (appointment.getPatient().getId() == account.getPatient().getId()) {
                                Object[] row = new Object[5];
                                row[0] = appointment;
                                row[1] = appointment.getPatient().getName();
                                row[2] = appointment.getStartTime();
                                row[3] = appointment.getEndTime();
                                row[4] = appointment.getStatus();

                                model.addRow(row);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        appiontmentsjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        requestforapponitmentjButton = new javax.swing.JButton();

        appiontmentsjTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appiontmentsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment", "Patient", "Start time", "End Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(appiontmentsjTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("My Appointments");

        requestforapponitmentjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        requestforapponitmentjButton.setText("Request For New Appointment ");
        requestforapponitmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestforapponitmentjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(requestforapponitmentjButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(requestforapponitmentjButton)
                .addContainerGap(200, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestforapponitmentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestforapponitmentjButtonActionPerformed
        // TODO add your handling code here:

        RequestForApointmentJPanel requestForApointmentJPanel = new RequestForApointmentJPanel(userProcessContainer, account, enterprise, network, organization, system);
        userProcessContainer.add("RequestForApointmentJPanel", requestForApointmentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestforapponitmentjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appiontmentsjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton requestforapponitmentjButton;
    // End of variables declaration//GEN-END:variables
}
