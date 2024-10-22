package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.modelo.entities.Comercial;
import rest.repository.ComercialRepository;
/*
 * En servicios rest se anota con @Service, que igualmente es muy similar a @Repository.
 */
@Service
public class ComercialServiceImplMy8Jpa implements ComercialService{
	//Se realiza la conexión con el repositorio.
	@Autowired
	private ComercialRepository comercialRepository;

	//Se busca su comercial por su id y si no se encuentra se devuelve null por el optional.
	@Override
	public Comercial buscarUnComercial(int idComercial) {
		return comercialRepository.findById(idComercial).orElse(null);
	}

	//Se devuelve el listado completo de todos los comerciales encontrados.
	@Override
	public List<Comercial> buscarTodosComerciales() {
		return comercialRepository.findAll();
	}

	/*
	 * Aunque el alta no suele dar problemas, por si acaso nos cubrimos con un try-catch
	 * Se insertan los datos del comercial completo que nos llega, siendo su id autoincremental.
	 * Se devuelve el comercial completo.
	 */
	@Override
	public Comercial altaComercial(Comercial comercial) {
		try {
			return comercialRepository.save(comercial);
		}catch (Exception e) {
			return null;
		}
		
	}

	/*
	 * Aquí también es conveniente hacer un try-catch, especialmente por si hubiera presencia de
	 * claves ajenas (aunque en la tabla de Comerciales no es el caso).
	 * Se busca un comercial en función de su id, y si no es nulo (existen ya registros del comercial)
	 * entonces se procede a modificar, no a dar de alta. Se devuelve el comercial completo.
	 */
	@Override
	public Comercial modificarComercial(Comercial comercial) {
		try {
			if(buscarUnComercial(comercial.getIdComercial()) != null)
				return comercialRepository.save(comercial);
			else
				return null;
		}catch (Exception e) {
			return null;
		}
	}

	/*
	 * Como en el caso de eliminar también se pueden levantar excepciones por claves ajenas
	 * también es bueno protegerse con un try-catch.
	 * Por tanto, se busca un comercial según su id, y si es distinto de null (existe),
	 * entonces se elimina y lo que se devuelve es true.
	 * En cualquier otro caso se devuelve false. En estas circunstancias, para ser más específico
	 * se podría devolver un entero distinto para concretar más cada situación en el caso del 'false'.
	 */
	@Override
	public boolean eliminarComercial(int idComercial) {
		try {
			if(buscarUnComercial(idComercial) != null) {
				comercialRepository.deleteById(idComercial);
				return true;
			}else
				return false;
		}catch(Exception e) {
			return false;
		}
	}

	//Se devuelve un listado de comerciales en función del cliente.
	@Override
	public List<Comercial> buscarComercialesPorCliente(int idCliente) {
		return comercialRepository.findCommercialByCustomer(idCliente);
	}

	//Se devuelve un listado completo de los comerciales que han gestionado algún pedido.
	@Override
	public List<Comercial> buscarComercialesConPedidos() {
		return comercialRepository.findCommercialsWithOrders();
	}

}
