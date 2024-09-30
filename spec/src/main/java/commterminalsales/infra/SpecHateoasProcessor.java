package commterminalsales.infra;

import commterminalsales.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpecHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Spec>> {

    @Override
    public EntityModel<Spec> process(EntityModel<Spec> model) {
        return model;
    }
}
