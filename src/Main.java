import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		/*
		 
		EntityManager em1 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
		em1.getTransaction().begin();
		
		Pais p1 = new Pais();
		p1.setNome("Pais1");
		p1.setPib(10000000.0);
		p1.setSigla("P1");
		p1.setArea(10000.0);
		em1.persist(p1);
		
		Pais p2 = new Pais();
		p2.setNome("Pais2");
		p2.setPib(100.0);
		p2.setSigla("P2");
		p2.setArea(10000.0);
		em1.persist(p2);
		
		Estado e1 = new Estado();
		e1.setNome("Estado1");
		e1.setRegiao("SUl");
		e1.setSigla("MG");
		e1.setPais(p1);
		em1.persist(e1);
		
		Estado e2 = new Estado();
		e2.setNome("Estado2");
		e2.setRegiao("SUl");
		e2.setSigla("E2");
		e2.setPais(p2);
		em1.persist(e2);
		
		Cidade c1 = new Cidade();
		c1.setNome("Cidade1");
		c1.setPib(1000001.0);
		c1.setPopulacao(501000);
		c1.setCapital(true);
		c1.setEstado(e1);
		em1.persist(c1);
		
		Cidade c2 = new Cidade();
		c2.setNome("Cidade2");
		c2.setPib(100.0);
		c2.setPopulacao(501000);
		c2.setCapital(false);
		c2.setEstado(e2);
		em1.persist(c2);
		
		em1.getTransaction().commit();
		
		
		EntityManager em = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();	
//		Liste os país com com pib maior que 1.000.000.
		TypedQuery<Pais> query = em.createQuery("select p from Pais p where p.pib > 1000000", Pais.class);
		List<Pais> paises = query.getResultList();
		System.out.println(paises);//pais1
		em.close();
		
		EntityManager em2 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Liste o estado com a sigla MG.
		TypedQuery<Estado> query2 = em2.createQuery("select e from Estado e where e.sigla = 'MG'", Estado.class);
		List<Estado> estados = query2.getResultList();
		System.out.println(estados);//estado1
		em2.close();

		EntityManager em3 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Liste as cidades com mais de 500.000 de população e pib maior que 1.000.000.
		TypedQuery<Cidade> query3 = em3.createQuery("select c from Cidade c where c.populacao > 500000 and c.pib > 1000000", Cidade.class);
		List<Cidade> cidades = query3.getResultList();
		System.out.println(cidades);//cidade1
		em3.close();

		EntityManager em4 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Liste os nomes das capitais cadastradas no banco.
		TypedQuery<String> query4 = em4.createQuery("select c.nome from Cidade c where c.capital ='true'", String.class);
		List<String> capitais = query4.getResultList();
		System.out.println(capitais);//cidade1
		em4.close();

		EntityManager em5 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Qual o maior pib de país cadastrado no banco?
		TypedQuery<Double> query5 = em5.createQuery("select MAX(p.pib) from Pais p ", Double.class);
		List<Double> paisesPibMax = query5.getResultList();
		System.out.println(paisesPibMax);//1000000
		em5.close();
		
		EntityManager em6 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Qual o estado que possui uma cidade chamada Juiz de Fora?
		TypedQuery<Estado> query6 = em6.createQuery("select e from Estado e JOIN FETCH e.cidades c where c.nome ='juizdefora'", Estado.class);
		List<Estado> juizdefora = query6.getResultList();
		System.out.println(juizdefora);
		em6.close();
		

		EntityManager em7 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Quantas cidades começam com A?   where c.nome LIKE 'C%'
		TypedQuery<Long> query7 = em7.createQuery("select COUNT(c.nome) from Cidade c where c.nome LIKE 'A%'", Long.class);
		Long aCont = query7.getSingleResult();
		System.out.println(aCont);
		em7.close();
		
		EntityManager em8 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Qual a média do pib das cidades?
		TypedQuery<Double> query8 = em8.createQuery("select AVG(c.pib) from Cidade c ", Double.class);
		Double avg = query8.getSingleResult();
		System.out.println(avg);
		em8.close();
		*/
		EntityManager em9 = Persistence.createEntityManagerFactory("mapeamentoAtividade_unit").createEntityManager();
//		Liste o nome do estado, o nome do país ao qual pertence, e sua capital, se houver.
		TypedQuery<Object[]> query9 = em9.createQuery("SELECT p FROM Pais p JOIN  p.estados e JOIN FETCH e.cidades c WHERE c.capital = 'true' ", Object[].class);
		List<Object[]> result = query9.getResultList();
		
		for(Object[] itens : result){
			String nameE = (String) itens[0];
			String nameP = (String) itens[1];
			String nameC = (String) itens[2];
			System.out.println(nameE+nameP+nameC);
		}
		
		em9.close();
		
//		Liste os nomes do País, Estado e Cidade sem que haja Lazy Loading.

		
		
		
		//em.getTransaction().commit();
		
		
	}

}
