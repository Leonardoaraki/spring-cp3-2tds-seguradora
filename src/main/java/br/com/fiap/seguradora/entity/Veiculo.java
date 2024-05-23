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
@Table(name = "TB_VEICULO"
)

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @Column(name = "PLC_VEICULO")
    private String placa;

    @Column(name = "MDL_VEICULO")
    private String modelo;

    @Column(name = "COR_VEICULO")
    private String cor;

    @Column(name = "MRC_VEICULO")
    private String marca;

    @Column(name = "CHASSI_VEICULO")
    private String chassi;

}
