package br.com.marketplace.view.entryitem;

import br.com.marketplace.model.Entry;
import br.com.marketplace.model.EntryItem;
import br.com.marketplace.repository.EntryItemRepository;
import br.com.marketplace.repository.EntryRepository;
import org.apache.commons.lang3.StringUtils;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Scope(value = "session")
@Component(value = "entryItemSave")
@ELBeanName(value = "entryItemSave")
@Join(path = "/entry-item", to = "/entryItem/entry-item-form.jsf")
public class SaveEntryItemHandler {

	@Autowired
	private EntryItemRepository entryItemRepository;

	private EntryItem entryItem = new EntryItem();

	public EntryItem getEntryItem() {
		return entryItem;
	}

	public String save() {
		entryItemRepository.save(entryItem);
		entryItem = new EntryItem();
		return "/entryItem/entry-item-list.xhtml?faces-redirect=true";
	}


}
