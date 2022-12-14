import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PaginaInicial {

    private Stage Palco;

    private Scene Cena;

    private Parent Raiz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConfiguracao;

    @FXML
    private Button btnListagem;

    @FXML
    private Button btnSairSistema;

    @FXML
    void AcaoEntrarConfiguracao(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("CadastroDeUsuario.fxml"));

        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Cena = new Scene(Raiz);

        Palco.setScene(Cena);

        Palco.show();
    }

    @FXML
    void AcaoListagem(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("Listagem2.fxml"));

        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Cena = new Scene(Raiz);

        Palco.setScene(Cena);

        Palco.show();
    }

    @FXML
    void AcaoSair(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Cena = new Scene(Raiz);

        Palco.setScene(Cena);

        Palco.show();
    }

    @FXML
    void initialize() {
        assert btnConfiguracao != null: "fx:id=\"btnConfiguracao\" was not injected: check your FXML file 'PaginaInicial.fxml'.";
        assert btnListagem != null: "fx:id=\"btnListagem\" was not injected: check your FXML file 'PaginaInicial.fxml'.";
        assert btnSairSistema != null: "fx:id=\"btnSairSistema\" was not injected: check your FXML file 'PaginaInicial.fxml'.";

    }

}
