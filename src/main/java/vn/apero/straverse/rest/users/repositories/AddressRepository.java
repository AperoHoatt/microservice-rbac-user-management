package vn.apero.straverse.rest.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.apero.straverse.rest.users.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
