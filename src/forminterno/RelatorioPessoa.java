
package forminterno;

import dao.PessoaDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pessoa;
import telas.AlterarPessoa;

public class RelatorioPessoa extends javax.swing.JInternalFrame {

    private List<Pessoa> listPessoa = new ArrayList<>();
    
    public RelatorioPessoa() {
        initComponents();
        buscarRegistros();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuAcoes = new javax.swing.JPopupMenu();
        itemMenuExcluir = new javax.swing.JMenuItem();
        itemMenuAlterar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        itemMenuExcluir.setText("Excluir");
        itemMenuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuExcluirActionPerformed(evt);
            }
        });
        menuAcoes.add(itemMenuExcluir);

        itemMenuAlterar.setText("Alterar");
        itemMenuAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAlterarActionPerformed(evt);
            }
        });
        menuAcoes.add(itemMenuAlterar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setToolTipText("Relatório de Pessoa");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        if (evt.getButton() == 3) {

            menuAcoes.show(table, evt.getX(), evt.getY());

        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void itemMenuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuExcluirActionPerformed

        int r = JOptionPane.showConfirmDialog(this, "Deseja excluir o item?",
            "Confirmação", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {

                Pessoa p = listPessoa.get(selectedRow);

                PessoaDao pd = new PessoaDao();
                if(pd.excluir(p.getId())){
                    System.out.println("Registro excluido com sucesso!");
                }else{
                    System.err.println("Erro ao excluir o registro!");
                }

                buscarRegistros();
                updateTable();

            }
        }

    }//GEN-LAST:event_itemMenuExcluirActionPerformed

    private void itemMenuAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAlterarActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {

            Pessoa obj = listPessoa.get(selectedRow);
            AlterarPessoa ap = new AlterarPessoa(null,
                true, obj);
            ap.setVisible(true);
            buscarRegistros();
            updateTable();

        }
    }//GEN-LAST:event_itemMenuAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuAlterar;
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

        PessoaDao pd = new PessoaDao();
        listPessoa = pd.buscar();

    }

}
