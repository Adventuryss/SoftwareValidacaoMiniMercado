package model.bean;

public class Estoque {

    /**
     * @return the cod_estoque
     */
    public int getCod_estoque() {
        return cod_estoque;
    }

    /**
     * @param cod_estoque the cod_estoque to set
     */
    public void setCod_estoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the ValorUnitario
     */
    public Double getValorUnitario() {
        return ValorUnitario;
    }

    /**
     * @param ValorUnitario the ValorUnitario to set
     */
    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
    
    private int cod_estoque;
    private String nome;
    private String quantidade;
    private Double ValorUnitario;
    
}
