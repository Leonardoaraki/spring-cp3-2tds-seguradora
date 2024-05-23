package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_IMOVEL"
)


public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IMOVEL")
    @SequenceGenerator(name = "SQ_IMOVEL", sequenceName = "SQ_IMOVEL", allocationSize = 1)
    @Column(name = "DSC_IMOVEL")
    private String decricao;

    @Column(name = "MQ_IMOVEL")
    private float metrosQuadrados;

    @Column(name = "QRTS_IMOVEL")
    private Integer quartos;

    @Column(name = "BANH_IMOVEL")
    private Integer banheiros;

    @Column(name = "VGS_IMOVEL")
    private Integer vagasGaragem;

    @Column(name = "MATR_IMOVEL")
    private String matricula;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_IMOVEL_ENDERECO")
    )
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_IMOVEL_FOTO",
            joinColumns = {
                    @JoinColumn(
                            name = "IMOVEL",
                            referencedColumnName = "ID_IMOVEL",
                            foreignKey = @ForeignKey(
                                    name = "FK_IMOVEL_FOTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "FOTO",
                            referencedColumnName = "ID_FOTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_FOTO_IMOVEL"
                            )
                    )
            }
    )
    private Set<Foto> fotos = new LinkedHashSet<>();


}
