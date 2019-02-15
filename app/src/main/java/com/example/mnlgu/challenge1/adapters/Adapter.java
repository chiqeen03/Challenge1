package com.example.mnlgu.challenge1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mnlgu.challenge1.CardActivity;
import com.example.mnlgu.challenge1.R;
import com.example.mnlgu.challenge1.model.Escuela;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecordHolder> {

    private Context context;
    private List<Escuela> escuelaList;
    RequestOptions options;

    public Adapter(Context context, List<Escuela> escuelaList){
        this.context = context;
        this.escuelaList = escuelaList;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
    }

    @NonNull
    @Override
    public Adapter.RecordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_item, viewGroup, false);

        final RecordHolder recordHolder = new RecordHolder(view);

        recordHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Escuela escuela = escuelaList.get(recordHolder.getAdapterPosition());
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(context, CardActivity.class);
                it.putExtra("escuela", escuela);
                context.startActivity(it);
            }
        });

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.RecordHolder recordHolder, int i) {
        recordHolder.nombre.setText(escuelaList.get(i).getNombre());
        recordHolder.campus.setText(escuelaList.get(i).getCampus());
        recordHolder.sitioWeb.setText(escuelaList.get(i).getSitioWeb());
        recordHolder.correoElectronico.setText(escuelaList.get(i).getCorreoElectronico());
        recordHolder.telefono.setText(escuelaList.get(i).getTelefono());

        Glide.with(context).load(escuelaList.get(i).getImagenURL()).apply(options).into(recordHolder.image);
    }

    @Override
    public int getItemCount() {
        return escuelaList.size();
    }

    public static class RecordHolder extends RecyclerView.ViewHolder{

        TextView nombre, campus, telefono, direccion, correoElectronico, sitioWeb;
        ImageView image;

        public RecordHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombre_card);
            campus = itemView.findViewById(R.id.campus_card);
            telefono = itemView.findViewById(R.id.telefono_card);
            //direccion = itemView.findViewById(R.id.direccion_card);
            correoElectronico = itemView.findViewById(R.id.email_card);
            sitioWeb = itemView.findViewById(R.id.sitioWeb_card);
            image = itemView.findViewById(R.id.image_card);

        }
    }
}
