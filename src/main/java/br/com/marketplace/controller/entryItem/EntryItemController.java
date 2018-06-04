package br.com.marketplace.controller.entryItem;

import br.com.marketplace.repository.EntryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryItemController {

	@Autowired
	private EntryItemRepository entryItemRepository;



}
