package eventos.modelo.dao;

import eventos.modelo.entitis.Usuario;

public interface UsuarioDao {
	Usuario buscarUsuarioPorId (String username);
	boolean registro (Usuario usuario);
	Usuario login (String username, String password);
	Usuario buscarPorUsername (String username);
}
