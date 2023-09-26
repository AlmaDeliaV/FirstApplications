package com.l20291026.myfirstapplication.usuario.repository;

import com.l20291026.myfirstapplication.usuario.model.Usuario;

import java.util.HashMap;

public class UsuarioRepository {
    //se instancia a si misma
    private static UsuarioRepository repository= null;

    private HashMap<String, HashMap<String, Usuario>> registerUsers;



    //constructor privado; solo ella(la clase) puede acceder a su codigo
    private UsuarioRepository(){
        Usuario u1= new Usuario("user1", "11234","Lala", 25,"lala@gmail.com");
        Usuario u2= new Usuario("user2","21234", "lulu",23,"lulu@gmail.com");
        Usuario u3 = new Usuario("user3","31234","lilo",18,"lilo@gmail.com");

        this.registerUsers= new HashMap<String,HashMap<String,Usuario>>();
        //agregar los datos a hash map
        registerUsers.put(u1.getUsuario(),new HashMap<String, Usuario>());
        registerUsers.get(u1.getUsuario()).put(u1.getPass(),u1);

        registerUsers.put(u2.getUsuario(),new HashMap<String, Usuario>());
        registerUsers.get(u2.getUsuario()).put(u2.getPass(),u2);

        registerUsers.put(u3.getUsuario(),new HashMap<String, Usuario>());
        registerUsers.get(u3.getUsuario()).put(u1.getPass(),u3);


    }
    //constructor estatico singleTon
    public static UsuarioRepository getInstance(){
        //si reposity
        if(repository==null)
            repository= new UsuarioRepository();

        return repository;

    }

    public HashMap<String, HashMap<String, Usuario>> getRegisterUsers() {
        return registerUsers;
    }
}
