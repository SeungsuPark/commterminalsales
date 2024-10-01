package commterminalsales.external;

import java.util.Date;
import lombok.Data;

@Data
public class Spec {

    private Long id;
    private String spec;
    private String phoneColor;
    private String phoneType;
    private Object image;
    private Object manufacturer;
}
