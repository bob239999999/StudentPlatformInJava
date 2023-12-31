import java.time.LocalDate;
import java.util.ArrayList;

public class Etudiant extends Utilisateur implements Observer {
    private ArrayList<TravailEtudiant> listeTravauxEtu;
    private ArrayList<Depot> listeDepots;
    private ArrayList<Matiere> listeMatieres;
    private ArrayList<Note> listeNotes;
    private Bulletin bulletin;

    public Etudiant(String nom, String prenom){
        super(nom,prenom);
        this.listeTravauxEtu = new ArrayList<TravailEtudiant>();
        this.listeDepots = new ArrayList<Depot>();
        this.listeMatieres = new ArrayList<Matiere>();
        this.listeNotes = new ArrayList<Note>();
        this.bulletin = new Bulletin();

    }

    public ArrayList<TravailEtudiant> getListeTravauxEtu() {
        return listeTravauxEtu;
    }

    public ArrayList<Depot> getListeDepots() {
        return listeDepots;
    }

    public ArrayList<Matiere> getListeMatieres() {
        return listeMatieres;
    }

    public ArrayList<Note> getListeNotes() {
        return listeNotes;
    }

    // Getter pour bulletin
    public Bulletin getBulletin() {
        return bulletin;
    }

    public void createTravailEtu(String contenu){
        TravailEtudiant travail = new TravailEtudiant(this, contenu);
        this.listeTravauxEtu.add(travail);
    }

    public void deposerTravailEtu(String titre, RepertoireDepot rep, TravailEtudiant travailEtu) {
        LocalDate currentDate = LocalDate.now();
        
        // Obtenir l'année, le mois et le jour sous forme de chaînes de caractères
        String year = String.valueOf(currentDate.getYear());
        String month = String.format("%02d", currentDate.getMonthValue());
        String day = String.format("%02d", currentDate.getDayOfMonth());
        
        // Concaténer les valeurs pour obtenir "yyyymmdd"
        String concatenatedDate = year + "-" + month + "-" + day;
        Depot dep = new Depot(titre, concatenatedDate, travailEtu);
        rep.addDepot(dep);
        dep.setRepDepot(rep);
    }

    @Override 
    public void afficherPlanning(String dateDeb){
        Etudiant etudiant = this;
        Planning planning = Planning.getInstance();
        ArrayList<Cours> coursDuJour = planning.getCours(dateDeb);
        
        ArrayList<Cours> coursAafficher = new ArrayList<>();
        
        for (Cours cours : coursDuJour) {
            if (etudiant.getListeMatieres().contains(cours.getMatiere())) {
                coursAafficher.add(cours);
            }
        }

        if (coursAafficher.isEmpty()) {
            System.out.printf("Pas de cours programmés pour le %s.", dateDeb);
        } else {
            System.out.printf("Cours programmés pour le %s : \n", dateDeb);
            for (Cours cours : coursAafficher) {
                System.out.println(cours);
            }
        }
    }

    @Override
    public void afficherPlanning(String dateDeb, String dateFin){
            Etudiant etudiant = this;
            Planning planning = Planning.getInstance();
            ArrayList<Cours> coursDuJour = planning.getCours(dateDeb, dateFin);
            
            ArrayList<Cours> coursAafficher = new ArrayList<>();
            
            for (Cours cours : coursDuJour) {
                if (etudiant.getListeMatieres().contains(cours.getMatiere())) {
                    coursAafficher.add(cours);
                }
            }

            if (coursAafficher.isEmpty()) {
                System.out.printf("Pas de cours programmés entre le %s et le %s", dateDeb, dateFin);
            } else {
                System.out.printf("Cours programmés entre le %s et le %s : \n", dateDeb, dateFin);
                for (Cours cours : coursAafficher) {
                    System.out.println(cours);
                }
            }
    }

    @Override
    public void updateNewRep(Matiere mat){
        System.out.println("\n");
    	System.out.printf("%s %s a reçu une notification : un nouveau repertoire a été ouvert dans le module %s. \n", 
                            this.getNom(), this.getPrenom(), mat.getNom());
    }
    
    @Override
    public void updateNewDoc(Matiere mat){
        System.out.println("\n");
    	System.out.printf("%s %s a reçu une notification : un document vient d'être ajouté dans le module %s \n", 
                            this.getNom(), this.getPrenom(), mat.getNom());
    }

}