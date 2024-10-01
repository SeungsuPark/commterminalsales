package commterminalsales.infra;

import commterminalsales.config.kafka.KafkaProcessor;
import commterminalsales.domain.*;
import commterminalsales.external.SpecService;
import commterminalsales.external.GetSpecDetailQuery;
import commterminalsales.external.Spec;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SalesStatusViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SalesStatusRepository salesStatusRepository;

    @Autowired
    private SpecService specService;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            SalesStatus salesStatus = new SalesStatus();
            // view 객체에 이벤트의 Value 를 set 함
            salesStatus.setProductId(orderPlaced.getProductId());
            salesStatus.setOrderId(orderPlaced.getId());
            salesStatus.setInsurance(
                Boolean.valueOf(orderPlaced.getInsuranceOption())
            );

            Spec spec = specService.getSpecDetail(orderPlaced.getProductId());

            salesStatus.setManufacturer(spec.getManufacturer());
            salesStatus.setPhoneColor(spec.getPhoneColor());

            // view 레파지 토리에 save
            salesStatusRepository.save(salesStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
