package com.broken.githubapiproject.client.dto;

public record BranchDto(String name, Commit commit) {
    public record Commit(String sha){}
}
