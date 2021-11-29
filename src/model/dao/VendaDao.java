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
import model.bean.ItemVenda;
import model.bean.Venda;

/**
 *
 * @author Bruno
 */
public class VendaDao {
    
    
    public void create(Venda v){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Venda (cod_venda, numeroNF, subtotal, total, data_venda) VALUES (?,?,?,?,?)");
            
            stmt.setInt(1, v.getCod_venda());
            stmt.setString(2, v.getNumeroNF());
            stmt.setDouble(3, v.getSubtotal());
            stmt.setDouble(4, v.getTotal());
            stmt.setString(5, v.getData_venda());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
        public List<Venda> read(){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from venda");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Venda venda = new Venda();
                
                venda.setCod_venda(rs.getInt("cod_venda"));
                venda.setData_venda(rs.getString("data_venda"));
                venda.setNumeroNF(rs.getString("numeroNF"));
                venda.setSubtotal(rs.getDouble("subtotal"));
                venda.setTotal(rs.getDouble("total"));
                
                vendas.add(venda);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return vendas;
    }
             
        
    public List<Venda> readForDesc(String desc){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<Venda> Vendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from venda where cod_venda LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Venda venda = new Venda();
                
                venda.setCod_venda(rs.getInt("cod_venda"));
                venda.setData_venda(rs.getString("data_venda"));
                venda.setNumeroNF(rs.getString("numeroNF"));
                venda.setSubtotal(rs.getDouble("subtotal"));
                venda.setTotal(rs.getDouble("total"));
                
                Vendas.add(venda);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return Vendas;
    }
        
        public void update(Venda v){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update venda SET numeroNF = ?, subtotal = ?, total = ?, data_venda = ? where cod_venda = ?");

            stmt.setString(1, v.getNumeroNF());
            stmt.setDouble(2, v.getSubtotal());
            stmt.setDouble(3, v.getTotal());
            stmt.setString(4, v.getData_venda());
            stmt.setInt(5, v.getCod_venda());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
        public void delete(Venda v){     //deletar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from venda where cod_venda = ?");


            stmt.setInt(1, v.getCod_venda());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
      
    
}
