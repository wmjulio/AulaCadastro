package pos.unipe.com.br.cadastro.service;

import android.widget.EditText;
import android.widget.Toast;

import pos.unipe.com.br.cadastro.DetailsActivity;
import pos.unipe.com.br.cadastro.R;
import pos.unipe.com.br.cadastro.model.Person;

public class DetailsHelper {

    private DetailsActivity da;

    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etSite;

    private Person person;

    public DetailsHelper(DetailsActivity da) {

        this.da = da;
        this.person = new Person();

        this.etName = da.findViewById(R.id.idName);
        this.etPhone = da.findViewById(R.id.idPhone);
        this.etEmail = da.findViewById(R.id.idEmail);
        this.etAddress = da.findViewById(R.id.idAddress);
        this.etSite = da.findViewById(R.id.idSite);
    }

    public Person pickPerson(){

        person.setName(etName.getText().toString());
        person.setPhone(etPhone.getText().toString());
        person.setEmail(etEmail.getText().toString());
        person.setAddress(etAddress.getText().toString());
        person.setSite(etSite.getText().toString());

        return this.person;
    }

    public void putPerson(Person person){

        etName.setText(person.getName());
        etPhone.setText(person.getPhone());
        etEmail.setText(person.getEmail());
        etAddress.setText(person.getAddress());
        etSite.setText(person.getSite());

        this.person = person;
    }


}
