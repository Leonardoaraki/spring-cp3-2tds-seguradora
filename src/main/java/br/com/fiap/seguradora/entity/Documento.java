package br.com.fiap.seguradora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_DOCUMENTO",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_CHEFE_UNIDADE", columnNames = {"FOTO", "UNIDADE"})
        }
)
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CHEFE")
    @SequenceGenerator(name = "SQ_DOCUMENTO", sequenceName = "SQ_DOCUMENTO", allocationSize = 1)
    @Column(name = "ID_DOCUMENTO")
    private Long id;

    @Column(name = "NR_DOCUMENTO")
    private String numero;
}
