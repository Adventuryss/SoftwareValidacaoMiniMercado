/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Bruno
 */
public class MoedaDao {
    
    public String BuscarValores() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String moedaBanco = ""; 

        try {
            stmt = con.prepareStatement("select moeda from Internacionalizacao");
            rs = stmt.executeQuery();

            while (rs.next()) {
                moedaBanco = rs.getString("moeda");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return moedaBanco;
    }
    
    
        public void update(String currency){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update Internacionalizacao SET moeda = ? where cod_inter = 1");

            stmt.setString(1, currency);
            
            stmt.executeUpdate();
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }    
}