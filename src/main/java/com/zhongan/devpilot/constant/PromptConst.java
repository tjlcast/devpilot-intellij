package com.zhongan.devpilot.constant;

import com.zhongan.devpilot.util.PromptTemplate;

public class PromptConst {

    private PromptConst() {
    }

    public static final String RESPONSE_FORMAT = "You are a coding expert.\n" +
            "You must obey ALL of the following rules:\n\n" +
            "- quote variable name with single backtick such as `name`.\n" +
            "- quote code block with triple backticks such as ```...```";

    public static final String ANSWER_IN_CHINESE = "\nPlease answer in Chinese.";

    // public static final String GENERATE_COMMIT = "Summarize the git diff with a concise and descriptive commit message. Adopt the imperative mood, present tense, active voice, and include relevant verbs. Remember that your entire response will be directly used as the git commit message.";
    public static final String GENERATE_COMMIT = "" +
            "feat: Add some tests about cache.\n" +
            "\n" +
            "fix: Fix some errors on chat.\n" +
            "\n" +
            "The above are two historical commit messages containing the 'feat' and 'fix' modes. Now your task is to generate a git message in the same format based on the following my git diff. Note that 'feat' represents a new development feature, 'fix' represents a problem fix, and only one can be used. The modifications need to be made more explicit.\n" +
            "\n" +
            "{{git_diff}}\n" +
            "\n" +
            "Only output the commit message, do not explain at the end, do not explain, do not output git diff information." +
            "";

    public final static String MOCK_WEB_MVC = "please use MockMvc to mock web requests, ";

    public static void main(String[] args) {
        String git_diff = "123";

        PromptTemplate commitPrompt = PromptTemplate.of(GENERATE_COMMIT);
        commitPrompt.setVariable("git_diff", git_diff);
        String commitPromptStr = commitPrompt.getPrompt();

        System.out.println(commitPromptStr);
    }
}
