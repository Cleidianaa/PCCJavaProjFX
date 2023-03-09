import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelos.Entrada;
import Modelos.Produto;
import Modelos.Saida;
import Modelos.Usuario;

public class Database {

    private static String usuarioDB = "root";
    private static String senhaDB = "Qwerty12";

    public Boolean ValidarUsuarioESenha(String usuario, String senha) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE Nome = '" + usuario + "' AND Senha = '" + senha + "'");
            if (!rs.isBeforeFirst()) {
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Usuario ObterUsuario(String nome) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE Nome = '" + nome + "'");
            Usuario usuario = new Usuario();
            while (rs.next()) {
                usuario.Nome = rs.getString("Nome");
                usuario.Senha = rs.getString("Senha");
                usuario.CadastroProduto = rs.getBoolean("CadastroProduto");
                usuario.EntradaMercadoria = rs.getBoolean("EntradaMercadoria");
                usuario.SaidaMercadoria = rs.getBoolean("SaidaMercadoria");
                break;
              }
            con.close();
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean CadastrarUsuario(Usuario user) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Query to retrieve records
            String query = "SELECT * FROM usuarios";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int id = rs.getInt("Id")+1;
            rs.moveToInsertRow();
            rs.updateInt("Id", id);
            rs.updateString("Nome", user.Nome);
            rs.updateString("Senha", user.Senha);
            rs.updateBoolean("CadastroProduto", user.CadastroProduto);
            rs.updateBoolean("EntradaMercadoria", user.EntradaMercadoria);
            rs.updateBoolean("SaidaMercadoria", user.SaidaMercadoria);
            rs.insertRow();
            rs.beforeFirst();
            if (!rs.isBeforeFirst()) {
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean CadastrarProduto(Produto produto) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Query to retrieve records
            String query = "SELECT * FROM produtos";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int id = rs.getInt("Id")+1;
            rs.moveToInsertRow();
            rs.updateInt("Id", id);
            rs.updateString("Codigo", produto.Codigo);
            rs.updateString("Descricao", produto.Descricao);
            rs.updateInt("Quantidade", produto.Quantidade);
            rs.updateDouble("Valor", produto.Valor);
            rs.updateString("Observacoes", produto.Observacoes);
            rs.insertRow();
            rs.beforeFirst();
            if (!rs.isBeforeFirst()) {
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean CadastrarSaida(Saida saida) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Query to retrieve records
            String query = "SELECT * FROM saidas";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int id = rs.getInt("Id")+1;
            rs.moveToInsertRow();
            rs.updateInt("Id", id);
            rs.updateString("CodigoProduto", saida.CodigoProduto);
            rs.updateString("Descricao", saida.Descricao);
            rs.updateInt("Quantidade", saida.Quantidade);
            rs.updateDouble("ValorTotal", saida.ValorTotal);
            rs.updateString("Motivo", saida.Motivo);
            rs.insertRow();
            rs.beforeFirst();
            if (!rs.isBeforeFirst()) {
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean CadastrarEntrada(Entrada entrada) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Query to retrieve records
            String query = "SELECT * FROM entradas";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int id = rs.getInt("Id")+1;
            rs.moveToInsertRow();
            rs.updateInt("Id", id);
            rs.updateString("NumeroFatura", entrada.NumeroFatura);
            rs.updateString("DataFatura", entrada.DataFatura);
            rs.updateString("CodigoProduto", entrada.CodigoProduto);
            rs.updateString("Descricao", entrada.Descricao);
            rs.updateInt("Quantidade", entrada.Quantidade);
            rs.updateDouble("ValorTotal", entrada.ValorTotal);
            rs.insertRow();
            rs.beforeFirst();
            if (!rs.isBeforeFirst()) {
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean AlterarProduto(Produto produto) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            // create the java mysql update preparedstatement
            String query = "UPDATE produtos SET Descricao = ?, Quantidade = ?, Valor = ?, Observacoes = ?, Alterar = ? WHERE Codigo = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, produto.Descricao);
            preparedStmt.setInt(2, produto.Quantidade);
            preparedStmt.setDouble(3, produto.Valor);
            preparedStmt.setString(4, produto.Observacoes);
            preparedStmt.setBoolean(5, false);
            preparedStmt.setString(6, produto.Codigo);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean AlterarQuantidadeProduto(String codigo, Integer quantidade) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            // create the java mysql update preparedstatement
            String query = "UPDATE produtos SET Quantidade = ?, Alterar = ? WHERE Codigo = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, quantidade);
            preparedStmt.setBoolean(2, false);
            preparedStmt.setString(3, codigo);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Produto> ObterProdutos() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");
            List<Produto> produtos = new ArrayList<Produto>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.Codigo = rs.getString("Codigo");
                produto.Descricao = rs.getString("Descricao");
                produto.Quantidade = rs.getInt("Quantidade");
                produto.Valor = rs.getDouble("Valor");
                produto.Observacoes = rs.getString("Observacoes");
                produto.ValorTotal = produto.Valor * produto.Quantidade;
                produtos.add(produto);
              }
            con.close();
            return produtos;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean SetAlterar(String codigo, Boolean alterar) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            // create the java mysql update preparedstatement
            String query = "UPDATE produtos SET Alterar = ? WHERE Codigo = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setBoolean(1, alterar);
            preparedStmt.setString(2, codigo);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Produto ObterProdutoPorAlterar() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos WHERE Alterar = 1");
            Produto produto = new Produto();
            while (rs.next()) {
                produto.Codigo = rs.getString("Codigo");
                produto.Descricao = rs.getString("Descricao");
                produto.Quantidade = rs.getInt("Quantidade");
                produto.Valor = rs.getDouble("Valor");
                produto.Observacoes = rs.getString("Observacoes");
                break;
              }
            con.close();
            return produto;
        } catch (Exception e) {
            return null;
        }
    }

    public Produto ObterProdutoPorCodigo(String codigo) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", usuarioDB, senhaDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos WHERE Codigo = '"+codigo+"'");
            Produto produto = new Produto();
            while (rs.next()) {
                produto.Codigo = rs.getString("Codigo");
                produto.Descricao = rs.getString("Descricao");
                produto.Quantidade = rs.getInt("Quantidade");
                produto.Valor = rs.getDouble("Valor");
                produto.Observacoes = rs.getString("Observacoes");
                break;
              }
            con.close();
            return produto;
        } catch (Exception e) {
            return null;
        }
    }
}
