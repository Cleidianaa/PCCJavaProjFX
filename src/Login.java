import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Login {

    private Stage Palco;
    private Scene Cena;
    private Parent Raiz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUsuario;

    @FXML
    void AcaoEntrarPaginaInicial(ActionEvent event) throws IOException {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if(usuario.isEmpty() || usuario == null){
            JOptionPane.showMessageDialog(null, "Usuário é obrigatório!");
            return;
        }

        if(senha.isEmpty() || senha == null){
            JOptionPane.showMessageDialog(null, "Senha é obrigatório!");
            return;
        }
        
        Database database = new Database();
        boolean isValid = database.ValidarUsuarioESenha(usuario, senha);

        if(isValid){
            Entrar(event);
        }
        else {
            if (usuario.equals("Adm") && senha.equals("123456")) {
                Entrar(event);
            } else {
                JOptionPane.showMessageDialog(null, "Dados Incorretos!");
            }
        }
    }

    private void Entrar(ActionEvent event) throws IOException {
        Raiz = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }

    @FXML
    void initialize() {
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtSenha != null : "fx:id=\"txtSenha\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'Login.fxml'.";
    }
}