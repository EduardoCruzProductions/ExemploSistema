
package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ItensVenda;
import modelo.Pessoa;
import modelo.Produto;
import modelo.Venda;

public class VendaDao {
    
    public boolean salvar(Venda venda){
        
        try (Connection con = Conexao.get();) {

            String sql = "insert into venda(data_venda,total_venda, id_pessoa) values(?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prep.setDate(1, new java.sql.Date(venda.getDataVenda().getTime()));
            prep.setDouble(2, venda.getTotalVenda());
            prep.setInt(3, venda.getPessoa().getId());

            prep.executeUpdate();
            
            //obtendo chaves criadas através do auto_increment
            ResultSet rs = prep.getGeneratedKeys();
            
            if(rs.first()){
                venda.setId(rs.getInt(1));
            }else{
                return false;
            }
            
            sql = "insert into itens_venda(valor_total,valor_unitario,quantidade,id_produto,id_venda) values (?,?,?,?,?)";
            prep = con.prepareStatement(sql);
            
            for(ItensVenda iv : venda.getItensVenda()){
            
                prep.setDouble(1, iv.getValorTotal());
                prep.setDouble(2, iv.getValorUnitario());
                prep.setInt(3, iv.getQuantidade());
                prep.setInt(4, iv.getProduto().getId());
                prep.setInt(5, venda.getId());
                prep.execute();
                
            }
            
            return true;
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        
    }
  
    public List<Venda> buscar(){
        
        List<Venda> list = new ArrayList<>();
        
        try (Connection con = Conexao.get();) {

            String sql = "select * from venda";

            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet result = prep.executeQuery();

            while (result.next()) {

                Venda v = new Venda();
                v.setDataVenda(result.getDate("data_venda"));
                v.setTotalVenda(result.getDouble("total_venda"));
                
                sql = "select * from pessoa where id ="+result.getInt("id_pessoa");
                prep = con.prepareStatement(sql);
                
                ResultSet result2 = prep.executeQuery();
                Pessoa p = new Pessoa();
                    
                if(result2.first()){
                    
                    p.setId(result2.getInt("id"));
                    p.setNome(result2.getString("nome"));
                    p.setEmail(result2.getString("email"));
                    p.setIdade(result2.getInt("idade"));
                    
                }
                
                v.setPessoa(p);
                
                sql = "select * from itens_venda where id_venda ="+result.getInt("id");
                prep = con.prepareStatement(sql);
                ResultSet result3 = prep.executeQuery();
                
                List<ItensVenda> itensVenda = new ArrayList<>();
                
                while(result3.next()){
                    ItensVenda iv = new ItensVenda();
                    iv.setId(result3.getInt("id"));
                    iv.setQuantidade(result3.getInt("quantidade"));
                    iv.setValorTotal(result3.getDouble("valor_total"));
                    iv.setValorUnitario(result3.getDouble("valor_unitario"));
                    
                    sql = "select * from produto where id = "+result3.getInt("id_produto");
                    prep = con.prepareStatement(sql);
                    ResultSet result4 = prep.executeQuery();
                    
                    Produto prod = new Produto();
                    if(result4.first()){
                        
                        prod.setId(result4.getInt("id"));
                        prod.setNome(result4.getString("nome"));
                        prod.setPreco(result4.getDouble("preco"));
                        prod.setQuantidadeEstoque(result4.getInt("quantidade_estoque"));
                        
                    }
                    
                    iv.setProduto(prod); 
                    itensVenda.add(iv);
                    
                }
                
                v.setItensVenda(itensVenda);
                
                list.add(v);
                
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return list;
        
    }
    
    public boolean alterar(Venda venda){
        
        try (Connection con = Conexao.get();) {

            String sql = "update venda set "
                    + "data_venda=?,"
                    + "total_venda=?,"
                    + "id_pessoa=? "
                    + "where id =" + venda.getId();

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setDate(1, new java.sql.Date(venda.getDataVenda().getTime()));
            prep.setDouble(2, venda.getTotalVenda());
            prep.setInt(3, venda.getPessoa().getId());

            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        
    }
    
}
