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
public class Compra {
    
    private int cod_compra;
    private String numeroNF;
    private Double subtotal;
    private Double total;
    private String data_compra;


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
     * @return the numeroNF
     */
    public String getNumeroNF() {
        return numeroNF;
    }

    /**
     * @param numeroNF the numeroNF to set
     */
    public void setNumeroNF(String numeroNF) {
        this.numeroNF = numeroNF;
    }

    /**
     * @return the subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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
     * @return the data_compra
     */
    public String getData_compra() {
        return data_compra;
    }

    /**
     * @param data_compra the data_compra to set
     */
    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    
    
}
