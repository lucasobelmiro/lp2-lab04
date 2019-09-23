package lab04;
/**
 * Representacao de um aluno no sistema, cada aluno possui matricula, nome e curso e é identificado unicamente pela sua matricula.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Aluno {
	/**
	 * A matricula do aluno.
	 */
	private String matricula;
	/**
	 * O nome do aluno.
	 */
	private String nome;
	/**
	 * O curso do aluno.
	 */
	private String curso;
	
	/**
	 * Constroi um aluno no sistema a partir da sua matricula, nome e curso.
	 * @param matricula a matricula do aluno.
	 * @param nome o nome do aluno.
	 * @param curso o curso do aluno.
	 */ 
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula nula.");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matrícula vazia.");
		}
		if (nome == null) {
			throw new NullPointerException("Nome nulo.");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome vazio.");
		}
		if (curso == null) {
			throw new NullPointerException("Curso nulo.");
		}
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso vazio.");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Get do atributo matricula.
	 * 
	 * @return uma String contendo a matricula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Representacao textual de um aluno no sistema.
	 * 
	 * @return uma String contendo a matricula do aluno, nome e curso.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
	/**
	 * Override do metodo HashCode, para comparar dois alunos a partir de suas matriculas, o identificador de um aluno.
	 * 
	 * @return um inteiro contendo o codigo Hash de um aluno. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * Override do metodo equals que verifica se dois alunos sao iguais a partir de suas matriculas.
	 * 
	 * @return um boolean True caso dois alunos sejam iguais se possuirem a mesma matricula e False caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
