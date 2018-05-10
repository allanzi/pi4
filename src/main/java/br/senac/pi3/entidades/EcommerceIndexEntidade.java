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
public class EcommerceIndexEntidade {
    List<EstoqueEntidade> produtos;
    List<EstoqueEntidade> destaques;

    public List<EstoqueEntidade> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<EstoqueEntidade> produtos) {
        this.produtos = produtos;
    }

    public List<EstoqueEntidade> getDestaques() {
        return destaques;
    }

    public void setDestaques(List<EstoqueEntidade> destaques) {
        this.destaques = destaques;
    }
}
