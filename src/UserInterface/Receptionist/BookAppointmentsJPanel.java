/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Receptionist;

import Business.Appointments.Appointment;
import Business.Department.Department;
import Business.EcoSystem;
import Business.Email.Email;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.NewOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushbu
 */
public class BookAppointmentsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    private Enterprise enterprise;
    private Department department;
    private NewOrganization organization;

    /**
     * Creates new form BookAppointmentsJPanel
     */
    public BookAppointmentsJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, NewOrganization organization, Department department, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        this.enterprise = enterprise;
        this.department = department;
        this.organization = organization;
        PopulateCombobox();
        populatePatientCombobox();
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) appiontmentsjTable.getModel();

        model.setRowCount(0);

        for (Appointment appointment : organization.getAppointmentDirectory().getAppointmentdir()) {
            Object[] row = new Object[5];
            row[0] = appointment.getPatient().getName();
            row[1] = appointment.getAssignedTo().getUsername();
            row[2] = appointment.getStartTime();
            row[3] = appointment.getEndTime();
            row[4] = appointment.getStatus();

            model.addRow(row);
        }
    }

    public void PopulateCombobox() {
        doctorListjComboBox.removeAllItems();
        NewOrganization org = null;
        for (NewOrganization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equals("Doctor Organization")) {
                org = organization;
                for (UserAccount ua : org.getUserAccountDirectory().getUserAccountDir()) {
                    if (ua.getEmployee().getDepartment().getDepartmentName().equals(department.getDepartmentName())) {
                        doctorListjComboBox.addItem(ua);
                    }
                }
            }
        }

    }

    public void populatePatientCombobox() {
        patientjComboBox.removeAllItems();
        for (Patient patient : enterprise.getPatientDirectory().getPatientDir()) {
            patientjComboBox.addItem(patient);
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

        jLabel1 = new javax.swing.JLabel();
        doctorListjComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        patientjComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appiontmentsjTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        bookAppointmentjButton = new javax.swing.JButton();
        startTimeJSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        endTimeJSpinner = new javax.swing.JSpinner();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Doctor");

        doctorListjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doctorListjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Patient");

        patientjComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        patientjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("End Time");

        appiontmentsjTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appiontmentsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Doctor", "Start time", "End Time", "Status"
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
        if (appiontmentsjTable.getColumnModel().getColumnCount() > 0) {
            appiontmentsjTable.getColumnModel().getColumn(0).setResizable(false);
            appiontmentsjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Book Appointments");

        bookAppointmentjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bookAppointmentjButton.setText("Submit");
        bookAppointmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAppointmentjButtonActionPerformed(evt);
            }
        });

        startTimeJSpinner.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        startTimeJSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1448948604658L), null, java.util.Calendar.HOUR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Start Time");

        endTimeJSpinner.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        endTimeJSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1448948604658L), null, java.util.Calendar.HOUR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doctorListjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startTimeJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endTimeJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(bookAppointmentjButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorListjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(startTimeJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(endTimeJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bookAppointmentjButton)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bookAppointmentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAppointmentjButtonActionPerformed
        // TODO add your handling code here:
        Date date=new Date();
        Date StartDate = (Date) startTimeJSpinner.getValue();
        Date endDate = (Date) endTimeJSpinner.getValue();
        long diff = endDate.getTime() - StartDate.getTime();
        long min = diff / (60 * 1000) % 60;

        if (endDate.getTime() <= StartDate.getTime()) {
            JOptionPane.showMessageDialog(null, "End Time should greater than the Start Time!!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (min > 30) {
            JOptionPane.showMessageDialog(null, "One Appointment cannot be greater than 30 mins!!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (min < 10) {
            JOptionPane.showMessageDialog(null, "One Appointment cannot be less than 10 mins!!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else if (StartDate.getTime()<date.getTime()) {
            JOptionPane.showMessageDialog(null, "Appointment cannot be of past!!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            NewOrganization org = null;
            for (NewOrganization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof DoctorOrganization) {
                    org = organization;
                    break;
                }
            }
          boolean test=true;
            Patient patient = (Patient) patientjComboBox.getSelectedItem();
            UserAccount ua = (UserAccount) doctorListjComboBox.getSelectedItem();
            for (Appointment apt : organization.getAppointmentDirectory().getAppointmentdir()) {
                if (apt.getAssignedTo().getUsername().equals(ua.getUsername())) {
                   if(StartDate.getTime()>(apt.getStartTime().getTime())&&endDate.getTime()<(apt.getEndTime().getTime()))
                   {
                   test=false;
                   break;
                   }
                   else{test=true;}
                }
             }
            if (!test)
            {
            JOptionPane.showMessageDialog(null, "Time Slot not available. Please select another time!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

            Appointment a = new Appointment();

            a.setAssignedTo(ua);
            ua.getEmployee().setAppointmentcount(ua.getEmployee().getAppointmentcount()+1);
            a.setBookedBy(account);
            a.setPatient(patient);
            a.setStartTime(StartDate);
            a.setEndTime(endDate);
            a.setStatus("Sent to the Doctor");
            ua.getAppointmentdir().getAppointmentdir().add(a);
            organization.getAppointmentDirectory().getAppointmentdir().add(a);
            String emailId = "healthcare.aed@gmail.com";
            String password = "kitty@123";
            String message = "Your Appointment with the  Doctor " + ua.getEmployee().getName() + " has been set from " + StartDate + " to " + endDate;
            Email.sendMail(emailId, password, message, patient.getEmailID());
            populateTable();
        }
    }//GEN-LAST:event_bookAppointmentjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appiontmentsjTable;
    private javax.swing.JButton bookAppointmentjButton;
    private javax.swing.JComboBox doctorListjComboBox;
    private javax.swing.JSpinner endTimeJSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox patientjComboBox;
    private javax.swing.JSpinner startTimeJSpinner;
    // End of variables declaration//GEN-END:variables
}
