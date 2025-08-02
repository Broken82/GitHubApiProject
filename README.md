# GitHub API Project

Minimal REST service that returns **all non‑forked public repositories of a GitHub user** together with every branch name and its last commit SHA.

---

## Features

* `GET /api/v1/users/{username}/repositories` – single entry point
* Filters out forked repositories
* Returns for each repository
  * repository name
  * owner login
  * list of branches with last commit SHA
* Error handling for status code 404 (user not found)
* Happy‑path integration test

---

## Tech Stack

| Layer        | Technology                            |
|--------------|---------------------------------------|
| Language     | Java 21                                |
| Framework    | Spring Boot 3.5.4 (MVC + RestClient)    |
| Build Tool   | Maven 4.0                            |
| Tests        | Mockito                      |

---

## Installation & Running

```bash
# 1. Clone the repo
git clone https://github.com/your‑org/github‑api‑project.git
cd github‑api‑project

# 2. Build the jar
mvn clean package

# 3. Run the app (default port 8080)
java -jar target/github-api-project.jar
```


---

## Usage Example

```bash
curl http://localhost:8080/api/v1/users/octocat/repositories | jq
```

```json
[
  {
    "repositoryName": "hello-world",
    "repositoryOwner": "octocat",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "7fd1a60b01f91b314f59955d894fd22a7a2c5a3a"
      }
    ]
  }
]
```

If the user does not exist you will receive:

```json
{
  "status": 404,
  "message": "User unknown-user not found"
}
```

---
## License

MIT

