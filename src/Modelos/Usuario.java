package Modelos;

public class Usuario {
    public String Nome;
    public String Senha;
    public boolean CadastroProduto;
    public boolean EntradaMercadoria;
    public boolean SaidaMercadoria;
    public boolean Admin;

    public Produto Produto;

    public Usuario() {
        super();
    }

    public Usuario(String usuario, String senha, boolean cadastroProduto, boolean entradaMercadoria,
    boolean saidaMercadoria, boolean admin)
    {
        this.Nome = usuario;
        this.Senha = senha;
        this.CadastroProduto = cadastroProduto;
        this.EntradaMercadoria = entradaMercadoria;
        this.SaidaMercadoria = saidaMercadoria;
        this.Admin = admin;
    }
}
