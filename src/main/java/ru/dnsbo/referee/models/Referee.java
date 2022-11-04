package ru.dnsbo.referee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "referees")
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secondName;

    private String firstName;

    private String email;

    private String password;

    public Referee(String secondName, String firstName, String email, String password) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }
}
