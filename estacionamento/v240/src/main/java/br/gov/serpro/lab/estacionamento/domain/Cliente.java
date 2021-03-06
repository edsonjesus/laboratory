/*
 Demoiselle Framework
 Copyright (C) 2013 SERPRO
 ============================================================================
 This file is part of Demoiselle Framework.
 Demoiselle Framework is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License version 3
 as published by the Free Software Foundation.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU Lesser General Public License version 3
 along with this program; if not,  see <http://www.gnu.org/licenses/>
 or write to the Free Software Foundation, Inc., 51 Franklin Street,
 Fifth Floor, Boston, MA  02110-1301, USA.
 ============================================================================
 Este arquivo é parte do Framework Demoiselle.
 O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 do Software Livre (FSF).
 Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 para maiores detalhes.
 Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 ou escreva para a Fundação do Software Livre (FSF) Inc.,
 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package br.gov.serpro.lab.estacionamento.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import br.gov.frameworkdemoiselle.validation.annotation.Cpf;
import br.gov.frameworkdemoiselle.validation.annotation.TituloEleitor;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue
	private Long id;

	@Column(length = 255)
	@NotNull
	private String nome;

	@Column
	@Cpf
	private String cpf;

	@Column
	private String email;

	@Column
	@TituloEleitor
	private String tituloEleitor;

	@Column(nullable = false, length = 25)
	private String documento;

	@Column(nullable = false, length = 15)
	private String telefone;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "cliente_fk")
	private List<Automovel> automoveis;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_cliente_endereco", joinColumns = @JoinColumn(name = "id_cliente"), 
				inverseJoinColumns = @JoinColumn(name = "cod_endereco"))
	private List<Endereco> enderecos;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String email, String tituloEleitor, String documento, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.tituloEleitor = tituloEleitor;
		this.documento = documento;
		this.telefone = telefone;
	}

	public Cliente(String nome, String cpf, String email, String tituloEleitor, String documento, String telefone,
					List<Automovel> automoveis, List<Endereco> enderecos) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.tituloEleitor = tituloEleitor;
		this.documento = documento;
		this.telefone = telefone;
		this.automoveis = automoveis;
		this.enderecos = enderecos;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getDocumento() {
		return this.documento;
	}

	public String getEmail() {
		return this.email;
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getTituloEleitor() {
		return this.tituloEleitor;
	}
	
	public List<Automovel> getAutomoveis() {
		return this.automoveis;
	}
	
	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
