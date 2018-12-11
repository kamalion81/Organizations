package organizations.business;

import organizations.model.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationService {

    List<Organization> findAll();

    Optional<Organization> findById(Integer id);

    void save(Organization organization);

    void delete(Integer id);


}
