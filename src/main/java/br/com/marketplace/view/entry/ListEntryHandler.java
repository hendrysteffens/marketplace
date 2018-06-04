package br.com.marketplace.view.entry;

import br.com.marketplace.model.Entry;
import br.com.marketplace.model.EntryItem;
import br.com.marketplace.repository.EntryItemRepository;
import br.com.marketplace.repository.EntryRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Scope (value = "session")
@Component(value = "listEntry")
@ELBeanName(value = "listEntry")
@Join(path = "/list-entry", to = "/entry/entry-list.jsf")
public class ListEntryHandler {

	@Autowired
	private EntryRepository entryRepository;
	private List<Entry> entries;


	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		entries = entryRepository.findAll();
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public String delete(Entry entry) {
		entryRepository.delete(entry);
		loadData();
		return null;
	}
}
