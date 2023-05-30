package Class;

import Class.data.*;
import Class.Model.*;
import Class.operation.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
	

		System.out.println("Book Shop");
		
		//création liste avec l'interface. Et donc, on pourra étendre des fonctionnalités, contraites ... avec la class Map par la suite etc ...
		IManage<Livre> livres = new Model_Map_Entity<Livre>();
		//les auteurs avec l'interface
		IManage<Auteur> auteurs = new Model_Map_Entity<Auteur>();
		//liste des emprunteurs/clients
		IManage<Emprunteur>emprunteurs = new Model_Map_Entity<Emprunteur>();
		
			
		//création des auteurs
		Auteur A1 = new Auteur("H.P. Lovecraft","20-08-1900","USA"); 
		Auteur A2 = new Auteur("Edward Alexander Crowley","20-08-1900","UK"); 
		Auteur A3 = new Auteur("Edgar Allan Poe","20-08-1900","USA"); 
		Auteur A4 = new Auteur("VGE","20-08-1900","Belgique"); 
		Auteur A5 = new Auteur("Pee Wee","20-08-1900","USA"); 
		
		
		//ajout à la liste des auteurs
		auteurs.addItem(A1); //on prendra l'id de la list pour la personne
		auteurs.addItem(A2);
		auteurs.addItem(A3);
		auteurs.addItem(A4);
		auteurs.addItem(A5);
		
		//on ajoute un autre livre dont l'auteur est inconnu et pour test du compteur en ajout à la collection
		Emprunteur cl4 = new Emprunteur("Tracy Lord","Hole in the dark","01 69 70 69 69"); 
		emprunteurs.addItem(cl4);
		
		//récup de l'auteur
		Auteur auteur_update = auteurs.updateItem(4);
		//récup de VGE et on change sa nationalité
		auteur_update.setNationalite("France");//voir résultat liste en mode debug
		
		
		//ajout de nouveaux livres disponibles
		Livre p1 = new Livre(1,"Necronomicon",1,"20-08-1980");//id 1 auteur
		livres.addItem(p1);	
		Livre p2 = new Livre(2,"Ghost",2,"20-08-1980");//id 2 auteur
		livres.addItem(p2);
		Livre p3 = new Livre(3,"The Raven",3,"20-08-1980");//id 3 auteur
		livres.addItem(p3);
		Livre p4 = new Livre(4,"L'affaire Charles Dexter Ward",1,"20-08-1980");//id 1 auteur LOVECRAFT
		livres.addItem(p4);
		Livre p5 = new Livre(5,"Démocratie Française",4,"20-05-1974");//id 4 auteur VGE
		livres.addItem(p5);
		Livre p6 = new Livre(6,"J'irai manger chez vous",4,"20-05-1978");//id 4 auteur VGE
		livres.addItem(p6);
		
		
		//liste des emprunteurs
		Emprunteur cl1 = new Emprunteur("Clara Morgane","VMD Streets","01 69 69 69 69");
		Emprunteur cl2 = new Emprunteur("Claire Chazel","Thailand Streets","01 69 69 66 66"); 
		Emprunteur cl3 = new Emprunteur("Brigitte Lahaie","Orient X Press Street ","01 69 70 69 69"); 
		
		//ajout à la list emprunteurs_builder
		emprunteurs.addItem(cl1);
		emprunteurs.addItem(cl2);
		emprunteurs.addItem(cl3);
		
		
		System.out.println("RESULTATS des AUTEURS et des LIVRES DISPONIBLES");
		
		//apperçu des auteur
		auteurs.selectAllItems().forEach((keyAuteur,auteur) -> livres.selectAllItems().forEach((keyLivre, livre) -> {
			
			if( keyAuteur == livre.getIdAuteur())
			{
				System.out.println( " Auteur : " + auteur.getNom() +" - > Livre: " + livre.getTitre()+" disponible " + livre.getDisponibilite());				
			}	}));
			
		
		//on décide d'emprunter un livre
		Livre livre_emprunte1 = livres.updateItem(1); //le Necronomicon -> updateItem car on va modifier l'objet pour l'emprunt
		
		//l'emprunteur ici C Brigitte id=3 
		Emprunteur Brigitte = emprunteurs.updateItem(3);
		
		//affiche un boolean pour la disponibilité du livre pour Brigitte
		System.out.println("Disponibilité du livre: "+ livre_emprunte1.getTitre() +" -> " + livre_emprunte1.getDisponibilite());
		
		//Brigitte choisie un livre (pas trop dur quand même) et avec un petit pattern builder
		Emprunt_Builder em1 = new Emprunt_Builder.Builder().dateEmprunt("21-12-2023").idLivre(livre_emprunte1.getId()).idEmprunteur(3).nomLivre(livre_emprunte1.getTitre()).nomEmprunteur(Brigitte.getNom()).build();
		
		//le livre "NECRNOMICON" est en mode prêt 		
		livre_emprunte1.EstEmprunteRetourne(); 
		
		//nouvel apperçu et on voit que le NECRONOMICON n'est plus disponible
		auteurs.selectAllItems().forEach((keyAuteur,auteur) -> livres.selectAllItems().forEach((keyLivre, livre) -> {			
			if( keyAuteur == livre.getIdAuteur())
			{
				System.out.println( " Auteur : " + auteur.getNom() +" - > Livre: " + livre.getTitre()+" disponible " + livre.getDisponibilite());				
			}	}));
		
		
		//réponse de la disponibilité qui passe à false
		//System.out.println("Livre retourné: "+livre_emprunte1.getDisponibilite());
	
		//on affecte le livre à la liste des emprunts
		Bibliotheque_Emprunts.ajouterEmprunt(em1);
			
		//affiche le statut de la bibliothèque
		Bibliotheque_Emprunts.afficherListEmprunts();
		
		//le retour du livre par Brigitte après les fêtes
		Bibliotheque_Emprunts.retourLivre(em1.getIdLivre(),"02-01-2024");
		
		//le livre est retourner et on met à jour le livre dans sa liste
		Livre livre_retour = livres.updateItem(em1.getIdLivre());
		//le livre est à nouyveau disponible
		livre_retour.EstEmprunteRetourne(); 
		
		//affiche l'état de la bibliothèque dont on conserve la liste
		Bibliotheque_Emprunts.afficherListEmprunts();
		
		
		//nouvel apperçu et on voit que le NECRONOMICON est disponible
		auteurs.selectAllItems().forEach((keyAuteur,auteur) -> livres.selectAllItems().forEach((keyLivre, livre) -> {			
			if( keyAuteur == livre.getIdAuteur())
			{
				System.out.println( " Auteur : " + auteur.getNom() +" - > Livre: " + livre.getTitre()+" disponible " + livre.getDisponibilite());				
			}	}));
		
		
		//on décide de supprimer VGE, id =4, et son livre considéré trop neuneu

		Auteur auteur_VGE_suppression = auteurs.selectItem(4);		
		livres.selectAllItems().forEach((keyLivre, livre) -> {
								
			if(livre.getIdAuteur()==4)
			{
				System.out.println( " livre Key: " + keyLivre);
				
				System.out.println( " livre à supprimer: " + livre.getTitre());
								
			}
		});
		
		//supression des livres
		livres.deleteItem(5);
		livres.deleteItem(6);
		
		//et on supprime l'auteur
		auteurs.deleteItem(4);
		
		
		
		
		//pour stopper le prog
		System.out.println("FINAL DEBUG");
		
		

		
	}

}
