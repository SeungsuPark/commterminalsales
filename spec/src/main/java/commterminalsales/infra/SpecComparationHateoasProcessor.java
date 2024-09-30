package commterminalsales.infra;

import commterminalsales.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpecComparationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SpecComparation>> {

    @Override
    public EntityModel<SpecComparation> process(
        EntityModel<SpecComparation> model
    ) {
        return model;
    }
}
