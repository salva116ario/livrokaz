package co.simplon.livrokaz.model;
// Generated 14 janv. 2019 à 21:06:11 by Hibernate Tools 5.2.11.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "book", catalog = "livrokaz")
public class Book implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer boId;
	private Style style;
	private String boTitle;
	private String boAuthor;
	private String boEditor;
	private String boIsbn;
	private String boCover;
	private String boTopic;
	private String boSynopsys;
	private Date boReleaseDate;
	private BigDecimal boPrice;
	private int boStock;
	private String boLanguage;
	private Set<CommandLine> commandLines = new HashSet<CommandLine>(0);

	public Book() {
	}

	public Book(Style style, String boTitle, String boAuthor, String boEditor, String boIsbn, String boCover,
			String boTopic, String boSynopsys, Date boReleaseDate, BigDecimal boPrice, int boStock, String boLanguage) {
		this.style = style;
		this.boTitle = boTitle;
		this.boAuthor = boAuthor;
		this.boEditor = boEditor;
		this.boIsbn = boIsbn;
		this.boCover = boCover;
		this.boTopic = boTopic;
		this.boSynopsys = boSynopsys;
		this.boReleaseDate = boReleaseDate;
		this.boPrice = boPrice;
		this.boStock = boStock;
		this.boLanguage = boLanguage;
	}

	public Book(Style style, String boTitle, String boAuthor, String boEditor, String boIsbn, String boCover,
			String boTopic, String boSynopsys, Date boReleaseDate, BigDecimal boPrice, int boStock, String boLanguage,
			Set<CommandLine> commandLines) {
		this.style = style;
		this.boTitle = boTitle;
		this.boAuthor = boAuthor;
		this.boEditor = boEditor;
		this.boIsbn = boIsbn;
		this.boCover = boCover;
		this.boTopic = boTopic;
		this.boSynopsys = boSynopsys;
		this.boReleaseDate = boReleaseDate;
		this.boPrice = boPrice;
		this.boStock = boStock;
		this.boLanguage = boLanguage;
		this.commandLines = commandLines;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "bo_id", unique = true, nullable = false)
	public Integer getBoId() {
		return this.boId;
	}

	public void setBoId(Integer boId) {
		this.boId = boId;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "st_id", nullable = false)
	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Column(name = "bo_title", nullable = false, length = 50)
	public String getBoTitle() {
		return this.boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	@Column(name = "bo_author", nullable = false)
	public String getBoAuthor() {
		return this.boAuthor;
	}

	public void setBoAuthor(String boAuthor) {
		this.boAuthor = boAuthor;
	}

	@Column(name = "bo_editor", nullable = false, length = 50)
	public String getBoEditor() {
		return this.boEditor;
	}

	public void setBoEditor(String boEditor) {
		this.boEditor = boEditor;
	}

	@Column(name = "bo_isbn", nullable = false, length = 50)
	public String getBoIsbn() {
		return this.boIsbn;
	}

	public void setBoIsbn(String boIsbn) {
		this.boIsbn = boIsbn;
	}
	
	@Column(name = "bo_cover", nullable = false, length = 65535, columnDefinition="TEXT")
	public String getBoCover() {
		return this.boCover;
	}

	public void setBoCover(String boCover) {
		this.boCover = boCover;
	}

	@Column(name = "bo_topic", nullable = false, length = 255)
	public String getBoTopic() {
		return this.boTopic;
	}

	public void setBoTopic(String boTopic) {
		this.boTopic = boTopic;
	}
	
	@Column(name = "bo_synopsys", nullable = false, length = 65535, columnDefinition="TEXT")
	public String getBoSynopsys() {
		return this.boSynopsys;
	}

	public void setBoSynopsys(String boSynopsys) {
		this.boSynopsys = boSynopsys;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "bo_release_date", nullable = false, length = 10)
	public Date getBoReleaseDate() {
		return this.boReleaseDate;
	}

	public void setBoReleaseDate(Date boReleaseDate) {
		this.boReleaseDate = boReleaseDate;
	}

	@Column(name = "bo_price", nullable = false, precision = 15, scale = 3)
	public BigDecimal getBoPrice() {
		return this.boPrice;
	}

	public void setBoPrice(BigDecimal boPrice) {
		this.boPrice = boPrice;
	}

	@Column(name = "bo_stock", nullable = false)
	public int getBoStock() {
		return this.boStock;
	}

	public void setBoStock(int boStock) {
		this.boStock = boStock;
	}

	@Column(name = "bo_language", nullable = false, length = 50)
	public String getBoLanguage() {
		return this.boLanguage;
	}

	public void setBoLanguage(String boLanguage) {
		this.boLanguage = boLanguage;
	}
	
	@JsonIgnore
	//@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<CommandLine> getCommandLines() {
		return this.commandLines;
	}

	public void setCommandLines(Set<CommandLine> commandLines) {
		this.commandLines = commandLines;
	}

}
