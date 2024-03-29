package pl.wip.wipplatformbe.repositories;

public interface TestRepository extends MongoRepository<Test, String> {
    // Get all items from the collection
    List<Test> findAll();
    // Get item by id
    Test findById(String id);
    // Save item
    Test save(Test test);
}
