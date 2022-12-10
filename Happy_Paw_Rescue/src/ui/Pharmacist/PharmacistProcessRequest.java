package ui.Pharmacist;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Animal.Animal;
import model.Animal.AnimalDirectory;
import model.EcoSystem.EcoSystem;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.TreatmentOrganization;
import model.UserAccount.UserAccount;
import model.WorkQueue.PharmacistWorkRequest;


/**
 *
 * @author Yifei Chen
 */
public class PharmacistProcessRequest extends javax.swing.JPanel {

    private final UserAccount userAccount;
    private final JPanel userProcessContainer;
    private final EcoSystem ecoSystem;
    Network network;
    private final TreatmentOrganization treatmentOrganization;
    PharmacistWorkRequest request;
    private final Animal animal;
    private final Enterprise enterprise;
   

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public PharmacistProcessRequest(JPanel userProcessContainer, PharmacistWorkRequest request, UserAccount userAccount,
            Enterprise enterprise,Animal animal, AnimalDirectory animalDirectory, EcoSystem ecoSystem, TreatmentOrganization treatmentOrganization) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        
        this.animal = request.getAnimal();
   
        this.ecoSystem = ecoSystem;
        this.treatmentOrganization = treatmentOrganization;
        
        //traverse network in networklist
        for (Network net : ecoSystem.getNetworkList()) {
            
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                
                if (ent.equals(enterprise)) {
                    
                    network = net;
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

        btnSubmit = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        txtResults = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(155, 209, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_reply.png"))); // NOI18N
        btnSubmit.setText("Submit Result");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 160, 40));

        lblResult.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblResult.setText("Result:");
        add(lblResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));
        add(txtResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 440, 40));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Result Submission");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        //bace to another form
        userProcessContainer.remove(this);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        
        //validation
        //if no message
       if (txtResults.getText().isEmpty()) {
           
            JOptionPane.showMessageDialog(this, "Please enter some message","Warning",
                    JOptionPane.WARNING_MESSAGE);
            
        } else {
           //complete the pharamacist request
            animal.setPharmacyMessage(txtResults.getText());
            
            request.setStatus("Completed");
            
            request.setResult(txtResults.getText());
            
            JOptionPane.showMessageDialog(this, "Request is completed !", 
                    "Thank you!", JOptionPane.INFORMATION_MESSAGE);
            

            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            
            userProcessContainer.add("BTWorkArea", new PharmacistWorkArea(userProcessContainer, 
                    userAccount, treatmentOrganization, enterprise, network, ecoSystem));
            
            layout.next(userProcessContainer);
            
       }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtResults;
    // End of variables declaration//GEN-END:variables
}