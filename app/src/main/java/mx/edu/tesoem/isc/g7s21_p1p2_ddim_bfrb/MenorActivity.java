package mx.edu.tesoem.isc.g7s21_p1p2_ddim_bfrb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenorActivity extends AppCompatActivity {

    String nombre;
    TextView lblsaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menor);
        lblsaludo = findViewById(R.id.lblmenor);
        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString("nombre");
        lblsaludo.setText("Bienvenido " +nombre +"  veo que eres menor de edad");
    }
    public void btnclick(View v) {

        Intent intent = new Intent(MenorActivity.this, DatosActivity.class);
        startActivity(intent);
        finish();
    }
}