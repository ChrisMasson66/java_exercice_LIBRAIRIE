package Class;

public class Emprunteur {
	
	private String nom;
	private String adresse;
	private String numero_telephone;
	
	
	public Emprunteur(String nom,String adresse, String numero_telephone)
	{
		this.nom =nom;
		this.adresse = adresse;
		this.numero_telephone = numero_telephone;
		
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNumero_telephone() {
		return numero_telephone;
	}


	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	
	

}
