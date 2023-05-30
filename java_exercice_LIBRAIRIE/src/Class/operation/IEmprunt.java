package Class.operation;

import Class.Emprunt_Builder;

public interface IEmprunt {
	
	void enregistrePret(final Emprunt_Builder livre, Integer idEmprunt);
	void supprimePret(Integer idEmprunt);

}
