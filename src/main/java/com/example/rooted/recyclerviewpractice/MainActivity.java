package com.example.rooted.recyclerviewpractice;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    greenAdapter adapter;
    Button add;
    List lines=new ArrayList<String>();
    List number=new ArrayList<Integer>();
//Hello Everyone

    @Override
    protected void onCreate(Bundle savedInstanceState) {
try
{
    setValues();
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    add=findViewById(R.id.add);
    recyclerView=findViewById(R.id.rView);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter=new greenAdapter(this,number,lines);

    recyclerView.setAdapter(adapter);
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

           TextView name,size;

            name=findViewById(R.id.name);
         size=findViewById(R.id.parysize);
            number.add(size.getText());
           lines.add(name.getText());
            Toast.makeText(getApplicationContext(),""+name.getText() + "   "+size.getText(),Toast.LENGTH_LONG).show();
          adapter=new greenAdapter(getApplicationContext(),number,lines);
            recyclerView.setAdapter(adapter);
        }
    });
    new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


            int position=viewHolder.getLayoutPosition();
            number.remove(position);
            lines.remove(position);
            Toast.makeText(getApplicationContext(),position+"DELETED",Toast.LENGTH_LONG).show();
            adapter=new greenAdapter(getApplicationContext(),number,lines);
            recyclerView.setAdapter(adapter);

        }

    }).attachToRecyclerView(recyclerView);

}catch(Exception e)
{
    Toast.makeText(getApplicationContext(),"Exception "+e,Toast.LENGTH_LONG).show();
}



    }

    private void setValues()
    {



        lines.add("Islamic");
        lines.add("Social");
        lines.add("Political");
        lines.add("Economical");
        lines.add("Moral");
        lines.add("Basic");
        lines.add("Pakistan");

        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);
        number.add(7);
    }

}
