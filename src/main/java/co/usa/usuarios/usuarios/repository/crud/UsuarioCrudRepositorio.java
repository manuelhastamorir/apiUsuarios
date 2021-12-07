package co.usa.usuarios.usuarios.repository.crud;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usa.usuarios.usuarios.model.Usuario;

public interface UsuarioCrudRepositorio extends CrudRepository<Usuario,Integer>
{
      
    @Query
    //Query Methods
    public Optional<Usuario> findByEmail (String email);
    public Optional<Usuario> findByName(String name); 
    public Optional<Usuario> findByPassword(String password);
    
}
