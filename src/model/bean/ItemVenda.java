/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;



/**
 *
 * @author Bruno
 */
public class ItemVenda {

    /**
     * @return the venda
     */

    private int cod_itemvenda;
    private Double valorunitario;
    private int quantidade;
    private Double total;
    private int cod_venda;
    private int cod_estoque;

    

    /**
     * @return the cod_itemvenda
     */
    public int getCod_itemvenda() {
        return cod_itemvenda;
    }

    /**
     * @param cod_itemvenda the cod_itemvenda to set
     */
    public void setCod_itemvenda(int cod_itemvenda) {
        this.cod_itemvenda = cod_itemvenda;
    }

    /**
     * @return the valorunitario
     */
    public Double getValorunitario() {
        return valorunitario;
    }

    /**
     * @param valorunitario the valorunitario to set
     */
    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the cod_venda
     */
    public int getCod_venda() {
        return cod_venda;
   }

    /**
     * @param cod_venda the cod_venda to set
     */
    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

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

}

