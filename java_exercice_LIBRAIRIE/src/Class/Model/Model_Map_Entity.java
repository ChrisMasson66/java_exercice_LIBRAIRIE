package Class.Model;

import java.util.HashMap;
import java.util.Map;

import Class.operation.*;

//class spéciale pour la gestion des listes en mode générique
public class Model_Map_Entity<T> implements IManage<T> {
	//init liste
	private Map<Integer,T> ListItems=null;
	
	//objet lamda
	private T entityClass = null;
	
	//init du compteur 
	private Integer idCounter = 1;
	
	public Model_Map_Entity()
	{		
		ListItems = new  HashMap<>();		
	}
	
	//retourne la liste
	@Override
	public  Map<Integer,T> selectAllItems()
	{
		return ListItems;
	}
	
	//récup de l'objet
	@Override
	public  T selectItem(Integer id_obj)
	{
		entityClass = ListItems.get(id_obj);
		
		return entityClass;
	}
	
	//ajout de l'objet
	@Override
	public  void addItem(T obj)
	{
		idCounter=setCounterNumber(); 
		
		ListItems.put(idCounter, obj);
		
		idCounter++;
	}
	
	//suppression objet
	@Override
	public void deleteItem(Integer id_obj)
	  {
		ListItems.remove(id_obj); 
	  }
	
	//récup de l'objet, oui comme selectItem mais C pour ne pas se perdre dans la sémantique
	@Override
	public T updateItem(Integer id_obj)
	  {
		
		entityClass =  this.selectItem(id_obj);
		return entityClass;
		
	  }
	
	
	
	//recalle le compteur pour la liste lamda en cas d'ajout
	private int setCounterNumber() 
	{
		var count = ListItems.size();
		//nouvel id
		count ++;
		return count;
	}
	
	

}
