
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class ControladorTelaVendas {

    private final TelaVendas visao;

    public ControladorTelaVendas(TelaVendas visao) {
        this.visao = visao;
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
    
    

}
