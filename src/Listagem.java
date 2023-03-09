import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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
import Modelos.Produto;
import Modelos.Usuario;


public class Listagem {

    private Stage Palco;
    private Scene Cena;
    private Parent Raiz;
    private String Codigo;

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
    private ListView<String> lvCodProduto;

    @FXML
    private ListView<String> lvDescricao;

    @FXML
    private ListView<String> lvQuantidade;

    @FXML
    private ListView<String> lvValor;

    @FXML
    private ListView<String> lvValorTotal;

    @FXML
    void AcaoAlterar(ActionEvent event) throws IOException {
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Usuario user = (Usuario) Palco.getUserData();
        if (user.CadastroProduto) {
            if (Codigo == null || Codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um produto");
            } else {
                Database database = new Database();
                Boolean setado = database.SetAlterar(Codigo, true);
                if (setado) {
                    Raiz = FXMLLoader.load(getClass().getResource("AlteracaoDeProduto.fxml"));
                    Cena = new Scene(Raiz);
                    Palco.setScene(Cena);
                    Palco.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao obter dados do produto " + Codigo);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário: " + user.Nome + " não tem permissão.");
        }
    }

    @FXML
    void AcaoCadastroProduto(ActionEvent event) throws IOException {

        Raiz = FXMLLoader.load(getClass().getResource("CadastroDeProduto.fxml"));
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Usuario user = (Usuario) Palco.getUserData();
        if (user.CadastroProduto) {
            Cena = new Scene(Raiz);
            Palco.setScene(Cena);
            Palco.show();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário: " + user.Nome + " não tem permissão.");
        }
    }

    @FXML
    void AcaoEntradaMercadoria(ActionEvent event) throws IOException {
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Usuario user = (Usuario) Palco.getUserData();
        if (user.EntradaMercadoria) {
            if (Codigo == null || Codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um produto");
            } else {
                Database database = new Database();
                Boolean setado = database.SetAlterar(Codigo, true);
                if (setado) {
                    Raiz = FXMLLoader.load(getClass().getResource("EntradaDeMercadoria.fxml"));
                    Cena = new Scene(Raiz);
                    Palco.setScene(Cena);
                    Palco.show();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário: " + user.Nome + " não tem permissão.");
        }
    }

    @FXML
    void AcaoSaidaMercadoria(ActionEvent event) throws IOException {
        Palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Usuario user = (Usuario) Palco.getUserData();
        if (user.SaidaMercadoria) {
            if (Codigo == null || Codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um produto");
            } else {
                Database database = new Database();
                Boolean setado = database.SetAlterar(Codigo, true);
                if (setado) {
                    Raiz = FXMLLoader.load(getClass().getResource("SaidaDeMercadoria.fxml"));
                    Cena = new Scene(Raiz);
                    Palco.setScene(Cena);
                    Palco.show();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário: " + user.Nome + " não tem permissão.");
        }
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
        PreencherLista();

        assert btnAlterar != null : "fx:id=\"btnAlterar\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert btnCadastroProduto != null : "fx:id=\"btnCadastroProduto\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert btnEntradaMercadoria != null  : "fx:id=\"btnEntradaMercadoria\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert btnImprimir != null : "fx:id=\"btnImprimir\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert btnSaidaMercadoria != null : "fx:id=\"btnSaidaMercadoria\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'Listagem.fxml'.";
        assert btnVoltarPaginaInicial != null : "fx:id=\"btnVoltarPaginaInicial\" was not injected: check your FXML file 'Listagem.fxml'.";

    }

    private void PreencherLista() {
        Database database = new Database();
        List<Produto> produtos = database.ObterProdutos();

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            lvCodProduto.getItems().add(produto.Codigo);
            lvDescricao.getItems().add(produto.Descricao);
            lvQuantidade.getItems().add(produto.Quantidade.toString());
            lvValor.getItems().add(String.format("%.2f", produto.Valor));
            lvValorTotal.getItems().add(String.format("%.2f", produto.ValorTotal));
        }

        lvCodProduto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<Integer> selectedIndices = lvCodProduto.getSelectionModel().getSelectedIndices();
                lvDescricao.getSelectionModel().select(selectedIndices.get(0));
                lvQuantidade.getSelectionModel().select(selectedIndices.get(0));
                lvValor.getSelectionModel().select(selectedIndices.get(0));
                lvValorTotal.getSelectionModel().select(selectedIndices.get(0));
                Codigo = newValue;
            }
        });

        lvDescricao.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<Integer> selectedIndices = lvDescricao.getSelectionModel().getSelectedIndices();
                lvCodProduto.getSelectionModel().select(selectedIndices.get(0));
                lvQuantidade.getSelectionModel().select(selectedIndices.get(0));
                lvValor.getSelectionModel().select(selectedIndices.get(0));
                lvValorTotal.getSelectionModel().select(selectedIndices.get(0));
            }
        });

        lvQuantidade.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<Integer> selectedIndices = lvQuantidade.getSelectionModel().getSelectedIndices();
                lvDescricao.getSelectionModel().select(selectedIndices.get(0));
                lvCodProduto.getSelectionModel().select(selectedIndices.get(0));
                lvValor.getSelectionModel().select(selectedIndices.get(0));
                lvValorTotal.getSelectionModel().select(selectedIndices.get(0));
            }
        });

        lvValor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<Integer> selectedIndices = lvValor.getSelectionModel().getSelectedIndices();
                lvDescricao.getSelectionModel().select(selectedIndices.get(0));
                lvQuantidade.getSelectionModel().select(selectedIndices.get(0));
                lvCodProduto.getSelectionModel().select(selectedIndices.get(0));
                lvValorTotal.getSelectionModel().select(selectedIndices.get(0));
            }
        });

        lvValorTotal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<Integer> selectedIndices = lvValorTotal.getSelectionModel().getSelectedIndices();
                lvDescricao.getSelectionModel().select(selectedIndices.get(0));
                lvQuantidade.getSelectionModel().select(selectedIndices.get(0));
                lvValor.getSelectionModel().select(selectedIndices.get(0));
                lvCodProduto.getSelectionModel().select(selectedIndices.get(0));
            }
        });
    }

}
