package cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajero.modelo.entity.Cuenta;
import cajero.repository.CuentaRepository;

//Hay que especificar que es un repositorio para que el Autowired lo encuentre.
@Repository
public class CuentaDaoImplMy8Jpa implements CuentaDao{
	//Aquí la fuente de datos no es una lista, sino el repositorio, que establece la conexión con la BBDD para traer información.
	//Se invoca un dato privado del tipo CuentaRepository:
	@Autowired
	private CuentaRepository crepo;

	//Se implementan los métodos:
	
	//El método findAll del JpaRepository aporta una lista de Cuentas
	@Override
	public List<Cuenta> buscarTodas() {
		return crepo.findAll();
	}

	//El findById devuelve un optional. Si la cuenta existe la devuelve, y sino se devuelve un null, como se especifica en el orElse.
	@Override
	public Cuenta buscarUna(int idCuenta) {
		return crepo.findById(idCuenta).orElse(null);
	}

	//Como en el método save desconozco si modifica o si inserta, para asegurarnos que se modifica, si al buscar la cuenta da distinto de nulo
	//significa que la cuenta existe, por lo que se procederá a su modificación. 
	@Override
	public int modificarCuenta(Cuenta cuenta) {
		if (buscarUna(cuenta.getIdCuenta()) != null) {
			crepo.save(cuenta);
			return 1;
		}else
			return 0; //No existe y no se ha podido modificar
	}
	
	/*
	 * El método de ingresar incrementa el saldo preexiste de una cuenta. 
	 * Devuelve dicha cuenta completa para verificar los datos de diversos campos.
	 * El método recibe la cuenta entera para saber a cuál debe afectar la operación, y el saldo para conocer el montante a incrementar.
	 * 
	 * Como las siguientes consultas involucran más fuertemente a la BBDD, se manejarán excepciones para no detener la ejecución del programa.
	 * Posteriormente, se busca una cuenta concreta de la BBDD empleando para ello el identificador, por lo que se obtiene toda la información de la cuenta. 
	 * La cuenta entera se almacena en la variable 'cuentita'
	 * 
	 * Si la cuenta no es nula (existe) al saldo previo se le suma el nuevo saldo.
	 * Tras esto, se modifica y se guarda el nuevo saldo de la cuenta, almacenado en la variable creada, 
	 * y se devuelve el objeto Cuenta con los campos debidamente actualizados.
	 * 
	 * Si no existe la cuenta (null) o si ha habido algún error o excepción se devuelve 'null'.
	 */
	@Override
	public Cuenta ingresar(Cuenta cuenta, double saldo) {
	    try {
	        Cuenta cuentita = buscarUna(cuenta.getIdCuenta());
	        if (cuentita != null) {
	            cuentita.setSaldo(cuentita.getSaldo() + saldo);
	            return crepo.save(cuentita); 
	        } else {
	            return null; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }
	}
	
	/*
	 * La lógica del método extraer es muy parecida al caso anterior. Sin embargo, hay que incorporar pasos extra.
	 * Si la cuenta existe, primero se debe almacenar en una variable el resultado de la resta del saldo previo y el saldo que se extrae.
	 * Si ese saldo almacenado en la variable 'saldoRestante' es negativo (números rojos) se devuelve null y se evita cualquier modificación en la BBDD.
	 * Si el resultado de la resta es positivo (queda saldo en la cuenta), entonces se le asigna el saldo actualizado de la variable al saldo de la cuenta,
	 * y se devuelve la cuenta con los datos modificados y guardados.
	 * Si la cuenta no existe o si hay alguna excepción se devuelve 'null'.
	 */
	@Override
	public Cuenta extraer(Cuenta cuenta, double saldo) {
	    try {
	        Cuenta cuentita = buscarUna(cuenta.getIdCuenta());
	        if (cuentita != null) {
	            double saldoRestante = cuentita.getSaldo() - saldo;
	            if (saldoRestante < 0) {
	                return null;
	            } else {
	                cuentita.setSaldo(saldoRestante); 
	                return crepo.save(cuentita); 
	            }
	        } else {
	            return null;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
