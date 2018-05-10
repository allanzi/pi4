/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import static br.senac.pi3.daos.Conexao.FecharConexao;
import static br.senac.pi3.daos.Conexao.obterConexao;
import br.senac.pi3.entidades.UsuarioEntidade;
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
public class UsuarioDAO extends Conexao {

    public List<UsuarioEntidade> todos(Object filialId) {
        List<UsuarioEntidade> usuarios = new ArrayList<UsuarioEntidade>();
        
        try {
            String sql = "SELECT * FROM usuarios where filial_id = ? ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                UsuarioEntidade usuario = new UsuarioEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone"),
                    resultado.getString("username"),
                    resultado.getString("senha"),
                    resultado.getInt("filial_id"),
                    resultado.getString("perfil")
                );
                
                usuarios.add(usuario);
            }
            
            return usuarios;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public UsuarioEntidade findWhereUsername(String username) {

        try {
            String sql = "SELECT * FROM usuarios WHERE username = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setString(1, username);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                UsuarioEntidade usuario = new UsuarioEntidade(
                    resultado.getString("username"),
                    resultado.getString("nome"),
                    resultado.getString("senha"),
                    resultado.getInt("filial_id"),
                    resultado.getInt("id"),
                    resultado.getString("perfil")
                );

                return usuario;
            }

            return null;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return null;
    }
    
    public UsuarioEntidade find(int id) {
        
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                UsuarioEntidade usuario = new UsuarioEntidade(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone"),
                    resultado.getString("username"),
                    resultado.getString("senha"),
                    resultado.getInt("filial_id"),
                    resultado.getString("perfil")
                );
                
                return usuario;
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public boolean cadastrar(UsuarioEntidade usuario) {
        try {
            String sql = "INSERT INTO usuarios (nome, email, telefone, username, senha, filial_id, perfil) values(?,?,?,?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getTelefone());
            comando.setString(4, usuario.getUsername());
            comando.setString(5, usuario.getHashSenha());
            comando.setObject(6, usuario.getFilialId());
            comando.setString(7, usuario.getPerfil());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean excluir(int usuarioId) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, usuarioId);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
    
    public boolean atualizar(int id, UsuarioEntidade usuario) {
        try {
            String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ?, username = ? WHERE id = ?;";
            
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getTelefone());
            comando.setString(4, usuario.getUsername());
            comando.setInt(5, id);

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return false;
    }
}
