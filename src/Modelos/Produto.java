package Modelos;

public class Produto {
    public String Codigo;
    public String Descricao;
    public Integer Quantidade;
    public Double Valor;
    public String Observacoes;
    public Double ValorTotal;

    public Produto() {
        super();
    }

    public Produto(String codigo, String descricao, Integer quantidade, Double valor, String observacoes) {
        this.Codigo = codigo;
        this.Descricao = descricao;
        this.Quantidade = quantidade;
        this.Valor = valor;
        this.Observacoes = observacoes;
    }
}
