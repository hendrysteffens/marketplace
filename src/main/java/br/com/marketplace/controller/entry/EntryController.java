package br.com.marketplace.controller.entry;

import br.com.marketplace.model.Entry;
import br.com.marketplace.model.EntryItem;
import br.com.marketplace.repository.EntryItemRepository;
import br.com.marketplace.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EntryController {

	@Autowired
	private EntryRepository entryRepository;

	public Entry save(Entry entity){
		if(entity.getTotal() == null || entity.getTotal() == 0D){
			entity.setTotal(entity.entryItems.stream().map(EntryItem::getValue).collect(Collectors.summingDouble(Double::doubleValue)));
		}
		return entryRepository.save(entity);
	}

}
