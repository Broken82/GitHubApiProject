package com.broken.githubapiproject.exception;

public class GitHubUserNotFoundException extends RuntimeException {


    public GitHubUserNotFoundException(String username) {
        super("User " + username + " not found");
    }
}
