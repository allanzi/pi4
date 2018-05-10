/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import br.senac.pi3.entidades.EstoqueEntidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class EstoqueDAO extends Conexao{
    
    public List<EstoqueEntidade> todos(Object filialId) {
        List<EstoqueEntidade> estoque = new ArrayList<EstoqueEntidade>();
        
        try {
            String sql = "SELECT * FROM estoque where filial_id = ? ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                EstoqueEntidade estoq = new EstoqueEntidade(
                    resultado.getInt("id"),
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getFloat("valor"),
                    resultado.getString("desenvolvedora"),
                    resultado.getString("plataforma"),
                    resultado.getInt("quantidade")
                );
                
                estoque.add(estoq);
            }
            
            return estoque;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    
    public List<EstoqueEntidade> todosAutoComplete(Object filialId) {
        List<EstoqueEntidade> estoque = new ArrayList<EstoqueEntidade>();
        
        try {
            String sql = "SELECT * FROM estoque where filial_id = ? ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                EstoqueEntidade estoq = new EstoqueEntidade(
                    resultado.getInt("codigo"),
                    resultado.getString("nome")
                );
                
                estoque.add(estoq);
            }
            
            return estoque;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public EstoqueEntidade find(int id) {
        
        try {
            String sql = "SELECT * FROM estoque WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                EstoqueEntidade estoque = new EstoqueEntidade(
                    resultado.getInt("id"),
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getFloat("valor"),
                    resultado.getString("desenvolvedora"),
                    resultado.getString("plataforma"),
                    resultado.getInt("quantidade")
                );
                
                return estoque;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    
    public EstoqueEntidade findWhereCode(int codigo) {
        
        try {
            String sql = "SELECT * FROM estoque WHERE codigo = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, codigo);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                EstoqueEntidade estoque = new EstoqueEntidade(
                    resultado.getInt("id"),
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getFloat("valor"),
                    resultado.getString("desenvolvedora"),
                    resultado.getString("plataforma"),
                    resultado.getInt("quantidade")
                );

                return estoque;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public boolean cadastrar(EstoqueEntidade estoque) {
        try {
            String sql = "INSERT INTO estoque (codigo, nome, valor, desenvolvedora, plataforma, quantidade, filial_id) values(?,?,?,?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setInt(1, estoque.getCodigo());
            comando.setString(2, estoque.getNome());
            comando.setFloat(3, estoque.getValor());
            comando.setString(4, estoque.getDesenvolvedora());
            comando.setString(5, estoque.getPlataforma());
            comando.setInt(6, estoque.getQuantidade());
            comando.setObject(7, estoque.getFilialId());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizar(int id, EstoqueEntidade estoque) {
        try {
            String sql = "UPDATE estoque SET codigo = ?, nome = ?, valor = ?, desenvolvedora = ?, plataforma = ?, quantidade = ? WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setInt(1, estoque.getCodigo());
            comando.setString(2, estoque.getNome());
            comando.setFloat(3, estoque.getValor());
            comando.setString(4, estoque.getDesenvolvedora());
            comando.setString(5, estoque.getPlataforma());
            comando.setInt(6, estoque.getQuantidade());
            comando.setInt(7, id);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizarQtde(int id, int qtde) {
        try {
            String sql = "UPDATE estoque SET quantidade = ? WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            
            comando.setInt(1, qtde);
            comando.setInt(2, id);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    
    public boolean excluir(int estoqueId) {
        try {
            String sql = "DELETE FROM estoque WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, estoqueId);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
}
