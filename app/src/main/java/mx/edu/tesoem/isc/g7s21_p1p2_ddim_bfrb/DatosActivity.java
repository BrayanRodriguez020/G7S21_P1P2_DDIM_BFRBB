package mx.edu.tesoem.isc.g7s21_p1p2_ddim_bfrb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatosActivity extends AppCompatActivity {

    EditText txtnombre;
    EditText txtedad;
    Button btningresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        // Inicializa los elementos del diseño
        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        btningresa = findViewById(R.id.btningresa);

        // Configura el listener del botón
        btningresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnclick(v);
            }
        });
    }

    public void btnclick(View v) {
        // Obtiene el nombre y la edad desde los EditText
        String nombre = txtnombre.getText().toString().trim();
        String edadStr = txtedad.getText().toString().trim();

        // Convierte la edad a un entero sin manejo de excepciones
        int edad = 0;  // Inicializa una variable para la edad
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Edad inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent;
        if (edad < 18) {
            // Si la edad es menor de 18, redirige a MenorActivity
            intent = new Intent(this, MenorActivity.class);
        } else {
            // Si la edad es mayor o igual a 18, redirige a MayorActivity
            intent = new Intent(this, MayorActivity.class);
        }

        // Envía el nombre como un extra en el Intent
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }
}
