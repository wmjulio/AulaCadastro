package pos.unipe.com.br.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import pos.unipe.com.br.cadastro.DAO.PersonDAO;
import pos.unipe.com.br.cadastro.adapter.PersonAdapter;
import pos.unipe.com.br.cadastro.model.Person;

public class MainActivity extends AppCompatActivity {

    private Button newBtn;

    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.newBtn = findViewById(R.id.idNewBtn);

        this.newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(i);
            }
        });

        myList = findViewById(R.id.idItemsList);

        registerForContextMenu(myList);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Person p;

                p = (Person) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("selectedPerson", p);
                startActivity(intent);

            }
        });



    }

    public void loadList(){

        PersonDAO personDAO = new PersonDAO(this);

        List<Person> people = personDAO.getList();

        PersonAdapter personAdapter = new PersonAdapter(people, this);

        this.myList.setAdapter(personAdapter);

    }

    @Override
    protected void onResume() {

        loadList();

        super.onResume();

    }

}
