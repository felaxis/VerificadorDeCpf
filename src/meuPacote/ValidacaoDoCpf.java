package meuPacote;

public class ValidacaoDoCpf {

	char calculoComDezDigitos;
	char calculoComOnzeDigitos;

	static int primeiroDigitoVerificador;
	static int segundoDigitoVerificador;


	public static void remocaoDosPontosETracos(String cpf) {
		cpf = cpf.replace("-", "");
		cpf = cpf.replace(".", "");
	}

	private static boolean testeParaPadraoInvalido(String cpf) {
		if (cpf.length() != 11) {
			return (false);
		} else {
			return (true);
		}
	}

	public static void calculoDigito(String cpf) {
		remocaoDosPontosETracos(cpf);
		if (testeParaPadraoInvalido(cpf) == true) {
			primeiroDigitoVerificador = calcularPrimeiroDigitoVerificador(cpf);
			segundoDigitoVerificador = calcularSegundoDigitoVerificador(cpf);
		}
	}	

	private static int calcularValorVezesPeso(String cpf, int contador) {
		int valorVezesPeso;
		valorVezesPeso = Integer.parseInt(cpf.substring(contador, contador+1));
		return valorVezesPeso;
	}
	
	private static int calcularPrimeiroDigitoVerificador(String cpf) {
		int peso = 10;
		int somaDoProdutoPesoPorNumeral = 0;
		int primeiroDigitoVerificador;
		int contador;
		
		for (contador = 0; contador < 9; contador++) {
			somaDoProdutoPesoPorNumeral += (calcularValorVezesPeso(cpf, contador) * peso);
			peso--;
		}
		primeiroDigitoVerificador = 11 - (somaDoProdutoPesoPorNumeral % 11);
		if ((primeiroDigitoVerificador == 10) || (primeiroDigitoVerificador == 11)) {
			primeiroDigitoVerificador = 0;
		}
		return primeiroDigitoVerificador;
	}

	private static int calcularSegundoDigitoVerificador(String cpf) {
		int peso = 11;
		int somaDoProdutoPesoPorNumeral = 0;
		int primeiroDigitoVerificador;
		int contador;
		
		for (contador = 0; contador < 10; contador++) {
			somaDoProdutoPesoPorNumeral += (calcularValorVezesPeso(cpf, contador) * peso);
			peso--;
		}
		primeiroDigitoVerificador = 11 - (somaDoProdutoPesoPorNumeral % 11);
		if ((primeiroDigitoVerificador == 10) || (primeiroDigitoVerificador == 11)) {
			primeiroDigitoVerificador = 0;
		}
		return primeiroDigitoVerificador;
	}

	public static boolean conferirDigitosVerificadores(String cpf) {
		if ((primeiroDigitoVerificador == Integer.parseInt(cpf.substring(9, 10)))
				&& (segundoDigitoVerificador == Integer.parseInt(cpf.substring(10, 11)))) {
			return (true);
		} else {
			return (false);
		}
	}

	public static String criarCpfCompleto(String cpf) {
		String cpfCompleto = null;

		if (conferirDigitosVerificadores(cpf) == (true)) {
			cpfCompleto = (cpf.substring(0, 9) + primeiroDigitoVerificador + segundoDigitoVerificador);
		}
		return cpfCompleto;
	}
	public static String imprimirCpf(String cpf) {
		if (ValidacaoDoCpf.conferirDigitosVerificadores(cpf)) {
			System.out.println("O CPF de número " + ValidacaoDoCpf.criarCpfCompleto(cpf) + " é válido.");
		} else {
			System.out.println("Erro, CPF invalido.");
		}
		return cpf;
		
	}
}
