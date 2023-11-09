
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {

    private Connection conexao;

    public ProdutosDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirProdutoNoBanco(Connection conexao, ProdutosDTO produto){
     try {

            String sql = "insert into produtos(nome,valor,status) values(?,?,?);";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getValor());
            ps.setString(3, produto.getStatus());
           
            ps.execute();
            ps.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDTO.class.getName()).log(Level.SEVERE, null, ex);

        }   
    }
}
