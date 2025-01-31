package objetivo;

import java.io.Serializable;

import sistema.Verificador;

/**
 * Classe que representa um objetivo. Todo Objetivo possui um tipo(GERAL ou
 * ESPECIFICO), descricao, aderencia (inteiro de 1 a 5), viabilidade (inteiro de
 * 1 a 5) e um codigo pelo qual e identificado unicamente.
 * 
 * @author Jose Matheus do N. Gama
 *
 */
public class Objetivo implements Serializable {

	/**
	 * versao de serializacao da classe
	 */
	private static final long serialVersionUID = 2787121198791897001L;

	/**
	 * Tipo do objetivo. Pode ser geral, um objetivo mais abrangente e que responde
	 * diretamente ao problema da pesquisa, ou especifico, que delimitam alvos
	 * especificos para atingir o objetivo geral, ou seja, a uma meta bem definida.
	 */
	private String tipo;

	/**
	 * Descricao do objetivo.
	 */
	private String descricao;

	/**
	 * Representacao quantitativa, de 1 a 5, do quanto o objetivo esta aderido a um
	 * problema.
	 */
	private int aderencia;

	/**
	 * Representacao quantitativa, em uma escala de 1 a 5, do quanto o objetivo e
	 * viavel.
	 */
	private int viabilidade;

	/**
	 * Codigo que identifica unicamente o objetivo. Tem formato "O" + id gerado
	 * automaticamente.
	 */
	private String codigo;

	/**
	 * Constroi um objeto do tipo Objetivo.
	 * 
	 * @param tipo        o tipo do objetivo, que pode ser geral ou especifico
	 * @param descricao   a descricao do objetivo
	 * @param aderencia   representacao quantitativa do quanto o objetivo esta
	 *                    aderido a um problema
	 * @param viabilidade representacao quantitativa do quanto o objetivo e viavel
	 * @param codigo      codigo que identifica unicamente o objetivo
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade, String codigo) {
		Verificador.verificaEntrada(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		Verificador.verificaEntrada(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.viabilidade = viabilidade;
		this.codigo = codigo;
	}

	/**
	 * Retorna a representacao em String do objetivo, no formato "codigo - tipo -
	 * descricao - valor(aderencia + viabilidade)".
	 * 
	 * @return a representacao em String do objetivo
	 */
	public String toString() {

		return this.codigo + " - " + this.tipo + " - " + this.descricao + " - " + (this.aderencia + this.viabilidade);

	}

	/**
	 * Retorna o codigo do objetivo
	 * 
	 * @return a String que representa o identificador unico do objetivo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Retorna a descricao do objetivo
	 * 
	 * @return a String que representa a descricao do objetivo
	 */
	public String getDescricao() {
		return descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objetivo other = (Objetivo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
