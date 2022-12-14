/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.BehaviorTherapist;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.Animal;
import model.UserAccount.UserAccount;
import model.Enterprise.Enterprise;
import model.Animal.AnimalDirectory;
import model.Organization.TreatmentOrganization;
import model.EcoSystem.EcoSystem;
import model.Enterprise.MedicalCareEnterprise;
import model.Network.Network;
import model.WorkQueue.BTWorkRequest;
import model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
/**
 *
 * @author Yifei Chen
 */
public class BTWorkArea extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private AnimalDirectory animalDirectory;
    private final Enterprise enterprise;
    private final UserAccount userAccount;
    private final EcoSystem ecosystem;
    private Animal animal;
    private final TreatmentOrganization organization;

    
    //Creates new form for bahavior therapist to work 
     
    public BTWorkArea(JPanel userProcessContainer, UserAccount account, TreatmentOrganization organization,
            MedicalCareEnterprise enterprise, Network network, EcoSystem ecosystem) {

        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = (TreatmentOrganization) organization;
        this.enterprise = enterprise;
        
        this.ecosystem = ecosystem;
        
        //search different networks in network list
        
        for (Network net : ecosystem.getNetworkList()) {
            
            for (Enterprise e : net.getEnterpriseDirectory().getEnterpriseList()) {
                
                if (e.equals(enterprise)) {
                    
                    network = net;
                }
            }
        }

        //clean the table
        
        populateTable();
    }

    public void populateTable() {
        
        //create a model for defaulttable
        
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            
            if (request instanceof BTWorkRequest) {
                
                Object[] row = new Object[model.getColumnCount()];
                
                //get information from each row
                
                row[0] = request;
                row[1] = request.getAnimal().getId();
                row[2] = request.getAnimal().getName();
                row[3] = request.getSender();
                row[4] = request.getReceiver() == null ? null : request.getReceiver();
                row[5] = request.getStatus();
                String result = ((BTWorkRequest) request).getResult();
                row[6] = result == null ? "Waiting" : result;
                
                
                //save
                model.addRow(row);
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
        tblWorkRequests = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(155, 209, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Animal ID", "Animal Name", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequests);
        if (tblWorkRequests.getColumnModel().getColumnCount() > 0) {
            tblWorkRequests.getColumnModel().getColumn(4).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 890, 350));

        btnAssign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_assign.png"))); // NOI18N
        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 150, 40));

        btnProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_process.png"))); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 150, 40));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Behavior Therapist Work Area");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed

        //get information from selectedrow
        int selectedRow = tblWorkRequests.getSelectedRow();
        
        //if select a row
        if (selectedRow >= 0) {
            
            WorkRequest request = (WorkRequest) tblWorkRequests.getValueAt(selectedRow, 0);
            
            //if the selected request is processed
            if (request.getStatus().equalsIgnoreCase("Processed")) {
                JOptionPane.showMessageDialog(this, "Request has already been processed.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
                
                //if the selected request was completed
            } else if (request.getStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(this, "Request has already been completed.", "Thank you!", JOptionPane.WARNING_MESSAGE);
                return;
                
            } else {
                request.setReceiver(userAccount);
                request.setStatus("Processed");
                populateTable();
            }

            //if no row selected
        } else {
            JOptionPane.showMessageDialog(this, "You should select a request please.","Warning",JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed

        int selectedRow = tblWorkRequests.getSelectedRow();
        
        //if didn't select a row
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "You should select a row from the table please ","Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //get information from select row
        BTWorkRequest request = (BTWorkRequest) tblWorkRequests.getValueAt(selectedRow, 0);
        
        //if the request is not assigned to you
         if (request.getReceiver() != userAccount) {
             
            JOptionPane.showMessageDialog(this, "This request is not assigned to you.","Warning",
                    
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        BTWorkRequest btwr = (BTWorkRequest) tblWorkRequests.getValueAt(selectedRow, 0);
        
        //if the request you chose have completed
        if (btwr.getStatus().equalsIgnoreCase("Completed")) {
            
            JOptionPane.showMessageDialog(this, "Request already completed,please choose another one.","Warning",
                    
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        BTProcessRequest ppr = new BTProcessRequest(userProcessContainer, request, userAccount, enterprise, animal,
                animalDirectory, ecosystem, organization);
        
        userProcessContainer.add("PharmacistProcessRequest", ppr);
        
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        
        layout.next(userProcessContainer);


    }//GEN-LAST:event_btnProcessActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnProcess;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    // End of variables declaration//GEN-END:variables
}
