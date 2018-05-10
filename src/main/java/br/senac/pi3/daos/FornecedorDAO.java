/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import br.senac.pi3.entidades.FornecedorEntidade;
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
public class FornecedorDAO extends Conexao{
    
    public List<FornecedorEntidade> todos(Object filialId) {
        List<FornecedorEntidade> fornecedores = new ArrayList<FornecedorEntidade>();
        
        try {
            String sql = "SELECT * FROM fornecedores WHERE filial_id = ? ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {
                FornecedorEntidade fornecedor = new FornecedorEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone"),
                    resultado.getString("cnpj"),
                    resultado.getString("cep"),
                    resultado.getString("logradouro"),
                    resultado.getInt("numero")
                );

                fornecedores.add(fornecedor);
            }
            
            return fornecedores;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public FornecedorEntidade find(int id) {
        
        try {
            String sql = "SELECT * FROM fornecedores WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                FornecedorEntidade fornecedor = new FornecedorEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone"),
                    resultado.getString("cnpj"),
                    resultado.getString("cep"),
                    resultado.getString("logradouro"),
                    resultado.getInt("numero")
                );
                
                return fornecedor;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public boolean cadastrar(FornecedorEntidade fornecedor) {
        try {
            String sql = "INSERT INTO fornecedores (nome, email, telefone, cnpj, cep, logradouro, numero, filial_id) values(?,?,?,?,?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getEmail());
            comando.setString(3, fornecedor.getTelefone());
            comando.setString(4, fornecedor.getCnpj());
            comando.setString(5, fornecedor.getCep());
            comando.setString(6, fornecedor.getLogradouro());
            comando.setInt(7, fornecedor.getNumeroResidencia());
            comando.setObject(8, fornecedor.getFilialId());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizar(int id, FornecedorEntidade fornecedor) {
        try {
            String sql = "UPDATE fornecedores SET nome = ?, email = ?, telefone = ?, cnpj = ?, cep = ?, logradouro = ?, numero = ? WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getEmail());
            comando.setString(3, fornecedor.getTelefone());
            comando.setString(4, fornecedor.getCnpj());
            comando.setString(5, fornecedor.getCep());
            comando.setString(6, fornecedor.getLogradouro());
            comando.setInt(7, fornecedor.getNumeroResidencia());
            comando.setInt(8, id);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    
    public boolean excluir(int fornecedorId) {
        try {
            String sql = "DELETE FROM fornecedores WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, fornecedorId);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
}
