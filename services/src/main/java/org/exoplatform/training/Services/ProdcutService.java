package org.exoplatform.training.Services;


import java.util.List;

import org.exoplatform.training.Entity.Products;
import org.exoplatform.training.dao.ProductDAO;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
public class ProdcutService  implements ProductInterface{
  private ProductDAO productdao ;
  private static Log log =  ExoLogger.getLogger(ProdcutServiceRest.class);

  public ProdcutService(ProductDAO productdao){
    this.productdao=productdao;
  }

  @Override
  public List<Products> getAllProducts() throws Exception {
    return this.productdao.findAll();
  }

  @Override
  public Products addProduct(Products a) {

      Products product = new Products(a.getName(),a.getDescription(),a.getImg(),a.getPrice());
      Products res= null;
        try {
            res = productdao.create(product);
        }catch (Exception e) {
          log.error("Cannot create the product", e);
        }
        return res;
  }
  
   
}
