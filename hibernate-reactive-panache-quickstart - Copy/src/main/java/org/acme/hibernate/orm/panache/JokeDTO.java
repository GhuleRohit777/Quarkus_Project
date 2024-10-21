package org.acme.hibernate.orm.panache;

public class JokeDTO {
    public String setup;
    public String punchline;

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    // Getters and setters (if needed)
}
