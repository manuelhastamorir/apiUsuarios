package co.usa.usuarios.usuarios.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.usuarios.usuarios.model.Usuario;
import co.usa.usuarios.usuarios.model.reportes.emailPassword;
import co.usa.usuarios.usuarios.repository.UsuarioRepositorio;

@Service
public class UsuarioServicio 
{
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario>getAll()
    {
        return usuarioRepositorio.getAll();
    }

    public Optional<Usuario>getUsuario(int id)
    {
        return usuarioRepositorio.getUsuario(id);
    }

    public Usuario save(Usuario usua)
    {
        //Verificar si el id es nulo
        if (usua.getId()== null) 
        {
            return usuarioRepositorio.save(usua);   
        } 
        else 
        {
            Optional<Usuario>consulta = usuarioRepositorio.getUsuario(usua.getId());
            if (consulta.isEmpty()) 
            {
                return usuarioRepositorio.save(usua);    
            }
            else
            {
                return usua;
            }
        }
    }

    public Usuario update (Usuario usua)
    {
        if(usua.getId()!=null)
        {
            Optional<Usuario> consulta = usuarioRepositorio.getUsuario(usua.getId());
            if (!consulta.isEmpty()) 
            {
                if (usua.getName()!=null) 
                {
                    consulta.get().setName(usua.getName());    
                }
                if (usua.getEmail()!=null)
                {
                    consulta.get().setEmail(usua.getEmail());   
                }
                if (usua.getPassword()!=null) 
                {
                    consulta.get().setPassword(usua.getPassword());
                }
                return usuarioRepositorio.save(consulta.get());
            }
        }
        return usua;
    }

    public boolean deleteUsuario (int id)
    {
        Optional<Usuario> consulta = usuarioRepositorio.getUsuario(id);
        if (!consulta.isEmpty()) 
        {
            usuarioRepositorio.delete(consulta.get());
            return true;    
        }
        return false;
    }

    public boolean getEmail(String email)
    {
        Optional <Usuario>consulta = usuarioRepositorio.getEmail(email);
        if(!consulta.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Optional<Usuario>getNombre(String name)
    {
        return usuarioRepositorio.getNombre(name);
    }

    public emailPassword getCorreoPassword(String email, String password)
    {
        
        Optional<Usuario>consultae = usuarioRepositorio.getEmail(email);
        if(!consultae.isEmpty())
        {
            if(consultae.get().getPassword().equals(password))
            {
                emailPassword reporteEmailPassword = new emailPassword(consultae.get().getId(), consultae.get().getEmail(), consultae.get().getPassword(),consultae.get().getName());
                return reporteEmailPassword;
            }
            else
            {
                emailPassword reporteEmailPassword = new emailPassword(null, email, password, "NO DEFINIDO");
                return reporteEmailPassword;
            }
            
        }
        else
        {
            emailPassword reporteEmailPassword = new emailPassword(null, email, password, "NO DEFINIDO");
            return reporteEmailPassword;
            
        }
        
        
    }


}
