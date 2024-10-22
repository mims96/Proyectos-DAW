package cajero.modelo.dao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajero.modelo.entity.Cuenta;
import cajero.modelo.entity.Movimiento;
import cajero.repository.MovimientoRepository;

@Repository
public class MovimientoDaoImplMy8Jpa implements MovimientoDao{

	@Autowired
	private MovimientoRepository mrepo;
	
	//Como necesito algunos datos de cuenta, establezco un dato privado de su DAO.
	@Autowired
	private CuentaDao cudao;

	//Para utilizar el identificador único que se incrementa automáticamente:
	private static int idAuto;	
	static {
		idAuto = 0;
	}
	
	//Métodos que se tienen que implementar:

	/*
	 * Se van a mostrar todos los movimientos de una cuenta concreta, por lo que se invoca al método personalizado del repositorio 
	 * y se facilita el id de la cuenta correspondiente.
	 * Si la cuenta no existe, se devuelve una lista vacía porque lo exige el método.
	 */
	@Override
	public List<Movimiento> mostrarTodosMovimientosCuenta(Cuenta cuenta) {
		if (cudao.buscarUna(cuenta.getIdCuenta())!= null) {
			return mrepo.buscarCuentaPorId(cuenta.getIdCuenta());
		}else
			return Collections.emptyList();
	}
	
	//Al interactuar con los datos de la BBDD, se van a recoger las posibles excepciones que se pudieran levantar.
	
	/*
	 * Se añaden los parámetros que deben ser usados y/o actualizados en el apunte del ingreso.
	 * El método devuelve un entero para centrarse en el éxito o no de la operación, en lugar de devolver información más detallada.
	 */
	@Override
	public int apunteIngreso(Cuenta cuenta, Date fecha, double cantidad, String operacion) {
		try {
			// Se crea un nuevo objeto de tipo Movimiento y se guarda en la variable denominada 'move'.
			Movimiento move = new Movimiento();
			
			/*
			 * Se obtiene la fecha y hora del momento de la ejecución, y la variable 'fyh' almacena dicha fecha y hora.
			 * Sin embargo, el método espera recibir un Date pero se encuentra con un LocalDateTime, 
			 * lo que genera problemas de compatibilidad. Por tanto, es necesario transformar de LocalDateTime a Date:
			 */
			LocalDateTime fyh = LocalDateTime.now();	
			Date fyhCompatible = Date.from(fyh.atZone(ZoneId.systemDefault()).toInstant());
			
			if (move != null) {
				//El id del movimiento lo establece automáticamente la BBDD.
				move.setIdMovimiento(idAuto);
				/*
				 * Se obtiene el id de la cuenta.
				 * Se busca mediante el método de dao de 'buscarUna' la cuenta entera cuyo id corresponde. Dicho id se almacena en la variable.
				 * Una vez localizada la cuenta correcta, esta será usada para el movimiento.
				 */		
		        int idCuenta = cuenta.getIdCuenta();	        
		        Cuenta cuentaCorrecta = cudao.buscarUna(idCuenta);
		        move.setCuenta(cuentaCorrecta);
		        
		        //Se añaden más datos de los campos de la tabla movimientos.
				move.setFecha(fyhCompatible);
				move.setCantidad(cantidad);
				move.setOperacion("Abono");
				
				//Se modifica el movimiento con los datos facilitados
				mrepo.save(move); 
				return 1;
			}else
				//Si no se ha inicializado adecuadamente el movimiento o si hay excepciones, se devuelve 0 o -1, respectivamente.
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	//La lógica es muy similar a la del método anterior. Solo cambia el String de la operación.
	@Override
	public int apunteExtracción(Cuenta cuenta, Date fecha, double cantidad, String operacion) {
		try {
			Movimiento move = new Movimiento();
			
			LocalDateTime fyh = LocalDateTime.now();	
			Date fyhCompatible = Date.from(fyh.atZone(ZoneId.systemDefault()).toInstant());
			
			if (move != null) {
				move.setIdMovimiento(idAuto);
	
		        int idCuenta = cuenta.getIdCuenta();	        
		        Cuenta cuentaCorrecta = cudao.buscarUna(idCuenta);
		        move.setCuenta(cuentaCorrecta);
		          
				move.setFecha(fyhCompatible);
				move.setCantidad(cantidad);
				move.setOperacion("Cargo");
				
				mrepo.save(move);
				return 1;
			}else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/*
	 * Los métodos concernientes a las transferencias igualmente son muy parecidos, pues en verdad son anotaciones.
	 * Al igual que sucede con el ingreso o la extracción normal, se pasa por parámetro aquello que deba ser actualizado
	 * tras realizar la transferencia.
	 */
	@Override
	public int meIngresanPorTransferencia(Cuenta cuenta, Date fecha, double cantidad, String operacion) {
		try {
			Movimiento move = new Movimiento();
			
			LocalDateTime fyh = LocalDateTime.now();	
			Date fyhCompatible = Date.from(fyh.atZone(ZoneId.systemDefault()).toInstant());
			
			if (move != null) {
				move.setIdMovimiento(idAuto);
	
		        int idCuenta = cuenta.getIdCuenta();	        
		        Cuenta cuentaCorrecta = cudao.buscarUna(idCuenta);
		        move.setCuenta(cuentaCorrecta);
		          
				move.setFecha(fyhCompatible);
				move.setCantidad(cantidad);
				move.setOperacion("Abono por transferencia");
				
				mrepo.save(move);
				return 1;
			}else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int envioPorTransferencia(Cuenta cuenta, Date fecha, double cantidad, String operacion) {
		try {
			Movimiento move = new Movimiento();
			
			LocalDateTime fyh = LocalDateTime.now();	
			Date fyhCompatible = Date.from(fyh.atZone(ZoneId.systemDefault()).toInstant());
			
			if (move != null) {
				move.setIdMovimiento(idAuto);
	
		        int idCuenta = cuenta.getIdCuenta();	        
		        Cuenta cuentaCorrecta = cudao.buscarUna(idCuenta);
		        move.setCuenta(cuentaCorrecta);
		          
				move.setFecha(fyhCompatible);
				move.setCantidad(cantidad);
				move.setOperacion("Cargo por transferencia");
				
				mrepo.save(move);
				return 1;
			}else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	
	}


