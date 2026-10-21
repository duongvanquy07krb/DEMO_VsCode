public class GitHubLinkTest {
    public static boolean isValidGitHubLink(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }

        String normalized = url.trim();
        String pattern = "^https?://(www\\.)?github\\.com/[A-Za-z0-9_.-]+(?:/[A-Za-z0-9_.-]+)+/?$";
        return normalized.matches(pattern);
    }

    public static void runTests() {
        String[][] testCases = {
            {"https://github.com/microsoft/vscode", "true"},
            {"https://www.github.com/openai/gpt-oss", "true"},
            {"https://github.com/owner/repo/", "true"},
            {"https://github.com/owner", "false"},
            {"https://gitlab.com/owner/repo", "false"},
            {"not-a-url", "false"},
            {"https://github.com/user/repo?tab=readme", "false"}
        };

        int passed = 0;
        int failed = 0;

        for (String[] test : testCases) {
            String input = test[0];
            boolean expected = Boolean.parseBoolean(test[1]);
            boolean actual = isValidGitHubLink(input);

            if (actual == expected) {
                passed++;
                System.out.println("PASS: " + input + " => " + actual);
            } else {
                failed++;
                System.out.println("FAIL: " + input + " => expected " + expected + " but got " + actual);
            }
        }

        System.out.println("\nKết quả: " + passed + " passed, " + failed + " failed");

        if (failed > 0) {
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
