package br.com.marketplace.repository;

import br.com.marketplace.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {

}
