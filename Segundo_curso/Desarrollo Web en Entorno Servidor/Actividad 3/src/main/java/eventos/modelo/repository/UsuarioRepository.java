package eventos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.entitis.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	/*
	 * Esto devuelve un usuario, y le paso un String con el user y la password,
	 * cada uno para cada interrogante.
	 */
	@Query ("select u from Usuario u where u.username=?1 and u.password=?2")
	public Usuario usuarioPorUsernameandPassword (String username, String password);
	
	//Se va a buscar un usuario en función de su username.
	@Query ("select u from Usuario u where u.username=?1")
	public Usuario findByUsername(String username);

}
