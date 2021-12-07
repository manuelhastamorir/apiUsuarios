package co.usa.usuarios.usuarios.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.usuarios.usuarios.model.Usuario;
import co.usa.usuarios.usuarios.repository.crud.UsuarioCrudRepositorio;

@Repository
public class UsuarioRepositorio 
{
    @Autowired
    UsuarioCrudRepositorio usuarioCrudRepositorio;
    
    public List<Usuario>getAll()
    {
        return (List<Usuario>)usuarioCrudRepositorio.findAll();
    }

    public Optional<Usuario>getUsuario(int id)
    {
        return usuarioCrudRepositorio.findById(id);
    }

    public Usuario save(Usuario usua)
    {
        return usuarioCrudRepositorio.save(usua);
    }

    public void delete (Usuario usua)
    {
        usuarioCrudRepositorio.delete(usua);
    }

    public Optional <Usuario>getEmail(String email)
    {
        return usuarioCrudRepositorio.findByEmail(email);
    }

    public Optional<Usuario>getNombre(String name)
    {
        return usuarioCrudRepositorio.findByName(name);
    }

   public Optional<Usuario>getPassword(String password)
   {
       return usuarioCrudRepositorio.findByPassword(password);
   }

}
