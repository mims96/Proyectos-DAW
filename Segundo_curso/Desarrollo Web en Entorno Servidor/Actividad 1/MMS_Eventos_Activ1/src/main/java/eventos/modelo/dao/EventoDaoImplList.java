package eventos.modelo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.javabeans.Evento;

//Se especifica que es un repositorio de datos para poder encontrarlo, ya que la lista hace la función de repositorio:
@Repository

//Se implementa en una lista el interface del Evento (todavía no hay acceso a bases de datos):
public class EventoDaoImplList implements EventoDao{
	
	private List<Evento> lista;
	private static int idAuto;
	
	static {
		idAuto=0;
	}
	
	//En el constructor se arranca un ArrayList, y se crea el método privado cargarLista, donde se simula la creación de varios eventos.
	public EventoDaoImplList() {
		lista= new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {	
		/*
		 * Se necesita crear un SimpleDateFormat para poder configurar o formatear la fecha en el formato que se desee.
		 * En lista.add se debe hacer un parse para que sea un objeto de tipo Date.
		 * Pero estaría manejando un método que arroja excepciones, por lo que hay que capturarlas con un try-catch.
		 */
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
		
		//Necesito tener acceso a los datos de Tipo para poder relacionar el id mediante un método de encontrar por id.
		TipoDaoImplList tdaoim= new TipoDaoImplList();
		
		try {
			lista.add(new Evento(1, "Concierto HZ", "Evento musical para escuchar las obras de Hans Zimmer", fecha.parse("01-12-2023"), 2, "Calle Alemania, 5", "Activo", "s", 1000, 200, 400.50, tdaoim.findById(5)));
			lista.add(new Evento(2, "Despedida de Juan José y Fátima", "Viaje a Ibiza para celebrar el fin de la soltería", fecha.parse("06-06-2024"), 24, "Calle Ushuaia, 90", "Activo", "s", 15, 5, 1578.99, tdaoim.findById(6)));
			lista.add(new Evento(3, "Cumpleaños de Chloe", "Celebración del 7º cumpleaños de Chloe", fecha.parse("11-02-2024"), 4, "Calle del Tractor, 2", "Activo", "s", 30, 7, 99.99, tdaoim.findById(7)));
			lista.add(new Evento(4, "Boda juvenil", "Evento nupcial entre Lola y Dani", fecha.parse("07-07-2024"), 10, "Calle de la Cuchara, 20", "Activo", "s", 78, 12, 6000.35, tdaoim.findById(8)));
			//El siguiente evento no debe figurar en la lista de activos porque está cancelado, pero sí que saldría en la lista completa de todos los eventos con findAll().
			lista.add(new Evento(5, "Boda senior", "Casamiento en la residencia", fecha.parse("20-04-2024"), 3, "Calle de la Plata, 75", "Cancelado", "s", 100, 18, 1000.89, tdaoim.findById(8)));
			idAuto=5;
		
		} catch (ParseException e) {
			e.printStackTrace();}
		}
		
	// Se añaden los métodos no implementados tras pulsar en EventoDaoImplList.
	
	/*
	 * Si el evento es igual al evento que llega, se recorre la lista y al encontrar el evento correspondiente se devuelve el objeto.
	 * De lo contrario, el evento  no existe.
	 */
	@Override
	public Evento findById(int idEvento) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getIdEvento()==idEvento)
				return lista.get(i);
		}
		return null;
	}

	//El método buscar todos devuelve la lista completa de eventos.
	@Override
	public List<Evento> findAll() {
		return lista;
	}

	/*
	 * Se pasa el evento con todo menos el id. Si la lista no contiene el evento (porque se quiere dar de alta),
	 * el insert asigna el id y al llamarlo él asigna un número. Devuelve 1 si se añade o 0 si no lo inserta.
	 */
	@Override
	public int insert(Evento evento) {
		if (!lista.contains(evento)) {
			evento.setIdEvento(++idAuto);
			lista.add(evento);
			return 1;
		}
		return 0;
	}

	/*
	 * Se llama al buscar por id. Si devuelve nulo entonces el evento no existe y, por tanto, no se borra.
	 * Sino se elimina y se devuelve un 1.
	 */
	@Override
	public int delete(int idEvento) {
		Evento evento = findById(idEvento);
		if (evento==null)
			return 0;
		return lista.remove(evento) ? 1 : 0;
	}

	/*
	 * Para cancelar un evento concreto primero se debe buscar. Si no hay evento no se puede cancelar y se devuelve 0.
	 * En cambio, si existe dicho evento, su atributo estado pasa a ser "cancelado" y se devuelve 1.
	 */
	@Override
	public int cancelar(int idEvento) {
		Evento evento = findById(idEvento);
		if (evento==null)
			return 0;
		else {
			evento.setEstado("cancelado");
			return 1;
		}
	}

	/*
	 * Finalmente, para que en el home figuren solo los eventos activos hay que realizar una especie findAll más concreto.
	 * Se recorre toda la lista completa y aquellos eventos cuyo estado sea "activo" se añaden a la lista de activos.
	 * Por consiguiente, la lista de activos contendrá todos los eventos activos que han ido añadiéndose sucesivamente.
	 */
	@Override
	public List<Evento> findActivos() {
		List<Evento> listaActivos = new ArrayList<>();

        for (Evento evento : lista) {
            if (evento.getEstado().equalsIgnoreCase("activo")) {
                listaActivos.add(evento);  
            }
        }
        return listaActivos;
	}	
}
