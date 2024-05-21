package com.joan.joan_tarea_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorDatos extends ArrayAdapter<Dato> {

    private Context mContext;
    private ArrayList<Dato> mDatos;

    public AdaptadorDatos(Context context, ArrayList<Dato> datos) {
        super(context, 0, datos);
        mContext = context;
        mDatos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_dato,parent,false);

        Dato datoActual = mDatos.get(position);

        TextView textViewPrimerNombre = listItem.findViewById(R.id.textViewPrimerNombre);
        textViewPrimerNombre.setText(datoActual.getPrimerNombre());

        TextView textViewApellido = listItem.findViewById(R.id.textViewApellido);
        textViewApellido.setText(datoActual.getApellido());

        TextView textViewAñoNacimiento = listItem.findViewById(R.id.textViewAñoNacimiento);
        textViewAñoNacimiento.setText(String.valueOf(datoActual.getAñoNacimiento()));

        return listItem;
    }
}
