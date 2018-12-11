package organizations.dao;

import org.springframework.data.repository.CrudRepository;
import organizations.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

}
