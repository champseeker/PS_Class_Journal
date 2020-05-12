package sg.edu.rp.c346.psclassjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv2;
    Button btnAdd, btnInfo, btnEmail;

    ArrayAdapter aa;
    ArrayList<DailyCA> CA1, CA2;

    Module module;
    String code, name, message;
    int request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv2 = findViewById(R.id.lvDailyGrade);

        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmail);
        btnAdd = findViewById(R.id.buttonAdd);

        CA1 = new ArrayList<DailyCA>();
        CA2 = new ArrayList<DailyCA>();

        DailyCA w1 = new DailyCA("B", "C347", "Android Programming 2", 1);
        CA1.add(w1);
        DailyCA w2 = new DailyCA("C", "C347", "Android Programming 2", 2);
        CA1.add(w2);
        DailyCA w3 = new DailyCA("A", "C347", "Android Programming 2", 3);
        CA1.add(w3);

        Intent i = getIntent();
        module = (Module) i.getSerializableExtra("module");
        code = module.getModuleCode();
        name = module.getModuleName();

        for (int c = 0; c < CA1.size(); c++){
            if(CA1.get(c).getModuleCode().equals(code)){
                CA2.add(CA1.get(c));
            }
        }

        aa = new DailyAdapter(this, R.layout.row, CA2);
        lv2.setAdapter(aa);
        lv2.refreshDrawableState();

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                if(code.equals("C347")){
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                }else if(code.equals("C302")){
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                }

                startActivity(rpIntent);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message = "Hi Faci,\n\nI am Jian Tong\nPlease see my remark so far, Thank you!\n\n";

                for(int i = 0; i<CA2.size(); i++){

                    message += "Week " + CA2.get(i).getWeek() + ": DG: " + CA2.get(i).getDgGrade() + "\n";

                }

                Log.i("TAG", "onClick: lmao " + message);

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(getBaseContext(), ThirdActivity.class);
                intent2.putExtra("Module Code", code);
                intent2.putExtra("Week", (CA2.size() + 1));
                intent2.putExtra("name", name);
                startActivityForResult(intent2, request);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {

                DailyCA newWeek = (DailyCA) data.getSerializableExtra("new");
                CA1.add(newWeek);

                CA2.clear();

                for (int c = 0; c < CA1.size(); c++){
                    if(CA1.get(c).getModuleCode().equals(code)){
                        CA2.add(CA1.get(c));
                    }
                }

                aa = new DailyAdapter(this, R.layout.row, CA2);
                lv2.setAdapter(aa);
                lv2.refreshDrawableState();

            }
        }
    }
}
