package com.broken.githubapiproject;

import com.broken.githubapiproject.client.GitHubClient;
import com.broken.githubapiproject.client.dto.BranchDto;
import com.broken.githubapiproject.client.dto.RepositoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GitHubApiProjectApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GitHubClient gitHubClient;

    @Test
    void happyPathIntegrationTest() throws Exception {
        //GIVEN
        when(gitHubClient.fetchRepositories("test")).thenReturn(List.of(
                new RepositoryDto("forked-repo", new RepositoryDto.Owner("test"), true),
                new RepositoryDto("normal-repo", new RepositoryDto.Owner("test"), false)
        ));

        when(gitHubClient.fetchBranches("test","normal-repo")).thenReturn(List.of(
                new BranchDto("main", new BranchDto.Commit("aaa111")),
                new BranchDto("dev", new BranchDto.Commit("bbb222"))
        ));

        mockMvc.perform(get("/api/repos/test"))
                .andExpect(status().isOk())
                //przefiltrowane forki
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].repositoryName").value("normal-repo"))
                .andExpect(jsonPath("$[0].repositoryOwner").value("test"))
                //branche
                .andExpect(jsonPath("$[0].branches.length()").value(2))
                .andExpect(jsonPath("$[0].branches[0].name").value("main"))
                .andExpect(jsonPath("$[0].branches[0].commit.sha").value("aaa111"));


    }

}
