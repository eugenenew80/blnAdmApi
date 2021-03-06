package kz.kegoc.bln.entity.adm;

import java.util.List;
import javax.validation.constraints.*;
import kz.kegoc.bln.entity.common.*;
import lombok.*;

@Data
@EqualsAndHashCode(of= {"id"})
public class User implements HasId, HasCode, HasName {
	private Long id;
	
	@NotNull @Size(max = 15)
	private String code;
	
	@NotNull @Size(max = 100)
	private String name;

	@NotNull
	private Long orgId;

	@NotNull @Size(max = 30)
	private String pass;

	private List<UserRole> roles; 
}
