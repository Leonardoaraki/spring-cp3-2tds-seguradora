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
@Table(name = "TB_SEGURO"
)

public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SEGURO")
    @SequenceGenerator(name = "SQ_SEGURO", sequenceName = "SQ_SEGURO", allocationSize = 1)
    @Column(name = "DSC_SEGURO")
    private String decricao;

    @Column(name = "ID_SEGURO")
    private Long id;

    @Column(name = "PRM_SEGURO")
    private Double premio;

    @Column(name = "VLR_SEGURO")
    private Double valor;

}
