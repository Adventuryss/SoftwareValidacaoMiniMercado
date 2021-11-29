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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Compra;
import model.bean.ItemCompra;

/**
 *
 * @author Bruno
 */
public class CompraDao {
    
        public void create(Compra c){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Compra (cod_compra, numeroNF, subtotal, total, data_compra) VALUES (?,?,?,?,?)");
            
            stmt.setInt(1, c.getCod_compra());        
            stmt.setString(2, c.getNumeroNF());
            stmt.setDouble(3, c.getSubtotal());
            stmt.setDouble(4, c.getTotal());
            stmt.setString(5, c.getData_compra());

            stmt.executeUpdate(); 

               
           JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
     
        
        public List<Compra> read(){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from compra");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Compra compra = new Compra();
                
                compra.setCod_compra(rs.getInt("cod_compra"));
                compra.setData_compra(rs.getString("data_compra"));
                compra.setNumeroNF(rs.getString("numeroNF"));
                compra.setSubtotal(rs.getDouble("subtotal"));
                compra.setTotal(rs.getDouble("total"));
                
                compras.add(compra);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return compras;
    }
        
        
    public List<Compra> readForDesc(String desc){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<Compra> compras = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from compra where cod_compra LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Compra compra = new Compra();
                
                compra.setCod_compra(rs.getInt("cod_compra"));
                compra.setData_compra(rs.getString("data_compra"));
                compra.setNumeroNF(rs.getString("numeroNF"));
                compra.setSubtotal(rs.getDouble("subtotal"));
                compra.setTotal(rs.getDouble("total"));
                
                compras.add(compra);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return compras;
    }
        
        public void update(Compra c){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update compra SET numeroNF = ?, subtotal = ?, total = ?, data_compra = ? where cod_compra = ?");

            stmt.setString(1, c.getNumeroNF());
            stmt.setDouble(2, c.getSubtotal());
            stmt.setDouble(3, c.getTotal());
            stmt.setString(4, c.getData_compra());
            stmt.setInt(5, c.getCod_compra());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
        public void delete(Compra c){     //deletar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from compra where cod_compra = ?");


            stmt.setInt(1, c.getCod_compra());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
}
