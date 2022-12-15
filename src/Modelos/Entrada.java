package Modelos;

public class Entrada {
    public String NumeroFatura;
    public String DataFatura;
    public String CodigoProduto;
    public String Descricao;
    public Integer Quantidade;
    public Double ValorTotal;

    public Entrada() {
        super();
    }

    public Entrada(String numeroFatura, String dataFatura, String codigoProduto, String descricao, Integer quantidade, Double valorTotal) {
        this.NumeroFatura = numeroFatura;
        this.DataFatura = dataFatura;
        this.CodigoProduto = codigoProduto;
        this.Descricao = descricao;
        this.Quantidade = quantidade;
        this.ValorTotal = valorTotal;
    }
}
