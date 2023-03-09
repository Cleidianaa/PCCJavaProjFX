import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javax.swing.JOptionPane;
import Modelos.Usuario;
import javafx.scene.control.CheckBox;

public class CadastroUsuario {
    private Stage Palco;
    private Scene Cena;
    private Parent Raiz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSalvarCadastro;

    @FXML
    private Button btnVoltarPaginaInicial;

    @FXML
    private CheckBox cbCadastroProduto;

    @FXML
    private CheckBox cbEntradaMercadoria;

    @FXML
    private CheckBox cbSaidaMercadoria;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUsuario;

    @FXML
    void AcaoSalvarCadastro(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        boolean cadastroProduto = cbCadastroProduto.isSelected();
        boolean entradaMercadoria = cbEntradaMercadoria.isSelected();
        boolean saidaMercadoria = cbSaidaMercadoria.isSelected();

        if(usuario.isEmpty() || usuario == null){
            JOptionPane.showMessageDialog(null, "Usuário é obrigatório!");
            return;
        }

        if(senha.isEmpty() || senha == null){
            JOptionPane.showMessageDialog(null, "Senha é obrigatório!");
            return;
        }

        if(!cadastroProduto && !entradaMercadoria && !saidaMercadoria){
            JOptionPane.showMessageDialog(null, "Ao menos uma permissão é obrigatório!");
            return;
        }

        Usuario user = new Usuario(usuario, senha, cadastroProduto, entradaMercadoria, saidaMercadoria, false);
        Database database = new Database();
        boolean cadastrado = database.CadastrarUsuario(user);

        if(cadastrado){
            txtUsuario.clear();
            txtSenha.clear();
            cbCadastroProduto.setSelected(false);
            cbEntradaMercadoria.setSelected(false);
            cbSaidaMercadoria.setSelected(false);

            JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
        }
    }

    @FXML
    void AcaoVoltarPaginaInicial(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }

    @FXML
    void initialize() {
        assert btnSalvarCadastro != null : "fx:id=\"btnSalvarCadastro\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
        assert txtSenha != null : "fx:id=\"txtSenha\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
        assert cbCadastroProduto != null : "fx:id=\"cbCadastroProduto\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
        assert cbEntradaMercadoria != null : "fx:id=\"cbEntradaMercadoria\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
        assert cbSaidaMercadoria != null : "fx:id=\"cbSaidaMercadoria\" was not injected: check your FXML file 'CadastroDeUsuario.fxml'.";
    }

}
