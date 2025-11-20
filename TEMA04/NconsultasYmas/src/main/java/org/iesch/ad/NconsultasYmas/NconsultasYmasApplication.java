package org.iesch.ad.NconsultasYmas;

import org.iesch.ad.NconsultasYmas.servicio.CriteriaDemoServicio;
import org.iesch.ad.NconsultasYmas.servicio.JdbcServicio;
import org.iesch.ad.NconsultasYmas.servicio.Nmas1DemoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

@SpringBootApplication
public class NconsultasYmasApplication implements CommandLineRunner {

	@Autowired
	Nmas1DemoServicio nmas1DemoServicio;

	@Autowired
	CriteriaDemoServicio criteriaDemoServicio;

	@Autowired
	JdbcServicio jdbcTemplateDemoService;

	public static void main(String[] args) {
		SpringApplication.run(NconsultasYmasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n" + "%".repeat(10));
		System.out.println("n + 1");
		System.out.println("\n" + "%".repeat(10));

		nmas1DemoServicio.mostrarProblemaNmas1();

		System.out.println("\n\n\n" + "%".repeat(20));
		System.out.println("Solución n + 1");
		System.out.println("\n" + "%".repeat(20));

		nmas1DemoServicio.solucionFetchJoin();


		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaSimple();

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaConWhere();

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaConLike();

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaConJoin();

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaMultiplesCondiciones(); //varios and, or ...

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaDinamica("Argentina", 12.0, 1960);

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaOrderBy();

		System.out.println("\n\n\n" + "--------------".repeat(20));
		criteriaDemoServicio.ejemploConsultaConAgregaciones();

		System.out.println("\n\t DEMO JDBC-TEMPLATE");
		jdbcTemplateDemoService.demoConsultasJDBCTemplate();
	}
}
