package cajero.controlador;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.dao.MovimientoDao;
import cajero.modelo.entity.Cuenta;
import jakarta.servlet.http.HttpSession;

@Controller
public class IngresarController {
	@Autowired
	private CuentaDao cdao;
	
	@Autowired
	private MovimientoDao mdao;
	
	//Para acceder a la página o vista de ingresar:
	@GetMapping("/ingresar")
	public String menuIngresar() {
		return "ingresar";
	}
	
	/*
	 * Al igual que sucede con la home, al haber un formulario con method 'post' se debe hacer un PostMapping.
	 * Se usa HttpSesion para guardar la sesión para que sea consultada en cualquier momento del programa.
	 * Se añade el parámetro saldo en la solicitud, que será el que se ingrese, es decir, lo que escribe el usuario en la caja de texto.
	 * Se incluye RedirectAttributes para mostrar un mensaje.
	 * 
	 * Luego se debe obtener la cuenta actual del usuario de la sesión y aclarar que la variable (cuentai) es de tipo Cuenta.
	 * Para garantizar la sincronización con la base de datos, se ingresa el saldo con la cuenta.
	 * 
	 * Si se ha logrado ingresar dinero, se actualiza la cuenta y se manda un mensaje para que el usuario lo sepa.
	 * Luego se crea un objeto Date llamado 'fi' que almacena la fecha y la hora en que se ha producido el ingreso.
	 * Posteriormente, se llama al método que apunta este ingreso en la tabla de movimientos:
	 * se facilitan la cuenta a la que se ha ingresado dinero, la fecha y hora de la variable recién creada,
	 * el saldo que se ha ingresado y el tipo de operación, en este caso un abono.
	 * 
	 * Si no se ha ingresado dinero, esto figura en un mensaje y no se actualiza la cuenta ni los movimientos.
	 */
	@PostMapping("/ingresar")
	public String ingresarDinero(HttpSession sesion, @RequestParam double saldo, RedirectAttributes ratt) {
	    Cuenta cuentai = (Cuenta) sesion.getAttribute("cuenta");
	    Cuenta cuentaActualizada = cdao.ingresar(cuentai, saldo);
	    if (cuentaActualizada != null) {
	        sesion.setAttribute("cuenta", cuentaActualizada);
	        ratt.addFlashAttribute("mensajePositivo", "Ingreso realizado");
	        Date fi = new Date();
	        mdao.apunteIngreso(cuentai, fi, saldo, "Abono");
			return "redirect:/ingresar";
	    } else {
	        ratt.addFlashAttribute("mensajeNegativo", "Ingreso fallido");
	    }
	    return "redirect:/ingresar";
	}

}
