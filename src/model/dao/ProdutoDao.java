package model.dao;

import Connection.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author Bruno
 */
public class ProdutoDao {
    
    public void create(Produto p){    // inserir
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Estoque (nome, quantidade, valorUnitario, qtdUnidade, tipoUnidade) VALUES (?,?,?,?,?)");
            
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getValorUnitario());
            stmt.setDouble(4, p.getQtdUnidade());
            stmt.setString(5, p.getTipoUnidade());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
    
    
    public List<Produto> read(){     // ler a tabela
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from estoque");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setCod_estoque(rs.getInt("cod_estoque"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValorUnitario(rs.getDouble("valorUnitario"));
                produto.setQtdUnidade(rs.getDouble("qtdUnidade"));
                produto.setTipoUnidade(rs.getString("tipoUnidade"));
                produtos.add(produto);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return produtos;
    }
    
       public List<Produto> readForDesc(String desc){
        
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from estoque where nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setCod_estoque(rs.getInt("cod_estoque"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValorUnitario(rs.getDouble("valorUnitario"));
                produto.setQtdUnidade(rs.getDouble("qtdUnidade"));
                produto.setTipoUnidade(rs.getString("tipoUnidade"));
                produtos.add(produto);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return produtos;
    }
    
        public void update(Produto p){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update estoque SET nome = ?, quantidade = ?, valorUnitario = ?, qtdUnidade = ?, tipoUnidade = ? where cod_estoque = ?");

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getValorUnitario());
            stmt.setDouble(4, p.getQtdUnidade());
            stmt.setString(5, p.getTipoUnidade());
            stmt.setInt(6, p.getCod_estoque());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
        public void delete(Produto p){     //deletar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from estoque where cod_estoque = ?");


            stmt.setInt(1, p.getCod_estoque());
            
            stmt.executeUpdate();
               
           JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
        public void updateValor(Float valor, Integer id){      // atualizar
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update estoque SET valorunitario = ? where cod_estoque = ?");

            stmt.setFloat(1, valor);
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
    public Float BuscarValores(Integer id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Float valor = null;

        try {
            stmt = con.prepareStatement("select ValorUnitario from estoque where cod_estoque LIKE ?");
            stmt.setString(1, "%" + id + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                valor = rs.getFloat("ValorUnitario");
                break;
            }


        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return valor;
    }
    
     public void updateMedida(Float valor, Integer id){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update estoque SET qtdUnidade = ? where cod_estoque = ?");

            stmt.setFloat(1, valor);
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
    public String buscarTipoMedida(Integer id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String tipo = "";

        try { 
            stmt = con.prepareStatement("select tipoUnidade from estoque where cod_estoque LIKE ?");
            stmt.setString(1, "%" + id + "%");
            rs = stmt.executeQuery();
  
            while (rs.next()) {
                tipo = rs.getString("tipoUnidade");
                break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return tipo;
    }
    
    public Float buscarMedida(Integer id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Float valor = null;

        try {
            stmt = con.prepareStatement("select qtdUnidade from estoque where cod_estoque LIKE ?");
            stmt.setString(1, "%" + id + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                valor = rs.getFloat("qtdUnidade");
                break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return valor;
    }

     public void updateTipoMedida(String valor, Integer id){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update estoque SET tipoUnidade = ? where cod_estoque = ?");

            stmt.setString(1, valor);
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ex);
        }finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
}