import specComparationYaml from "./specComparation-openapi.yaml";
import orderYaml from "./order-openapi.yaml";
import retargettingYaml from "./retargetting-openapi.yaml";
import insuranceSubscriptionYaml from "./insuranceSubscription-openapi.yaml";
import paymentYaml from "./payment-openapi.yaml";
import customerYaml from "./customer-openapi.yaml";
import messageYaml from "./message-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let specComparationSpec = YAML.stringify(specComparationYaml);
apiSpec += specComparationSpec;

let orderSpec = YAML.stringify(orderYaml);
apiSpec += orderSpec;

let retargettingSpec = YAML.stringify(retargettingYaml);
apiSpec += retargettingSpec;

let insuranceSubscriptionSpec = YAML.stringify(insuranceSubscriptionYaml);
apiSpec += insuranceSubscriptionSpec;

let paymentSpec = YAML.stringify(paymentYaml);
apiSpec += paymentSpec;

let customerSpec = YAML.stringify(customerYaml);
apiSpec += customerSpec;

let messageSpec = YAML.stringify(messageYaml);
apiSpec += messageSpec;


export default apiSpec;