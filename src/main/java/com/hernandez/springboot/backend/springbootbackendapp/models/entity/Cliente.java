package com.hernandez.springboot.backend.springbootbackendapp.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4, max = 12)
    private String nombre;
    @Column(nullable = false)
    @NotEmpty
    private String apellido;
    @Column(unique = true, nullable = false)
    @Email
    @NotEmpty
    private String email;
    @Column(name = "create_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate createAt;
    @Serial
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        this.createAt = LocalDate.now();
    }


}
