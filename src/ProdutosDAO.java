
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    private Connection conexao;

    public ProdutosDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirProdutoNoBanco(Connection conexao, ProdutosDTO produto) {
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

    public ArrayList<ProdutosDTO> listaTodosProdutos(Connection conexao) {
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();
        String sql = "select * from produtos;";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                // Extrair informações do ResultSet e criar objetos Produtos
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String valor = rs.getString("valor");
                String status = rs.getString("status");
                ProdutosDTO produtosDTO = new ProdutosDTO(id, nome, valor, status);
                produtos.add(produtosDTO);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha no sql!");
        }

        return produtos;

    }

}
