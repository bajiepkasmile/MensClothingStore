package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.data.datasources.remote.impl.DtoMapper;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.McsApi;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.ProductDto;
import com.nodomain.mensclothingstore.domain.exceptions.ConnectionFailedException;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;


public class ProductsRemoteStorage {

    private final McsApi api;
    private final DtoMapper dtoMapper;

    public ProductsRemoteStorage(McsApi api, DtoMapper dtoMapper) {
        this.api = api;
        this.dtoMapper = dtoMapper;
    }

    public List<Product> getProductsFromCategory(Category category) {
        try {
            return tryToGetProductsFromCategory(category);
        } catch (IOException e) {
            throw new ConnectionFailedException();
        }
    }

    private List<Product> tryToGetProductsFromCategory(Category category) throws IOException {
        Response<ProductDto[]> response = submitGetProductsFromCategoryRequest(category);
        return getProductsFromResponse(response);
    }

    private Response<ProductDto[]> submitGetProductsFromCategoryRequest(Category category) throws IOException {
        return api.getProductsFromCategory(category.getId()).execute();
    }

    private List<Product> getProductsFromResponse(Response<ProductDto[]> response) {
        ProductDto[] productDtos = response.body();
        return dtoMapper.fromDtos(productDtos);
    }
}
