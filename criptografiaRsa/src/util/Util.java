package util;

public class Util {

	/**
	 * Verifica se um número recebido é ou não primo.
	 * 
	 * @param n
	 * @return
	 */

	public static boolean isPrime(long n) {
		boolean result = true;
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Calcula o maior divisor comum entre dois números.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	
	public static int calcularMdc(int a, int b) {
		
		int retorno;
		if (a == 0) {
			
			retorno = b;
		}
		
		else {
		retorno = calcularMdc(b % a, a);
		}
		
		return retorno;
	}
	
	/**
	 * Calcula o inverso multiplicativo modular de um número seguindo a versão extendida do algorítmo de Euclides.
	 *   
	 * @param numero
	 * @param modulo
	 * @return
	 */
	public static int calcInversoMultiplicativoModular(int numero, int modulo) {
		
		int aux = 0;
		int dividido = modulo;
		int aux2 = 1;
		int divisor = numero;
		
		while (divisor != 0) {
			
			int resultadoInteiro = dividido / divisor;
			aux = aux2;
			aux2 = dividido - (resultadoInteiro * aux2);
			int divisorAux = divisor;
			divisor = dividido - (resultadoInteiro * divisor);
			dividido = divisorAux;
		}
		
		if (dividido > 1) {
			
			throw new IllegalArgumentException("Não existe inverso multiplicativo modular para esses valores.");
		}
		
		if (aux < 0) {
			
			aux = aux + modulo;
		}
		
		return aux;
	}
}
