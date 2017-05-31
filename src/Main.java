import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
		em.getTransaction().begin();

		///*
		Pais p1 = new Pais();
		p1.setNome("Pais1");
		p1.setPib(10000000.0);
		p1.setSigla("P12222");
		p1.setArea(10000.0);
		em.persist(p1);
		
		Pais p2 = new Pais();
		p2.setNome("Pais2");
		p2.setPib(100.0);
		p2.setSigla("P2");
		p2.setArea(10000.0);
		em.persist(p2);
		
		Estado e1 = new Estado();
		e1.setNome("Estado1");
		e1.setRegiao("SUl");
		e1.setSigla("E1");
		e1.setPais(p1);
		em.persist(e1);
		
		Estado e2 = new Estado();
		e2.setNome("Estado2");
		e2.setRegiao("SUl");
		e2.setSigla("E2");
		e2.setPais(p2);
		em.persist(e2);
		
		Cidade c1 = new Cidade();
		c1.setNome("Cidade1");
		c1.setPib(100.0);
		c1.setPopulacao(10000);
		c1.setCapital(true);
		c1.setEstado(e1);
		em.persist(c1);
		
		Cidade c2 = new Cidade();
		c2.setNome("Cidade2");
		c2.setPib(100.0);
		c2.setPopulacao(10000);
		c2.setCapital(false);
		c2.setEstado(e2);
		em.persist(c2);
		//*/
		
//		Liste os país com com pib maior que 1.000.000.
		TypedQuery<Pais> query = em.createQuery("select p from Pais p where p.pib > 1000000", Pais.class);
		List<Pais> paises = query.getResultList();
		
		System.out.println(paises);
		
//		Liste o estado com a sigla MG.
		
		
//		Liste as cidades com mais de 500.000 de população e pib maior que 1.000.000.
		
		
//		Liste os nomes das capitais cadastradas no banco.
		
		
//		Qual o maior pib de país cadastrado no banco?
		
		
//		Qual o estado que possui uma cidade chamada Juiz de Fora?
		
		
//		Quantas cidades começam com A?
		
		
//		Qual a média do pib das cidades?
		
		
//		Liste o nome do estado, o nome do país ao qual pertence, e sua capital, se houver.
		
		
//		Liste os nomes do País, Estado e Cidade sem que haja Lazy Loading.

		
		
		
		em.getTransaction().commit();
		
		
	}

}
