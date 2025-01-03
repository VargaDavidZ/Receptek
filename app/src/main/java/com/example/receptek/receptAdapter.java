package com.example.receptek;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class receptAdapter extends BaseAdapter
{
    private List<Recept> recepies;
    private Context context;

    public receptAdapter(List<Recept> books, Context context) {
        this.recepies = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return recepies.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.recept_list_item,viewGroup,false);

        TextView recepieTitleTextView = view.findViewById((R.id.recepieTitleTextView));
        TextView recepieQualityTextView = view.findViewById((R.id.recepieQualityTextView));
        TextView recepieDiffTextView = view.findViewById((R.id.recepieDiffTextView));

        LinearLayout listLinearLayout = view.findViewById(R.id.listLinearLayout);

        TextView detailsTitle = view.findViewById(R.id.detailsTitle);
        TextView detailsQuality = view.findViewById(R.id.detailsQuality);
        TextView detailsDiff = view.findViewById(R.id.detailsDiff);



//        listLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                detailsAuthor.setText(books.get(i).getAuthor());
//                detailsTitle.setText(books.get(i).getTitle());
//                detailsPageNumber.setText(books.get(i).getPageNumber());
//            }
//        });


        Button bookDeleteButton = view.findViewById(R.id.bookDeleteButton);


        bookDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Törlés");
                builder.setMessage("Biztosan törli a receptet?");
                int myIndex = i;
                builder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        recepies.remove(myIndex);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Nem",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });



        Recept b1 = recepies.get(i);


        recepieTitleTextView.setText(b1.getTitle());
        recepieQualityTextView.setText(b1.getQuality());
        recepieDiffTextView.setText(b1.getDifficulity());



        return view;
    }
}
