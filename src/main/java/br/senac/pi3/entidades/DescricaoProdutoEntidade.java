/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.entidades;

import java.util.List;

/**
 *
 * @author allan
 */
public class DescricaoProdutoEntidade {
    public List<String> breadcrumps;
    public EstoqueEntidade estoque;

    public DescricaoProdutoEntidade(List<String> breadcrumps, EstoqueEntidade estoque) {
        this.breadcrumps = breadcrumps;
        this.estoque = estoque;
    }

    public List<String> getBreadcrumps() {
        return breadcrumps;
    }

    public void setBreadcrumps(List<String> breadcrumps) {
        this.breadcrumps = breadcrumps;
    }

    public EstoqueEntidade getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueEntidade estoque) {
        this.estoque = estoque;
    }
}
