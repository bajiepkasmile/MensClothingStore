package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductsRemoteStorage {

    private List<Product> allProducts;

    public ProductsRemoteStorage() {
        allProducts = new ArrayList<>();
        allProducts.add(new Product(0, 0, "Футболка стретч", 245, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Футболка стретч"));
        allProducts.add(new Product(1, 0, "Футболка с длинным рукавом", 3643, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Футболка с длинным рукавом"));
        allProducts.add(new Product(2, 0, "Футболка Slim fit", 64, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Футболка Slim fit"));
        allProducts.add(new Product(3, 0, "Футболка с круглым воротом", 1264, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Футболка с круглым воротом"));
        allProducts.add(new Product(4, 0, "Широкая футболка", 634, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Широкая футболка"));
        allProducts.add(new Product(5, 1, "Рубашка Slim fit", 12, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Рубашка Slim fit"));
        allProducts.add(new Product(6, 1, "Хлопковая рубашка Regular fit", 745, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Хлопковая рубашка Regular fit"));
        allProducts.add(new Product(7, 1, "Рубашка Easy iron Slim fit", 2456, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Рубашка Easy iron Slim fit"));
        allProducts.add(new Product(8, 1, "Рубашка из смесового льна", 345, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Рубашка из смесового льна"));
        allProducts.add(new Product(9, 1, "Джинсовая рубашка", 978, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Джинсовая рубашка"));
        allProducts.add(new Product(10, 2, "Толстовка", 7562, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Толстовка"));
        allProducts.add(new Product(11, 2, "Трикотажный свитшот", 36, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Трикотажный свитшот"));
        allProducts.add(new Product(12, 2, "Хлопковый джемпер", 365, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Хлопковый джемпер"));
        allProducts.add(new Product(13, 2, "Джемпер", 34, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Джемпер"));
        allProducts.add(new Product(14, 2, "Свитшот из неопрена", 2355, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Свитшот из неопрена"));
        allProducts.add(new Product(15, 3, "Slim Low Jeans", 472, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Slim Low Jeans"));
        allProducts.add(new Product(16, 3, "Skinny Low Jeans", 43, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Skinny Low Jeans"));
        allProducts.add(new Product(17, 3, "Брюки карго", 52, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Брюки карго"));
        allProducts.add(new Product(18, 3, "Короткие шорты-чиносы", 233, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Короткие шорты-чиносы"));
        allProducts.add(new Product(19, 3, "Твиловые шорты", 2424, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Твиловые шорты"));
        allProducts.add(new Product(20, 4, "Куртка-бомбер", 4211, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Куртка-бомбер"));
        allProducts.add(new Product(21, 4, "Стеганная куртка", 42, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Стеганная куртка"));
        allProducts.add(new Product(22, 4, "Утепленная куртка-бомбер", 424, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Утепленная куртка-бомбер"));
        allProducts.add(new Product(23, 4, "Трикотажный бомбер", 418, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Трикотажный бомбер"));
        allProducts.add(new Product(24, 4, "Утепленная куртка", 356, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Утепленная куртка"));
        allProducts.add(new Product(25, 5, "Пиджак Slim fit", 656, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Пиджак Slim fit"));
        allProducts.add(new Product(26, 5, "Костюмные брюки Slim fit", 8688, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Костюмные брюки Slim fit"));
        allProducts.add(new Product(27, 5, "Пиджак Regular fit", 5668, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Пиджак Regular fit"));
        allProducts.add(new Product(28, 5, "Пиджак из хлопкового поплина", 56, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Пиджак из хлопкового поплина"));
        allProducts.add(new Product(29, 5, "Костюмная жилетка", 568, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Костюмная жилетка"));
        allProducts.add(new Product(30, 6, "Спортивная футболка", 56, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for Спортивная футболка"));
        allProducts.add(new Product(31, 6, "Стеганная куртка", 356, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for Стеганная куртка"));
        allProducts.add(new Product(32, 6, "Шорты для бега до колена", 355, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Шорты для бега до колена"));
        allProducts.add(new Product(33, 6, "Куртка", 68, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for Куртка"));
        allProducts.add(new Product(34, 6, "Стеганная куртка", 36, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for Стеганная куртка"));
        allProducts.add(new Product(35, 7, "4 пары боксеров", 863, "http://veralline.com/uploads/images/comparison/2015/03/12/55618ffdc4.jpg", "Description for 4 пары боксеров"));
        allProducts.add(new Product(36, 7, "7 пар трусов", 3865, "http://www.4shopping.ru/media/coll/2012/11/4925/scotch-and-soda-4925-fall-winter-12-13-0031.jpg", "Description for 7 пар трусов"));
        allProducts.add(new Product(37, 7, "Пижамные брюки с рисунком", 658, "http://www.ru.all.biz/img/ru/catalog/1119617.jpeg", "Description for Пижамные брюки с рисунком"));
        allProducts.add(new Product(38, 7, "3 пары боксеров", 85, "http://yepman.ru/wp-content/uploads/2013/02/tumblr_mhuw6tAikS1qeuobqo1_1280.jpg", "Description for 3 пары боксеров"));
        allProducts.add(new Product(39, 7, "2 пары хлопковых боксеров", 3658, "http://www.sportmaster.ru/upload/resize_cache/iblock/48e/1000_1000_1/11391710299.jpg", "Description for 2 пары хлопковых боксеров"));
    }

    public List<Product> getProductsFromCategory(Category category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product detailedProduct : allProducts) {
            if (detailedProduct.getCategoryId() == category.getId()) {
                categoryProducts.add(detailedProduct);
            }
        }
        return categoryProducts;
    }
}
