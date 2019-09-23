package lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Representacao do Controle de alunos, responsavel por realizar o registro e armazenar todos os alunos e grupos e manter o controle dos 
 * alunos que responderam questoes no quadro.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Controle {
	/**
	 * Mapa de alunos cadastrados no sistema.
	 */
	Map<String, Aluno> alunos;
	/**
	 * Mapa de grupos cadastrados no sistema.
	 */
	Map<String, Grupo> grupos;
	/**
	 * Listra contendo o registro de todos os alunos que responderam questoes no quadro.
	 */
	ArrayList<Aluno> quadro;
	
	/**
	 * Constroi um Controle de Alunos.
	 */
	public Controle() {
		this.alunos = new HashMap<String, Aluno>();;
		this.grupos = new HashMap<String, Grupo>();
		this.quadro = new ArrayList<Aluno>();
	}
	
	/**
	 * Metodo que cadastra um aluno no sistema a partir de sua matricula, nome e curso, verificando se um aluno ja esta cadastrado ou
	 * nao no sistema a partir de sua matricula.
	 * @param matricula a matricula do aluno.
	 * @param nome o nome do aluno.
	 * @param curso o curso do aluno.
	 * 
	 * @return um boolean True caso o aluno seja cadastrado com sucesso e False caso o contrario.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {		
		if (alunos.containsKey(matricula)) {
			return false;
		}
		else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			alunos.put(matricula, aluno);
			return true;
		}
	}
	
	/**
	 * Metodo que exibe a representacao textual de um aluno a partir de sua matricula.
	 * @param matricula a matricula do aluno que se deseja exibir.
	 * 
	 * @return uma String contendo as informacoes do aluno.
	 */
	public String exibeAluno(String matricula) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		else {
			return "Aluno: " + alunos.get(matricula).toString();
		}
	}
	
	/**
	 * Metodo que cadastra um grupo no sistema a partir do seu tema, é verificado se o grupo já existe a partir do seu tema.
	 * @param tema o tema do grupo que se deseja cadastrar.
	 * 
	 * @return um boolean True caso o grupo seja cadastrado com sucesso e False caso contrario.
	 */
	public boolean cadastraGrupo (String tema) {
		if (!grupos.containsKey(tema.toUpperCase())) {
			Grupo grupo = new Grupo(tema);
			grupos.put(tema.toUpperCase(), grupo);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Metodo que aloca um aluno em um grupo a partir da matricula do aluno e tema do grupo, é verificado se o aluno e grupo existem no
	 * sistema a partir dos dados passados.
	 * @param matricula a matricula do aluno que se deseja alocar.
	 * @param grupo o grupo que se deseja alocar um aluno.
	 * 
	 * @return uma String informado se o Aluno ou Grupo não existe ou se o aluno foi alocado com sucesso.
	 */
	public String alocaAluno(String matricula, String grupo) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		else if (!grupos.containsKey(grupo.toUpperCase())) {
			return "Grupo não cadastrado.";
		}
		else {
			Aluno aluno = alunos.get(matricula);
			grupos.get(grupo.toUpperCase()).alocaAluno(aluno);
			return "ALUNO ALOCADO!";
		}
	}
	
	/**
	 * Metodo que lista todos os alunos cadastrados em um grupo. É passado como parametro o tema do grupo que se deseja exibir.
	 * É verificado se o grupo existe ou nao no sistema.
	 * @param grupo o tema do grupo que se deseja exibir os alunos cadastrados.
	 * 
	 * @return uma String informado caso o grupo passado nao esteja cadastrado no sistema ou a listagem com todos os alunos alocados
	 * no grupo.
	 */
	public String listaGrupo(String grupo) {
		if(!grupos.containsKey(grupo.toUpperCase())) {
			return "Grupo não cadastrado.";
		}
		else {
			return grupos.get(grupo.toUpperCase()).toString();
		}
	}
	
	/**
	 * Metodo que registra quando um aluno responde uma questao no quadro.
	 * @param matricula a matricula do aluno que respondeu uma questao no quadro.
	 *
	 * @return uma String informando se o aluno nao é cadastrado no sistema ou se o aluno foi registrado com sucesso.
	 */
	public String registraAlunos(String matricula) {
		if(!alunos.containsKey(matricula)){
			return "Aluno não cadastrado.";
		}
		else {
			quadro.add(alunos.get(matricula));
			}
			return "ALUNO REGISTRADO!";
		}
	
	/**
	 * Metodo que lista todos os alunos que responderam uma ou mais questoes no quadro.
	 * 
	 * @return uma String contendo todos os alunos que responderam questoes no quadro.
	 */
	public String imprimeQuadro() {
		String saida = "Alunos: \n";
		for (int i = 0; i < quadro.size(); i++) {
			if (quadro.get(i) != null) {
				saida += i+1 + ". " + quadro.get(i) + "\n";
			}
		}
		return saida;
	}
}