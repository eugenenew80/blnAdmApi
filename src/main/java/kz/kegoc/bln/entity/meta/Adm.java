package kz.kegoc.bln.entity.meta;

import kz.kegoc.bln.entity.common.*;
import lombok.*;

@Data
@EqualsAndHashCode(of= {"id"})
public class Adm implements HasId, HasName {
	private Long id;
	private String name;
}
