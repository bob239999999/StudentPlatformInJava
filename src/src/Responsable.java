import java.util.ArrayList;

public class Responsable extends Utilisateur {


    private static Responsable instance;
    private ArrayList<Utilisateur> listeUsers;

    private Responsable() {
        super("Favrelieres", "Hugues");
    }

    public static Responsable getInstance() {
        if (instance == null) {
            instance = new Responsable();
        }
        return(instance);
    }

    public ArrayList<Utilisateur> getListeUsers(){
        return listeUsers;
    }

    public void addUser(Utilisateur u){
        listeUsers.add(u);
    }

    public void removeUser(Utilisateur u){
        listeUsers.remove(u);
    }


    public void planifierCours(Matiere m, Professeur prof, String date, String salle) {

    }

    public void annulerCours(Cours cours) {

    }

    public void inscrireEtudiantMat(Etudiant etu, Matiere ma) {

    }

    public void desinscrireEtudiantMat(Etudiant etu, Matiere ma) {

    }
}