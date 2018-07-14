package pos.unipe.com.br.cadastro.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pos.unipe.com.br.cadastro.R;
import pos.unipe.com.br.cadastro.model.Person;

public class PersonAdapter extends BaseAdapter {

    private final List<Person> people;
    private final Activity activity;

    public PersonAdapter(List<Person> people, Activity activity) {
        this.people = people;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int position) {
        return people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return people.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View line = view;

        Person p = people.get(position);

        if(line==null){
            line = this.activity.getLayoutInflater().inflate(R.layout.cell_person, viewGroup, false);
        }

        TextView tvName = line.findViewById(R.id.idNameCell);
        TextView tvPhone = line.findViewById(R.id.idPhoneCell);
        TextView tvEmail = line.findViewById(R.id.idEmailCell);
        TextView tvAddress = line.findViewById(R.id.idAddressCell);
        TextView tvSite = line.findViewById(R.id.idSiteCell);

        tvName.setText(p.getName());
        tvPhone.setText(p.getPhone());

        if(tvEmail != null){
            tvEmail.setText(p.getEmail());
        }
        if(tvAddress != null){
            tvAddress.setText(p.getAddress());
        }
        if(tvSite != null){
            tvSite.setText(p.getSite());
        }

        return line;
    }
}
