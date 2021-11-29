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
import model.bean.ItemCompra;

/**
 *
 * @author Bruno
 */
public class ItemCompraDao {
        public void create(ItemCompra ic){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into ItemCompra (cod_itemcompra, valorunitario, quantidade, total, cod_compra, cod_estoque) VALUES (?,?,?,?,?,?)");
            
            stmt.setInt(1, ic.getCod_itemcompra());
            stmt.setDouble(2, ic.getValorunitario());
            stmt.setInt(3, ic.getQuantidade());
            stmt.setDouble(4, ic.getTotal());
            stmt.setInt(5, ic.getCod_compra());
            stmt.setInt(6, ic.getCod_estoque());
            
            stmt.executeUpdate();
               
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
        public List<ItemCompra> read(){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<ItemCompra> ItemCompras = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from ItemCompra");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ItemCompra itemCompra = new ItemCompra();
                
                itemCompra.setCod_itemcompra(rs.getInt("cod_itemcompra"));
                itemCompra.setValorunitario(rs.getDouble("valorunitario"));
                itemCompra.setQuantidade(rs.getInt("quantidade"));
                itemCompra.setTotal(rs.getDouble("total"));
               // itemCompra.setCod_compra(rs.getInt("cod_compra"));
             //   itemCompra.setCod_estoque(rs.getInt("cod_estoque"));
                
                ItemCompras.add(itemCompra);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return ItemCompras;
    }
        
        
    public List<ItemCompra> readForDesc(String desc){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<ItemCompra> ItemCompras = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from ItemCompra where cod_compra LIKE ?");
            stmt.setString(1, desc);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ItemCompra itemCompra = new ItemCompra();
                
                itemCompra.setCod_itemcompra(rs.getInt("cod_itemcompra"));
                itemCompra.setValorunitario(rs.getDouble("valorunitario"));
                itemCompra.setQuantidade(rs.getInt("quantidade"));
                itemCompra.setTotal(rs.getDouble("total"));
                itemCompra.setCod_compra(rs.getInt("cod_compra"));
                itemCompra.setCod_estoque(rs.getInt("cod_estoque"));
                
                ItemCompras.add(itemCompra);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return ItemCompras;
    }
        
        public void update(ItemCompra ic){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update ItemCompra SET ValorUnitario = ?, total = ?, Quantidade = ?, cod_compra = ?, cod_estoque = ? where cod_itemcompra = ?");

            stmt.setDouble(1, ic.getValorunitario());
            stmt.setDouble(2, ic.getTotal());
            stmt.setInt(3, ic.getQuantidade());
            stmt.setInt(4, ic.getCod_compra());
            stmt.setInt(5, ic.getCod_estoque());
            stmt.setInt(6, ic.getCod_itemcompra());
            
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
        public void delete(ItemCompra ic){     //deletar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from ItemCompra where cod_itemcompra = ?");


            stmt.setInt(1, ic.getCod_itemcompra());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
}
