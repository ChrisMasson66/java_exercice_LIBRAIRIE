package Class;


public class Emprunt_Builder {
	
	
	private String nomEmprunteur;
	private String nomLivre;
	private String dateEmprunt;
	private String dateRetour;
	private Integer idLivre;
	private Integer idEmprunteur;

	
	
	 public static class Builder {
		 
			private String nomEmprunteur="";
			private String nomLivre ="";
			private String dateEmprunt="";
			private String dateRetour ="";
			private Integer idLivre=0;
			private Integer idEmprunteur=0;


	     public Builder nomEmprunteur(String val)
	         { nomEmprunteur = val;      return this; }
	     
	     public Builder nomLivre(String val)
	         { nomLivre = val;return this; }
	     
	     public Builder dateEmprunt(String val)
	         { dateEmprunt = val;  return this; }
	     
	     
	     public Builder dateRetour(String val)
         { dateRetour = val;  return this; }
	     
	     
	     public Builder idLivre(Integer val)
         { idLivre = val;  return this; }
	     
	     public Builder idEmprunteur(Integer val)
         { idEmprunteur = val;  return this; }
	     
	     	     
	     public Emprunt_Builder build() {
	         return new Emprunt_Builder(this);
	     }
	     
	 }
	
	
	 private Emprunt_Builder(Builder builder) {
			nomEmprunteur=builder.nomEmprunteur;
			nomLivre =builder.nomLivre;
			dateEmprunt=builder.dateEmprunt;
			dateRetour =builder.dateRetour;
			idLivre=builder.idLivre;
			idEmprunteur=builder.idEmprunteur;
			
	 }
		
		
	public Integer getIdLivre() {
		return idLivre;
	}


	public Integer getIdEmprunteur() {
		return idEmprunteur;
	}


	
	public String getnomEmprunteur() {
		return nomEmprunteur;
	}

	public String getnomLivre() {
		return nomLivre;
	}


	public void setnomLivre(String nomLivre) {
		this.nomLivre = nomLivre;
	}


	public String getdateEmprunt() {
		return dateEmprunt;
	}

	
	public String getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	
    @Override
    public String toString() {
   	 
   	 String info = "";
   	 
   	 if(this.dateRetour != "")
   	 {	    		 
   		 info ="Livre: '"+ this.nomLivre + "' Emprunteur: '" + this.nomEmprunteur + "' le" + this.dateEmprunt+ " retourné le:" + this.dateRetour;	    		 
   	 }
   	 
   	 else
   	 {
   		 info = "Livre '"+this.nomLivre  +"' emprunté le "+this.dateEmprunt+" par '"+ this.nomEmprunteur +"' est en attente de retour";
   		
   	 }
   	 
        return info;
    }

}
