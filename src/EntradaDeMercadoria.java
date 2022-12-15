import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private DatePicker dtDataFatura;

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
        String numeroFatura = txtNumeroFatura.getText().trim();
        String dataFatura = dtDataFatura.getValue().toString();
        String codigoProduto = txtCodigoProduto.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String quantidade = txtQuantidade.getText().trim();
        String valorTotal = txtValorTotal.getText().trim();

        if(numeroFatura.isEmpty() || numeroFatura == null){
            JOptionPane.showMessageDialog(null, "Numero de Fatura é obrigatório!");
            return;
        }

        if(dataFatura.isEmpty() || dataFatura == null){
            JOptionPane.showMessageDialog(null, "Data da Fatura é obrigatório!");
            return;
        }

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

        if(valorTotal.isEmpty() || valorTotal == null){
            JOptionPane.showMessageDialog(null, "Valor Total é obrigatório!");
            return;
        }
        else if(!isNumeric(valorTotal)){
            JOptionPane.showMessageDialog(null, "Valor Total invalido!");
            return;
        }

        Entrada entrada = new Entrada(numeroFatura, dataFatura, codigoProduto, descricao, Integer.parseInt(quantidade), Double.parseDouble(valorTotal));

        Database database = new Database();
        boolean cadastradoEntrada = database.CadastrarEntrada(entrada);

        Produto produto = database.ObterProdutoPorCodigo(entrada.CodigoProduto);
        boolean alteradoProduto = database.AlterarQuantidadeProduto(entrada.CodigoProduto, (produto.Quantidade + entrada.Quantidade));

        if(alteradoProduto && cadastradoEntrada){
            txtNumeroFatura.clear();
            dtDataFatura.getEditor().clear();
            txtQuantidade.clear();
            txtValorTotal.clear();

            JOptionPane.showMessageDialog(null, "Entrada cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null, "Entrada não cadastrado!");
        }
    }

    @FXML
    void AcaoVoltarPaginaInicial(ActionEvent event) throws IOException {
        Database database = new Database();
        database.SetAlterar(txtCodigoProduto.getText(), false);

        Raiz = FXMLLoader.load(getClass().getResource("Listagem.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Cena = new Scene(Raiz);
        Palco.setScene(Cena);
        Palco.show();
    }

    @FXML
    void initialize() {
        assert btnSalvarEntrada != null : "fx:id=\"btnSalvarEntrada\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert dtDataFatura != null : "fx:id=\"dtDataFatura\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtCodigoProduto != null : "fx:id=\"txtCodigoProduto\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtDescricao != null : "fx:id=\"txtDescricao\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtNumeroFatura != null : "fx:id=\"txtNumeroFatura\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtQuantidade != null : "fx:id=\"txtQuantidade\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";
        assert txtValorTotal != null : "fx:id=\"txtValorTotal\" was not injected: check your FXML file 'EntradaDeMercadoria.fxml'.";

        Database database = new Database();
        Produto produto = database.ObterProdutoPorAlterar();

        txtCodigoProduto.setText(produto.Codigo);
        txtDescricao.setText(produto.Descricao);
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