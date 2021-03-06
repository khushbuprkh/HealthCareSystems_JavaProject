/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SysadminReports;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.LabTestList.LabTest;
import Business.Network.Network;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushbu
 */
public class MostPopularTestJPanel extends javax.swing.JPanel {

    private JPanel sysAdminContainer;
    private EcoSystem system;

    /**
     * Creates new form MostPopularTestJPanel
     */
    public MostPopularTestJPanel(JPanel sysAdminContainer, EcoSystem system) {
        initComponents();
        this.sysAdminContainer = sysAdminContainer;
        this.system = system;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) mostPopularTestjTable.getModel();
        dtm.setRowCount(0);
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                Collections.sort(ent.getLabTestDirectory().getLabTestDir());

                int i = 0;
                for (LabTest test : ent.getLabTestDirectory().getLabTestDir()) {
                    Object row[] = new Object[4];
                    row[0] = test;
                    row[1] = test.getTestcount();
                    row[2] = test.getPrice();
                    row[3] = test.getDescription();
                    dtm.addRow(row);
                    i++;
                    if (i == 1) {
                        break;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostPopularTestjTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Most Popular Test");

        mostPopularTestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test", "Test Count", "Test Price", "Test Desc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mostPopularTestjTable);
        if (mostPopularTestjTable.getColumnModel().getColumnCount() > 0) {
            mostPopularTestjTable.getColumnModel().getColumn(0).setResizable(false);
            mostPopularTestjTable.getColumnModel().getColumn(1).setResizable(false);
            mostPopularTestjTable.getColumnModel().getColumn(2).setResizable(false);
            mostPopularTestjTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mostPopularTestjTable;
    // End of variables declaration//GEN-END:variables
}
