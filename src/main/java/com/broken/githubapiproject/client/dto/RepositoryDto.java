package com.broken.githubapiproject.client.dto;

public record RepositoryDto(String name, Owner owner, boolean fork) {
    public record Owner(String login){}
}
