
package forminterno;

import dao.VendaDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ItensVenda;
import modelo.Venda;
import telas.RelatorioItensVenda;

public class RelatorioVenda extends javax.swing.JInternalFrame {

    private List<Venda> listVenda = new ArrayList<>();
    
    public RelatorioVenda() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Relatório de Vendas");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if(evt.getClickCount() == 2){
            
            if(table.getSelectedRow() != -1){
                
                List<ItensVenda> listItensVenda = listVenda.get(table.getSelectedRow()).getItensVenda();
                System.out.println(listItensVenda.size());
                RelatorioItensVenda riv = new RelatorioItensVenda(null, true, listItensVenda);
                riv.setVisible(true);
                
            }
            
        }
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void updateTable(){
        
        DefaultTableModel modelo = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        modelo.addColumn("Data");
        modelo.addColumn("Pessoa");
        modelo.addColumn("Total Venda");
        
        VendaDao vc = new VendaDao();
        listVenda = vc.buscar();
        
        for(Venda v : listVenda){
            
            modelo.addRow(new Object[]{
                
                v.getDataVenda().toString(),
                v.getPessoa().getNome(),
                v.getTotalVenda()
                
            });
            
        }
        
        table.setModel(modelo);
        
    }

}
