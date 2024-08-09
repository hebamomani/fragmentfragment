package com.example.fragmentactivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.main_rv);
        ArrayList<Name>names=new ArrayList<>();
        names.add(new Name("Ahmed"));
        names.add(new Name("Mohammed"));
        names.add(new Name("John"));
        names.add(new Name("Ayman"));

        NameAdapter adapter=new NameAdapter(names, new OnItemClickListener() {
            @Override
            public void onItemClick(Name name) {
                Bundle bundle=new Bundle();
                bundle.putString("name",name.getName());
                NameFragment fragment= new NameFragment();
                fragment.setArguments(bundle);
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_fragment,fragment);
                ft.commit();
            }
        });
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}