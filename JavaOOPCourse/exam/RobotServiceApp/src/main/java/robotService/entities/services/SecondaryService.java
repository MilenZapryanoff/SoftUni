package robotService.entities.services;

public class SecondaryService extends BaseService {
    private static final int DEFAULT_CAPACITY = 15;

    public SecondaryService(String name) {
        super(name, DEFAULT_CAPACITY);
    }
}
