package Class.operation;

//import Class.Livre_Builder;
import Class.Livre;

public class Notyfication_Emprunt extends Observer_Emprunt {

	
	public Notyfication_Emprunt(Livre livre)
	{
		this.livre = livre;
		this.livre.attach(this);
	}
	
	@Override
	public void updateLivreEmprunte() {
		
		if(livre.getDisponibilite()==true) //le livre peut être emprunté
		{
			//le livre est emprunté
			livre.setDisponibilite(false);
			
		}
		else
		{
			//le livre est retourné
			livre.setDisponibilite(true);
			
		}
		
	}
	
	
}
