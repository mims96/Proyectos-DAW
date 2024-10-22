package rest.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Se ha creado esta clase configuración por si hiciera falta en algún momento
//hacer un Autowired a ModelMapper.
@Configuration
public class BeanConfiguracion {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
