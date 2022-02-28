package webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;

public class ProductRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long insertProduct(String productName, int price, int stock){
       try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into products (product_name,price,stock) values(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
           stmt.setString(1, productName);
           stmt.setInt(2, price);
           stmt.setInt(3, stock);
           stmt.executeUpdate();
           try (ResultSet rs = stmt.getGeneratedKeys()) {
               if (rs.next()) {
                   return rs.getLong("id");
               }
               throw new IllegalStateException("Error by inserting");
           }
       } catch (
               SQLException sqle) {
           throw new IllegalArgumentException("Error by inserting", sqle);
       }
   }

    public Product findProductById(long id){
        jdbcTemplate=new JdbcTemplate(dataSource);
       return jdbcTemplate.queryForObject("select * from products where id=?",
               (rs, rowNum) -> new Product(rs.getLong("id"),rs.getString("product_name"),
                       rs.getInt("price"),rs.getInt("stock")), id);
    }

   public void updateProductStock(long id, int amount){
       jdbcTemplate=new JdbcTemplate(dataSource);
       jdbcTemplate.update("update products set stock=stock-? where id=?",amount,id);
   }
}
