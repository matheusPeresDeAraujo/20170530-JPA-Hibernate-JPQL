import javax.persistence.*;
@Entity
public class Cidade {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	private int populacao;
	private Double pib;
	private Boolean capital;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cidade_id", nullable=false)
	private Estado estado;

	public Cidade(String nome, int populacao, Double pib, Boolean capital, Estado estado) {
		super();
		this.nome = nome;
		this.populacao = populacao;
		this.pib = pib;
		this.capital = capital;
		this.estado = estado;
	}

	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public Double getPib() {
		return pib;
	}

	public void setPib(Double pib) {
		this.pib = pib;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", pib=" + pib + ", capital="
				+ capital + ", estado=" + estado + "]";
	}
	
	
}
