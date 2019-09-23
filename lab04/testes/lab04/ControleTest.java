package lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Classe de testes da Classe Controle.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
class ControleTest {
	
	Controle cont;
	
	@BeforeEach
	void setUp() {
		cont = new Controle();
	}

	void testCadastraAluno() {
		//Cadastra aluno com nova matrícula.
		assertTrue(cont.cadastraAluno("852", "Aline", "Direito"));
		//Tenta cadastrar aluno com matricula já cadastrada.
		assertFalse(cont.cadastraAluno("852", "Beatriz", "Medicina"));
	}
	
	@Test
	void testExibeAluno() {
		cont.cadastraAluno("963", "Maria", "Quimica");
		cont.cadastraAluno("753", "Eliane", "Pedagogia");
		assertEquals("Aluno: 963 - Maria - Quimica", cont.exibeAluno("963"));
		assertEquals("Aluno: 753 - Eliane - Pedagogia", cont.exibeAluno("753"));
		assertEquals("Aluno não cadastrado.", cont.exibeAluno("332"));
	}
	
	@Test
	void testCadastraGrupo() {
		// Cadastra Grupo com nome inexistente
		assertTrue(cont.cadastraGrupo("Pesquisa"));
		// Tenta cadastrar grupos que já existe(nome repetido sem diferenciar letras)
		assertFalse(cont.cadastraGrupo("pesquisa"));
		assertFalse(cont.cadastraGrupo("PESQUISA"));
		assertFalse(cont.cadastraGrupo("pEsQuIsA"));
		assertFalse(cont.cadastraGrupo("pesqUISA"));
		assertFalse(cont.cadastraGrupo("PESQuisa"));
	}
	
	@Test
	void testAlocaAluno() {
		cont.cadastraAluno("951", "Bruna", "Contabilidade");
		cont.cadastraAluno("423", "Clara", "Artes");
		cont.cadastraGrupo("Laboratório");
		assertEquals("ALUNO ALOCADO!", cont.alocaAluno("951", "Laboratório"));
		// Ao tentar alocar aluno novamente não deve apresentar erro.
		assertEquals("ALUNO ALOCADO!", cont.alocaAluno("951", "Laboratório"));
		// Tenta alocar aluno não cadastrado.
		assertEquals("Aluno não cadastrado.", cont.alocaAluno("554", "Laboratório"));
		// Tenta alocar para um grupo não cadastrado.
		assertEquals("Grupo não cadastrado.", cont.alocaAluno("423", "hist"));
	}
	
	@Test
	void testListaGrupo() {
		cont.cadastraAluno("951", "Bruna", "Contabilidade");
		cont.cadastraAluno("423", "Clara", "Artes");
		cont.cadastraGrupo("Leitura");
		cont.alocaAluno("951", "Leitura");
		assertEquals("Alunos do grupo Leitura:\n* 951 - Bruna - Contabilidade\n",cont.listaGrupo("leitura"));
		cont.alocaAluno("423", "Leitura");
		assertEquals("Alunos do grupo Leitura:\n* 951 - Bruna - Contabilidade\n* 423 - Clara - Artes\n", cont.listaGrupo("Leitura"));
		assertEquals("Grupo não cadastrado.", cont.listaGrupo("Projeto"));
	}
	
	@Test
	void testRegistrarAlunos() {
		cont.cadastraAluno("951", "Bruna", "Contabilidade");
		assertEquals("ALUNO REGISTRADO!", cont.registraAlunos("951"));
		assertEquals("ALUNO REGISTRADO!", cont.registraAlunos("951"));
		cont.cadastraAluno("423", "Clara", "Artes");
		assertEquals("ALUNO REGISTRADO!", cont.registraAlunos("423"));
		assertEquals("Aluno não cadastrado.", cont.registraAlunos("456"));
		cont.cadastraAluno("741", "Luciana", "Direito");
		assertEquals("ALUNO REGISTRADO!", cont.registraAlunos("741"));
	}
	
	@Test
	void testImprimeQuadro() {
		cont.cadastraAluno("741", "Luciana", "Direito");
		cont.cadastraAluno("423", "Clara", "Artes");
		cont.cadastraAluno("951", "Bruna", "Contabilidade");
		assertEquals("Alunos: \n", cont.imprimeQuadro());
		cont.registraAlunos("741");
		assertEquals("Alunos: \n1. 741 - Luciana - Direito\n", cont.imprimeQuadro());
		cont.registraAlunos("741");
		cont.registraAlunos("423");
		assertEquals("Alunos: \n1. 741 - Luciana - Direito\n2. 741 - Luciana - Direito\n3. 423 - Clara - Artes\n", cont.imprimeQuadro());
		cont.registraAlunos("951");
		cont.registraAlunos("951");
		assertEquals("Alunos: \n1. 741 - Luciana - Direito\n2. 741 - Luciana - Direito\n3. 423 - Clara - Artes\n4. 951 - Bruna - Contabilidade\n5. 951 - Bruna - Contabilidade\n", cont.imprimeQuadro());
	}
}
