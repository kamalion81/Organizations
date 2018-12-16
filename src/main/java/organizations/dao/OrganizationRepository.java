package organizations.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import organizations.model.Organization;

@CrossOrigin(origins = "http://localhost:4200")
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

}
