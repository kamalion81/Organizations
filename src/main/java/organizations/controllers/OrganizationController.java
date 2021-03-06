package organizations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import organizations.business.OrganizationService;
import organizations.model.Organization;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@CrossOrigin(origins = "http://localhost:4200")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @RequestMapping
    public List<Organization> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Organization show(@PathVariable Integer id) {
        return service.findById(id).orElseThrow(() -> new OrganizationNotFoundException(id.toString()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Organization organization) {
        service.save(organization);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Organization organization) {

        service.findById(id).orElseThrow(() -> new OrganizationNotFoundException(organization.getName()));
        service.save(organization);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class OrganizationNotFoundException extends RuntimeException {

        public OrganizationNotFoundException(String organization) {
            super("Organization with ID/name " + organization + " haven't been found");
        }
    }

}
