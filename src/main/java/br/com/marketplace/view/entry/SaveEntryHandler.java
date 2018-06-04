package br.com.marketplace.view.entry;

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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Scope(value = "session")
@Component(value = "entrySave")
@ELBeanName(value = "entrySave")
@Join(path = "/entry", to = "/entry/entry-form.jsf")
public class SaveEntryHandler {
	@Autowired
	private EntryRepository entryRepository;
	@Autowired
	private EntryItemRepository entryItemRepository;

	private DualListModel<EntryItem> entryItems;
	private Entry entry = new Entry();

	@PostConstruct
	public void init() {
		List<EntryItem> entryItemsTarget = new ArrayList<>();
		List<EntryItem> entryItemsSource = entryItemRepository.findAll();

		entryItems = new DualListModel<EntryItem>(entryItemsSource, entryItemsTarget);
	}

	public DualListModel<EntryItem> getEntryItems() {
		return entryItems;
	}

	public void setEntryItems(DualListModel<EntryItem>  entryItems) {
		this.entryItems = entryItems;
	}

	public Entry getEntry() {
		return entry;
	}

	public String save() {
		entry.entryItems = loadDualistValues(entryItems.getTarget());
		entryRepository.save(entry);
		return "/entry/entry-list.xhtml?faces-redirect=true";
	}

	private Set<EntryItem> loadDualistValues(List<EntryItem> target) {
		if(target.isEmpty()) return null;
		List<EntryItem> items = new ArrayList<>();
		for (Object object: target) {
			items.add(stringToEntryItem(object));
		}
		return items.stream().collect(Collectors.toSet());
	}

	private EntryItem stringToEntryItem(Object object) {
		EntryItem item = new EntryItem();
		String stringDTO = (String) object;
		String[] values = StringUtils.substringsBetween(stringDTO, "=", ",");
		item.setId(Integer.parseInt(values[0]));
		item.setDescription(values[1]);
		if(!values[2].equalsIgnoreCase("null"))
			item.setValue(Double.parseDouble(values[2]));
		return item;
	}

}
