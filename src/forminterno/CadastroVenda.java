package forminterno;

import dao.VendaDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ItensVenda;
import modelo.Pessoa;
import modelo.Venda;
import telas.SeletorPessoa;
import telas.SeletorProduto;

public class CadastroVenda extends javax.swing.JInternalFrame {

    private Pessoa pessoa = new Pessoa();
    private ItensVenda itensVenda = new ItensVenda();
    private List<ItensVenda> listItensVenda = new ArrayList<>();

    public CadastroVenda() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopUpMenu = new javax.swing.JPopupMenu();
        menuRemoverItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        btnBuscarPessoa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNomePessoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarProduto = new javax.swing.JButton();
        btnAdicionar1 = new javax.swing.JButton();

        menuRemoverItem.setText("Remover");
        menuRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverItemActionPerformed(evt);
            }
        });
        tablePopUpMenu.add(menuRemoverItem);

        setClosable(true);
        setIconifiable(true);
        setTitle("Realizar Venda");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Cliente");

        txtNomeProduto.setEditable(false);
        txtNomeProduto.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        btnBuscarPessoa.setText("Buscar");
        btnBuscarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPessoaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Produto");

        txtNomePessoa.setEditable(false);
        txtNomePessoa.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Valor Unitário");

        txtValorUnitario.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        txtQuantidade.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Quantidade");

        txtValorTotal.setEditable(false);
        txtValorTotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Valor total");

        btnBuscarProduto.setText("Buscar");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        btnAdicionar1.setText("Finalizar Venda");
        btnAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNomePessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPessoa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorUnitario)
                            .addComponent(txtQuantidade)
                            .addComponent(txtValorTotal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtNomeProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdicionar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(btnBuscarPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAdicionar1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPessoaActionPerformed
        SeletorPessoa sp = new SeletorPessoa(null, true);
        sp.setVisible(true);
        if (sp.getPessoa() != null) {
            pessoa = sp.getPessoa();
            txtNomePessoa.setText(pessoa.getNome());
        }
    }//GEN-LAST:event_btnBuscarPessoaActionPerformed

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed

        itensVenda = new ItensVenda();

        SeletorProduto sp = new SeletorProduto(null, true);
        sp.setVisible(true);

        if (sp.getProduto() != null) {

            itensVenda.setProduto(sp.getProduto());
            itensVenda.setValorUnitario(itensVenda.getProduto().getPreco());

            txtNomeProduto.setText(itensVenda.getProduto().getNome());
            txtValorUnitario.setText(itensVenda.getValorUnitario() + "");

        }

    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased
        if (itensVenda != null) {
            getQuantidade();
        }

    }//GEN-LAST:event_txtQuantidadeKeyReleased

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        if (itensVenda != null) {

            getQuantidade();

            if (itensVenda.getProduto() != null
                    && itensVenda.getQuantidade() != 0
                    && itensVenda.getValorUnitario() != 0
                    && itensVenda.getValorTotal() != 0) {

                listItensVenda.add(itensVenda);
                updateTable();
                clear();

            } else {
                System.out.println("Preencha todos os campos");
            }

        } else {
            System.out.println("Preencha todos os campos");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        if (evt.getButton() == 3) {
            tablePopUpMenu.show(table, evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_tableMouseClicked

    private void menuRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverItemActionPerformed

        if (table.getSelectedRow() != -1) {

            listItensVenda.remove(table.getSelectedRow());
            updateTable();

        }

    }//GEN-LAST:event_menuRemoverItemActionPerformed

    private void btnAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionar1ActionPerformed
        if (listItensVenda.size() != 0 && pessoa != null) {

            Venda venda = new Venda();
            venda.setDataVenda(null); // tem que arrumar
            venda.setPessoa(pessoa);
            venda.setItensVenda(listItensVenda);
            venda.setTotalVenda(Double.parseDouble(txtTotal.getText()));

            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            venda.setDataVenda(data);

            VendaDao vd = new VendaDao();
            if (vd.salvar(venda)) {
                System.out.println("Cadastro realizado com sucesso!");
                clearAll();
            }else{
                System.err.println("Erro de registro");
            }

        }
    }//GEN-LAST:event_btnAdicionar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAdicionar1;
    private javax.swing.JButton btnBuscarPessoa;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem menuRemoverItem;
    private javax.swing.JTable table;
    private javax.swing.JPopupMenu tablePopUpMenu;
    private javax.swing.JTextField txtNomePessoa;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables

    private void calcularValorTotal() {

        if (itensVenda != null) {

            try {

                double novoValorUnitario = Double.parseDouble(txtValorUnitario.getText());

                if (novoValorUnitario != itensVenda.getValorUnitario()) {
                    itensVenda.setValorUnitario(novoValorUnitario);
                }

                itensVenda.setValorTotal(itensVenda.getValorUnitario() * itensVenda.getQuantidade());
                txtValorTotal.setText(itensVenda.getValorTotal() + "");

            } catch (Exception e) {
                System.err.println("Erro de conversão de valores");
            }

        }

    }

    private void updateTable() {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modelo.addColumn("Nome");
        modelo.addColumn("Preço Unitário");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Preço Total");

        double total = 0;
        for (ItensVenda iv : listItensVenda) {

            modelo.addRow(new Object[]{
                iv.getProduto().getNome(),
                iv.getValorUnitario(),
                iv.getQuantidade(),
                iv.getValorTotal()
            });

            total += iv.getValorTotal();

        }

        table.setModel(modelo);
        txtTotal.setText(total + "");

    }

    private void clear() {

        itensVenda = new ItensVenda();
        txtNomeProduto.setText("");
        txtQuantidade.setText("");
        txtValorTotal.setText("");
        txtValorUnitario.setText("");

    }
    
    private void clearAll(){
        
        clear();
        pessoa = new Pessoa();
        listItensVenda.clear();
        txtNomePessoa.setText("");
        updateTable();
        
    }

    private void getQuantidade() {

        try {

            int quantidade = Integer.parseInt(txtQuantidade.getText());
            itensVenda.setQuantidade(quantidade);
            calcularValorTotal();

        } catch (Exception e) {
            System.err.println("Erro de conversão de valores");
            itensVenda.setQuantidade(0);
        }

    }

}
