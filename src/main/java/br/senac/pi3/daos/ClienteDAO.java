/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import br.senac.pi3.entidades.ClienteEntidade;
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
public class ClienteDAO extends Conexao{
    
    public List<ClienteEntidade> todos(Object filialId) {
        List<ClienteEntidade> clientes = new ArrayList<ClienteEntidade>();
        
        try {
            String sql = "SELECT * FROM clientes where filial_id = ? ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                ClienteEntidade cliente = new ClienteEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("cpf"),
                    resultado.getString("telefone"),
                    resultado.getString("logradouro"),
                    resultado.getInt("numero"),
                    resultado.getString("cep")
                );
                
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public List<ClienteEntidade> todosAutoComplete(Object filialId) {
        List<ClienteEntidade> clientes = new ArrayList<ClienteEntidade>();
        
        try {
            String sql = "SELECT * FROM clientes where filial_id = ? ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                ClienteEntidade cliente = new ClienteEntidade(
                    resultado.getString("email")
                );
                
                clientes.add(cliente);
            }
            
            return clientes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public ClienteEntidade find(int id) {
        
        try {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                ClienteEntidade cliente = new ClienteEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("cpf"),
                    resultado.getString("telefone"),
                    resultado.getString("logradouro"),
                    resultado.getInt("numero"),
                    resultado.getString("cep")
                );
                
                return cliente;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public ClienteEntidade findWhereEmail(String email) {
        
        try {
            String sql = "SELECT * FROM clientes WHERE email = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setString(1, email);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                ClienteEntidade cliente = new ClienteEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("cpf"),
                    resultado.getString("telefone"),
                    resultado.getString("logradouro"),
                    resultado.getInt("numero"),
                    resultado.getString("cep")
                );
                
                return cliente;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public boolean cadastrar(ClienteEntidade cliente) {
        try {
            String sql = "INSERT INTO clientes (nome, email, telefone, cpf, cep, logradouro, numero, filial_id) values(?,?,?,?,?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getCpf());
            comando.setString(5, cliente.getCep());
            comando.setString(6, cliente.getLogradouro());
            comando.setInt(7, cliente.getNumeroResidencia());
            comando.setObject(8, cliente.getFilialId());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizar(int id, ClienteEntidade cliente) {
        try {
            String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, cpf = ?, cep = ?, logradouro = ?, numero = ? WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getCpf());
            comando.setString(5, cliente.getCep());
            comando.setString(6, cliente.getLogradouro());
            comando.setInt(7, cliente.getNumeroResidencia());
            comando.setInt(8, id);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    
    public boolean excluir(int clienteId) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, clienteId);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
}
