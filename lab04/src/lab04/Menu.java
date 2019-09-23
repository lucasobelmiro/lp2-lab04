package lab04;

import java.util.Scanner;
/**
 * Representacao do Menu do sistema que realiza a integracao com o usuario.
 * 
 * @author Lucas Oliveira Belmmiro - 118210068
 *
 */
public class Menu {
	/**
	 * Constroi o menu do sistema.
	 */
	public Menu() {
	}
	
	Scanner sc = new Scanner(System.in);
	Controle cont = new Controle();
	
	/**
	 * Imprime as opcoes do menu.
	 */
	public void opcoes() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!\n");
		System.out.print("Opção> ");
	}
	
	/**
	 * Metodo que imprime e recebe as entradas necessarias caso o usuario selecione a opcao C.
	 */
	public void cadastro() {
		System.out.print("Matrícula: "); String matricula = sc.nextLine();
		System.out.print("Nome: "); String nome = sc.nextLine(); 
		System.out.print("Curso: "); String curso = sc.nextLine();
		
		if(cont.cadastraAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO!\n");
		}
		else {
			System.out.println("MATRÍCULA JÁ CADASTRADA!\n");
		}
	}
	
	/**
	 * Metodo que imprime e recebe as entradas necessarias caso o usuario selecione a opcao E.
	 */
	public void exibe() {
		System.out.print("Matrícula: "); String matricula = sc.nextLine();
		System.out.println("\n" + cont.exibeAluno(matricula) + "\n");
	}
	
	/**
	 * Metodo que imprime e recebe as entradas necessarias caso o usuario selecione a opcao N.
	 */
	public void novoGrupo() {
		System.out.print("Grupo: "); String tema = sc.nextLine();
		if (cont.cadastraGrupo(tema)) {
			System.out.println("CADASTRO REALIZADO!\n");
		}
		else {
			System.out.println("GRUPO JÁ CADASTRADO!\n");
		}
	}
	
	/**
	 * Metodo que imprime e recebe as entradas necessarias caso o usuario selecione a opcao A.
	 */
	public void alocaAlunoGrupo() {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		char ent = sc.next().toUpperCase().charAt(0);
		sc.nextLine();
		
		if (ent == 'A') {
			System.out.print("Matricula: "); String matricula = sc.nextLine();
			System.out.print("Grupo: "); String grupo = sc.nextLine();
			System.out.println(cont.alocaAluno(matricula, grupo)+"\n");
		}
		else if (ent == 'I') {
			System.out.print("Grupo: "); String grupo = sc.nextLine();
			System.out.println("\n" + cont.listaGrupo(grupo));
		}
	}
	
	/**
	 * Metodo que imprime e recebe as entradas necessarias caso o usuario selecione a opcao R.
	 */
	public void registraAlunoQuadro() {
		System.out.print("Matricula: "); String matricula = sc.nextLine(); 
		System.out.println(cont.registraAlunos(matricula) + "\n");
	}
	
	/**
	 * Metodo que imprime e recebe as entradas necessarias caso o usuario selecione a opcao I.
	 */
	public void imprimeQuadro() {
		System.out.println(cont.imprimeQuadro());
	}
}
