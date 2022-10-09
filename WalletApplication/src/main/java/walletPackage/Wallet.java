package walletPackage;


import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Wallet extends javax.swing.JFrame {
    
    Connection conn;
    String uname= JOptionPane.showInputDialog(this, "Enter same username again: ", "Account Holder", JOptionPane.PLAIN_MESSAGE);
    
    public Wallet() throws SQLException {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletapp","root","");
            
            PreparedStatement pst = conn.prepareStatement("select * from logininfo where username=?");
            pst.setString(1, uname);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)  infoTable.getModel();
            while(rs.next()) {
                model.addRow(new String[]{rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        walletLabel = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        withdrawButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        walletLabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        walletLabel.setText("Your Wallet Application");

        depositButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        withdrawButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        infoTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Account Holder", "Bank Name", "Account Number", "Current Balance"
            }
        ));
        jScrollPane1.setViewportView(infoTable);

        exitButton.setBackground(new java.awt.Color(255, 102, 102));
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setLabel("EXIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(walletLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(exitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(walletLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(exitButton)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletapp","root","");
            
            PreparedStatement pst = conn.prepareStatement("select * from logininfo where username=?");
            pst.setString(1, uname);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                String accHolder = rs.getString("username");
                String accNumber = rs.getString("account_number");
                double balance = rs.getDouble("balance_current");
               
                Account acc = new Account(accHolder, accNumber, balance);
                String amountString = JOptionPane.showInputDialog(this, "Enter an amount to deposit: ", "Deposit", JOptionPane.PLAIN_MESSAGE);
                double amount = Double.parseDouble(amountString);
                acc.deposit(amount);
                double value = acc.getBalance();
                
                String query = "update logininfo set balance_current=? where username=?";
                ps = conn.prepareStatement(query);
                ps.setDouble(1, value);
                ps.setString(2, uname);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(this,"Successfully Updated to "+value,"Deposited",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_depositButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletapp","root","");
            
            PreparedStatement pst = conn.prepareStatement("select * from logininfo where username=?");
            pst.setString(1, uname);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                String accHolder = rs.getString("username");
                String accNumber = rs.getString("account_number");
                double balance = rs.getDouble("balance_current");
               
                Account acc = new Account(accHolder, accNumber, balance);
                String amountString = JOptionPane.showInputDialog(this, "Enter the amount to withdraw: ", "Withdraw", JOptionPane.PLAIN_MESSAGE);
                double amount = Double.parseDouble(amountString);
                acc.withdraw(amount);
                
                double value = acc.getBalance();
                
                String query = "update logininfo set balance_current=? where username=?";
                ps = conn.prepareStatement(query);
                ps.setDouble(1, value);
                ps.setString(2, uname);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(this,"Successfully Updated.\nCurrent Balance = "+value,"Withdrawn",JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_withdrawButtonActionPerformed

    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Wallet().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton depositButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTable infoTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel walletLabel;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
