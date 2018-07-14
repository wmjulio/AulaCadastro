package pos.unipe.com.br.cadastro.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pos.unipe.com.br.cadastro.model.Person;

public class PersonDAO extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String TABLE = "TB_CADASTRO";
    private static final String DATABASE = "BD_CADASTRO";

    private static final String ID = DATABASE+"_id";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String SITE = "site";



    public PersonDAO(Context context){
        super(context, DATABASE, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE "+ TABLE +" ("
                +ID+" INTEGER PRIMARY KEY, "
                +NAME+" TEXT NOT NULL, "
                +PHONE+" TEXT, "
                +EMAIL+" TEXT, "
                +ADDRESS+" TEXT, "
                +SITE+" TEXT); ";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertPerson(Person p){
        ContentValues values = new ContentValues();
        values.put(NAME, p.getName());
        values.put(PHONE, p.getPhone());
        values.put(ADDRESS, p.getAddress());
        values.put(EMAIL, p.getEmail());
        values.put(SITE, p.getSite());

        getWritableDatabase().insert(TABLE, null, values);
    }

    public List<Person> getList(){
        List<Person> people = new ArrayList<>();

        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+" ;", null);

        while(c.moveToNext()){
            Person p = new Person();

            p.setId(c.getLong(c.getColumnIndex(ID)));
            p.setName(c.getString(c.getColumnIndex(NAME)));
            p.setPhone(c.getString(c.getColumnIndex(PHONE)));
            p.setEmail(c.getString(c.getColumnIndex(EMAIL)));
            p.setAddress(c.getString(c.getColumnIndex(ADDRESS)));
            p.setSite(c.getString(c.getColumnIndex(SITE)));

            people.add(p);

        }
        c.close();
        return people;
    }

    public boolean isPessoa(String name){
        String[] params = {name};
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+" WHERE "+NAME+" = ?", params);

        int total = c.getCount();
        c.close();
        return total > 0;
    }

    public void updatePerson(Person p){
        ContentValues values = new ContentValues();

        values.put(NAME, p.getName());
        values.put(PHONE, p.getPhone());
        values.put(ADDRESS, p.getAddress());
        values.put(EMAIL, p.getEmail());
        values.put(SITE, p.getSite());

        String [] currentID = {p.getId().toString()};

        getWritableDatabase().update(TABLE, values, ID+"=?", currentID);
    }

    public void removePerson(Person p){
        String [] currentID = {p.getId().toString()};

        getWritableDatabase().delete(TABLE, ID+"=?", currentID);
    }
}
