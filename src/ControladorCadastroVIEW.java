
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kauan
 */
public class ControladorCadastroVIEW {

    private final cadastroVIEW visao;

    public ControladorCadastroVIEW(cadastroVIEW visao) {
        this.visao = visao;
    }

    public ProdutosDTO construirProduto() {
        ProdutosDTO produto = null;
        String nome = visao.getCadastroNome().getText();
        String valor = visao.getCadastroValor().getText();
        String status = "A venda";

        produto = new ProdutosDTO(nome, valor, status);

        return produto;
    }

    public void inserirProdutoNoBanco() {
        ProdutosDTO produto = this.construirProduto();
        try {

            Connection conexao = new conectaDAO().getConnection();
            ProdutosDAO produtoDAO = new ProdutosDAO(conexao);
            produtoDAO.inserirProdutoNoBanco(conexao, produto);
            JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO! NADA FOI CADASTRADO!");
            Logger.getLogger(ControladorCadastroVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
