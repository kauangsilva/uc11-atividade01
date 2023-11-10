
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class ControladorListagemVIEW {

    private final listagemVIEW visao;

    public ControladorListagemVIEW(listagemVIEW visao) {
        this.visao = visao;
    }

    public DefaultTableModel criaModeloTabela(ArrayList<ProdutosDTO> produtos) {

        //cria a matriz com os dados
        Object[][] df = new Object[produtos.size()][4];

        //preenche a matriz
        for (int i = 0; i < produtos.size(); i++) {
            ProdutosDTO produto = produtos.get(i);
            df[i][0] = produto.getId();
            df[i][1] = produto.getNome();
            df[i][2] = produto.getValor();
            df[i][3] = produto.getStatus();

        }
        //cria o modelo da tabela com os dados
        String[] colunaNomes = {"id", "nome", "valor", "status"};
        DefaultTableModel modeloTabela = new DefaultTableModel(df, colunaNomes);

        return modeloTabela;

    }

    public Connection criaConexaoComBancoDados() {
        Connection conexao = null;
        try {
            conexao = new conectaDAO().getConnection();

        } catch (SQLException ex) {
            Logger.getLogger(ControladorListagemVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexao;
    }
    
    public void exibeModeloNaTabela(){
        Connection conexao = this.criaConexaoComBancoDados();
        ProdutosDAO produtosDAO = new ProdutosDAO(conexao);
        ArrayList<ProdutosDTO> produtos = produtosDAO.listaTodosProdutos(conexao);
        DefaultTableModel modeloTabela = this.criaModeloTabela(produtos);
        visao.getListaProdutos().setModel(modeloTabela);
        
    }
    
    public void venderProduto(){
        
        String status = "vendido";
        String id = visao.getId_produto_venda().getText();
        int idInt = Integer.valueOf(id);
        ProdutosDTO produto = new ProdutosDTO(idInt,status);
        
        Connection conexao = this.criaConexaoComBancoDados();
        
        ProdutosDAO produtosDAO  = new  ProdutosDAO(conexao);
        
        produtosDAO.atualizarProduto(conexao, produto);
        
        
    }

}
