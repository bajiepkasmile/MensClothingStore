package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.data.datasources.remote.impl.DtoMapper;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.McsApi;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.CategoryDto;
import com.nodomain.mensclothingstore.domain.exceptions.ConnectionFailedException;
import com.nodomain.mensclothingstore.model.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


public class CategoriesRemoteStorage {

    private final McsApi api;
    private final DtoMapper dtoMapper;

    public CategoriesRemoteStorage(McsApi api, DtoMapper dtoMapper) {
        this.api = api;
        this.dtoMapper = dtoMapper;
    }

    public List<Category> getCategories() {
        try {
            return tryToGetCategories();
        } catch (IOException e) {
            throw new ConnectionFailedException();
        }
    }

    private List<Category> tryToGetCategories() throws IOException {
        Response<CategoryDto[]> response = submitGetCategoriesRequest();
        return getCategoriesFromResponse(response);
    }

    private Response<CategoryDto[]> submitGetCategoriesRequest() throws IOException {
        return api.getCategories().execute();
    }

    private List<Category> getCategoriesFromResponse(Response<CategoryDto[]> response) {
        CategoryDto[] categoryDtos = response.body();
        return dtoMapper.fromDtos(categoryDtos);
    }
}
