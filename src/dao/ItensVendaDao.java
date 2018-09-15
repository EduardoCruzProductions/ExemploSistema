
package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.ItensVenda;

public class ItensVendaDao {
    
    public boolean alterar(ItensVenda iv) {

        try (Connection con = Conexao.get();) {

            String sql = "update itens_venda set "
                    + "valor_total=?,"
                    + "valor_unitario=?,"
                    + "quantidade=?, "
                    + "id_produto=? "
                    + "where id =" + iv.getId();

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setDouble(1, iv.getValorTotal());
            prep.setDouble(2, iv.getValorUnitario());
            prep.setInt(3, iv.getQuantidade());
            prep.setDouble(4, iv.getProduto().getId());

            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }
    
    public boolean excluir(int id) {

        try (Connection con = Conexao.get();) {

            String sql = "delete from itens_venda where id =" + id;

            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }
}
