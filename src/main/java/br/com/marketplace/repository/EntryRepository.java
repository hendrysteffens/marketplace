package br.com.marketplace.repository;

import br.com.marketplace.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

	String GET_ALL_WITH_AVERAGE_GREATER_THAN_ONE_HUNDRED = "" +
			"select * from lancamento inner join lancamento_item on lancamento.id = lancamento_item.id_lancamento "
			+ "inner join item on lancamento_item.id_item = item.id group by lancamento_item.id, lancamento.id, item.id having avg(item.valor) >=100";
	String FIND_TOP_10_BY_TOTAL_GREATER_THAN_AND_DESCRIPTION_STARTS_WITH_A = "" +
			"select * from lancamento inner join lancamento_item on lancamento.id = lancamento_item.id_lancamento " +
			"inner join item on lancamento_item.id_item = item.id where lancamento.vl_total >= ? and upper(item.descricao) like 'A%' " +
			"group by lancamento_item.id, lancamento.id, item.id limit 10";

	@Query(value = GET_ALL_WITH_AVERAGE_GREATER_THAN_ONE_HUNDRED, nativeQuery = true)
	List<Entry> findAllWithAverageGreaterThanOneHundred();

	@Query(value = FIND_TOP_10_BY_TOTAL_GREATER_THAN_AND_DESCRIPTION_STARTS_WITH_A, nativeQuery = true)
	List<Entry> findTop10ByTotalGreaterThanAndDescription(Double total);


}
