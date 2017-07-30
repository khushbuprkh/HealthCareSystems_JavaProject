/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BloodBank;

import Business.BloodBankStores.Blood;
import Business.BloodBankStores.Blood.BloodType;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NewOrganization.OrganizationType;
import java.sql.Timestamp;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushbu
 */
public class AddBloodToInventoryJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private Enterprise enterprise;

    /**
     * Creates new form AddBloodToInventoryJPanel
     */
    public AddBloodToInventoryJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        populateComboBox();
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) bloodjTable.getModel();

        model.setRowCount(0);

        for (Blood blood : enterprise.getBloodDirectory().getBloodDir()) {
            Object row[] = new Object[5];
            row[0] = blood;
            row[1] = blood.getQuantity();
            row[2] = blood.getCollectedOn();
            ((DefaultTableModel) bloodjTable.getModel()).addRow(row);
        }
    }

    private void populateComboBox() {
        bloodTypeJComboBox.removeAllItems();
        for (BloodType type : Blood.BloodType.values()) {
            bloodTypeJComboBox.addItem(type);
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
        bloodjTable = new javax.swing.JTable();
        bloodTypeJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        quantityjTextField = new javax.swing.JTextField();
        addjButton = new javax.swing.JButton();

        bloodjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Type", "Quantity", "Collected On"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bloodjTable);
        if (bloodjTable.getColumnModel().getColumnCount() > 0) {
            bloodjTable.getColumnModel().getColumn(0).setResizable(false);
            bloodjTable.getColumnModel().getColumn(1).setResizable(false);
            bloodjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        bloodTypeJComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bloodTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Blood Type");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Quantity");

        quantityjTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        addjButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addjButton.setText("ADD");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(quantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(addjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(bloodTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(quantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(addjButton)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(bloodTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(191, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed
        // TODO add your handling code here:
 
        java.util.Date date = new java.util.Date();
                    date = new Timestamp(date.getTime());
                    BloodType type= (BloodType)bloodTypeJComboBox.getSelectedItem();
                    Blood addnew = enterprise.getBloodDirectory().addBlood(type);
                    addnew.setQuantity(Integer.parseInt(quantityjTextField.getText()));
                    addnew.setCollectedOn(date);
                    populateTable();
        
    }//GEN-LAST:event_addjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addjButton;
    private javax.swing.JComboBox bloodTypeJComboBox;
    private javax.swing.JTable bloodjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField quantityjTextField;
    // End of variables declaration//GEN-END:variables
}