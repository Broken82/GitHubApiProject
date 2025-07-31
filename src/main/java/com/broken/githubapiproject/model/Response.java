package com.broken.githubapiproject.model;

import com.broken.githubapiproject.client.dto.BranchDto;

import java.util.List;

public record Response(String repositoryName, String repositoryOwner, List<BranchDto> branches) {
}
