/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import br.senac.pi3.entidades.SuporteEntidade;
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
public class SuporteDAO extends Conexao{
    
    public List<SuporteEntidade> todos() {
        List<SuporteEntidade> suporte = new ArrayList<SuporteEntidade>();
        
        try {
            String sql = "SELECT * FROM suporte ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                SuporteEntidade suporte1 = new SuporteEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone")    
                );
                
                suporte.add(suporte1);
            }
            
            return suporte;
            
        } catch (SQLException ex) {
            Logger.getLogger(SuporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public SuporteEntidade find(int id) {
        
        try {
            String sql = "SELECT * FROM suporte WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                SuporteEntidade suporte = new SuporteEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone")
                );
                
                return suporte;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(SuporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public boolean cadastrar(SuporteEntidade suporte) {
        try {
            String sql = "INSERT INTO suporte (id, nome, email, telefone) values(?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, suporte.getNome());
            comando.setString(2, suporte.getEmail());
            comando.setString(3, suporte.getTelefone());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SuporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizar(int id, SuporteEntidade suporte) {
        try {
            String sql = "UPDATE suporte SET nome = ?, email = ? WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, suporte.getNome());
            comando.setString(2, suporte.getEmail());
            comando.setString(3, suporte.getTelefone());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SuporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    
    public boolean excluir(int suporteId) {
        try {
            String sql = "DELETE FROM suporte WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, suporteId);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SuporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
}
