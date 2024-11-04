package com.example.tareacheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbCamion;
    private CheckBox cbMoto;
    private CheckBox cbCoche;
    private Button btnEnviar;
    private TextView tvSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar componentes de UI
        cbCamion = findViewById(R.id.cbCamion);
        cbMoto = findViewById(R.id.cbMoto);
        cbCoche = findViewById(R.id.cbCoche);
        btnEnviar = findViewById(R.id.btnEnviar);
        tvSeleccion = findViewById(R.id.tvSeleccion);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarVehiculosSeleccionados();
            }
        });
    }

    // Método para mostrar vehículos seleccionados
    private void mostrarVehiculosSeleccionados() {
        StringBuilder vehiculosSeleccionados = new StringBuilder("Seleccionado: ");

        // Comprobar qué CheckBoxes están seleccionados
        if (cbCamion.isChecked()) {
            vehiculosSeleccionados.append("Camión, ");
        }
        if (cbMoto.isChecked()) {
            vehiculosSeleccionados.append("Moto, ");
        }
        if (cbCoche.isChecked()) {
            vehiculosSeleccionados.append("Coche, ");
        }

        // Quitar la última coma y espacio si hay algún vehículo seleccionado
        if (vehiculosSeleccionados.length() > 12) {
            vehiculosSeleccionados.setLength(vehiculosSeleccionados.length() - 2);
        }

        // Mostrar el resultado
        tvSeleccion.setText(vehiculosSeleccionados.toString());
    }
}
