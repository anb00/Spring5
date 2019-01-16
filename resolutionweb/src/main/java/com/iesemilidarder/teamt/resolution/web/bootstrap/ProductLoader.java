package com.iesemilidarder.teamt.resolution.web.bootstrap;



import com.iesemilidarder.teamt.resolution.web.domain.Product;
import com.iesemilidarder.teamt.resolution.web.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product hotel = new Product();
        hotel.setDescription(" Hotel Nº1");
        hotel.setPrice(new BigDecimal("180.90"));
        hotel.setImageUrl("https://lh3.googleusercontent.com/-p5UZZS8al2U/XDd4P-MZApI/AAAAAAAAA5c/Eltq_KUNSwYTFtTk-3izO9QiUKotiakWwCL0BGAYYCw/h138/Logo.png");
        hotel.setProductId("235268845711068308");
        productRepository.save(hotel);

        log.info("Saved Shirt - id: " + hotel.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://lh3.googleusercontent.com/-p5UZZS8al2U/XDd4P-MZApI/AAAAAAAAA5c/Eltq_KUNSwYTFtTk-3izO9QiUKotiakWwCL0BGAYYCw/h138/Logo.png");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
