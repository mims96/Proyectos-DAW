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
public class ExtraerController {
	
	@Autowired
	private CuentaDao cdao;
	
	@Autowired
	private MovimientoDao mdao;
	
	//Este controlador sigue una lógica muy parecida al de ingresar.
	
	@GetMapping("/extraer")
	public String menuExtraer() {
		return "extraer";
	}
	
	@PostMapping("/extraer")
	public String extraerDinero(HttpSession sesion, @RequestParam double saldo, RedirectAttributes ratt) {
	    Cuenta cuentae = (Cuenta) sesion.getAttribute("cuenta");
	    Cuenta cuentaActualizada = cdao.extraer(cuentae, saldo);
	    if (cuentaActualizada != null) {
	        sesion.setAttribute("cuenta", cuentaActualizada);
	        ratt.addFlashAttribute("mensajePositivo", "Extracción realizada");
	        Date fe = new Date();
	        mdao.apunteExtracción(cuentaActualizada, fe, saldo, "Cargo");
			return "redirect:/extraer";
	    } else {
	        ratt.addFlashAttribute("mensajeNegativo", "Saldo insuficiente");
	    }
	    return "redirect:/extraer";
	}

}