package githubapiserver;

import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/github")
public class GitHubController {

    @Value("${github.token}")
    private String githubToken;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping
    public String github() {
        return "GitHub";
    }

    @PostMapping("/create-repository")
    public ResponseEntity<Repository> createRepository(@RequestBody Repository repo) {
        try {
            GitHub github = GitHub.connectUsingOAuth(githubToken);
            GHCreateRepositoryBuilder builder = github.getOrganization(repo.getOrg())
                    .createRepository(repo.getName())
                    .private_(repo.getVisibility().equalsIgnoreCase("private"));

            GHRepository ghRepository = builder.create();

            // Create README.md file
            ghRepository.createContent("# " + repo.getName() + "\n\nThis is a required file for the repository.",
                    "Required File", "README.md");

            return new ResponseEntity<>(repo, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}