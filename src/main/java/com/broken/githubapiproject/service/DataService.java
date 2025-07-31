package com.broken.githubapiproject.service;

import com.broken.githubapiproject.client.GitHubClient;
import com.broken.githubapiproject.client.dto.BranchDto;
import com.broken.githubapiproject.client.dto.RepositoryDto;
import com.broken.githubapiproject.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DataService {

    private final GitHubClient gitHubClient;

    @Autowired
    public DataService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }


    public List<Response> fetchAllRepos(String nickname){
        List<RepositoryDto> repoList = gitHubClient.fetchRepositories(nickname)
                .stream()
                .filter(repositoryDto -> !repositoryDto.fork())
                .toList();


        return repoList.stream()
                .map(
                        repositoryDto -> {
                            List<BranchDto> branchList = gitHubClient.fetchBranches(nickname, repositoryDto.name());
                            return new Response(repositoryDto.name(), repositoryDto.owner().login(), branchList);
                        }
                ).toList();
    }
}
