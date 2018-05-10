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
public class FornecedorEntidade {
    public int id;
    public String nome;
    public String email;
    public String cnpj;
    public String telefone;
    public String logradouro;
    public int numeroResidencia;
    public String cep;
    public Object filialId;

    public FornecedorEntidade(int id, String nome, String email, String telefone, String cnpj, String cep, String logradouro, int numeroResidencia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.cep = cep;
    }
    
    public FornecedorEntidade(String nome, String email, String telefone, String cnpj, String cep, String logradouro, int numeroResidencia, Object filiaId) {
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.cep = cep;
        this.filialId = filiaId;
    }

    public Object getFilialId() {
        return filialId;
    }

    public void setFilialId(Object filialId) {
        this.filialId = filialId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(int numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }




}
