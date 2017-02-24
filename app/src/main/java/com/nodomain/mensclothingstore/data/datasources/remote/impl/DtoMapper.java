package com.nodomain.mensclothingstore.data.datasources.remote.impl;


import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.CategoryDto;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.CommentDto;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.ProductDto;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;


public class DtoMapper {

    @Inject
    public DtoMapper() {
    }

    public Category fromDto(CategoryDto categoryDto) {
        return new Category(categoryDto.id, categoryDto.name);
    }

    public Product fromDto(ProductDto productDto) {
        return new Product(
                productDto.id,
                productDto.categoryId,
                productDto.name,
                productDto.price,
                //server sends image url without "http://" prefix, but retrofit doesn't load image without it
                "http://" + productDto.imageUrl,
                productDto.description);
    }

    public Comment fromDto(CommentDto commentDto) {
        Calendar sentTime = unixSecondsToCalendar(commentDto.sentTime);
        return new Comment(commentDto.productId, commentDto.senderName, sentTime, commentDto.text);
    }

    public List<Category> fromDtos(CategoryDto[] categoryDtos) {
        ArrayList<Category> categories = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtos) {
            categories.add(fromDto(categoryDto));
        }

        return categories;
    }

    public List<Product> fromDtos(ProductDto[] productDtos) {
        ArrayList<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            products.add(fromDto(productDto));
        }

        return products;
    }

    public List<Comment> fromDtos(CommentDto[] commentDtos) {
        ArrayList<Comment> comments = new ArrayList<>();
        for (CommentDto commentDto : commentDtos) {
            comments.add(fromDto(commentDto));
        }

        return comments;
    }

    private Calendar unixSecondsToCalendar(long unixSeconds) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
        calendar.setTimeInMillis(unixSeconds * 1000L);  //Calendar works with milliseconds, so need to multiply by 1000
        return calendar;
    }
}
