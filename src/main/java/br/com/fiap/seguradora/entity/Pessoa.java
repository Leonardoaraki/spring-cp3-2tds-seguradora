package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

import java.time.LocalDate;
import java.time.Year;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_PESSOA"

)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "SNM_PESSOA")
    private String sobrenome;

    @Column(name = "EMAIL_PESSOA")
    private String email;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "DOCUMENTO",
            referencedColumnName = "ID_DOCUMENTO",
            foreignKey = @ForeignKey(
                    name = "FK_DOCUMENTO_PESSOA"
            )
    )
    private Documento documento;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_PESSOA_ENDERECO",
            joinColumns = {
                    @JoinColumn(
                            name = "PESSOA",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(
                                    name = "FK_PESSOA_ENDERECO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ENDERECO",
                            referencedColumnName = "ID_ENDERECO",
                            foreignKey = @ForeignKey(
                                    name = "FK_ENDERECO_PESSOA"
                            )
                    )
            }
    )
    private Set<Endereco> endereco = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_PESSOA_FOTO",
            joinColumns = {
                    @JoinColumn(
                            name = "PESSOA",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(
                                    name = "FK_PESSOA_FOTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "FOTO",
                            referencedColumnName = "ID_FOTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_FOTO_PESSOA"
                            )
                    )
            }
    )
    private Set<Foto> fotos = new LinkedHashSet<>();


}
