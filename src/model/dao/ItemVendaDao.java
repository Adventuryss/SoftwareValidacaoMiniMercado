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

/**
 *
 * @author Bruno
 */
public class ItemVendaDao {
    
    
     public void create(ItemVenda iv){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into ItemVenda (cod_itemvenda, valorunitario, quantidade, total, cod_venda, cod_estoque) VALUES (?,?,?,?,?,?)");
            
            stmt.setInt(1, iv.getCod_itemvenda());
            stmt.setDouble(2, iv.getValorunitario());
            stmt.setInt(3, iv.getQuantidade());
            stmt.setDouble(4, iv.getTotal());
            stmt.setInt(5, iv.getCod_venda());
            stmt.setInt(6, iv.getCod_estoque());
            
            stmt.executeUpdate();
               
       //    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
        public List<ItemVenda> read(){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<ItemVenda> ItemVendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from ItemVenda");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ItemVenda itemVenda = new ItemVenda();
                
                itemVenda.setCod_itemvenda(rs.getInt("cod_itemvenda"));
                itemVenda.setValorunitario(rs.getDouble("valorunitario"));
                itemVenda.setQuantidade(rs.getInt("quantidade"));
                itemVenda.setTotal(rs.getDouble("total"));
                itemVenda.setCod_venda(rs.getInt("cod_venda"));
                itemVenda.setCod_estoque(rs.getInt("cod_estoque"));
                
                ItemVendas.add(itemVenda);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return ItemVendas;
    }
        
        
    public List<ItemVenda> readForDesc(String desc){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<ItemVenda> ItemVendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from itemvenda where cod_venda LIKE ?");
            stmt.setString(1, desc);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ItemVenda itemvenda = new ItemVenda();
                
                itemvenda.setCod_itemvenda(rs.getInt("cod_itemvenda"));
                itemvenda.setValorunitario(rs.getDouble("valorunitario"));
                itemvenda.setQuantidade(rs.getInt("quantidade"));
                itemvenda.setTotal(rs.getDouble("total"));
                itemvenda.setCod_venda(rs.getInt("cod_venda"));
                itemvenda.setCod_estoque(rs.getInt("cod_estoque"));
                
                ItemVendas.add(itemvenda);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return ItemVendas;
    }
        
        public void update(ItemVenda iv){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update Itemvenda SET ValorUnitario = ?, Quantidade = ?, Total = ?, cod_venda = ?, cod_estoque = ? where cod_itemvenda = ?");

            stmt.setDouble(1, iv.getValorunitario());
            stmt.setInt(2, iv.getQuantidade());
            stmt.setDouble(3, iv.getTotal());
            stmt.setInt(4, iv.getCod_venda());
            stmt.setInt(5, iv.getCod_estoque());
            stmt.setInt(6, iv.getCod_itemvenda());
            
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
        public void delete(ItemVenda iv){     //deletar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from itemvenda where cod_itemvenda = ?");


            stmt.setInt(1, iv.getCod_itemvenda());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
         
    
}
