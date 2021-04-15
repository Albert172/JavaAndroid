package umn.ac.id.uts_33036;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //object declaration
    EditText username, password;
    Button buttonLgn;
    Button buttonPfl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        buttonLgn = (Button)findViewById(R.id.buttonLgn);
        buttonPfl = (Button)findViewById(R.id.buttonPfl);

        buttonLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mengubah input menjadi string
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                //credentials sesuai ketentuan UAS
                if (usernameKey.equals("uasmobile") && passwordKey.equals("uasmobilegenap")){

                    //login berhasil
                    Toast.makeText(getApplicationContext(), "Welcome Albert",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();

                }
                else {

                    //login gagal muncul alert
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Wrong Credentials!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }

        });

        //intent untuk profil
        buttonPfl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            }
        });

    }
}