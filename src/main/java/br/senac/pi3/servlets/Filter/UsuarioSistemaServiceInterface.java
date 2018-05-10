/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.Filter;

import br.senac.pi3.entidades.UsuarioEntidade;

/**
 *
 * @author kaio.hvsantos
 */
public interface UsuarioSistemaServiceInterface {

    public UsuarioEntidade autenticar(String username, String senha);

}
