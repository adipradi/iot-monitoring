package com.test.iotmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView txtSuhu, txtKelembaban, txtSoil, txtLdr;

    private DatabaseReference refSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSuhu = findViewById(R.id.txtSuhu);
        txtKelembaban = findViewById(R.id.txtKelembaban);
        txtSoil = findViewById(R.id.txtSoil);
        txtLdr = findViewById(R.id.txtLdr);

        // Connect ke Firebase Realtime Database
        refSensor = FirebaseDatabase.getInstance().getReference("sensor");

        // Listener realtime
        refSensor.limitToLast(1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot child : snapshot.getChildren()) {
                        String suhu = safeGet(child, "suhu");
                        String kelembaban = safeGet(child, "kelembaban");
                        String soil = safeGet(child, "soil_moisture");
                        String ldr = safeGet(child, "ldr");

                        txtSuhu.setText("🌡️ Suhu: " + suhu + " °C");
                        txtKelembaban.setText("💧 Kelembaban: " + kelembaban + " %");
                        txtSoil.setText("🌱 Soil Moisture: " + soil);
                        txtLdr.setText("☀️ LDR: " + ldr);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Data sensor kosong!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Error: " + error.getMessage());
            }
        });
    }

    private String safeGet(DataSnapshot snapshot, String key) {
        Object value = snapshot.child(key).getValue();
        return value != null ? value.toString() : "--";
    }
}
