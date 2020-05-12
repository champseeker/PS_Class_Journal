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
    ArrayList moduleCodeArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModuleCode);

        moduleCodeArray = new ArrayList<String>();
        moduleCodeArray.add("C347");
        moduleCodeArray.add("C346");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moduleCodeArray );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                String selectedFromList = (String) lv.getItemAtPosition(i);
                intent.putExtra("Module Code", selectedFromList);
                startActivity(intent);

            }
        });

    }
}
