/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AnimalRegistorRole;

import model.EcoSystem.EcoSystem;
import model.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import model.Enterprise.AnimalShelterEnterprise;
import model.Network.Network;
import model.Organization.AnimalRegisterOrganization;

/**
 *
 * @author Jiale Lyu
 */

//animal registor work area jpanel
public class AnimalRegistorWorkAreaJPanel extends javax.swing.JPanel {
    
        private final Network network;
        private final EcoSystem ecosystem;
        private final JPanel workArea;
        private final AnimalRegisterOrganization organization;
        private final AnimalShelterEnterprise enterprise;
        private final UserAccount account;
        
//constractor
    public AnimalRegistorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,  AnimalRegisterOrganization animalRegisterOrganization,AnimalShelterEnterprise animalShelterEnterprise, Network network, EcoSystem ecosystem) {
        initComponents();

        this.workArea = userProcessContainer;
        this.account = account;
        this.network = network;
        this.ecosystem = ecosystem;
        this.organization = animalRegisterOrganization;
        this.enterprise = animalShelterEnterprise;

    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestVolunteerJButton = new javax.swing.JButton();
        registerAnimalJButton = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(155, 209, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestVolunteerJButton.setText("Request Volunteer");
        requestVolunteerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestVolunteerJButtonActionPerformed(evt);
            }
        });
        add(requestVolunteerJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 240, 50));

        registerAnimalJButton.setText("Register Animal");
        registerAnimalJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAnimalJButtonActionPerformed(evt);
            }
        });
        add(registerAnimalJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 240, 50));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Animal Registor Work Area");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestVolunteerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestVolunteerJButtonActionPerformed

        RequestVolunteerJPanel requestVolunteerJPanel = new RequestVolunteerJPanel(workArea, account, organization, enterprise , network, ecosystem);
        workArea.add("requestVolunteerJPanel", requestVolunteerJPanel);

        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);

    }//GEN-LAST:event_requestVolunteerJButtonActionPerformed

    private void registerAnimalJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerAnimalJButtonActionPerformed

        RegistorAnimalJPanel registorAnimalJPanel = new RegistorAnimalJPanel(workArea, account, enterprise);
        workArea.add("registorAnimalJPanel", registorAnimalJPanel);        
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_registerAnimalJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton registerAnimalJButton;
    private javax.swing.JButton requestVolunteerJButton;
    // End of variables declaration//GEN-END:variables
}