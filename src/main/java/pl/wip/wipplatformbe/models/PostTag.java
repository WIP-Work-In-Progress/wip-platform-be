package pl.wip.wipplatformbe.models;

import pl.wip.wipplatformbe.enums.Importance;

public class PostTag {
  private Tag tag;
  private Importance importance;

  public PostTag(Tag tag, Importance importance) {
    this.tag = tag;
    this.importance = importance;
  }
}
