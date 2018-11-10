
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Category extends DomainEntity {

	private List<Category>	subCategorys;
	private String			name;


	public Category() {		//Created for Json purposes
		super();
	}

	@OneToMany
	@Valid
	public List<Category> getSubCategorys() {
		return this.subCategorys;
	}

	public void setSubCategorys(final List<Category> subCategorys) {
		this.subCategorys = subCategorys;
	}

	@Column(unique = true)
	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
