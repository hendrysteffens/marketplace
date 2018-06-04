package br.com.marketplace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "item")
public class EntryItem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hibernate_sequence")
	@SequenceGenerator(
			name="hibernate_sequence",
			sequenceName="hibernate_sequence"
	)
	public Integer id;

	@Column(name = "descricao")
	private String description;

	@Column(name = "valor")
	private Double value;

	@JsonIgnore
	@ManyToMany(mappedBy = "entryItems")
	private Set<Entry> entries = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item:" +
				"id=" + id +
				", description='" + description + '\'' +
				", value=" + value +",";
	}
}
