package kz.kegoc.bln.service.adm.impl;

import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Validator;
import kz.kegoc.bln.entity.adm.Role;
import kz.kegoc.bln.entity.adm.RoleDict;
import kz.kegoc.bln.entity.adm.RoleDictId;
import kz.kegoc.bln.entity.adm.RoleFunc;
import kz.kegoc.bln.entity.adm.RoleFuncId;
import kz.kegoc.bln.entity.adm.RoleModule;
import kz.kegoc.bln.entity.adm.RoleModuleId;
import kz.kegoc.bln.exception.EntityNotFoundException;
import kz.kegoc.bln.repository.common.Repository;
import kz.kegoc.bln.service.adm.RoleService;
import kz.kegoc.bln.service.common.AbstractEntityService;


@Stateless
public class RoleServiceImpl extends AbstractEntityService<Role> implements RoleService {
    
	@Inject
    public RoleServiceImpl(Repository<Role> repository, Validator validator) {
        super(repository, validator);
    }

	@Override
	public RoleModule findModuleById(RoleModuleId id) {
		Role role = findById(id.getRoleId());		
		Optional<RoleModule> optional = role.getModules()
			.stream()
		    .filter(m -> m.getModule().getId().equals(id.getModuleId()) )
		    .findAny();
			
		if (!optional.isPresent())
			throw new EntityNotFoundException(id.getModuleId());
		
		return optional.get();
	}
	

	@Override
	public RoleModule addModule(Long roleId, RoleModule roleModule) {
		RoleModuleId roleModuleId = new RoleModuleId(roleId, roleModule.getModule().getId());

		roleModule.setId(roleModuleId);
		Role role = findById(roleId);
		role.getModules().add(roleModule);
		update(role);

		return findModuleById(roleModuleId);
	}
	
	
	@Override
	public RoleModule updateModule(Long roleId, RoleModule roleModule) {
		Role role = findById(roleId);		
		
		RoleModule currentRoleModule = findModuleById(new RoleModuleId(roleId, roleModule.getModule().getId()));
		currentRoleModule.setStartDate(roleModule.getStartDate());
		currentRoleModule.setEndDate(roleModule.getEndDate());
		
		update(role);
		return findModuleById(new RoleModuleId(roleId, roleModule.getModule().getId()));
	}

	
	@Override
	public boolean deleteModule(Long roleId, Long moduleId) {
		RoleModule entity = findModuleById(new RoleModuleId(roleId, moduleId));		
		entity.getRole().getModules().remove(entity);
		update(entity.getRole()); 
		return true;
	}	
	
	

	@Override
	public RoleFunc findFuncById(RoleFuncId id) {
		Role role = findById(id.getRoleId());		
		Optional<RoleFunc> optional = role.getFuncs()
			.stream()
		    .filter(m -> m.getFunc().getId().equals(id.getFuncId()) )
		    .findAny();
			
		if (!optional.isPresent())
			throw new EntityNotFoundException(id.getFuncId());
		
		return optional.get();
	}

	
	@Override
	public RoleFunc addFunc(Long roleId, RoleFunc roleFunc) {
		RoleFuncId roleFuncId = new RoleFuncId(roleId, roleFunc.getFunc().getId());

		roleFunc.setId(roleFuncId);
		Role role = findById(roleId);
		role.getFuncs().add(roleFunc);
		update(role);

		return findFuncById(roleFuncId);
	}

	
	@Override
	public RoleFunc updateFunc(Long roleId, RoleFunc roleFunc) {
		Role role = findById(roleId);		
		
		RoleFunc currentRoleFunc = findFuncById(new RoleFuncId(roleId, roleFunc.getFunc().getId()));
		currentRoleFunc.setStartDate(roleFunc.getStartDate());
		currentRoleFunc.setEndDate(roleFunc.getEndDate());
		
		update(role);
		return findFuncById(new RoleFuncId(roleId, roleFunc.getFunc().getId()));
	}

	
	@Override
	public boolean deleteFunc(Long roleId, Long funcId) {
		RoleFunc entity = findFuncById(new RoleFuncId(roleId, funcId));		
		entity.getRole().getFuncs().remove(entity);
		update(entity.getRole()); 
		return true;
	}
	
	
	
	@Override
	public RoleDict findDictById(RoleDictId id) {
		Role role = findById(id.getRoleId());		
		Optional<RoleDict> optional = role.getDicts()
			.stream()
		    .filter(m -> m.getDict().getId().equals(id.getDictId()) )
		    .findAny();
			
		if (!optional.isPresent())
			throw new EntityNotFoundException(id.getDictId());
		
		return optional.get();
	}
	

	@Override
	public RoleDict addDict(Long roleId, RoleDict roleDict) {
		RoleDictId roleDictId = new RoleDictId(roleId, roleDict.getDict().getId());

		roleDict.setId(roleDictId);
		Role role = findById(roleId);
		role.getDicts().add(roleDict);
		update(role);

		return findDictById(roleDictId);
	}
	
	
	@Override
	public RoleDict updateDict(Long roleId, RoleDict roleDict) {
		Role role = findById(roleId);		
		
		RoleDict currentRoleDict = findDictById(new RoleDictId(roleId, roleDict.getDict().getId()));
		currentRoleDict.setStartDate(roleDict.getStartDate());
		currentRoleDict.setEndDate(roleDict.getEndDate());
		
		update(role);
		return findDictById(new RoleDictId(roleId, roleDict.getDict().getId()));
	}

	
	@Override
	public boolean deleteDict(Long roleId, Long dictId) {
		RoleDict entity = findDictById(new RoleDictId(roleId, dictId));		
		entity.getRole().getDicts().remove(entity);
		update(entity.getRole()); 
		return true;
	}		
}
