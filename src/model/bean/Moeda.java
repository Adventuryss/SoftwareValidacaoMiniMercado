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
public class Moeda {
    private int cod_moeda;
    private String moeda;

    /**
     * @return the cod_moeda
     */
    public int getCod_moeda() {
        return cod_moeda;
    }

    /**
     * @param cod_moeda the cod_moeda to set
     */
    public void setCod_moeda(int cod_moeda) {
        this.cod_moeda = cod_moeda;
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
}
