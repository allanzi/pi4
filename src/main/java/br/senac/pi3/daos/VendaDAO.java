/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import static br.senac.pi3.daos.Conexao.FecharConexao;
import static br.senac.pi3.daos.Conexao.obterConexao;
import br.senac.pi3.entidades.VendaEntidade;
import br.senac.pi3.entidades.EstoqueEntidade;
import br.senac.pi3.entidades.VendaEntidade;
import java.math.BigDecimal;
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
public class VendaDAO extends Conexao {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private EstoqueDAO estoqueDAO = new EstoqueDAO();

    public boolean cadastrar(VendaEntidade venda) {
        try {
            String sql = "INSERT INTO vendas (data, cliente_id, valor, pagamento, vendedor_id, filial_id) values(?,?,?,?,?,?);";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            java.sql.Date sqlDate = new java.sql.Date(venda.getData().getTime());
            comando.setDate(1, sqlDate);
            comando.setInt(2, venda.getCliente().getId());
            comando.setBigDecimal(3, venda.getValor());
            comando.setString(4, venda.getPagamento());
            comando.setObject(5, venda.getVendedor());
            comando.setObject(6, venda.getFilialId());

            comando.execute();

            VendaEntidade ultimaVenda = ObterUltimo();
            for (EstoqueEntidade estoque : venda.getProdutos()) {
                String sqlProduto = "INSERT INTO venda_estoque (estoque_id, venda_id) values(?,?);";
                PreparedStatement comandoProduto = obterConexao().prepareStatement(sqlProduto);

                comandoProduto.setInt(1, estoque.getId());
                comandoProduto.setInt(2, ultimaVenda.id);

                comandoProduto.execute();
            }

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return false;
    }

    public VendaEntidade ObterUltimo() {

        try {
            String sql = "select * from vendas order by id desc limit 1;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                VendaEntidade venda = new VendaEntidade(
                        resultado.getInt("id"),
                        resultado.getDate("data"),
                        clienteDAO.find(resultado.getInt("cliente_id")),
                        resultado.getBigDecimal("valor"),
                        resultado.getString("pagamento"),
                        usuarioDAO.find(resultado.getInt("vendedor_id"))
                );

                return venda;
            }

            return null;

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return null;
    }

    public List<VendaEntidade> todos(Object filialId) {
        List<VendaEntidade> vendas = new ArrayList<VendaEntidade>();

        try {
            String sql = "SELECT * FROM vendas where filial_id = ? ORDER BY data DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setObject(1, filialId);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                List<EstoqueEntidade> produtos = new ArrayList<>();

                VendaEntidade venda = new VendaEntidade(
                        resultado.getInt("id"),
                        resultado.getDate("data"),
                        clienteDAO.find(resultado.getInt("cliente_id")),
                        produtos,
                        resultado.getBigDecimal("valor"),
                        resultado.getString("pagamento"),
                        usuarioDAO.find(resultado.getInt("vendedor_id")),
                        resultado.getObject("filial_id")
                );

                String sqlProdutos = "SELECT * FROM venda_estoque where venda_id = ?";
                PreparedStatement comandoProdutos = obterConexao().prepareStatement(sqlProdutos);
                comandoProdutos.setInt(1, venda.getId());
                ResultSet resultadoProdutos = comandoProdutos.executeQuery();

                while (resultadoProdutos.next()) {
                    EstoqueEntidade estoque = estoqueDAO.find(resultadoProdutos.getInt("estoque_id"));
                    produtos.add(estoque);
                }
                venda.setProdutos(produtos);
                
                vendas.add(venda);
            }

            return vendas;

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return null;
    }
}
