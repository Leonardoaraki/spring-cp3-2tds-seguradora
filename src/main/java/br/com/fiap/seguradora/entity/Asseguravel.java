package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_ASSEGURAVEL"
)

public class Asseguravel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ASSEGURAVEL")
    @SequenceGenerator(name = "SQ_ASSEGURAVEL", sequenceName = "SQ_ASSEGURAVEL", allocationSize = 1)
    @Column(name = "ID_ASSEGURAVEL")
    private Long id;
}
