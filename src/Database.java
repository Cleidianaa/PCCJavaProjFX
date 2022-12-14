import java.sql.*;

public class Database {
    public boolean ValidarUsuarioESenha(String usuario, String senha) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", "root", "Qwerty12");
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

    public boolean CadastrarUsuario(String usuario, String senha, boolean cadastroProduto, boolean entradaMercadoria,
            boolean saidaMercadoria) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", "root", "Qwerty12");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Query to retrieve records
            String query = "SELECT * FROM usuarios";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int id = rs.getInt("Id")+1;
            rs.moveToInsertRow();
            rs.updateInt("Id", id);
            rs.updateString("Nome", usuario);
            rs.updateString("Senha", senha);
            rs.updateBoolean("CadastroProduto", cadastroProduto);
            rs.updateBoolean("EntradaMercadoria", entradaMercadoria);
            rs.updateBoolean("SaidaMercadoria", saidaMercadoria);
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

    public boolean CadastrarProduto(String codigoProduto, String descricao, String quantidade, String valorUnt,
    String observacoes) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pccjavaprojfx", "root", "Qwerty12");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Query to retrieve records
            String query = "SELECT * FROM produtos";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            int id = rs.getInt("Id")+1;
            rs.moveToInsertRow();
            rs.updateInt("Id", id);
            rs.updateString("Codigo", codigoProduto);
            rs.updateString("Descricao", descricao);
            rs.updateInt("Quantidade", Integer.parseInt(quantidade));
            rs.updateDouble("Valor", Double.parseDouble(valorUnt));
            rs.updateString("Observacoes", observacoes);
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
}
