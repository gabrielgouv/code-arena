package br.com.codearena.vo.challenge;

public class ChallengeOutputVO {

    private Long id;
    private String title;
    private String content;
    private String inputFormat;
    private String constraints;
    private String outputFormat;
    private String testCases;
    private String testExpectation;
    private String difficultLevel;
    private Long authorId;
    private Boolean userSolved;

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getConstraints() {
        return constraints;
    }

    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getTestCases() {
        return testCases;
    }

    public void setTestCases(String testCases) {
        this.testCases = testCases;
    }

    public String getTestExpectation() {
        return testExpectation;
    }

    public void setTestExpectation(String testExpectation) {
        this.testExpectation = testExpectation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(String difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Boolean getUserSolved() {
        return userSolved;
    }

    public void setUserSolved(Boolean userSolved) {
        this.userSolved = userSolved;
    }
}
