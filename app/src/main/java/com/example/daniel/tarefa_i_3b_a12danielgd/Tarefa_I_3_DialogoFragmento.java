package com.example.daniel.tarefa_i_3b_a12danielgd;

/**
 * Created by daniel on 12/10/15.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Tarefa_I_3_DialogoFragmento extends DialogFragment {

    private static final int DIALOGO_MENSAXE = 1;
    private static final int DIALOGO_TRES_BOTONS = 2;
    private static final int DIALOGO_LISTA = 3;
    private static final int DIALOGO_RADIO_BUTTON = 4;
    private static final int DIALOGO_CHECK_BOX = 5;
    private static final int DIALOGO_ENTRADA_TEXTO = 6;
    private int opt;
    private boolean[] opcions={false,true,false,true,false,false,false};
    // Variable para crear as ventás de diálogo
    AlertDialog.Builder venta;


    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int id = getArguments().getInt("id");
        switch (id) {

            case DIALOGO_MENSAXE:
                venta = new AlertDialog.Builder(getActivity());
                venta.setTitle("Atención");
                venta.setMessage("Nova amensaxe. Preme o botón 'Back' para volver á pantalla principal");
                venta.setIcon(android.R.drawable.ic_dialog_email);
                return venta.create();


            case DIALOGO_TRES_BOTONS:
                venta = new AlertDialog.Builder(getActivity());
                venta.setIcon(android.R.drawable.ic_dialog_info);
                venta.setTitle("Enquisa");
                venta.setMessage("Compras sempre en grandes superficies?");
                venta.setCancelable(false);
                venta.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Si */
                        Toast.makeText(getActivity(), "Premeches 'Si'", Toast.LENGTH_SHORT).show();
                    }
                });
                venta.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Non */
                        Toast.makeText(getActivity(), "Premeches'Non'", Toast.LENGTH_SHORT).show();
                    }
                });
                venta.setNeutralButton("Ás veces", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Ás veces */
                        Toast.makeText(getActivity(), "Premeches 'Ás veces'", Toast.LENGTH_SHORT).show();
                    }
                });
                return venta.create();


            case DIALOGO_LISTA:
                venta = new AlertDialog.Builder(getActivity());
                venta.setIcon(android.R.drawable.ic_dialog_alert);
                venta.setTitle("Escolle unha opción");
                venta.setItems(R.array.elementos_dialog_seleccion, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        // O usuario selecciona unha das opcións do listado
                        String[] opcions = getResources().getStringArray(R.array.elementos_dialog_seleccion);
                        Toast.makeText(getContext(), "Seleccionaches: '" + opcions[opcion] + "'", Toast.LENGTH_SHORT).show();
                    }
                });
                return venta.create();


            case DIALOGO_RADIO_BUTTON:
                venta = new AlertDialog.Builder(getActivity());
                venta.setIcon(android.R.drawable.ic_dialog_info);
                venta.setTitle("Selecciona un smartpohone");
                // Non incluír mensaxe dentro de este tipo de diálogo!!!

                final CharSequence[] smartphones = {"iPhone", "Blackberry", "Android"};
                venta.setSingleChoiceItems(smartphones, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        // Evento que ocorre cando o usuario selecciona una opción
                        opt=opcion;
                        Toast.makeText(getContext(), "Seleccionaches: " + smartphones[opcion], Toast.LENGTH_SHORT).show();
                    }
                });
                venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getContext(), "Seleccionaches: "+ smartphones[opt], Toast.LENGTH_SHORT).show();
                    }
                });
                venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getContext(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                return venta.create();


            case DIALOGO_CHECK_BOX:
                venta = new AlertDialog.Builder(getActivity());
                venta.setIcon(android.R.drawable.ic_dialog_info);
                venta.setTitle("Selecciona modos de transporte");
                Resources res = getResources();
                final String[] matriz = res.getStringArray(R.array.elementos_dialog_seleccion2);

                // Non incluír mensaxe dentro de este tipo de diálogo!!!
                venta.setMultiChoiceItems(matriz, opcions, new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                        // Evento que ocorre cando o usuario selecciona unha opción
                        if (isChecked) {
                            Toast.makeText(getContext(), "Seleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                            opcions[opcion] = true;
                        } else{
                            Toast.makeText(getContext(), "Deseleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                            opcions[opcion] = false;
                        }
                    }
                });
                venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        String texto="Seleccionaches: ";
                        for(int i=0;i<matriz.length;i++){
                            if(opcions[i]) texto+=matriz[i]+" ";
                        }

                        Toast.makeText(getContext(), texto, Toast.LENGTH_SHORT).show();
                    }
                });
                venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getContext(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                return venta.create();


            case DIALOGO_ENTRADA_TEXTO:
                // Primeiro preparamos o interior da ventá de diálogo inflando o seu
                // fichero XML
                String infService = Context.LAYOUT_INFLATER_SERVICE;
                LayoutInflater li = (LayoutInflater) getActivity().getSystemService(infService);
                // Inflamos o compoñente composto definido no XML
                View inflador = li.inflate(R.layout.dialogo_entrada_texto, null);
                // Buscamos os compoñentes dentro do Diálogo
                final TextView etNome = (TextView) inflador.findViewById(R.id.et_nome);
                final TextView etContrasinal = (TextView) inflador.findViewById(R.id.et_contrasinal);

                venta = new AlertDialog.Builder(getActivity());
                venta.setTitle("Indica usuario e contrasinal");
                // Asignamos o contido dentro do diálogo (o que inflamos antes)
                venta.setView(inflador);
                // Non se pode incluír unha mensaxe dentro deste tipo de diálogo!!!
                venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Escribiches nome: '" + etNome.getText().toString() + "'. Contrasinal: '" + etContrasinal.getText().toString() + "' e premeches 'Aceptar'",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Premeches en 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                return venta.create();

        }
        return null;
    }
}