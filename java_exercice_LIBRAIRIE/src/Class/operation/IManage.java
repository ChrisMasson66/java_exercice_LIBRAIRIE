package Class.operation;

import java.util.Map;


/*Interface que l'on va utiliser pour le model generique*/
 public interface IManage<T>{
	
	 Map<Integer,T> selectAllItems();
	 T selectItem(Integer obj);
	  void addItem(T obj);	
	  void deleteItem(Integer obj);
	  T updateItem(Integer obj);

}
 
 

