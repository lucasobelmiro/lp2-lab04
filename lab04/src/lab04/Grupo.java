package lab04;

import java.util.HashSet;
import java.util.Set;
/**
 * Representacao de um grupo no sistema, um grupo é criado a partir do seu tema e possui um conjunto de alunos que o constitui.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Grupo {
	/**
	 * O tema do grupo.
	 */
	private String tema;
	/**
	 * Conjunto de alunos que formam um grupo.
	 */
	private Set<Aluno> alunos;
	
	/**
	 * Constroi um grupo a partir do tema passado e inicia o conjunto onde serão cadastrados os alunos que formarão esse grupo.
	 * @param tema o tema do grupo.
	 */
	public Grupo(String tema) {
		if (tema == null) {
			throw new NullPointerException("Nome nulo.");
		}
		if (tema.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome vazio.");
		}
		this.tema = tema;
		this.alunos = new HashSet<Aluno>();
	}
	
	/**
	 * Get do atributo tema do grupo.
	 * 
	 * @return uma String com o tema do grupo.
	 */
	public String getTema() {
		return tema;
	}
	
	/**
	 * Metodo acessorio que adiciona um aluno ao conjunto de alunos que foram o grupo.
	 * @param aluno o aluno a ser adicionado no grupo.
	 */
	public void alocaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	/**
	 * Override do metodo toString contendo a representacao textual de um grupo cadastrado no sistema.
	 * 
	 * @return Retorna uma lista contendo todos os alunos que fazem parte do grupo.
	 */
	@Override
	public String toString() {
		String lista = "Alunos do grupo " + this.tema + ":\n";
		for (Aluno aluno : alunos) {
			lista += "* " + aluno.toString() + "\n";
		}
		return lista;
	}
	
	/**
	 * Override do metodo HashCode, para comparar dois grupos a partir de seus temas, o identificador de um grupo.
	 * 
	 * @return um inteiro contendo o codigo Hash de um grupo. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}
	
	/**
	 * Override do metodo equals que verifica se dois grupos sao iguais a partir de seus temas.
	 * 
	 * @return um boolean True caso dois grupos sejam iguais se possuirem o mesmo tema e False caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}
}
