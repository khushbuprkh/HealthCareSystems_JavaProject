/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Doctor;

import Business.Appointments.Appointment;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.NewOrganization;
import Business.Patient.Patient;
import Business.Sensors.Sensor;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushbu
 */
public class processAppointmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Appointment appointment;
    private UserAccount account;
    private EcoSystem system;
    private Enterprise enterprise;
    private NewOrganization organization;
    private Network network;

    /**
     * Creates new form processAppointmentJPanel
     */
    public processAppointmentJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Network network, NewOrganization organization, Appointment appointment) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.appointment = appointment;
        this.account = account;
        this.system = system;
        this.enterprise = enterprise;
        this.organization = organization;
        this.network = network;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) appiontmentsjTable.getModel();

        model.setRowCount(0);

        Object[] row = new Object[5];
        row[0] = appointment;
        row[1] = appointment.getPatient().getName();
        row[2] = appointment.getStartTime();
        row[3] = appointment.getEndTime();
        row[4] = appointment.getStatus();

        model.addRow(row);

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
        addVitalSignjButton = new javax.swing.JButton();
        listOfTestjButton = new javax.swing.JButton();
        observationjButton = new javax.swing.JButton();
        prescribeMedicinejButton = new javax.swing.JButton();
        CompletejButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        askforjButton = new javax.swing.JButton();

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

        addVitalSignjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addVitalSignjButton.setText("Add VitalSign");
        addVitalSignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVitalSignjButtonActionPerformed(evt);
            }
        });

        listOfTestjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        listOfTestjButton.setText("Send patient to Lab ");
        listOfTestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfTestjButtonActionPerformed(evt);
            }
        });

        observationjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        observationjButton.setText("Under Observation");
        observationjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observationjButtonActionPerformed(evt);
            }
        });

        prescribeMedicinejButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        prescribeMedicinejButton.setText("Prescribe Medcine");
        prescribeMedicinejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescribeMedicinejButtonActionPerformed(evt);
            }
        });

        CompletejButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CompletejButton.setText("Set as Completed");
        CompletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompletejButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        askforjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        askforjButton.setText("Ask Blood");
        askforjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askforjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(observationjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addVitalSignjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(listOfTestjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prescribeMedicinejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CompletejButton)
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(askforjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CompletejButton)
                    .addComponent(backJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addVitalSignjButton)
                    .addComponent(listOfTestjButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(observationjButton)
                    .addComponent(prescribeMedicinejButton))
                .addGap(18, 18, 18)
                .addComponent(askforjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listOfTestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfTestjButtonActionPerformed
        // TODO add your handling code here:
        Patient patient = appointment.getPatient();
        ListofTestsJPanel listofTestsJPanel = new ListofTestsJPanel(userProcessContainer, patient, account, enterprise, network, system);
        userProcessContainer.add("ListofTestsJPanel", listofTestsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_listOfTestjButtonActionPerformed

    private void addVitalSignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVitalSignjButtonActionPerformed
        // TODO add your handling code here:
        Patient patient = appointment.getPatient();
        AddVitalSignJPanel addVitalSignJPanel = new AddVitalSignJPanel(userProcessContainer, patient, account);
        userProcessContainer.add("ManageDepartmentsJPanel", addVitalSignJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addVitalSignjButtonActionPerformed

    private void prescribeMedicinejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescribeMedicinejButtonActionPerformed
        // TODO add your handling code here:
        Patient patient = appointment.getPatient();
        WriteAPrescriptionJPanel writeAPrescriptionJPanel = new WriteAPrescriptionJPanel(userProcessContainer, account,patient, enterprise, network, system);
        userProcessContainer.add("ManageDepartmentsJPanel", writeAPrescriptionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_prescribeMedicinejButtonActionPerformed

    private void observationjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observationjButtonActionPerformed
        // TODO add your handling code here:
        Patient patient = appointment.getPatient();
        patient.setUnderObservation('Y');
        patient.setSunderobservationby(account);
        Sensor s=new Sensor();
        
        patient.setSensor(s);
    }//GEN-LAST:event_observationjButtonActionPerformed

    private void CompletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompletejButtonActionPerformed
        // TODO add your handling code here:
        appointment.setStatus("Completed");
        populateTable();
    }//GEN-LAST:event_CompletejButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
            userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void askforjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askforjButtonActionPerformed
        // TODO add your handling code here:
                Patient patient = appointment.getPatient();
        AskForBloodJPanel askForBloodJPanel = new AskForBloodJPanel(userProcessContainer, account,patient, enterprise, network, system);
        userProcessContainer.add("AskForBloodJPanel", askForBloodJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_askforjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompletejButton;
    private javax.swing.JButton addVitalSignjButton;
    private javax.swing.JTable appiontmentsjTable;
    private javax.swing.JButton askforjButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listOfTestjButton;
    private javax.swing.JButton observationjButton;
    private javax.swing.JButton prescribeMedicinejButton;
    // End of variables declaration//GEN-END:variables
}