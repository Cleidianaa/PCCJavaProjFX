import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javax.swing.JOptionPane;

public class Listagem2 {
        private Stage Palco;
        private Scene Cena;
        private Parent Raiz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnCadastroProduto;

    @FXML
    private Button btnEntradaMercadoria;

    @FXML
    private Button btnImprimir;

    @FXML
    private Button btnSaidaMercadoria;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnVoltarPaginaInicial;

    @FXML
    private ListView<?> lvCodProduto;

    @FXML
    private ListView<?> lvDescricao;

    @FXML
    private ListView<?> lvQuantidade;

    @FXML
    private ListView<?> lvValor;

    @FXML
    private ListView<?> lvValorTotal;

    @FXML
    void AcaoAlterar(ActionEvent event) {

    }

    @FXML
    void AcaoCadastroProduto(ActionEvent event)  throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("CadastroDeProduto.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }

    @FXML
    void AcaoEntradaMercadoria(ActionEvent event)  throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("EntradaDeMercadoria.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }

    @FXML
    void AcaoImprimir(ActionEvent event) {

    }

    @FXML
    void AcaoSaidaMercadoria(ActionEvent event)  throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("SaidaDeMercadoria.fxml"));
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
    void AcaoVoltarPaginaInicial(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }
    @FXML
    void initialize() {
        JOptionPane.showMessageDialog(null, "Passei aqui!");

        assert btnAlterar != null : "fx:id=\"btnAlterar\" was not injected: check your FXML file 'Listagem2.fxml'.";
        assert btnCadastroProduto != null  : "fx:id=\"btnCadastroProduto\" was not injected: check your FXML file 'Listagem2.fxml'.";
        assert btnEntradaMercadoria != null : "fx:id=\"btnEntradaMercadoria\" was not injected: check your FXML file 'Listagem2.fxml'.";
        assert btnImprimir != null : "fx:id=\"btnImprimir\" was not injected: check your FXML file 'Listagem2.fxml'.";
        assert btnSaidaMercadoria != null : "fx:id=\"btnSaidaMercadoria\" was not injected: check your FXML file 'Listagem2.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'Listagem2.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'Listagem2.fxml'.";

    }

}
