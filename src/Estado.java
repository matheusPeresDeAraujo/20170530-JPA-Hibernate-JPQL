import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Estado {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;

	@Column(unique=true, length=2)
	private String sigla;
	private String regiao;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id", nullable=false)
	private Pais pais;
	
	@OneToMany(mappedBy = "estado", 
			 cascade = CascadeType.ALL, 
			 orphanRemoval = true)
	private List<Cidade> cidades = new ArrayList<>();

	public Estado(String nome, String sigla, String regiao, Pais pais) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.regiao = regiao;
		this.pais = pais;
	}

	public Estado() {
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

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		Estado other = (Estado) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", regiao=" + regiao + ", pais=" + pais
				+ "]";
	}
	
	
}
