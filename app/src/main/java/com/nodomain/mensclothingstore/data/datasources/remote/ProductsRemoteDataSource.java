package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.domain.exceptions.InvalidProductIdException;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.model.DetailedProduct;

import java.util.ArrayList;
import java.util.List;


public class ProductsRemoteDataSource {

    private List<DetailedProduct> allDetailedProducts;

    public ProductsRemoteDataSource() {
        allDetailedProducts = new ArrayList<>();
        allDetailedProducts.add(new DetailedProduct(0, 0, "Футболка стретч", 245, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Футболка стретч"));
        allDetailedProducts.add(new DetailedProduct(1, 0, "Футболка с длинным рукавом", 3643, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Футболка с длинным рукавом"));
        allDetailedProducts.add(new DetailedProduct(2, 0, "Футболка Slim fit", 64, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Футболка Slim fit"));
        allDetailedProducts.add(new DetailedProduct(3, 0, "Футболка с круглым воротом", 1264, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Футболка с круглым воротом"));
        allDetailedProducts.add(new DetailedProduct(4, 0, "Широкая футболка", 634, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Широкая футболка"));
        allDetailedProducts.add(new DetailedProduct(5, 1, "Рубашка Slim fit", 12, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Рубашка Slim fit"));
        allDetailedProducts.add(new DetailedProduct(6, 1, "Хлопковая рубашка Regular fit", 745, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Хлопковая рубашка Regular fit"));
        allDetailedProducts.add(new DetailedProduct(7, 1, "Рубашка Easy iron Slim fit", 2456, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Рубашка Easy iron Slim fit"));
        allDetailedProducts.add(new DetailedProduct(8, 1, "Рубашка из смесового льна", 345, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Рубашка из смесового льна"));
        allDetailedProducts.add(new DetailedProduct(9, 1, "Джинсовая рубашка", 978, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Джинсовая рубашка"));
        allDetailedProducts.add(new DetailedProduct(10, 2, "Толстовка", 7562, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Толстовка"));
        allDetailedProducts.add(new DetailedProduct(11, 2, "Трикотажный свитшот", 36, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Трикотажный свитшот"));
        allDetailedProducts.add(new DetailedProduct(12, 2, "Хлопковый джемпер", 365, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Хлопковый джемпер"));
        allDetailedProducts.add(new DetailedProduct(13, 2, "Джемпер", 34, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Джемпер"));
        allDetailedProducts.add(new DetailedProduct(14, 2, "Свитшот из неопрена", 2355, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Свитшот из неопрена"));
        allDetailedProducts.add(new DetailedProduct(15, 3, "Slim Low Jeans", 472, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Slim Low Jeans"));
        allDetailedProducts.add(new DetailedProduct(16, 3, "Skinny Low Jeans", 43, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Skinny Low Jeans"));
        allDetailedProducts.add(new DetailedProduct(17, 3, "Брюки карго", 52, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Брюки карго"));
        allDetailedProducts.add(new DetailedProduct(18, 3, "Короткие шорты-чиносы", 233, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Короткие шорты-чиносы"));
        allDetailedProducts.add(new DetailedProduct(19, 3, "Твиловые шорты", 2424, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Твиловые шорты"));
        allDetailedProducts.add(new DetailedProduct(20, 4, "Куртка-бомбер", 4211, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Куртка-бомбер"));
        allDetailedProducts.add(new DetailedProduct(21, 4, "Стеганная куртка", 42, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Стеганная куртка"));
        allDetailedProducts.add(new DetailedProduct(22, 4, "Утепленная куртка-бомбер", 424, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Утепленная куртка-бомбер"));
        allDetailedProducts.add(new DetailedProduct(23, 4, "Трикотажный бомбер", 418, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Трикотажный бомбер"));
        allDetailedProducts.add(new DetailedProduct(24, 4, "Утепленная куртка", 356, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Утепленная куртка"));
        allDetailedProducts.add(new DetailedProduct(25, 5, "Пиджак Slim fit", 656, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Пиджак Slim fit"));
        allDetailedProducts.add(new DetailedProduct(26, 5, "Костюмные брюки Slim fit", 8688, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Костюмные брюки Slim fit"));
        allDetailedProducts.add(new DetailedProduct(27, 5, "Пиджак Regular fit", 5668, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Пиджак Regular fit"));
        allDetailedProducts.add(new DetailedProduct(28, 5, "Пиджак из хлопкового поплина", 56, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Пиджак из хлопкового поплина"));
        allDetailedProducts.add(new DetailedProduct(29, 5, "Костюмная жилетка", 568, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Костюмная жилетка"));
        allDetailedProducts.add(new DetailedProduct(30, 6, "Спортивная футболка", 56, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Спортивная футболка"));
        allDetailedProducts.add(new DetailedProduct(31, 6, "Стеганная куртка", 356, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Стеганная куртка"));
        allDetailedProducts.add(new DetailedProduct(32, 6, "Шорты для бега до колена", 355, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Шорты для бега до колена"));
        allDetailedProducts.add(new DetailedProduct(33, 6, "Куртка", 68, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Куртка"));
        allDetailedProducts.add(new DetailedProduct(34, 6, "Стеганная куртка", 36, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Стеганная куртка"));
        allDetailedProducts.add(new DetailedProduct(35, 7, "4 пары боксеров", 863, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for 4 пары боксеров"));
        allDetailedProducts.add(new DetailedProduct(36, 7, "7 пар трусов", 3865, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for 7 пар трусов"));
        allDetailedProducts.add(new DetailedProduct(37, 7, "Пижамные брюки с рисунком", 658, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Пижамные брюки с рисунком"));
        allDetailedProducts.add(new DetailedProduct(38, 7, "3 пары боксеров", 85, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for 3 пары боксеров"));
        allDetailedProducts.add(new DetailedProduct(39, 7, "2 пары хлопковых боксеров", 3658, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for 2 пары хлопковых боксеров"));
    }

    public List<Product> getAllProducts() {
        return convertToProducts(allDetailedProducts);
    }

    public List<Product> getProductsFromCategory(Category category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (DetailedProduct detailedProduct : allDetailedProducts) {
            if (detailedProduct.getCategoryId() == category.getId()) {
                categoryProducts.add(convertToProduct(detailedProduct));
            }
        }
        return categoryProducts;
    }

    public DetailedProduct getDetailedProduct(Product product) {
        int i = 0;
        while (i < allDetailedProducts.size()) {
            if (allDetailedProducts.get(i).getId() == product.getId())
                return allDetailedProducts.get(i);
            i++;
        }
        throw new InvalidProductIdException();
    }

    private List<Product> convertToProducts(List<DetailedProduct> detailedProducts) {
        List<Product> products = new ArrayList<>();
        for (DetailedProduct detailedProduct : detailedProducts) {
            products.add(convertToProduct(detailedProduct));
        }
        return products;
    }

    private Product convertToProduct(DetailedProduct detailedProduct) {
        return new Product(
                detailedProduct.getId(),
                detailedProduct.getCategoryId(),
                detailedProduct.getName(),
                detailedProduct.getPrice(),
                detailedProduct.getImageUrl());
    }
}
