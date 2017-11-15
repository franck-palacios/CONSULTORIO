/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fran
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    // Obtener una lista de usuarios con el apellido indicado
    List<Usuario> findByApellido(String apellido);

    // Obtener una lista de los usuarios con edad menor a la indicada
    List<Usuario> findByEdadLessThan(Integer edad);
    
    long countByApellido(String apellido);
    
    @Transactional
    void deleteByApellido(String apellido);

    @Transactional
    List<Usuario> removeByApellido(String apellido);

    /*@Modifying
    @Transactional
    @Query("delete from Usuario u where u.apellido = Palacios")*/
    //long deleteByApellido(String apellido);
    //void removeByApellido(String apellido);

}
