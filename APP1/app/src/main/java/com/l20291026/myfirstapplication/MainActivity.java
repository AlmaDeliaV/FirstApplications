package com.l20291026.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l20291026.myfirstapplication.usuario.DashboardUsuario;
import com.l20291026.myfirstapplication.usuario.repository.UsuarioRepository;

public class MainActivity extends AppCompatActivity {

    //private  HashMap<String, String> registerUsers= new HashMap<String,String>();
   private UsuarioRepository ur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ur = UsuarioRepository.getInstance();


//local
       // UsuarioRepository ur = UsuarioRepository.getInstance();
       // registerUsers.put("user1","11234");
       // registerUsers.put("user2","21234");
       // registerUsers.put("user3","31234");
    }

    //crear una alerta
    private AlertDialog createAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //operaciones anidadas.
        builder.setTitle(title)
                .setMessage(message);

        return builder.create();

    }
    //Builder() es una clase mutable

    public void  onBtnIngresarTap(View view) {
        //AlertDialog.Builder builders = new AlertDialog.Builder(this);
       // AlertDialog dialog = builders.create();
        EditText etUsuario = findViewById(R.id.etUsuario);//encontrar un id
        EditText etPass = findViewById(R.id.etPassw);

            //obtener los datos del usuario
        String user,pass;
        user= etUsuario.getText().toString();
        pass= etPass.getText().toString();

        if(!ur.getRegisterUsers().containsKey(user)){
      //      builders.create().setTitle("felicidades presionaste boton");
           // dialog.setTitle("felicidades presionaste boton");
           // dialog.setMessage("Usuario no registrado");
            //dialog.show();
            this.createAlertDialog("felicidades presionaste boton","Usuario no registrado").show();
            return;

    /*
            //String con formato
            dialog.setMessage(String.format("datos ingresado\n Usuario:%s\n Password: %s", user,pass));
            dialog.show();
            return; //break

            */

        }
            if(!ur.getRegisterUsers().get(user).containsKey(pass)){
               // dialog.setTitle("ATENCION");
                //dialog.setMessage("La contraseña no coincide");
                //dialog.show();

                this.createAlertDialog("ATENCION","CONTRASEÑA INCORRECTA").show();
                return;
            }
            //else{
         //       dialog.setTitle("Felicidades ingresaste sesion");
           //     dialog.setMessage(String.format("datos ingresado\n Usuario:%s\n Password: %s", user,pass));
             //   dialog.show();

                //Mensajes usndo toast
                String message= "Felicidades ingresaste con exito";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();

                //llamar otros layouts
                //(contexto de quien lo esta lanzando(invocando);this, a quien se va a llamar)
                Intent i = new Intent(this, DashboardUsuario.class);
                i.putExtra("usuario",user);
                i.putExtra("pass", pass);
                //llemada
                startActivity(i);
                //return;
            //}
    }
}