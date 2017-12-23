package kz.kegoc.bln.ejb.mapper;

import org.dozer.DozerBeanMapper;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Arrays;

@Startup
@Singleton
public class BeanMapper {
    private DozerBeanMapper mapper;

    public DozerBeanMapper getMapper() {
        return mapper;
    }

    @PostConstruct
    public void init() {
        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList(
            "mapping/MappingConfig.xml",
            "mapping/adm/FuncDtoDefaultMapping.xml",
            "mapping/adm/RoleDictDtoDefaultMapping.xml",
            "mapping/adm/RoleDtoDefaultMapping.xml",
            "mapping/adm/RoleFuncDtoDefaultMapping.xml",
            "mapping/adm/RoleModuleDtoDefaultMapping.xml",
            "mapping/adm/UserDtoDefaultMapping.xml",
            "mapping/adm/UserRoleDtoDefaultMapping.xml"
        ));
    }
}
