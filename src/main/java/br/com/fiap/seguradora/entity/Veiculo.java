package br.com.fiap.seguradora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;


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

    @Column(name = "ANO_VEICULO")
    private Year ano;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_VEICULO_FOTO",
            joinColumns = {
                    @JoinColumn(
                            name = "VEICULO",
                            referencedColumnName = "ID_VEICULO",
                            foreignKey = @ForeignKey(
                                    name = "FK_VEICULO_FOTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "FOTO",
                            referencedColumnName = "ID_FOTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_FOTO_VEICULO"
                            )
                    )
            }
    )
    private Set<Foto> fotos = new LinkedHashSet<>();

}
