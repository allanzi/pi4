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
public class ClienteEntidade {
    public int id;
    public String nome;
    public String email;
    public String cpf;
    public String telefone;
    public String logradouro;
    public int numeroResidencia;
    public String cep;
    public Object filialId;

    public ClienteEntidade(int id, String nome, String email, String cpf, String telefone, String logradouro, int numeroResidencia, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.cep = cep;
    }
    
    
    public ClienteEntidade(String nome, String email, String cpf, String telefone, String logradouro, int numeroResidencia, String cep, Object filialId) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.cep = cep;
        this.filialId = filialId;
    }
    
    public ClienteEntidade(String nome, String email, String telefone, String cpf, Object filialId) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.filialId = filialId;
    }
    
    public ClienteEntidade(String email) {
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
