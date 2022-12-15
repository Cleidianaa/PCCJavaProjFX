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
import Modelos.*;


public class AlteracaoDeProduto {
    private Stage Palco;
    private Scene Cena;
    private Parent Raiz;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAlterarProduto;

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
    void AcaoAlterarProduto(ActionEvent event) {
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

        Produto produto = new Produto(codigoProduto, descricao, Integer.parseInt(quantidade), Double.parseDouble(valorUnt), observacoes);

        Database database = new Database();
        boolean cadastrado = database.AlterarProduto(produto);

        if(cadastrado){
            JOptionPane.showMessageDialog(null, "Produto alterado!");
        }else{
            JOptionPane.showMessageDialog(null, "Produto não alterado!");
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
        assert btnAlterarProduto != null : "fx:id=\"btnAlterarProduto\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";
        assert txtCodigoProduto != null : "fx:id=\"txtCodigoProduto\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";
        assert txtDescricao != null : "fx:id=\"txtDescricao\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";
        assert txtObservacoes != null : "fx:id=\"txtObservacoes\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";
        assert txtQuantidade != null : "fx:id=\"txtQuantidade\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";
        assert txtValorUnt != null : "fx:id=\"txtValorUnt\" was not injected: check your FXML file 'AlteracaoDeProduto.fxml'.";

        Database database = new Database();
        Produto produto = database.ObterProdutoPorAlterar();

        txtCodigoProduto.setText(produto.Codigo);
        txtDescricao.setText(produto.Descricao);
        txtObservacoes.setText(produto.Observacoes);
        txtQuantidade.setText(produto.Quantidade.toString());
        txtValorUnt.setText(produto.Valor.toString());
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
