package br.com.infracommerce.inscription;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ifc.vinicius.saraiva on 20/08/17.
 */

@RepositoryRestResource(collectionResourceRel = "inscription", path = "inscription")
public interface InscriptionRepository extends MongoRepository<Inscription, String> {
    List<Inscription> findByEmail(@Param("email") String email);



}