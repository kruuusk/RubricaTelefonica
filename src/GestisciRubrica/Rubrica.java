package GestisciRubrica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Rubrica {
	ArrayList<Contatto> contatti = new ArrayList<Contatto>();

	public void aggiungiContatto(Contatto nuovoContatto) {
		boolean check = false;
		for (Contatto vecchioContatto : this.contatti) {
			if (nuovoContatto.getTelefono() == vecchioContatto.getTelefono()) {
				check = true;
				System.out.println(nuovoContatto.toString() + " già registrato");
				break;
			}
		}
		if (!check) {
			this.contatti.add(nuovoContatto);
		}
	}

	public void rimuoviContatto(Contatto contattoEliminare) {
		boolean check = false;
		for (Contatto vecchioContatto : this.contatti) {
			if (contattoEliminare.getTelefono() != vecchioContatto.getTelefono()) {
				check = true;
				break;
			}
		}
		if (!check) {
			this.contatti.remove(contattoEliminare);
		}
	}

	public String cercaContatto(String nome, String cognome) {
		String contattoCercato = "";
		Iterator<Contatto> i = this.contatti.iterator();
		while (i.hasNext()) {
			Contatto myContact = i.next();
			if (myContact.getNome().equals(nome) && myContact.getCognome().equals(cognome)) {
				contattoCercato = ("Contatto:\n" + myContact.getNome() + " " + myContact.getCognome() + "\nNumero:\n"
						+ myContact.getTelefono());
				break;
			}
		}
		return contattoCercato;
	}
	
	public String cercaContattoNumero(String numero) {
		String contattoCercato = "";
		Iterator<Contatto> i = this.contatti.iterator();
		while (i.hasNext()) {
			Contatto myContact = i.next();
			if (myContact.getTelefono().equals(numero)) {
				contattoCercato = ("Contatto:\n" + myContact.getNome() + " " + myContact.getCognome() + "\nNumero:\n"
						+ myContact.getTelefono());
				break;
			}
		}
		return contattoCercato;
	}
	
	public HashMap<String, Integer> creaMappa() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Integer contatore = 0;
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int j=0;j<alfabeto.length();j++) {
			Iterator<Contatto> i = this.contatti.iterator();
			while (i.hasNext()) {
				Contatto contattoRegistrato = i.next();
				if(alfabeto.charAt(j) == contattoRegistrato.getCognome().toUpperCase().charAt(0)) {
					contatore ++;
				}
			}
			map.put(Character.toString(alfabeto.charAt(j)), contatore);
			contatore = 0;
		}
		return map;		
	}
	
	public HashMap<String, ArrayList<Contatto>> creaMappaLista() {
		HashMap<String, ArrayList<Contatto>> map = new HashMap<String, ArrayList<Contatto>>();
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		ArrayList<Contatto> tmp = null;
		for(int j=0;j<alfabeto.length();j++) {
			tmp = new ArrayList<Contatto>();
			Iterator<Contatto> i = this.contatti.iterator();
			while (i.hasNext()) {
				Contatto contattoRegistrato = i.next();
				if(alfabeto.charAt(j) == contattoRegistrato.getCognome().toUpperCase().charAt(0)) {
					tmp.add(contattoRegistrato);
				}
			}
			map.put(Character.toString(alfabeto.charAt(j)), tmp);
		}
		return map;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contatti == null) ? 0 : contatti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rubrica other = (Rubrica) obj;
		if (contatti == null) {
			if (other.contatti != null)
				return false;
		} else if (!contatti.equals(other.contatti))
			return false;
		return true;
	}

	public ArrayList<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(ArrayList<Contatto> contatti) {
		this.contatti = contatti;
	}
}
