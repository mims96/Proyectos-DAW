package cajero.controlador;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.dao.MovimientoDao;
import cajero.modelo.entity.Cuenta;
import jakarta.servlet.http.HttpSession;

@Controller
public class TransferenciaController {
	@Autowired
	private CuentaDao cdao;
	
	@Autowired
	private MovimientoDao mdao;
	
	@GetMapping("/transferencia")
	public String menu() {
		return "transferencia";
	}
	
	
	/*
	 * Al método se le debe pasar el atributo de sesión actual.
	 * Además, el usuario del cajero va a introducir dos datos por las cajas de texto, por lo que el método necesita el @RequestParam de cada uno.
	 * Se incluye RedirectAttributes para mostrar un mensaje.
	 * 
	 * Se obtiene el objeto Cuenta que forma parte de la sesión, para mantenerlo en las distintas tareas de la app.
	 * Posteriormente, se busca mediante el método del DAO una cuenta concreta vía su identificador.
	 * Para obtener la fecha y hora del momento de la ejecución se crea un objeto de tipo Date del java.util.
	 * 
	 * A continuación se verifica si la cuenta de destino existe (not null).
	 * En el caso de que no figure en la BBDD, se mostrará el mensaje correspondiente.
	 * 
	 * Una vez que queda desmostrada la existencia de la cuenta de destino, en primer lugar se realiza la extracción
	 * en la cuenta de origen, siendo el resultado de la diferencia entre el saldo inicial y saldo a extraer almacenado en la variable 'extraccion'.
	 * Si la extracción es distinta de nula (hay saldo suficiente), primero se actualiza la sesión con el nuevo saldo tras la extracción
	 * para garantizar la sincronización entre la BBDD y los datos mostrados por pantalla.
	 * 
	 * Posteriormente, se ingresa en la cuenta de destino el saldo escrito por el usuario.
	 * Fruto del intercambio de saldos, es necesario anotar cada movimiento respectivo: 
	 * la extracción para la cuenta de origen y el ingreso para la cuenta de destino. Para ello se emplean los métodos del DAO.
	 * Se avisa al usuario que la transferencia ha sido exitosa.
	 * 
	 * En caso de que la cuenta de destino se vaya por la rama del else (null) no se transfiere ni se apunta nada; solo apararece el mensaje. 
	*/
	@PostMapping("/transferencia")
	public String transferir(HttpSession sesion, @RequestParam double saldo, @RequestParam int idCuenta, RedirectAttributes ratt) {
	    Cuenta cuentaOrigen = (Cuenta) sesion.getAttribute("cuenta");
	    Cuenta cuentaDestino = cdao.buscarUna(idCuenta);
	    Date fyh = new Date();

	    if (cuentaDestino != null) {
	        Cuenta extraccion = cdao.extraer(cuentaOrigen, saldo);

	        if (extraccion != null) {
	            sesion.setAttribute("cuenta", extraccion);

	            Cuenta ingreso = cdao.ingresar(cuentaDestino, saldo);
	                mdao.envioPorTransferencia(cuentaOrigen, fyh, saldo, "Cargo por transferencia");
	                mdao.meIngresanPorTransferencia(cuentaDestino, fyh, saldo, "Abono por transferencia");
	                ratt.addFlashAttribute("mensajePositivo", "Transferencia realizada con éxito");
	        } else {
	            ratt.addFlashAttribute("mensajeNegativo", "Saldo insuficiente para transferir");
	        }
	    } else {
	        ratt.addFlashAttribute("mensajeNegativo", "Cuenta de destino no existe");
	    }

	    return "redirect:/transferencia";
	}
	
}
