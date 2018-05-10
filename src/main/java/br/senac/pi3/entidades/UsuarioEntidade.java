/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.entidades;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author kaio henrique
 */
public final class UsuarioEntidade {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String username;
    private String hashSenha;
    private Object filialId;
    private String perfil;

    public UsuarioEntidade(String nome, String email, String telefone, String username, String hashSenha, Object filialId, String perfil) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.username = username;
        setSenha(hashSenha);
        this.filialId = filialId;
        this.perfil = perfil;
    }

    public UsuarioEntidade(int id, String nome, String email, String telefone, String username, String hashSenha, Object filialId, String perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.username = username;
        this.hashSenha = hashSenha;
        this.filialId = filialId;
        this.perfil = perfil;
    }

    public UsuarioEntidade(String username, String nome, String senha, int filial_id, int id, String perfil) {
        this.username = username;
        this.nome = nome;
        this.hashSenha = senha;
        this.filialId = filial_id;
        this.id = id;
        this.perfil = perfil;
    }

    public UsuarioEntidade(String nome, String email, String telefone, String username) {
        this.username = username;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getFilialId() {
        return filialId;
    }

    public void setFilialId(Object filialId) {
        this.filialId = filialId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public void setSenha(String senha) {
        this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean verificarSenha(String senha) {
        return BCrypt.checkpw(senha, hashSenha);
    }

    public boolean temPerfil(String perfil) {
        return perfil.equals(this.perfil);
    }

}
