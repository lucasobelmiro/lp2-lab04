package lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab04.Aluno;
/**
 * Classe de testes da Classe Aluno.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
class AlunoTest {
	
	Aluno al1;
	Aluno al2;
	
	@BeforeEach
	void setUp(){
		al1 = new Aluno("336", "Lucas Belmiro", "Computação");
		al2 = new Aluno("752", "Arthur Machado", "Arquitetura e Urbanismo");
	}

	@Test
	void testAlunoComValoresValidos() {
		assertEquals("336 - Lucas Belmiro - Computação", al1.toString());
		assertEquals("752 - Arthur Machado - Arquitetura e Urbanismo", al2.toString());
	}
	
	@Test
	void testAlunoComValoresNulos() {
		try {
			al1 = new Aluno(null, "Lucas Belmiro", "Computação");
			fail("Deveria ter sido lançada exceção ao passar matrícula nula.");
		} catch (NullPointerException npe) {

		}

		try {
			al1 = new Aluno("336", null, "Computação");
			fail("Deveria ter sido lançada exceção ao passar nome nulo.");
		} catch (NullPointerException npe) {

		}

		try {
			al1 = new Aluno("336", "Lucas Belmiro", null);
			fail("Deveria ter sido lançada exceção ao passar curso nulo");
		} catch (NullPointerException npe) {

		}
	}
	
	@Test
	void testAlunoComValoresInvalidos() {
		try {
			al2 = new Aluno("     ", "Arthur Machado", "Arquitetura e Urbanismo");
			fail("Deveria ter sido lançada exceção ao passar matrícula vazia.");
		} catch (IllegalArgumentException iae) {

		}

		try {
			al2 = new Aluno("", "Arthur Machado", "Arquitetura e Urbanismo");
			fail("Deveria ter sido lançada exceção ao passar matrícula vazia");
		} catch (IllegalArgumentException iae) {

		}

		try {
			al2 = new Aluno("752", "       ", "Arquitetura e Urbanismo");
			fail("Deveria ter sido lançada exceção ao passar nome vazio.");
		} catch (IllegalArgumentException iae) {

		}

		try {
			al2 = new Aluno("752", "", "Arquitetura e Urbanismo");
			fail("Deveria ter sido lançada exceção ao passar nome vazio.");
		} catch (IllegalArgumentException iae) {

		}

		try {
			al2 = new Aluno("752", "Arthur Machado", "        ");
			fail("Deveria ter sido lançada exceção ao passar curso vazio.");
		} catch (IllegalArgumentException iae) {

		}

		try {
			al2 = new Aluno("752", "Arthur Machado", "");
			fail("Deveria ter sido lançada exceção ao passar curso vazio.");
		} catch (IllegalArgumentException iae) {

		}
	}
	
	@Test
	void testToString() {
		assertEquals("336 - Lucas Belmiro - Computação", al1.toString());
		assertEquals("752 - Arthur Machado - Arquitetura e Urbanismo", al2.toString());
	}

}
