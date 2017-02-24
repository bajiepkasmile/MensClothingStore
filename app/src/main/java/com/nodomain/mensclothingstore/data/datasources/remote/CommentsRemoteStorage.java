package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.data.datasources.remote.impl.DtoMapper;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.McsApi;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos.CommentDto;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.requestbodies.AddCommentRequestBody;
import com.nodomain.mensclothingstore.domain.exceptions.ConnectionFailedException;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;


public class CommentsRemoteStorage {

    private final McsApi api;
    private final DtoMapper dtoMapper;

    public CommentsRemoteStorage(McsApi api, DtoMapper dtoMapper) {
        this.api = api;
        this.dtoMapper = dtoMapper;
    }

    public List<Comment> getCommentsForProduct(Product product) {
        try {
            return tryToGetCommentsForProduct(product);
        } catch (IOException e) {
            throw new ConnectionFailedException();
        }
    }

    private List<Comment> tryToGetCommentsForProduct(Product product) throws IOException {
        Response<CommentDto[]> response = submitGetCommentsForProductRequest(product);
        return getCommentsForProductFromResponse(response);
    }

    private Response<CommentDto[]> submitGetCommentsForProductRequest(Product product) throws IOException {
        return api.getCommentsForProduct(product.getId()).execute();
    }

    private List<Comment> getCommentsForProductFromResponse(Response<CommentDto[]> response) {
        CommentDto[] commentDtos = response.body();
        return dtoMapper.fromDtos(commentDtos);
    }

    public Comment addCommentToProduct(String senderName, String text, Product product) {
        try {
            return tryToAddCommentToProduct(senderName, text, product);
        } catch (IOException e) {
            throw new ConnectionFailedException();
        }
    }

    private Comment tryToAddCommentToProduct(String senderName, String text, Product product) throws IOException {
        Response<CommentDto> response = submitAddCommentToProductRequest(senderName, text, product);
        return getCommentFromResponse(response);
    }

    private Response<CommentDto> submitAddCommentToProductRequest(String senderName, String text, Product product)
            throws IOException {
        AddCommentRequestBody body = new AddCommentRequestBody(senderName, text);
        return api.addCommentToProduct(product.getId(), body).execute();
    }

    private Comment getCommentFromResponse(Response<CommentDto> response) {
        CommentDto commentDto = response.body();
        return dtoMapper.fromDto(commentDto);
    }
}
