package Class;
import java.util.ArrayList;
import java.util.List;

import Class.operation.Notyfication_Emprunt;
import Class.operation.Observer_Emprunt;


public class Livre  {
	
	private String NomLivre;	
	private String datePublication;	
	private int id;	//id livre pour auteur
	private int idAuteur; //id auteur
	private boolean  disponibilite=true; //le livre est disponible
	private List<Observer_Emprunt> observers;
	
	public Livre(int id, String NomLivre, int idAuteur,String datePublication)
	{
		this.id=id;
		this.idAuteur = idAuteur;
		this.datePublication = datePublication;
		this.NomLivre = NomLivre;
		observers=new ArrayList<Observer_Emprunt>();		
		new Notyfication_Emprunt(this);
	}
	
	
	//
	public void EstEmprunteRetourne()
	{		
		 notifyEstEmprunte();		
	}
	
	//mise en place d'un pattern observer pour la mise à jour de l'emprunt
	 public void attach(Observer_Emprunt observer){
		 observers.add(observer);
		}
	 
	 //on notifie l'emprunt
	 private void notifyEstEmprunte() {
			for (Observer_Emprunt observer : observers) {
				observer.updateLivreEmprunte();
			}
	 }
	
		
	public String getTitre() {
		return NomLivre;
	}


	public String getDatePublication() {
		return datePublication;
	}

	
	public int getIdAuteur() {
		return idAuteur;
	}

//pour modif
	public void setIdAuteur(int id) {
		this.idAuteur = id;
	}
	
	

	public int getId() {
		return id;
	}

//pour modif
	public void setId(int id) {
		this.id = id;
	}


	public boolean getDisponibilite() {
		return disponibilite;
	}


	//pour modif
	public void setTitre(String titre) {
		this.NomLivre = titre;
	}

	public void setDisponibilite(boolean disponibilite) {
	
		this.disponibilite = disponibilite;
		
	}
//pour modif
	public void setDatePublication(String datePublication) {
		this.datePublication = datePublication;
	}

	

	
}
