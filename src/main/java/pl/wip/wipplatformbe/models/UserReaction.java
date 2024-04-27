package pl.wip.wipplatformbe.models;

import pl.wip.wipplatformbe.enums.Reaction;
public class UserReaction {
  private Reaction reaction;
  private String userId;

  public UserReaction(Reaction reaction, String userId) {
    this.reaction = reaction;
    this.userId = userId;
  }
}
