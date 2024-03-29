package pl.wip.wipplatformbe.models;

@Document(collection = "test")
public class Test {
    @Id
    private String id;
    private String name;
}
