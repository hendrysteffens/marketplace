package br.com.marketplace.view.entryitem;

import br.com.marketplace.model.EntryItem;
import br.com.marketplace.repository.EntryItemRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope(value = "session")
@Component(value = "listEntryItem")
@ELBeanName(value = "listEntryItem")
@Join(path = "/list-entry-item", to = "/entryItem/entry-item-list.jsf")
public class ListEntryItemHandler {

	@Autowired
	private EntryItemRepository entryItemRepository;

	private List<EntryItem> entryItems;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		entryItems = entryItemRepository.findAll();
	}

	public List<EntryItem> getEntryItems() {
		return entryItems;
	}

	public String delete(EntryItem entryItem) {
		entryItemRepository.delete(entryItem);
		loadData();
		return entryItem.getId().toString();
	}
}
