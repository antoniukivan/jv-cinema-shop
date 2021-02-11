package ua.com.cinema.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import ua.com.cinema.model.CinemaHall;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.MovieSession;
import ua.com.cinema.model.Order;
import ua.com.cinema.model.ShoppingCart;
import ua.com.cinema.model.Ticket;
import ua.com.cinema.model.User;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {
        "ua.com.cinema.dao",
        "ua.com.cinema.service"
})
public class AppConfig {
    private final Environment environment;

    public AppConfig(Environment env) {
        this.environment = env;
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(CinemaHall.class);
        factoryBean.setAnnotatedClasses(Movie.class);
        factoryBean.setAnnotatedClasses(MovieSession.class);
        factoryBean.setAnnotatedClasses(Order.class);
        factoryBean.setAnnotatedClasses(ShoppingCart.class);
        factoryBean.setAnnotatedClasses(Ticket.class);
        factoryBean.setAnnotatedClasses(User.class);

        return factoryBean;
    }
}
