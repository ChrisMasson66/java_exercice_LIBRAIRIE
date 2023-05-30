package Class.data;

import java.util.Map;

import java.util.HashMap;

import Class.Emprunt_Builder;
import Class.operation.IEmprunt;



 public class Bibliotheque_Emprunts {
	
	 /*
	  * on va prendre une class static
	  * 
	  * on part du principe qu'il n'y aura pas de suppression des emprunts de livre
	  * et que le ficher sera conservé
	  */

	 
	 //init de la list
	 private static final Map<Integer,Emprunt_Builder>Emprunteurs=new HashMap<>();

	 
	//retour liste
	public static Map<Integer,Emprunt_Builder>getListEmprunt()
	{
		return Emprunteurs;
	}
		
	
	//calcul de l'id emprunt pour implementation auto
	private static Integer getId()
	{	
		Integer newId = Emprunteurs.size() + 1;
		
		return newId;
	}
	
	
	//on ajoute un livre.L'emprunt est déjà créé et on l'ajoute à la liste
	public static  void ajouterEmprunt(Emprunt_Builder emprunt)
	{
		try {
			
			//obtient un nouvel id
			Integer Id = getId();
			
			Emprunteurs.put(Id, emprunt);
			
		} catch (Exception e) {
			
			  System.out.println("Something went wrong.");
		}
		
	}
	
	//affichage de la liste
	public static void afficherListEmprunts()
	{
		try {
			

		     for (Map.Entry<Integer,Emprunt_Builder>entry : Emprunteurs.entrySet()) 
		     {
		          System.out.println("id = "+entry.getKey() +" -> "+entry.getValue().toString());   
		    	 
		     }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			  System.out.println("Something went wrong.");
		}
		
	}
	
	
	//retour du livre avec mise à jour pour la date retour
	public static void retourLivre(Integer id_emprunt, String dateRetour)
	{
		try {
			
			Emprunt_Builder emprunt_retour = Emprunteurs.get(id_emprunt);
			emprunt_retour.setDateRetour(dateRetour);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			  System.out.println("Something went wrong.");
		}
		
	}
	

}




