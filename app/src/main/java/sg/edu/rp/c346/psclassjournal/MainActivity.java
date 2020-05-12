package sg.edu.rp.c346.psclassjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa1;
    ArrayList<Module> moduleArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModuleCode);

        moduleArray = new ArrayList<Module>();

        Module web = new Module("C302", "Web Services");
        moduleArray.add(web);
        Module android = new Module("C347", "Android Programming 2");
        moduleArray.add(android);

        aa1 = new ArrayAdapterFirst(this, R.layout.row1, moduleArray);
        lv.setAdapter(aa1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                intent.putExtra("module", moduleArray.get(i));
                startActivity(intent);

            }
        });

    }
}
