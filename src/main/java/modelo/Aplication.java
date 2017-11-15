/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Configuration;

/**
 *
 * @author fran*/

//@Configuration
//@EnableAutoConfiguration 

@SpringBootApplication
public class Aplication {
        public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Aplication.class);
        UsuarioRepository repository = context.getBean(UsuarioRepository.class);
        
        repository.deleteByApellido("Palacios");

        /*Guardar un conjunto de usuarios*/
        repository.save(new Usuario("Jose", "Palacios", 55));
        repository.save(new Usuario("BBBBB", "Martinez", 15));
        repository.save(new Usuario("CCCCCC", "Ruixs", 23));
        repository.save(new Usuario("FFFFF", "Mars", -6));
        
        //repository.delete(repository.findByApellido("Palacios"));

        // findAll heredado de la interface CrudRepository
        Iterable<Usuario> todos = repository.findAll();
        System.out.println("Listar todos los Usuarios:");
        for (Usuario usr : todos) {
            System.out.println("\t" + usr);
        }
        System.out.println();

        // findByEdadLessThan devuelve todos los usuarios con edades menores a la indicada
        Iterable<Usuario> edades = repository.findByEdadLessThan(21);
        System.out.println("Usuarios con edad menor a 21");
        for (Usuario usr : edades) {
            System.out.println("\t" + usr);
        }
        System.out.println();
        
        Iterable<Usuario> otro = repository.findByApellido("Palacios");
        System.out.println("Usuarios con apellido Palacios");
        for (Usuario usr : otro) {
            System.out.println("\t" + usr);
        }
        System.out.println();
                
        //System.out.println("Total: \t" + cuenta);

        /*repository.deleteAll();
        
        Usuario u = new Usuario();*/

        context.close();
    }
    
}
