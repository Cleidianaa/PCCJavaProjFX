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

public class EntradaDeMercadoria {
    private Stage Palco;
    private Scene Cena;
    private Parent Raiz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSalvarEntrada;

    @FXML
    private Button btnVoltarPaginaInicial;

    @FXML
    private TextField txtCodigoProduto;

    @FXML
    private TextField txtDataFatura;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtNumeroFatura;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtValorTotal;

    @FXML
    void AcaoSalvarEntrada(ActionEvent event) {

    }

    @FXML
    void AcaoVoltarPaginaInicial(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("Listagem2.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }

    @FXML
    void initialize() {
        assert btnSalvarEntrada != null : "fx:id=\"btnSalvarEntrada\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtCodigoProduto != null : "fx:id=\"txtCodigoProduto\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtDataFatura != null : "fx:id=\"txtDataFatura\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtDescricao != null : "fx:id=\"txtDescricao\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtNumeroFatura != null : "fx:id=\"txtNumeroFatura\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtQuantidade != null : "fx:id=\"txtQuantidade\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtValorTotal != null : "fx:id=\"txtValorTotal\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";

    }

}
