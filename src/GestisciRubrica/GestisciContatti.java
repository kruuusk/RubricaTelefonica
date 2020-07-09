package GestisciRubrica;

public class GestisciContatti {

	public static void main(String[] args) {

		Contatto cont1 = new Contatto("Andrea", "Caretto", "389-8984208");
		Contatto cont2 = new Contatto("Gianni", "Bianchi", "389-8954208");
		Contatto cont3 = new Contatto("Paolo", "Rossi", "389-8684208");
		Contatto cont4 = new Contatto("Giorgio", "Galeazzi", "389-8984278");
		Contatto cont5 = new Contatto("Franco", "Franchi", "389-8985208");
		Contatto cont6 = new Contatto("Ciccio", "Ingrassia", "389-8984408");
		Contatto cont7 = new Contatto("Ciccio", "Ingrassia", "389-8984408");
		Contatto cont8 = new Contatto("Roberto", "Baggio", "389-8986608");
		
		Rubrica rub1 = new Rubrica();
		rub1.aggiungiContatto(cont1);
		rub1.aggiungiContatto(cont2);
		rub1.aggiungiContatto(cont3);
		rub1.aggiungiContatto(cont4);
		rub1.aggiungiContatto(cont5);
		rub1.aggiungiContatto(cont6);
		rub1.aggiungiContatto(cont7);
		rub1.aggiungiContatto(cont8);
		System.out.println(rub1.getContatti());
		System.out.println(rub1.cercaContatto("Andrea", "Caretto"));
		System.out.println(rub1.cercaContattoNumero("389-8954208"));
	}

}
