package sg.edu.rp.c346.psclassjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> dailyGrade;
    private Context context;
    private TextView tvDG, tvGrade, tvWeek;
    private ImageView moduleImage;

    public DailyAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        dailyGrade = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvDG = rowView.findViewById(R.id.tvDG);
        tvGrade = rowView.findViewById(R.id.tvGrade);
        tvWeek = rowView.findViewById(R.id.tvWeek);

        moduleImage = rowView.findViewById(R.id.iv);


        DailyCA currentDailyGrade = dailyGrade.get(position);

        tvWeek.setText("Week " + currentDailyGrade.getWeek());
        tvDG.setText("DG");
        tvGrade.setText(currentDailyGrade.getDgGrade());
        moduleImage.setImageResource(R.drawable.dg);

        return rowView;
    }

}
