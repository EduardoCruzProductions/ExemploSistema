
package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ProdutoDao {

    public boolean salvar(Produto produto) {

        try (Connection con = Conexao.get();) {

            String sql = "insert into produto(nome,quantidade_estoque,preco) values(?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getQuantidadeEstoque());
            prep.setDouble(3, produto.getPreco());

            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }
    
    public boolean alterar(Produto produto) {

        try (Connection con = Conexao.get();) {

            String sql = "update produto set "
                    + "nome=?,"
                    + "quantidade_estoque=?,"
                    + "preco=? "
                    + "where id =" + produto.getId();

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getQuantidadeEstoque());
            prep.setDouble(3, produto.getPreco());

            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }
    
    public boolean excluir(int id) {

        try (Connection con = Conexao.get();) {

            String sql = "delete from produto where id =" + id;

            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }
    
    public List<Produto> buscar() {

        List<Produto> list = new ArrayList<>();
        
        try (Connection con = Conexao.get();) {

            String sql = "select * from produto";

            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet result = prep.executeQuery();

            while (result.next()) {

                Produto p = new Produto();
                p.setId(result.getInt("id"));
                p.setNome(result.getString("nome"));
                p.setQuantidadeEstoque(result.getInt("quantidade_estoque"));
                p.setPreco(result.getDouble("preco"));

                list.add(p);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return list;
        
    }
    
}
