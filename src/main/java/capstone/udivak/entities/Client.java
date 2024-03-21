<<<<<<< Updated upstream:src/main/java/capstone/udivak/Entities/client.java
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
=======
package capstone.udivak.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "cognome",nullable = false)
    private String cognome;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        return this.id == other.id;
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
>>>>>>> Stashed changes:src/main/java/capstone/udivak/entities/Client.java
