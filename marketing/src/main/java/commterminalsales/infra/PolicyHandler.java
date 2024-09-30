package commterminalsales.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commterminalsales.config.kafka.KafkaProcessor;
import commterminalsales.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RetargettingRepository retargettingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SpecCompared'"
    )
    public void wheneverSpecCompared_스펙재방문시타켓팅수치증가(
        @Payload SpecCompared specCompared
    ) {
        SpecCompared event = specCompared;
        System.out.println(
            "\n\n##### listener 스펙재방문시타켓팅수치증가 : " +
            specCompared +
            "\n\n"
        );

        // Sample Logic //
        Retargetting.스펙재방문시타켓팅수치증가(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
