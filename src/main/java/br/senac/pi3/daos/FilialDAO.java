/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import br.senac.pi3.entidades.FilialEntidade;
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
public class FilialDAO extends Conexao{
    
    public List<FilialEntidade> todos() {
        List<FilialEntidade> filiais = new ArrayList<FilialEntidade>();
        
        try {
            String sql = "SELECT * FROM filiais ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                FilialEntidade filial = new FilialEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("cnpj"),
                    resultado.getString("cep"),
                    resultado.getString("localidade"),
                    resultado.getString("logradouro"),
                    resultado.getString("numero"),
                    resultado.getString("telefone")
                );
                
                filiais.add(filial);
            }
            
            return filiais;
            
        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public FilialEntidade find(int id) {
        
        try {
            String sql = "SELECT * FROM filiais WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                FilialEntidade filial = new FilialEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("cnpj"),
                    resultado.getString("cep"),
                    resultado.getString("localidade"),
                    resultado.getString("logradouro"),
                    resultado.getString("numero"),
                    resultado.getString("telefone")
                );
                
                return filial;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public FilialEntidade findWhereEmail(String email) {
        
        try {
            String sql = "SELECT * FROM filiais WHERE email = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setString(1, email);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                FilialEntidade filial = new FilialEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("cnpj"),
                    resultado.getString("cep"),
                    resultado.getString("localidade"),
                    resultado.getString("logradouro"),
                    resultado.getString("numero"),
                    resultado.getString("telefone")
                );
                
                return filial;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public boolean cadastrar(FilialEntidade filial) {
        try {
            String sql = "INSERT INTO filiais (nome, cnpj, cep, localidade, logradouro, numero, telefone) values(?,?,?,?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, filial.getNome());
            comando.setString(2, filial.getCnpj());
            comando.setString(3, filial.getCep());
            comando.setString(4, filial.getLocalidade());
            comando.setString(5, filial.getLogradouro());
            comando.setString(6, filial.getNumeroResidencia());
            comando.setString(7, filial.getTelefone());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizar(int id, FilialEntidade filial) {
        try {
            String sql = "UPDATE filiais SET nome = ?, cnpj = ?, cep = ?, localidade = ?, logradouro = ?, numero = ?, telefone = ? WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, filial.getNome());
            comando.setString(2, filial.getCnpj());
            comando.setString(3, filial.getCep());
            comando.setString(4, filial.getLocalidade());
            comando.setString(5, filial.getLogradouro());
            comando.setString(6, filial.getNumeroResidencia());
            comando.setString(7, filial.getTelefone());
            comando.setInt(8, id);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    
    public boolean excluir(int filialId) {
        try {
            String sql = "DELETE FROM filiais WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, filialId);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
}
