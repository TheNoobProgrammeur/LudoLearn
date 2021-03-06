package progmobile.ludolearn;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import progmobile.ludolearn.bd.Question;

public class IntrusActivity extends AppCompatActivity {

    public int nQuestion=1;
    public List<Question> listeQuestion;
    public ArrayList<Button> listeBouton = new ArrayList<Button>();
    public ArrayList<Integer> intList = new ArrayList<Integer>();
    public int boutonVrai;
    public static int nbErreurs;
    public boolean choixEffectue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrus);

        nbErreurs = 0;

        creerQuestions();

        // Générer ma liste aléatoire de chiffres sans doublons
        int i=0;
        while (i<10){
            int val = new Random().nextInt(10);
            if (!intList.contains(val)){
                intList.add(val);
                i++;
            }
        }

        //Affichage de ma question
        listeQuestion = Question.listAll(Question.class);

        TextView numeroQuestion = (TextView) findViewById(R.id.textViewNumeroQuestion);
        numeroQuestion.setText(nQuestion + "/10");
        TextView text = (TextView) findViewById(R.id.textViewQuestion);
        text.setText(listeQuestion.get(intList.get(nQuestion-1)).getIntitule());
        Button boutonR1 = (Button) findViewById(R.id.bouton1);
        Button boutonR2 = (Button) findViewById(R.id.bouton2);
        Button boutonR3 = (Button) findViewById(R.id.bouton3);
        Button boutonR4 = (Button) findViewById(R.id.bouton4);

        listeBouton.add(boutonR1);
        listeBouton.add(boutonR2);
        listeBouton.add(boutonR3);
        listeBouton.add(boutonR4);

        Collections.shuffle(listeBouton);
        for (int k =0 ; k<listeBouton.size(); k++){
            if (k==0){
                listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse1());
            } else if (k==1){
                listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse2());
            } else if (k==2){
                listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse3());
            } else {
                listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseVrai());
                boutonVrai=listeBouton.get(k).getId();
            }
        }

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(nQuestion);
    }

    private void creerQuestions() {
        Question question = new Question(
                "Comiques",
                "Coluche",
                "Fernandel",
                "Dany Boon",
                "Raymond Devos",
                "Intrus");
        question.save();

        Question question2 = new Question(
                "Gastronomie",
                "Cassoulet",
                "Fèves au lard",
                "Chili con carne",
                "Couscous",
                "Intrus");
        question2.save();

        Question question3 = new Question(
                "Prénoms",
                "Camille",
                "Dominique",
                "Claude",
                "Bernard",
                "Intrus");
        question3.save();

        Question question4 = new Question(
                "Informatique",
                "Disque dur",
                "Clé USB",
                "Cd-rom",
                "Carte mère",
                "Intrus");
        question4.save();

        Question question5 = new Question(
                "Sportifs",
                "Vincent Moscato",
                "Éric Cantona",
                "Joël Cantona",
                "Zinédine Zidane",
                "Intrus");
        question5.save();

        Question question6 = new Question(
                "Italie",
                "Florence",
                "Turin",
                "Milan",
                "Capri",
                "Intrus");
        question6.save();

        Question question7 = new Question(
                "Fruits et légumes",
                "Pomme",
                "Kiwi",
                "Tomate",
                "Poivron",
                "Intrus");
        question7.save();

        Question question8 = new Question(
                "Flics de choc",
                "G. I. G. N.",
                "R. A. I. D.",
                "G. I. P. N.",
                "B. R. I. G. A. D.",
                "Intrus");
        question8.save();

        Question question9 = new Question(
                "Jeux télévisés",
                "Slam",
                "Mot de passe",
                "Motus",
                "Les 12 coups de midi",
                "Intrus");
        question9.save();

        Question question10 = new Question(
                "Séries policières françaises",
                "Les Cordier, juge et flic",
                "Navarro",
                "Julie Lescaut",
                "Marc Éliott",
                "Intrus");
        question10.save();
    }

    public void suivant(View view) {
        // SI AUCUNE REPONSE N'EST DONNEE
        if(!choixEffectue){
            Toast.makeText(this, "Tu dois choisir une réponse à cette question !", Toast.LENGTH_SHORT).show();
        }

        else{
            choixEffectue = false;
            // REMISE A ZERO DES BOUTONS
            for (int k =0 ; k<listeBouton.size(); k++){
                listeBouton.get(k).getBackground().clearColorFilter();
                listeBouton.get(k).setClickable(true);
            }

            // On passe a la question suivante
            if (nQuestion <11){
                listeBouton.clear();
                TextView text = (TextView) findViewById(R.id.textViewQuestion);
                text.setText(listeQuestion.get(intList.get(nQuestion-1)).getIntitule());
                Button boutonR1 = (Button) findViewById(R.id.bouton1);
                Button boutonR2 = (Button) findViewById(R.id.bouton2);
                Button boutonR3 = (Button) findViewById(R.id.bouton3);
                Button boutonR4 = (Button) findViewById(R.id.bouton4);
                TextView numeroQuestion = (TextView) findViewById(R.id.textViewNumeroQuestion);
                numeroQuestion.setText(nQuestion + "/10");
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setProgress(nQuestion);

                listeBouton.add(boutonR1);
                listeBouton.add(boutonR2);
                listeBouton.add(boutonR3);
                listeBouton.add(boutonR4);

                Collections.shuffle(listeBouton);
                for (int k =0 ; k<listeBouton.size(); k++){
                    if (k==0){
                        listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse1());
                    } else if (k==1){
                        listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse2());
                    } else if (k==2){
                        listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse3());
                    } else {
                        listeBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseVrai());
                        boutonVrai=listeBouton.get(k).getId();
                    }
                }
                System.out.print("ICI");
                if(nQuestion == 10){
                    Button boutonContinuer = findViewById(R.id.intrus_boutonContinuer);
                    boutonContinuer.setText("Résultats");
                }
            }
            else {
                Question.deleteAll(Question.class);
                Intent intent = new Intent(this, ResultatIntrusActivity.class);
                startActivity(intent);
            }
        }
    }
    public void valider(View view) {
        //Gestion des erreurs
        if (view.getId() != boutonVrai){
            nbErreurs++;
        }
        nQuestion++;

        // AFFICHAGE DE LA BONNE REPONSE
        for (int k =0 ; k<listeBouton.size(); k++){
            if(listeBouton.get(k).getId() == boutonVrai) listeBouton.get(k).getBackground().setColorFilter(ContextCompat.getColor(this, R.color.correct), PorterDuff.Mode.MULTIPLY);

            else listeBouton.get(k).getBackground().setColorFilter(ContextCompat.getColor(this, R.color.incorrect), PorterDuff.Mode.MULTIPLY);
            listeBouton.get(k).setClickable(false);
        }
        choixEffectue = true;
    }
}
