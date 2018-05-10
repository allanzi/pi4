/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import static br.senac.pi3.daos.Conexao.obterConexao;
import br.senac.pi3.entidades.DescricaoProdutoEntidade;
import br.senac.pi3.entidades.EstoqueEntidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class DescricaoProdutoDao extends Conexao{
    public DescricaoProdutoEntidade find(int id) {
        
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
                    resultado.getInt("quantidade"),
                    resultado.getString("descricao_curta"),
                    resultado.getString("descricao_longa"),
                    resultado.getString("imagens")
                );
                
                List<String> breadcrumps = Arrays.asList("Início", estoque.plataforma, estoque.nome);
                
                return (new DescricaoProdutoEntidade(breadcrumps, estoque));
            }
            
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }
        
        return null;
    }
}
