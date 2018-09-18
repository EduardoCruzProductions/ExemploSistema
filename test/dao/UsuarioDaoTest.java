
package dao;

import modelo.Usuario;

public class UsuarioDaoTest {
    
    public static void main(String[] args) {
        
        String login = "admin";
        String senha = "12345";
        
        UsuarioDao ud = new UsuarioDao();
        Usuario usuario = ud.autenticacao(login, senha);
        
        if(usuario != null){
            System.out.println(usuario.getNome());
        }else{
            System.err.println("Erro de autenticacao!");
        }
        
    }
    
}
