import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void ShopTestPositive(){
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(55,"Кофе", 245);
        Product product2 = new Product(123,"Тесто", 60);
        Product product3 = new Product(13,"Носки", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(55);
        Product[] expended ={product2,product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expended, actual);
    }
    @Test
    public void ShopTestPNegative(){
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(55,"Кофе", 245);
        Product product2 = new Product(123,"Тесто", 60);
        Product product3 = new Product(13,"Носки", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(155);
        Product[] expended ={product1,product2,product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expended, actual);
    }
    @Test
    public void shouldFindExceptions(){
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(55,"Кофе", 245);
        Product product2 = new Product(123,"Тесто", 60);
        Product product3 = new Product(13,"Носки", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->{
            repo.remove(155);
        });
    }
}
