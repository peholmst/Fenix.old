package net.pkhapps.fenix.core.boundary.rest.dto;

import net.pkhapps.fenix.core.boundary.rest.AbstractEntityDTOMapper;
import net.pkhapps.fenix.core.entity.SystemUser;
import org.springframework.stereotype.Service;

/**
 * DTO mapper for {@link net.pkhapps.fenix.core.boundary.rest.dto.UserDTO} and {@link net.pkhapps.fenix.core.entity.SystemUser}.
 */
@Service
public class UserDTOMapper extends AbstractEntityDTOMapper<UserDTO, SystemUser> {

    public UserDTOMapper() {
        super(UserDTO.class, SystemUser.class);
    }

    @Override
    protected void populateDTO(SystemUser source, UserDTO destination) {
        destination.email = source.getEmail();
        destination.firstName = source.getFirstName();
        destination.lastName = source.getLastName();
        destination.enabled = source.isEnabled();
        destination.locked = source.isLocked();
        destination.sysadmin = source.isSysadmin();
        destination.passwordExpires = source.getPasswordExpirationDate();
        destination.accountExpires = source.getAccountExpirationDate();
        source.getFireDepartmentRoles().forEach((fd, s) -> destination.fireDepartmentRoles.put(fd.getId(), s));
    }
}