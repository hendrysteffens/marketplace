package br.com.marketplace.model;

import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "lancamento")
public class Entry {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hibernate_sequence")
	@SequenceGenerator(
			name="hibernate_sequence",
			sequenceName="hibernate_sequence"
	)
	private Integer id;

	@ManyToMany(cascade = { CascadeType.DETACH })
	@JoinTable(
			name = "lancamento_item",
			joinColumns = { @JoinColumn(name = "id_lancamento") },
			inverseJoinColumns = { @JoinColumn(name = "id_item") }
	)
	public Set<EntryItem> entryItems = new HashSet<>();

	@Column(name = "dt_inicial")
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDateTime startDate;

	@Column(name = "dt_final")
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDateTime endDate;

	@Column(name = "vl_total")
	private Double total;

	@Column(name = "observacao")
	private String observation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<EntryItem> getEntryItems() {
		return entryItems;
	}

	public void setEntryItems(Set<EntryItem> entryItems) {
		this.entryItems = entryItems;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
}
