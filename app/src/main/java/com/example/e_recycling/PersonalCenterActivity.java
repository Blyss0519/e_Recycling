package com.example.e_recycling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonalCenterActivity extends AppCompatActivity {
    private List<Electronics> electronicsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_center);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initElectronics();
        ElectronicsAdapter adapter=new ElectronicsAdapter(PersonalCenterActivity.this,R.layout.electronics_item,electronicsList);
        ListView listView=(ListView) findViewById(R.id.electronics_type_list);
        listView.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this,"You click Settings",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }



    private void initElectronics(){
        Electronics computer=new Electronics("Computer");
        electronicsList.add(computer);
        Electronics cp=new Electronics("Cell Phone");
        electronicsList.add(cp);
        Electronics camera=new Electronics("Camera");
        electronicsList.add(camera);
        Electronics gd=new Electronics("Game Device");
        electronicsList.add(gd);
        Electronics ha=new Electronics("Household Applicances");
        electronicsList.add(ha);
        Electronics ew=new Electronics("Electronic Watch");
        electronicsList.add(ew);
    }
}
