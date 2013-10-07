import java.util.Scanner;


public class EX01_Binario {


	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int risposta =0;
		
		do{
		System.out.println("Inserisci un numero");
		risposta = scanner.nextInt();
		}while(risposta<0);
		
		System.out.println("hai inserito: "+risposta);
		
		String binario = "";
		do{
			binario = risposta%2 + binario;
			risposta /=2;
			
		}while(risposta>0);

		System.out.println("il valore binario è : "+binario);
	}

}
