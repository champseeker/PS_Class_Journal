package sg.edu.rp.c346.psclassjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayAdapterFirst extends ArrayAdapter<Module> {

    private ArrayList<Module> module;
    private Context context;
    private TextView tvC, tvN;

    public ArrayAdapterFirst(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row1, parent, false);

        tvC = rowView.findViewById(R.id.textViewCode);
        tvN = rowView.findViewById(R.id.textViewName);

        Module currentModule = module.get(position);

        tvC.setText(currentModule.getModuleCode());
        tvN.setText(currentModule.getModuleName());

        return rowView;
    }

}
