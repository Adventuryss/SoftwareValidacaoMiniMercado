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




public class ItemCompra {

    /**
     * @return the cod_compra
     */
    public int getCod_compra() {
        return cod_compra;
    }

    /**
     * @param cod_compra the cod_compra to set
     */
    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
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
    
        /**
     * @return the compra
     */
    
    
    
    private int cod_itemcompra;
    private Double valorunitario;
    private int quantidade;
    private Double total;
    private int cod_compra;
    private int cod_estoque;

    /**
     * @return the cod_itemcompra
     */
    public int getCod_itemcompra() {
        return cod_itemcompra;
    }

    /**
     * @param cod_itemcompra the cod_itemcompra to set
     */
    public void setCod_itemcompra(int cod_itemcompra) {
        this.cod_itemcompra = cod_itemcompra;
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

    public void setCod_estoque(String cod_produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the cod_compra
     */


    /**
     * @return the cod_estoque
     */
//    public int getCod_estoque() {
//        return cod_estoque;
//    }
//
//    /**
//     * @param cod_estoque the cod_estoque to set
//     */
//    public void setCod_estoque(int cod_estoque) {
//        this.cod_estoque = cod_estoque;
//    }

}
