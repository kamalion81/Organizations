package organizations.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organizations.business.OrganizationService;
import organizations.dao.OrganizationRepository;
import organizations.model.Organization;

import java.util.List;
import java.util.Optional;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    public OrganizationServiceImpl() {
    }

    @Override
    public List<Organization> findAll() {
        return (List<Organization>) repository.findAll();
    }

    @Override
    public Optional<Organization> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Organization organization) {
        repository.save(organization);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);


    }
}
