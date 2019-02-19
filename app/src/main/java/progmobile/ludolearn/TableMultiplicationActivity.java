package progmobile.ludolearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TableMultiplicationActivity extends AppCompatActivity {

    public static final String NBERREURS = "nbErreurs";
    public int reponse1;
    public int reponse2;
    public int reponse3;
    public int reponse4;
    public int reponse5;
    public boolean champsComplets = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        int table = getIntent().getIntExtra(ChoixTableMultiplication.TABLE, 1);
        TextView operation1 = (TextView) findViewById(R.id.operation1);
        TextView operation2 = (TextView) findViewById(R.id.operation2);
        TextView operation3 = (TextView) findViewById(R.id.operation3);
        TextView operation4 = (TextView) findViewById(R.id.operation4);
        TextView operation5 = (TextView) findViewById(R.id.operation5);


        Random random = new Random();
        int randNum = random.nextInt(10) + 1;
        reponse1 = randNum * table;
        operation1.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse2 = randNum * table;
        operation2.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse3 = randNum * table;
        operation3.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse4 = randNum * table;
        operation4.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse5 = randNum * table;
        operation5.setText(randNum + " x " + table + " = ");
    }

    public void valider(View view){
        EditText rep1 = (EditText) findViewById(R.id.rep1);
        EditText rep2 = (EditText) findViewById(R.id.rep2);
        EditText rep3 = (EditText) findViewById(R.id.rep3);
        EditText rep4 = (EditText) findViewById(R.id.rep4);
        EditText rep5 = (EditText) findViewById(R.id.rep5);


        int nbErreurs = 0;

        if (rep1.getText().toString().equals("") || rep2.getText().toString().equals("") || rep3.getText().toString().equals("") || rep4.getText().toString().equals("") || rep5.getText().toString().equals(""))
        {
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show();
            champsComplets = false;
        } else {
            if (Integer.parseInt(rep1.getText().toString()) != reponse1){
                nbErreurs++;
                champsComplets = true;
            }
            if (Integer.parseInt(rep2.getText().toString()) != reponse2){
                nbErreurs++;
                champsComplets = true;
            }
            if (Integer.parseInt(rep3.getText().toString()) != reponse3){
                nbErreurs++;
                champsComplets = true;
            }
            if (Integer.parseInt(rep4.getText().toString()) != reponse4){
                nbErreurs++;
                champsComplets = true;
            }
            if (Integer.parseInt(rep5.getText().toString()) != reponse5){
                nbErreurs++;
                champsComplets = true;
            }
        }

        if (champsComplets) {
            Intent intent = new Intent(this, ResultatFoisActivity.class);
            intent.putExtra(NBERREURS, nbErreurs);
            intent.putExtra("activity","fois");
            startActivity(intent);
            startActivity(intent);
        }
    }
}