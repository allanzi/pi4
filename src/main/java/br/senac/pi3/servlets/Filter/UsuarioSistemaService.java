/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.Filter;
import br.senac.pi3.daos.UsuarioDAO;
import br.senac.pi3.entidades.UsuarioEntidade;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistemaService extends UsuarioDAO implements UsuarioSistemaServiceInterface {

  @Override
  public UsuarioEntidade autenticar(String username, String senha) {
    UsuarioEntidade usuario = findWhereUsername(username);

    if (usuario != null && usuario.verificarSenha(senha)) {
      return usuario;
    }
    return null;
  }

}
