package lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab04.Aluno;
import lab04.Grupo;
/**
 * Classe de testes da Classe Grupo.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
class GrupoTest {
	
	Aluno al1;
	Aluno al2;
	Aluno al3;
	Aluno al4;
	Grupo gr1;
	
	@BeforeEach
	void setUp(){
		al1 = new Aluno("456", "Flávia", "Sociologia");
		al2 = new Aluno("123", "Mariana", "Design");
		al3 = new Aluno("789", "Jeany", "Administração");
		al4 = new Aluno("741", "Yasmin", "Direito");
		gr1 = new Grupo("Estudo");
	}
	
	@Test
	void testNomeNulo() {
		try {
			gr1 = new Grupo(null);
			fail("Deveria ter sido lançada exceção ao passar nome de grupo nulo.");
		} catch (NullPointerException npe) {

		}
	}
	
	@Test
	void testNomeInvalido() {
		try {
			gr1 = new Grupo("        ");
			fail("Deveria ter sido lançada exceção ao passar nome de grupo vazio.");
		} catch (IllegalArgumentException iae) {

		}

		try {
			gr1 = new Grupo("");
			fail("Deveria ter sido lançada exceção ao passar nome de grupo vazio.");
		} catch (IllegalArgumentException iae) {

		}
	}
	
	@Test
	void testAlocarAluno() {
		gr1.alocaAluno(al1);
		// Testa se o aluno foi adicionado atravs do toString do grupo.
		assertEquals("Alunos do grupo Estudo:\n* 456 - Flávia - Sociologia\n", gr1.toString());
	}

	@Test
	void testToString() {
		assertEquals("Alunos do grupo Estudo:\n", gr1.toString());
		gr1.alocaAluno(al1);
		assertEquals("Alunos do grupo Estudo:\n* 456 - Flávia - Sociologia\n", gr1.toString());
		gr1.alocaAluno(al2);
		assertEquals("Alunos do grupo Estudo:\n* 123 - Mariana - Design\n* 456 - Flávia - Sociologia\n",gr1.toString());
		gr1.alocaAluno(al3);
		assertEquals("Alunos do grupo Estudo:\n* 123 - Mariana - Design\n* 456 - Flávia - Sociologia\n* 789 - Jeany - Administração\n", gr1.toString());
		gr1.alocaAluno(al4);
		assertEquals("Alunos do grupo Estudo:\n* 123 - Mariana - Design\n* 741 - Yasmin - Direito\n* 456 - Flávia - Sociologia\n* 789 - Jeany - Administração\n", gr1.toString());
	}

}
