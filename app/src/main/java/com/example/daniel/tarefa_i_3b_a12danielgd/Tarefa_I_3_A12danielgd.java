package com.example.daniel.tarefa_i_3b_a12danielgd;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

public class Tarefa_I_3_A12danielgd extends FragmentActivity {
    private static final int DIALOGO_MENSAXE = 1;
    private static final int DIALOGO_TRES_BOTONS = 2;
    private static final int DIALOGO_LISTA = 3;
    private static final int DIALOGO_RADIO_BUTTON = 4;
    private static final int DIALOGO_CHECK_BOX = 5;
    private static final int DIALOGO_ENTRADA_TEXTO = 6;
    private Tarefa_I_3_DialogoFragmento dialogoFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa__i_3__a12danielgd);
        dialogoFragmento = new Tarefa_I_3_DialogoFragmento();
    }


    public void onBotonClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle argumentos = new Bundle();
        int id=0;
        switch (view.getId()) {
            case R.id.btn_dialogo:
                id=DIALOGO_MENSAXE;
                break;

            case R.id.btn_diag_tres_botons:
                id=DIALOGO_TRES_BOTONS;
                break;

            case R.id.btn_diag_list_selecc:
                id=DIALOGO_LISTA;
                break;

            case R.id.btn_diag_radio_button:
                id=DIALOGO_RADIO_BUTTON;
                break;

            case R.id.btn_diag_checkbox:
                id=DIALOGO_CHECK_BOX;

                break;

            case R.id.btn_diag_entrada_texto:
                id=DIALOGO_ENTRADA_TEXTO;

                break;

            default:
                break;
        }
        argumentos.putInt("id", id);
        dialogoFragmento.setArguments(argumentos);
        dialogoFragmento.show(fm, "");
    }


}