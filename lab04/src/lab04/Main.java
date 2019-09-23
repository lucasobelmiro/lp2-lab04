package lab04;

import java.util.Scanner;
/**
 * Main do sistema.
 * 
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		char op;
		
		do {
			menu.opcoes();
			op = sc.next().toUpperCase().charAt(0);

			if (op == 'C') {
				menu.cadastro();
			}
			else if (op == 'E') {
				menu.exibe();
			}
			else if (op == 'N') {
				menu.novoGrupo();
			}
			else if (op == 'A') {
				menu.alocaAlunoGrupo();
			}
			else if (op == 'R') {
				menu.registraAlunoQuadro();
			}
			else if (op == 'I') {
				menu.imprimeQuadro();
			}
			else if (op!='C' && op!='E' && op!='N' && op!='A' && op!='R' && op!='I' && op!='O') {
				System.out.println("Opção Inválida! \n");
				break;
			}				
		} while (op != 'O');
		sc.close();
	}
}

