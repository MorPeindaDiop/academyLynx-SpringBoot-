package it.jac.lynx.dto;



import org.springframework.beans.BeanUtils;
import it.jac.lynx.entity.Result;
import lombok.Data;

@Data
public class ResultDTO {
	
	int risultatoAritmetico;
	
	int risultatoPonderato;
	
	public static ResultDTO build(Result risultato) {

		ResultDTO result = new ResultDTO();
		BeanUtils.copyProperties(result, result);

		return result;
	}

}
