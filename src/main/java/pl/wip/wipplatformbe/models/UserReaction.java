package pl.wip.wipplatformbe.models;

import pl.wip.wipplatformbe.enums.Reaction;

public class UserReaction {
    private Reaction reaction;
    private final String userId;
    
    public UserReaction(Reaction reaction, String userId) {
        this.reaction = reaction;
        this.userId = userId;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public String getUserId() {
        return userId;
    }
}
