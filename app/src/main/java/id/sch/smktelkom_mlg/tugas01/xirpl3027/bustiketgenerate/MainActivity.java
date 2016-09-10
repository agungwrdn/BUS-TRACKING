package id.sch.smktelkom_mlg.tugas01.xirpl3027.bustiketgenerate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spDari,spTujuan;
    TextView tvHasil;
    EditText edNama;
    RadioGroup rgGroup;
    CheckBox biaya, waktu,kursi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNama = (EditText) findViewById(R.id.editTextNama);
        spDari = (Spinner) findViewById(R.id.spinnerDari);
        spTujuan = (Spinner) findViewById(R.id.spinnertujuan);
        tvHasil = (TextView) findViewById(R.id.textViewtampil);
        rgGroup = (RadioGroup) findViewById(R.id.radioGroup);
        biaya = (CheckBox) findViewById(R.id.checkBoxBiaya);
        waktu = (CheckBox) findViewById(R.id.checkBoxWaktu);
        kursi = (CheckBox) findViewById(R.id.checkBoxKursi);
        findViewById(R.id.buttonProses).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;
        if (isValid()) {
            String nama = edNama.getText().toString();

            if (rgGroup.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgGroup.getCheckedRadioButtonId());
                hasil = rb.getText().toString();

                if (rgGroup.getCheckedRadioButtonId() != R.id.PP) {
                    EditText etJA = (EditText) findViewById(R.id.editTextNama);
                    hasil += "\nNama Penumpang : " + etJA.getText();
                }

                String desk = "\nFasilitas Tambahan:\n";
                int startlen = hasil.length();
                if (biaya.isChecked()) desk += biaya.getText() + "\n";
                if (waktu.isChecked()) desk += waktu.getText() + "\n";
                if (kursi.isChecked()) desk += kursi.getText() + "\n";

                tvHasil.setText(" =========SMK TELKOM MALANG=========== \n\n TIKET ANDA DAN TUKARKAN KE LOKET \n\n Nama Penumpang : " + nama+ "\nBus Tujuan " + spDari.getSelectedItem().toString() + "-" + spTujuan.getSelectedItem().toString() + "\n Jenis Tiket : " + hasil + (desk));
            }
        }
    }
    private boolean isValid() {
        boolean valid = true;

        String nama = edNama.getText().toString();

        if (nama.isEmpty()){
            edNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3){
            edNama.setError("Nama minimal 3 karakter");
        }
        else{
            edNama.setError(null);
        }
        return valid;
    }
}
