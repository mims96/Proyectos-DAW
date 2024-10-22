package eventos.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.javabeans.Evento;
import eventos.modelo.javabeans.Tipo;

//Se determina que es un repositorio de datos y así poder hallarlo. La lista hace la función de repositorio:
@Repository

//Se implementa en una lista el interface del Evento:
public class TipoDaoImplList implements TipoDao{
	private List<Tipo> lista;
	private static int idAuto;
	
	static {
		idAuto=0;
	}
	
	//Se arranca un ArrayList en el constructor, y se crea el método privado cargarLista, donde se simula la creación de varios tipos.
	public TipoDaoImplList() {
		lista= new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {
		/*
		 * Al no contar la clase Tipo con ningún atributo privado de tipo Date o un objeto entero de otra clase,
		 * no es necesario crear nada extra, por lo que simplemente se rellena el constructor.
		 */
		lista.add(new Tipo(5, "Concierto", "Asistencia a teatro cubierto"));
		lista.add(new Tipo(6, "Despedida", "Bailes hasta altas horas de la madrugada"));
		lista.add(new Tipo(7, "Cumpleaños", "Merienda con piñata y tarta"));
		lista.add(new Tipo(8, "Boda", "Evento religioso y cena en un castillo"));
		idAuto=4;
	}

	/*
	 * Se añaden los métodos no implementados tras pulsar en TipoDaoImplList.
	 * Si el tipo es igual al tipo que llega, se recorre la lista y al encontrar el tipo correspondiente se devuelve el objeto.
	 * De lo contrario, el tipo  no existe.
	 */
	@Override
	public Tipo findById(int idTipo) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getIdTipo()==idTipo)
				return lista.get(i);
		}
		return null;
	}

	//El método buscar todos devuelve la lista completa de eventos.
	@Override
	public List<Tipo> findAll() {
		return lista;
	}

}
