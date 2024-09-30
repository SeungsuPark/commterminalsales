package commterminalsales.infra;

import commterminalsales.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RetargettingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Retargetting>> {

    @Override
    public EntityModel<Retargetting> process(EntityModel<Retargetting> model) {
        return model;
    }
}
