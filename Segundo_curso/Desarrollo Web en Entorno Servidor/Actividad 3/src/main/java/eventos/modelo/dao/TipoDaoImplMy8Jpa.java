package eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.repository.TipoRepository;

@Repository
public class TipoDaoImplMy8Jpa implements TipoDao{
	@Autowired
	private TipoRepository trepo;
}
