/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Business.Ambulance.AmbulanceWorkrequest;
import Business.Db4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.AmbulanceOrganization;
import Business.Organization.NewOrganization;
import Business.UserAccount.UserAccount;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushbu
 */
public class CallTheAmbulanceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    private DB4OUtil dB4OUtil;
    private Enterprise enterprise;
    private NewOrganization organization;
    private Network network;

    /**
     * Creates new form CallTheAmbulanceJPanel
     */
    public CallTheAmbulanceJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Network network, NewOrganization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
        this.enterprise = enterprise;
        this.organization = organization;
        this.network = network;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) ambulanceWorkrequestjTable.getModel();

        model.setRowCount(0);

        for (AmbulanceWorkrequest r : account.getAmbulanceWorkQueue().getAmbulanceWorkRequestDir()) {
            Object row[] = new Object[4];
            row[0] = r.getReceiver();
            row[1] = r.getStatus();
            row[2] = r.getRequestDate();
            row[3] = r.getResolveDate();
            ((DefaultTableModel) ambulanceWorkrequestjTable.getModel()).addRow(row);
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
        ambulanceWorkrequestjTable = new javax.swing.JTable();
        callTheAmbulancejButton = new javax.swing.JButton();

        ambulanceWorkrequestjTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ambulanceWorkrequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Receiver", "Status", "Request Dttm", "Request Closed Dttm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ambulanceWorkrequestjTable);
        if (ambulanceWorkrequestjTable.getColumnModel().getColumnCount() > 0) {
            ambulanceWorkrequestjTable.getColumnModel().getColumn(0).setResizable(false);
            ambulanceWorkrequestjTable.getColumnModel().getColumn(1).setResizable(false);
            ambulanceWorkrequestjTable.getColumnModel().getColumn(2).setResizable(false);
            ambulanceWorkrequestjTable.getColumnModel().getColumn(3).setResizable(false);
        }

        callTheAmbulancejButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        callTheAmbulancejButton.setText("Call The Ambulance");
        callTheAmbulancejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callTheAmbulancejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(callTheAmbulancejButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(callTheAmbulancejButton)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void callTheAmbulancejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callTheAmbulancejButtonActionPerformed
        // TODO add your handling code here:
        for(AmbulanceWorkrequest wr:account.getAmbulanceWorkQueue().getAmbulanceWorkRequestDir())
        {
        if(wr.getResolveDate()==null)
        {
        JOptionPane.showMessageDialog(null, "One request is already in the queue!!", "Information", JOptionPane.INFORMATION_MESSAGE);
        return;
        }
        }
        
        java.util.Date date = new java.util.Date();
        date = new Timestamp(date.getTime());
        AmbulanceWorkrequest wr = new AmbulanceWorkrequest();
        wr.setPatient(account.getPatient());
        wr.setSender(account);
        wr.setRequestDate(date);
        wr.setStatus("Request Sent");
        NewOrganization org = null;
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof HospitalEnterprise) {
                for (NewOrganization organization : e.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof AmbulanceOrganization) {
                        org = organization;
                        break;
                    }
                }
            }
        }
        account.getAmbulanceWorkQueue().getAmbulanceWorkRequestDir().add(wr);
        org.getAmbulanceWorkQueue().getAmbulanceWorkRequestDir().add(wr);
        populateTable();
    }//GEN-LAST:event_callTheAmbulancejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ambulanceWorkrequestjTable;
    private javax.swing.JButton callTheAmbulancejButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}