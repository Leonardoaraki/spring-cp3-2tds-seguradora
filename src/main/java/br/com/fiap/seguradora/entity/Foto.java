package br.com.fiap.seguradora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_FOTO")

public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FOTO")
    @SequenceGenerator(name = "SQ_FOTO", sequenceName = "SQ_FOTO", allocationSize = 1)
    @Column(name = "ID_FOTO")
    private Long id;

    private String src;
}
