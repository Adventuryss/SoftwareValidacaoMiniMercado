package model.bean;

/**
 *
 * @author Bruno
 */
public class Produto {
    
    private int cod_estoque;
    private String nome;
    private int quantidade;
    private Double ValorUnitario;
    private String moeda;
    private Double qtdUnidade;
    private String tipoUnidade;

    public int getCod_estoque() {
        return cod_estoque;
    }

    public void setCod_estoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
    
    @Override
    public String toString(){
	return getNome();
}

    /**
     * @return the moeda
     */
    public String getMoeda() {
        return moeda;
    }

    /**
     * @param moeda the moeda to set
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    /**
     * @return the qtdUnidade
     */
    public Double getQtdUnidade() {
        return qtdUnidade;
    }

    /**
     * @param qtdUnidade the qtdUnidade to set
     */
    public void setQtdUnidade(Double qtdUnidade) {
        this.qtdUnidade = qtdUnidade;
    }

    /**
     * @return the tipoUnidade
     */
    public String getTipoUnidade() {
        return tipoUnidade;
    }

    /**
     * @param tipoUnidade the tipoUnidade to set
     */
    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }
}