
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Warranty extends DomainEntity {

	private String			title;
	private List<String>	terms;
	private List<String>	laws;


	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@Valid
	public List<String> getTerms() {
		return this.terms;
	}

	public void setTerms(final List<String> terms) {
		this.terms = terms;
	}

	@Valid
	public List<String> getLaws() {
		return this.laws;
	}

	public void setLaws(final List<String> laws) {
		this.laws = laws;
	}

}
