package demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.LinkDiscoverers;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired WebApplicationContext context;
	@Autowired LinkDiscoverers discoverers;

	@Autowired ProductRepository productRepository;
	@Autowired CategoryRepository categoryRepository;

	MockMvc mvc;

	Product prodcut;
	Category category;

	@Before
	public void setUp() {

		this.mvc = MockMvcBuilders.webAppContextSetup(context).//
				defaultRequest(get("/").accept(MediaTypes.HAL_JSON)).build();

		this.prodcut = productRepository.save(new Product("123"));

		Category category = new Category("c1");
		category.setProduct(this.prodcut);
		this.category = categoryRepository.save(category);
	}

	@Test
	public void shouldBeAbleToResolveLazyLoadingProxyForProductInCategory() throws Exception {

		/*
		 * set a breakpoint in org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler.getSelfLinkFor(Object)
		 * -> local variable instance is JavaAssistLazyInitializer
		 * -> should probably be the actual product instance instead.
		 */

		this.mvc.perform(get("/category/c1/product")) //
				.andExpect(status().isOk());
	}

}
