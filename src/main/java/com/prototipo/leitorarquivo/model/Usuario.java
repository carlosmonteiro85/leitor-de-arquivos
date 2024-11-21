package com.prototipo.leitorarquivo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private String telefone;

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Usuario:  [ ")
				.append(" Nome: ").append(this.nome)
				.append(", Email: ").append(this.email)
				.append(", Telefone: ").append(this.telefone)
				.append(" ]").toString();
	}
}
