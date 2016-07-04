package meuPacote;

import java.util.Scanner;
import meuPacote.ValidacaoDoCpf;

public class ImpressaoNaTela {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);

		String cpf;

		System.out.printf("Informe o CPF: ");
		cpf = scan.nextLine();
		
		ValidacaoDoCpf.calculoDigito(cpf);
		ValidacaoDoCpf.imprimirCpf(cpf);
	}
}