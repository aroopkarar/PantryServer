package com.test.sbmvc;

import com.test.sbmvc.Repository.ProductRepository;
import com.test.sbmvc.Service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class JUnitSpring {


    @InjectMocks
    ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void checkProductService()
    {
        assertEquals("class com.test.sbmvc.Service.ProductService",this.productService.getClass().toString());
    }

    @Test
    public void isProductServiceValid()
    {
        assertEquals(productService.isValid(),true);
    }

    /*@Before
    public void setUp() {
        productService= new ProductService();
        productRepository = mock(ProductRepository.class);
        productService.setRepository(productRepository);
    }
*/
}
