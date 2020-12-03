package com.pix.api.pixfacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PixfacilApplication {
//	private static final Logger log = LoggerFactory.getLogger(PixfacilApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PixfacilApplication.class);
	}

//	@Bean
//	public CommandLineRunner demo(ProdutoRepository repository) {
//		return (args) -> {
//			
//			Produto p = new Produto();
//			p.setIdproduto(2L);
//			p.setDescricao("teste img");
//			p.setCodBarras("090807090807");
//			Estabelecimento e = new Estabelecimento();
//			e.setIdestab(1L);
//			p.setEstabelecimento(e);
//			
//			byte[] array = Files.readAllBytes(Paths.get("c:/opt/img.jpg"));
//
//			p.setImgProduto(array);
//			
//			repository.save(p);
//			log.info("FIM");
//			System.exit(0);
//		};
//	}

}