package tw.snitch.entity;

import javax.persistence.*;

/**
 *
 * @author	P-C Lin (a.k.a 高科技黑手)
 */
@Entity
@Table(catalog = "\"GroupImageDB\"", schema = "\"public\"", name = "\"Keyword\"", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"\"word\""}),
	@UniqueConstraint(columnNames = {"\"ordinal\""})
})
@NamedQueries({
	@NamedQuery(name = "Keyword.findAll", query = "SELECT k FROM Keyword k")
})
public class Keyword implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"", nullable = false)
	@Basic(optional = false)
	private Short id;

	@Basic(optional = false)
	@Column(name = "\"word\"", nullable = false, length = 2147483647)
	private String word;

	@Column(name = "\"ordinal\"")
	private Short ordinal;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Keyword)) {
			return false;
		}
		Keyword other = (Keyword) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "tw.snitch.entity.Keyword[ id=" + id + " ]";
	}

	public Keyword() {
	}

	public Keyword(Short id) {
		this.id = id;
	}

	public Keyword(Short id, String word) {
		this.id = id;
		this.word = word;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Short getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Short ordinal) {
		this.ordinal = ordinal;
	}
}
