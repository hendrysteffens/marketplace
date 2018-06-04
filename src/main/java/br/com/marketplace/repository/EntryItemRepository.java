package br.com.marketplace.repository;

import br.com.marketplace.model.EntryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryItemRepository extends JpaRepository<EntryItem, Integer> {
}
