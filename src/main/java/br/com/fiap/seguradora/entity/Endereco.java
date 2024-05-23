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
@Table(name = "TB_ENDERECO"
)


public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "MQ_ENDERECO")
    private float metrosQuadrados;

    @Column(name = "LGRD_ENDERECO")
    private String logradouro;

    @Column(name = "NMR_ENDERECO")
    private String numero;

    @Column(name = "COMPL_ENDERECO")
    private String complemento;

    @Column(name = "CEP_ENDERECO")
    private String cep;

}
