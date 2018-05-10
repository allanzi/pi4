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
public class EcommerceIndexDAO extends Conexao{
    
    public List<EstoqueEntidade> todos() {
        List<EstoqueEntidade> estoque = new ArrayList<EstoqueEntidade>();
        
        try {
            String sql = "SELECT * FROM estoque where filial_id = 1 ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                EstoqueEntidade estoq = new EstoqueEntidade(
                    resultado.getInt("id"),
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getFloat("valor"),
                    resultado.getString("desenvolvedora"),
                    resultado.getString("plataforma"),
                    resultado.getInt("quantidade"),
                    resultado.getString("descricao_curta"),
                    resultado.getString("descricao_longa"),
                    resultado.getString("imagens")
                );
                
                estoque.add(estoq);
            }
            
            return estoque;
            
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceIndexDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
    
    public List<EstoqueEntidade> destaques() {
        List<EstoqueEntidade> estoque = new ArrayList<EstoqueEntidade>();
        
        try {
            String sql = "SELECT * FROM estoque where filial_id = 1 ORDER BY id DESC LIMIT 3";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {                
                EstoqueEntidade estoq = new EstoqueEntidade(
                    resultado.getInt("id"),
                    resultado.getInt("codigo"),
                    resultado.getString("nome"),
                    resultado.getFloat("valor"),
                    resultado.getString("desenvolvedora"),
                    resultado.getString("plataforma"),
                    resultado.getInt("quantidade"),
                    resultado.getString("descricao_curta"),
                    resultado.getString("descricao_longa"),
                    resultado.getString("imagens")
                );
                
                estoque.add(estoq);
            }
            
            return estoque;
            
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceIndexDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
}
