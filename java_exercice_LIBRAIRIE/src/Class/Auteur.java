package Class;



public class Auteur {
	

	private String nom;
	private String date_naissance;
	private String nationalite;
	
	public Auteur(String nom,String date_naissance,String nationalite)
	{
		this.nom = nom;
		this.date_naissance = date_naissance;
		this.nationalite = nationalite;		
	}
		

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	

	
	
	
}
