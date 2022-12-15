package Modelos;

public class Saida {
    public String CodigoProduto;
    public String Descricao;
    public Integer Quantidade;
    public Double ValorTotal;
    public String Motivo;

    public Saida() {
        super();
    }

    public Saida(String codigoProduto, String descricao, Integer quantidade, Double valorTotal, String motivo) {
        this.CodigoProduto = codigoProduto;
        this.Descricao = descricao;
        this.Quantidade = quantidade;
        this.ValorTotal = valorTotal;
        this.Motivo = motivo;
    }
}
