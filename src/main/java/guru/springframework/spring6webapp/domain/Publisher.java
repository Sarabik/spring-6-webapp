package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String publisherName;

	private String address;

	private String city;

	private String state;

	private String zip;

	@OneToMany(mappedBy = "publisher")
	private Set<Book> books = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(final String publisherName) {
		this.publisherName = publisherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(final String zip) {
		this.zip = zip;
	}

	@Override
	public final boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final Publisher publisher)) {
			return false;
		}

		return Objects.equals(id, publisher.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(final Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher{" +
			"id=" + id +
			", publisherName='" + publisherName + '\'' +
			", address='" + address + '\'' +
			", city='" + city + '\'' +
			", state='" + state + '\'' +
			", zip='" + zip + '\'' +
			", books=" + books +
			'}';
	}
}
