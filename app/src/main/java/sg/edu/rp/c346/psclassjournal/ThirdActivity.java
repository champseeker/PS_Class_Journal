package sg.edu.rp.c346.psclassjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    ImageView iv;
    TextView tvWeek;
    RadioGroup rg;
    Button btn;

    String code, grade, name;
    Integer week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvWeek = findViewById(R.id.textViewWeek);
        iv = findViewById(R.id.imageView);
        rg = findViewById(R.id.rgGrade);
        btn = findViewById(R.id.buttonSubmit);

        Intent i = getIntent();
        code = i.getStringExtra("Module Code");
        week = i.getIntExtra("Week", 0);
        name = i.getStringExtra("name");

        tvWeek.setText("Week " + week);
        iv.setImageResource(R.drawable.dg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton rb = (RadioButton) findViewById(i);

                grade = rb.getText().toString();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DailyCA wnew = new DailyCA(grade, code, name, week);

                Intent i = new Intent();
                i.putExtra("new", wnew);
                setResult(RESULT_OK, i);
                finish();

            }
        });

    }
}
