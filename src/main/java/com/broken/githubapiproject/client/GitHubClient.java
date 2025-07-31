package com.broken.githubapiproject.client;

import com.broken.githubapiproject.client.dto.BranchDto;
import com.broken.githubapiproject.client.dto.RepositoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component

public class GitHubClient {
    private final RestClient restClient;

    @Autowired
    public GitHubClient(RestClient restClient) {
        this.restClient = restClient;
    }


    public List<RepositoryDto> fetchRepositories(String username){
                return restClient.get().uri("/users/{username}/repos", username).retrieve().body(new ParameterizedTypeReference<>() {
                });
            }

            public List<BranchDto> fetchBranches(String username, String repo){
                return restClient.get().uri("/repos/{username}/{repo}/branches", username, repo).retrieve().body(new ParameterizedTypeReference<>() {
                });
            }

}
