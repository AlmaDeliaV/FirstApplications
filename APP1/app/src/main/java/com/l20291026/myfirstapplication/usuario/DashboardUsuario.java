package com.l20291026.myfirstapplication.usuario;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.l20291026.myfirstapplication.R;
import com.l20291026.myfirstapplication.usuario.model.Usuario;
import com.l20291026.myfirstapplication.usuario.repository.UsuarioRepository;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);

        ur = UsuarioRepository.getInstance();

        //obtener la informacion del activity main
        String  usuario = getIntent().getStringExtra("usuario");
        String pass= getIntent().getStringExtra("pass");

        //obtener la informacion del usuario
        userInfo=ur.getRegisterUsers().get(usuario).get(pass);


        AlertDialog.Builder builders = new AlertDialog.Builder(this);
        AlertDialog dialog = builders.create();
        EditText etUser= findViewById(R.id.etUser);//encontrar un id
        EditText etPassw = findViewById(R.id.etPassw);
        EditText etName = findViewById(R.id.etName);
        EditText etAge = findViewById(R.id.etAge);
        EditText etEmail = findViewById(R.id.etEmail);

        //obtener los datos del usuario
        String user,passw,name,age, email;
        user= userInfo.getUsuario().toString();
        etUser.setText(user);

        passw= userInfo.getPass().toString();
        etPassw.setText(passw);

        name= userInfo.getNombre().toString();
        etName.setText(name);

        age= Integer.toString(userInfo.getEdad());
        etAge.setText(age);

        email= userInfo.getEmail().toString();
        etEmail.setText(email);

        //pass= etPass.getText().toString();

    }
}