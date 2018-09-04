package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;

public class PessoaDao {

    public boolean salvar(Pessoa pessoa) {

        try (Connection con = Conexao.get();) {

            String sql = "insert into pessoa(nome,idade,email) values(?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, pessoa.getNome());
            prep.setInt(2, pessoa.getIdade());
            prep.setString(3, pessoa.getEmail());

            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }

    public boolean alterar(Pessoa novaPessoa) {

        try (Connection con = Conexao.get();) {

            String sql = "update pessoa set "
                    + "nome=?,"
                    + "idade=?,"
                    + "email=? "
                    + "where id =" + novaPessoa.getId();

            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, novaPessoa.getNome());
            prep.setInt(2, novaPessoa.getIdade());
            prep.setString(3, novaPessoa.getEmail());
            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }

    public boolean excluir(int id) {

        try (Connection con = Conexao.get();) {

            String sql = "delete from pessoa where id =" + id;

            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();

            return true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }

    }

    public List<Pessoa> buscar() {

        List<Pessoa> list = new ArrayList<>();
        
        try (Connection con = Conexao.get();) {

            String sql = "select * from pessoa";

            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet result = prep.executeQuery();

            while (result.next()) {

                Pessoa p = new Pessoa();
                p.setId(result.getInt("id"));
                p.setNome(result.getString("nome"));
                p.setIdade(result.getInt("idade"));
                p.setEmail(result.getString("email"));

                list.add(p);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return list;
        
    }

}
