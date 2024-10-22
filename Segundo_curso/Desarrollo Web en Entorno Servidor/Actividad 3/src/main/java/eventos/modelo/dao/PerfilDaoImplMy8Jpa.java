package eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitis.Perfil;
import eventos.modelo.repository.PerfilRepository;

@Repository
public class PerfilDaoImplMy8Jpa implements PerfilDao{
	@Autowired
	private PerfilRepository prepo;
	
	//Se realiza un buscarUno según el id, por lo que devuelve un optional en caso de null. 
	@Override
	public Perfil buscarPerfilPorId(int idPerfil) {
		return prepo.findById(idPerfil).orElse(null);
	}
}
