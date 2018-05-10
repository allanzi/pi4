/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.entidades;

/**
 *
 * @author allan
 */
public class FilialEntidade {
    public int id;
    public String nome;
    public String cnpj;
    public String cep;
    public String localidade;
    public String logradouro;
    public String numeroResidencia;
    public String telefone;
    
    public FilialEntidade(int id, String nome, String cnpj, String cep, String localidade, String logradouro, String numeroResidencia, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.localidade = localidade;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.telefone = telefone;
    }
    
    public FilialEntidade(String nome, String cnpj, String cep, String localidade, String logradouro, String numeroResidencia, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.localidade = localidade;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.telefone = telefone;
    }
    
        public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }
}
