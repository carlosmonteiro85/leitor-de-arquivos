package com.prototipo.leitorarquivo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
    private String nome;
    private double preco;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Produto:  [ ")
                .append(" Nome: ").append(nome)
                .append(", Preço: ").append(preco)
                .append(" ]").toString();
    }
}
