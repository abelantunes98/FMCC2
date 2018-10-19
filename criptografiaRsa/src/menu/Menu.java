package menu;

import java.util.Arrays;
import java.util.Scanner;

import criptografiaRsaImpl.CriptoRsa;
import util.GeraPrimos;

public class Menu {
	
	Scanner sc;
	CriptoRsa cripto;
	
	public Menu() {
		this.sc = new Scanner(System.in);
		cripto = new CriptoRsa();
	}
	
	public void iniciaMenu() {
		
		System.out.print("Criptografia RSA\n\nVocê deseja (C)ifrar ou (D)ecifrar? (S para sair) ");
		
		String escolha = sc.nextLine();
		switch (escolha){
		
		case "c":
			System.out.print("insira o texto: ");
			String texto = sc.nextLine();
			System.out.print("\nDeseja (E)scolher os números primos ou usar números (A)leatorios? ");
			
			int num1 = 0, num2 = 0;
			switch (sc.nextLine()) {
			
			case "e":
				System.out.print("\nNum1: ");
				num1 = sc.nextInt();
				sc.nextLine();
				System.out.print("Num2: ");
				num2 = sc.nextInt();
				sc.nextLine();
				break;
				
			case "a":
				GeraPrimos gerador = new GeraPrimos();
				num1 = gerador.retornaPrimosAleatorios();
				num2 = 11;
				break;
			}
						
			String saida = "\nTexto criptografado: " + Arrays.toString(cripto.criptografar(texto, num1, num2)) + "\n\nChave privada: " + cripto.getChavePrivada()
			+ "\nChave pública: " + cripto.getChavePublica();
			System.out.println(saida);
			iniciaMenu();
		
		case "d":
			System.out.print("\nTexto criptografado: ");
			String textoCrip = sc.nextLine();
			System.out.print("\nChave privada: ");
			int chavePriv = sc.nextInt();
			sc.nextLine();
			System.out.print("Chave pública: ");
			int chavePub = sc.nextInt();
			sc.nextLine();
			String saidaDec = "\n" + cripto.decriptografar(textoCrip, chavePriv, chavePub);
			System.out.println(saidaDec);
			System.out.println();
			iniciaMenu();
		
		case "s":
			System.exit(0);
			
		default:
			System.out.println("\nInsira uma opção válida!");
		}
		
	}
	
	public static void main (String[] args) {
		
		Menu menu = new Menu();
		menu.iniciaMenu();
	}
}
