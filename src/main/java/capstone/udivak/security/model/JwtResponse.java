package capstone.udivak.security.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private int id;
    private final String jwttoken;
    private String nome;
    private String cognome;

    public JwtResponse(String jwttoken, String nome, String cognome, int id) {
        this.jwttoken = jwttoken;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}
