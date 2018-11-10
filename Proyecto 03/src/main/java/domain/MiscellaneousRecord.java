
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class MiscellaneousRecord extends DomainEntity {

	private String			title;
	private String			linkAttachement;
	private List<String>	comments;


	public MiscellaneousRecord() {		//Created for Json Purposes
		super();
	}
	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@URL
	public String getLinkAttachement() {
		return this.linkAttachement;
	}

	public void setLinkAttachement(final String linkAttachement) {
		this.linkAttachement = linkAttachement;
	}

	@Valid
	@ElementCollection(targetClass = String.class)
	public List<String> getComments() {
		return this.comments;
	}

	public void setComments(final List<String> comments) {
		this.comments = comments;
	}

}
