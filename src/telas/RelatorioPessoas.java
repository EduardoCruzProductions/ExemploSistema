package telas;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Pessoa;

public class RelatorioPessoas extends javax.swing.JFrame {

    private List<Pessoa> listPessoa = new ArrayList<>();

    public RelatorioPessoas() {
        initComponents();
        buscarRegistros();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuAcoes = new javax.swing.JPopupMenu();
        itemMenuExcluir = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        itemMenuExcluir.setText("Excluir");
        itemMenuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuExcluirActionPerformed(evt);
            }
        });
        menuAcoes.add(itemMenuExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
        if(evt.getButton() == 3){
            
            menuAcoes.show(table, evt.getX(), evt.getY());
            
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void itemMenuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuExcluirActionPerformed
        
        int selectedRow = table.getSelectedRow();
        if(selectedRow >= 0){
            
            Pessoa p = listPessoa.get(selectedRow);
            
            Connection con = Conexao.get();
            String sql = "delete from pessoa where id ="+p.getId();
            
            try{
                
                PreparedStatement prep = con.prepareStatement(sql);
                prep.execute();
                buscarRegistros();
                updateTable();
                
            }catch(SQLException sqle){
                sqle.printStackTrace();
            }
            
        }
        
    }//GEN-LAST:event_itemMenuExcluirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioPessoas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuAcoes;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };

        modelo.addColumn("Nome");
        modelo.addColumn("Idade");
        modelo.addColumn("Email");

        for (Pessoa p : listPessoa) {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getIdade(),
                p.getEmail()
            });
        }

        table.setModel(modelo);

    }

    private void buscarRegistros() {

        Connection con = Conexao.get();
        String sql = "select * from pessoa";

        try {
            
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet result = prep.executeQuery();
            
            listPessoa.clear();
            while(result.next()){
                
                Pessoa p = new Pessoa();
                p.setId(result.getInt("id"));
                p.setNome(result.getString("nome"));
                p.setIdade(result.getInt("idade"));
                p.setEmail(result.getString("email"));
                
                listPessoa.add(p);
            }
            
        } catch (SQLException sqle) {

        }

    }

}
