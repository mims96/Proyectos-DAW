package eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitis.Usuario;
import eventos.modelo.repository.UsuarioRepository;

//Se debe especificar que este es el repositorio
@Repository
public class UsuarioDaoImplMy8Jpa implements UsuarioDao{
	@Autowired
	private UsuarioRepository urepo;

	@Override
	public Usuario buscarUsuarioPorId(String username) {
		return urepo.findById(username).orElse(null);
	}

	/*
	 * Con este método se busca un usuario por su identificador. Si tras rastrear el username devuelve nulo,
	 * eso quiere decir que dicho usuario no está en la base de datos, por lo que se guarda y se devuelve true.
	 * En caso contrario se devuelve false.
	 */
	@Override
	public boolean registro(Usuario usuario) {
		if(buscarUsuarioPorId(usuario.getUsername())== null) {
			urepo.save(usuario);
			return true;
		}return false;
	}

	/*
	 * Este método es del repository.
	 * Si devuelve un usuario se lo mando, y sino devuelve null.
	 */
	@Override
	public Usuario login(String username, String password) {
		return urepo.usuarioPorUsernameandPassword(username, password);
	}

	
	// Este método devuelve un usuario según su username.
	@Override
	public Usuario buscarPorUsername(String username) {
		return urepo.findByUsername(username);
	}
}
