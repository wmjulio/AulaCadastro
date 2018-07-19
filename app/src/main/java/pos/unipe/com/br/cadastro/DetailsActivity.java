package pos.unipe.com.br.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pos.unipe.com.br.cadastro.DAO.PersonDAO;
import pos.unipe.com.br.cadastro.model.Person;
import pos.unipe.com.br.cadastro.service.DetailsHelper;

public class DetailsActivity extends AppCompatActivity {

    private Button btnSave;

    private DetailsHelper helper;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        helper = new DetailsHelper(this);

        Intent intent = this.getIntent();
        this.person = (Person) intent.getSerializableExtra("selectedPerson");

        if(this.person != null){
            this.helper.putPerson(this.person);
        }

        btnSave = findViewById(R.id.idSaveBtn);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person p = helper.pickPerson();

                PersonDAO personDAO = new PersonDAO(DetailsActivity.this);

                if(p.getId() == null){
                    personDAO.insertPerson(p);
                }else{
                    personDAO.updatePerson(p);
                }

                personDAO.close();

                finish();

            }
        });


    }
}
