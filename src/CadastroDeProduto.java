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


public class CadastroDeProduto {
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
    private TextField txtCodigoProduto;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtObservacoes;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtValorUnt;

    @FXML
    void AcaoSalvarProduto(ActionEvent event) {
        String codigoProduto = txtCodigoProduto.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String quantidade = txtQuantidade.getText().trim();
        String valorUnt = txtValorUnt.getText().trim();
        String observacoes = txtObservacoes.getText().trim();

        if(codigoProduto.isEmpty() || codigoProduto == null){
            JOptionPane.showMessageDialog(null, "Código do Produto é obrigatório!");
            return;
        }

        if(descricao.isEmpty() || descricao == null){
            JOptionPane.showMessageDialog(null, "Descrição é obrigatório!");
            return;
        }

        if(quantidade.isEmpty() || quantidade == null){
            JOptionPane.showMessageDialog(null, "Quantidade é obrigatório!");
            return;
        }else if (!quantidade.matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "Quantidade invalida!");
            return;
        }

        if(valorUnt.isEmpty() || valorUnt == null){
            JOptionPane.showMessageDialog(null, "Valor Unt. é obrigatório!");
            return;
        }
        else if(!isNumeric(valorUnt)){
            JOptionPane.showMessageDialog(null, "Valor Unt. invalido!");
            return;
        }

        if(observacoes.isEmpty() || observacoes == null){
            JOptionPane.showMessageDialog(null, "Observações é obrigatório!");
            return;
        }

        Database database = new Database();
        boolean cadastrado = database.CadastrarProduto(codigoProduto, descricao, quantidade, valorUnt, observacoes);

        if(cadastrado){
            txtCodigoProduto.clear();
            txtDescricao.clear();
            txtQuantidade.clear();
            txtValorUnt.clear();
            txtObservacoes.clear();

            JOptionPane.showMessageDialog(null, "Produto cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
        }
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
        assert btnSalvarCadastro != null : "fx:id=\"btnSalvarCadastro\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";
        assert txtCodigoProduto != null : "fx:id=\"txtCodigoProduto\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";
        assert txtDescricao != null : "fx:id=\"txtDescricao\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";
        assert txtObservacoes != null : "fx:id=\"txtObservacoes\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";
        assert txtQuantidade != null : "fx:id=\"txtQuantidade\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";
        assert txtValorUnt != null : "fx:id=\"txtValorUnt\" was not injected: check your FXML file 'CadastroDeProduto.fxml'.";

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
