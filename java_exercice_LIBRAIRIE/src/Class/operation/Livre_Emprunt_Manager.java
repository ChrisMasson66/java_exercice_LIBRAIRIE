package Class.operation;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import Class.Emprunt_Builder;
import Class.Livre;
import Class.Model.Model_Map_Entity;


//gestion pour l'emprunt des livres
public class Livre_Emprunt_Manager {
	
	private IManage<Emprunt_Builder>emprunts=null;
	
	private Livre emprunteur=null;

		public Livre_Emprunt_Manager()					
				{
					emprunts = new Model_Map_Entity<Emprunt_Builder>();
	
				}
			
		
		public 	IManage<Emprunt_Builder>LivresEmpruntes()
		{
			
			return emprunts;
		}
	     
}
