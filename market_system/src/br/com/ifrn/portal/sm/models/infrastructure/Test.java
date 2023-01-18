package br.com.ifrn.portal.sm.models.infrastructure;

import br.com.ifrn.portal.sm.models.entities.Product;
import br.com.ifrn.portal.sm.models.entities.UnitMeasurement;
import br.com.ifrn.portal.sm.models.services.implementation.ProductService;
import br.com.ifrn.portal.sm.models.services.utilities.PagedEntity;

public class Test {

	public static void main(String[] args) {
		
		/*DAOProduct daoProduct = new DAOProduct();
		UnitMeasurement measurement = new UnitMeasurement("pc", "pacote");
		Brand brand = new Brand("Marat�");
		Category category = new Category("consumivel");
		
		Calendar dataFabricacao = Calendar.getInstance();
		dataFabricacao.setTime(new Date("2021/03/23"));
		
		Calendar dataValidade = Calendar.getInstance();
		dataValidade.setTime(new Date("2024/03/23"));
		
		Product product = new Product(category, measurement, brand, "4353", "A�ucar dumel 1 kg", dataFabricacao, dataValidade, new Byte[] {12});
		
		daoProduct.insertAtomic(product);*/
		ProductService productService = new ProductService();
		
		DAOUnitMeasurement  daoUnitMeasurement = new DAOUnitMeasurement();
		UnitMeasurement measurement = daoUnitMeasurement.findById(5L);
		//Category category = daoCategory.findById(5L);
		
		PagedEntity<Product> paged = productService.findByUnitMeasurement(measurement,1);
		paged.getPaginatedEntityList().stream().forEach(e -> System.out.println(e.getDescription()));
		System.out.println(paged.getPaginationInfo().toString());
		
		//daoProduct.findByBarCode(848374L);
	}

}
