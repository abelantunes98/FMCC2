package criptografiaRsaImpl;

import java.math.BigInteger;
import java.util.Arrays;

import util.Util;

public class CriptoRsa {
	
	private String texto;
	private int primo1, primo2, chavePubN, chavePubCoPrimo, funcaoFi, chavePrivadaInverso;
	
	public int[] criptografar(String texto, int primo1, int primo2) {
		
		this.primo1 = primo1;
		this.primo2 = primo2;
		this.texto = texto;
		geraChaves();
		
		int[] arrayRetorno = retornaAscTexto(this.texto);
		for (int i=0 ; i < arrayRetorno.length ; i++) {
			BigInteger novoNum = BigInteger.valueOf (arrayRetorno[i]).modPow (BigInteger.valueOf (this.chavePubCoPrimo), BigInteger.valueOf (this.chavePubN));
			arrayRetorno[i] = novoNum.intValue();
		}
		
		return arrayRetorno;
	}
	
	public String decriptografar(String arrayCodStr, int chavePriv, int chavePub) {
		
		String[] array1 = arrayCodStr.split(", ");
		int[] arrayCod = new int[array1.length];
		for (int i=0 ; i < arrayCod.length ; i++) {
			arrayCod[i] = Integer.parseInt(array1[i]);
		}
		
		String saida = "";
		for (int i=0 ; i < arrayCod.length ; i++) {
			BigInteger novoNum = BigInteger.valueOf (arrayCod[i]).modPow (BigInteger.valueOf (chavePriv), BigInteger.valueOf (chavePub));
			arrayCod[i] = novoNum.intValue();
			saida = saida + (char) arrayCod[i];
		}
		
		saida = "Novos valores: " + Arrays.toString(arrayCod) + "\nTradução: " + saida;
		return saida;
	}
	
	public int getChavePrivada() {
		
		return this.chavePrivadaInverso;
	}
	
	public int getChavePublica() {
		
		return this.chavePubN;
	}
	
	private void geraChaves() {
		
		this.chavePubN = primo1 * primo2;
		this.funcaoFi = (primo1 - 1) * (primo2 - 1);
		this.chavePubCoPrimo = geraCoPrimo(this.funcaoFi);
		this.chavePrivadaInverso = Util.calcInversoMultiplicativoModular(chavePubCoPrimo, funcaoFi);
	}
	
	
	private int geraCoPrimo(int totiente) {
		
		int retorno = 0;
		int indice = 2;
		while (indice < totiente && (Util.calcularMdc(totiente, indice) != 1)) {
			
			indice ++;
		}
		
		if (indice < totiente) {
			retorno = indice;
			
			return retorno;
		}
		
		else {
			
			throw new IllegalArgumentException("Não há coPrimos!");
		}
		
	}
	
	private int[] retornaAscTexto(String texto) {
		
		int[] arraySaida = new int[texto.length()];
		for (int i=0 ; i < texto.length() ; i ++) {
			
			arraySaida[i] = (int) (texto.charAt(i));
		}
		
		return arraySaida;
	}
}
