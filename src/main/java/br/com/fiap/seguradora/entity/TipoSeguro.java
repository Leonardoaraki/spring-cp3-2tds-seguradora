package br.com.fiap.seguradora.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoSeguro {
    IMOVEL, VEICULO;

    @Override
    public String toString() {
        return this.name();
    }
}