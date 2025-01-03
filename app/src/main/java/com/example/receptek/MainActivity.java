package com.example.receptek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText recepieTitleEditText;
    private EditText recepieQualityEditText;
    private EditText recepieDiffEditText;



    private Button addBookButton;

    private ListView bookListView;

    private List<Recept> recepies;
    receptAdapter adapter;


    //private LinearLayout listLinearLayout;
    private TextView detailsTitle;
    private TextView detailsAuthor;
    private TextView detailsPageNumber;
    private TextView detailsRandomYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();




        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = recepieTitleEditText .getText().toString();
                String quality = recepieQualityEditText.getText().toString();
                String diff = recepieDiffEditText.getText().toString();

                if(title.equals("")  || quality.equals("") || diff.equals("") )
                {
                    Toast.makeText(MainActivity.this, "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();

                } else if (Integer.parseInt(quality) < 0 || Integer.parseInt(quality) > 100) {
                    Toast.makeText(MainActivity.this, "A minőségnek 0 és 100 között kell lennie", Toast.LENGTH_SHORT).show();
                }

                else if (Integer.parseInt(diff) < 0 || Integer.parseInt(diff) > 3) {
                    Toast.makeText(MainActivity.this, "A nehézségnek 0 és 3 között kell lennie", Toast.LENGTH_SHORT).show();
                }                else
                {
                    recepies.add(new Recept(title,quality ,diff));
                    adapter.notifyDataSetChanged();
                }


            }
        });

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println();
                Intent details = new Intent(MainActivity.this, DetailsActivity.class);
                details.putExtra("diffKey",recepies.get(i).getDifficulity());
                details.putExtra("titleKey",recepies.get(i).getTitle());
                details.putExtra("qualityKey",recepies.get(i).getQuality());
                startActivity(details);


            }
        });








    }




    public void init()
    {
        recepieTitleEditText = findViewById(R.id.recepieTitleEditText);
        recepieQualityEditText = findViewById(R.id.recepieQualityEditText);
        recepieDiffEditText = findViewById(R.id.recepieDiffEditText);



        addBookButton = findViewById(R.id.addRecepieButton);

        bookListView = findViewById(R.id.bookListView);

        //listLinearLayout = findViewById(R.id.listLinearLayout);
//
//        detailsAuthor = findViewById(R.id.detailsAuthor);
//        detailsPageNumber = findViewById(R.id.detailsPageNumber);
//        detailsRandomYear = findViewById(R.id.detailsRandomYear);

        recepies = new ArrayList<>();
        adapter = new receptAdapter(recepies,MainActivity.this);
        bookListView.setAdapter(adapter);

        recepies.add(new Recept("Test1","3","1"));
        recepies.add(new Recept("Test1","10","1"));
        recepies.add(new Recept("Test1","50","1"));
        recepies.add(new Recept("Test1","50","1"));




    }
}