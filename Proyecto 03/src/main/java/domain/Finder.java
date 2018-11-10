
package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Finder {

	private String			keyWord;
	private Category		category;
	private Warranty		warranty;
	private double			minPrice;
	private double			maxPrice;
	private Date			startDate;
	private Date			endDate;

	private List<FixUpTask>	fixUpTasks;


	@NotBlank
	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(final String keyWord) {
		this.keyWord = keyWord;
	}
	@OneToMany
	@Valid
	public List<FixUpTask> getFixUpTasks() {
		return this.fixUpTasks;
	}

	public void setFixUpTasks(final List<FixUpTask> fixUpTasks) {
		this.fixUpTasks = fixUpTasks;
	}

	@NotNull
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	@NotNull
	public Warranty getWarranty() {
		return this.warranty;
	}

	public void setWarranty(final Warranty warranty) {
		this.warranty = warranty;
	}

	@NotNull
	@Min(0)
	@Digits(fraction = 2, integer = 9)
	public double getMinPrice() {
		return this.minPrice;
	}

	public void setMinPrice(final double minPrice) {
		this.minPrice = minPrice;
	}

	@NotNull
	@Digits(fraction = 2, integer = 9)
	public double getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(final double maxPrice) {
		if (maxPrice >= this.minPrice)
			this.maxPrice = maxPrice;
	}

	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

}
