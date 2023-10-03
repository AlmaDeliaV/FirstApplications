package com.l20291026.myfirstapplication.usuario;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


import com.l20291026.myfirstapplication.R;
import com.l20291026.myfirstapplication.usuario.model.Usuario;
import com.l20291026.myfirstapplication.usuario.repository.UsuarioRepository;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;
    Toolbar toolbar;


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

        //vincular toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        AlertDialog.Builder builders = new AlertDialog.Builder(this);
        AlertDialog dialog = builders.create();
        EditText etUser= findViewById(R.id.etUser);//encontrar un id
        EditText etPassw = findViewById(R.id.etPassw);
        EditText etName = findViewById(R.id.etName);
        EditText etAge = findViewById(R.id.etAge);
        EditText etEmail = findViewById(R.id.etEmail);

        //hacer np editables
        etUser.setFocusable(false);
        etUser.setClickable(false);
        etUser.setCursorVisible(false);

        etPassw.setFocusable(false);
        etPassw.setClickable(false);
        etPassw.setCursorVisible(false);

        etName.setFocusable(false);
        etName.setClickable(false);
        etName.setCursorVisible(false);

        etAge.setFocusable(false);
        etAge.setClickable(false);
        etAge.setCursorVisible(false);

        etEmail.setFocusable(false);
        etEmail.setClickable(false);
        etEmail.setCursorVisible(false);

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

    //barra de navegacion


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        //inflador de menues
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
       // return super.onCreateOptionsMenu(menu);
        return true;
    }

    //saber que opcion se presiono
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        if (item.getItemId()==R.id.miBorrar){
            //Toast.makeText(this, "Borrar", Toast.LENGTH_LONG).show();
            builder.setTitle("Confirmacion").setMessage("Estas seguro de querer borrar los datos?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(getApplicationContext(), "Si", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();
                        }
                    });
            AlertDialog dialog=builder.create();
            dialog.show();

        }else if(item.getItemId()==R.id.miInfo){
            //Toast.makeText(this, "Info", Toast.LENGTH_LONG).show();
            AlertDialog dialog=builder.create();
             dialog.setTitle("Datos");
            dialog.setMessage("Alma Delia Vargas Baltazar\n NC: 20291026");dialog.show();
        }else if(item.getItemId()==R.id.miSetting){
            Toast.makeText(this, "Accediendo a configuración", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


}