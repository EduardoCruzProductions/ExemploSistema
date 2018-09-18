
package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

public class UsuarioDao {
    
    public Usuario autenticacao(String login, String senha){
        
        Usuario usuario = null;
        try(Connection con = Conexao.get()){
        
            String sql = "SELECT * FROM usuario"
                    + " WHERE login=? and senha=?";
            
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1,login);
            prep.setString(2, senha);
            
            ResultSet result = prep.executeQuery();
            
            if(result.first()){
                
                usuario = new Usuario();
                usuario.setId(result.getInt("id"));
                usuario.setNome(result.getString("nome"));
                usuario.setLogin(login);
                usuario.setSenha(senha);
                return usuario;
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
        
    }  
    
}
