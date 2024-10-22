package cajero.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.dao.MovimientoDao;
import cajero.modelo.entity.Cuenta;
import cajero.modelo.entity.Movimiento;
import jakarta.servlet.http.HttpSession;

@Controller
public class MovimientosController {
	@Autowired
	private CuentaDao cdao;
	
	@Autowired
	private MovimientoDao mdao;
		
	/*
	 * Para mostrar el listado de los movimientos, el método necesita la sesión y la información que hay en ella.
	 * Además, los datos del movimiento se le asignan a model para que se muestren en la vista.
	 * Se debe obtener el objeto Cuenta almacenado en la sesión y se hace el casting para asegurarnos de que es de tipo Cuenta.
	 * Dicha cuenta se le asigna a la variable 'cuentam'.
	 * Posteriormente se crea una lista de movimientos llamada 'movimientosListado'.
	 * El método del dao devuelve todos los movimientos de esa cuenta concreta y se almacenan en la lista creada.
	 * Luego la lista de movimientos se le asigna al model con el identificador movimientos para que dicha lista se muestre en la vista.
	 * Finalmente se devuelve la vista con el listado de los movimientos.
	 */
	
	@GetMapping("/movimientos")
	public String listadoMovimientos(HttpSession sesion, Model model) {
		 Cuenta cuentam = (Cuenta) sesion.getAttribute("cuenta");
		 List<Movimiento> movimientosListado = mdao.mostrarTodosMovimientosCuenta(cuentam);
		 model.addAttribute("movimientos", movimientosListado);
		return "movimientos";
	}
	
}
