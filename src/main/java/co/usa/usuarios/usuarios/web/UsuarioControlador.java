package co.usa.usuarios.usuarios.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.usuarios.usuarios.model.Usuario;
import co.usa.usuarios.usuarios.model.reportes.emailPassword;
import co.usa.usuarios.usuarios.service.UsuarioServicio;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UsuarioControlador 
{
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/all")
    public List<Usuario> getUsuarios()
    {
        return usuarioServicio.getAll();
    }

    /* @GetMapping("/{id}")
    public Optional <Usuario>getUsuario(@PathVariable("id") int id)
    {
        return usuarioServicio.getUsuario(id);
    } */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usua)
    {
        return usuarioServicio.save(usua);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update (@RequestBody Usuario usua)
    {
        return usuarioServicio.update(usua);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUsuario(@PathVariable ("id") int id)
    {
        return usuarioServicio.deleteUsuario(id);
    }

    @GetMapping("/{email}")
    public boolean getEmail(@PathVariable ("email") String email)
    {
        //email="mistral@gmail.com";
        return usuarioServicio.getEmail(email);
    }

   /*  @GetMapping("/{name}")
    public Optional<Usuario>getNombre(@PathVariable("name") String name)
    {
        return usuarioServicio.getNombre(name);
    }  */

    @GetMapping("/{email}/{password}")
    public emailPassword getEmailPassword(@PathVariable("email") String email,@PathVariable("password") String password)
    {
        return usuarioServicio.getCorreoPassword(email, password);
    }

}
