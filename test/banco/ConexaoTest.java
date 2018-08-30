
package banco;

public class ConexaoTest {
    
    public static void main(String[] args) {
        
        System.out.println(Conexao.status);
        Conexao.get();
        System.out.println(Conexao.status);
        
    }
    
}
