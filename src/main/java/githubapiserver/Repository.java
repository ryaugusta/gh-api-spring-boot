package githubapiserver;

import lombok.Data;
@Data
public class Repository {
    private String org;
    private String name;
    private String visibility;
}
