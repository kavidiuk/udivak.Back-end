package capstone.udivak.Entities;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
//@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="clients")
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Setter
    @Column(name = "nome",nullable = false)
    private String nome;

    @Setter
    @Column(name = "cognome",nullable = false)
    private String cognome;

    @Setter
    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Setter
    @Column(name = "password",nullable = false)
    private String password;
    public client(UUID id, String nome, String cognome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "client{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
