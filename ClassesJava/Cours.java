public class Cours {
    private String date;
    private String heure;
    private Matiere matiere;
    private Professeur prof;

    public Cours(String date, String heure, Matiere matiere, Professeur prof) {
        this.date = date;
        this.heure = heure;
        this.matiere = matiere;
        this.prof = prof;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Professeur getProf() {
        return this.prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    @Override
    public String toString() {
        String typeCours = "";

        if (this instanceof CM) {
            typeCours = "CM";
        } else if (this instanceof TD) {
            typeCours = "TD";
        } else if (this instanceof TP) {
            typeCours = "TP";
        }

        return "----------\n" +
               matiere.getNom() + " - " + typeCours + "\n" +
               date + " - " + heure + "\n" +
               prof.getNom() + " " + prof.getPrenom() + "\n" +
               "---------";
    }
}