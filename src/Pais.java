import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@Column(unique=true, length=3)
	private String sigla;
	private Double pib;
	private Double area;
	
	@OneToMany(mappedBy = "pais", 
			 cascade = CascadeType.ALL, 
			 orphanRemoval = true)
	private List<Estado> estados = new ArrayList<>();

	public Pais(String nome, String sigla, Double pib, Double area) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.pib = pib;
		this.area = area;
	}

	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Double getPib() {
		return pib;
	}

	public void setPib(Double pib) {
		this.pib = pib;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", pib=" + pib + ", area=" + area + "]";
	}
	
	
}


