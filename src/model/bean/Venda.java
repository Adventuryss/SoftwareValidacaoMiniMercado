
package model.bean;



/**
 *
 * @author Bruno
 */
public class Venda {

    /**
     * @return the itemvendas
     */

    private int cod_venda;
    private String numeroNF;
    private Double subtotal;
    private Double total;
    private String data_venda;
    //private ArrayList<ItemVenda> itemvendas = new ArrayList<ItemVenda>();
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
     * @return the data_venda
     */
    public String getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }


    
}
