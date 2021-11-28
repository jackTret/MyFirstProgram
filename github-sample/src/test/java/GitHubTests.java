import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;

public class GitHubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("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");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("jackTret", "MyFirstProgram")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
