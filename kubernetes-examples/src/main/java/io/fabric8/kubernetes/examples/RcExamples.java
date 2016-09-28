/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RcExamples {

  private static final Logger logger = LoggerFactory.getLogger(RcExamples.class);

  public static void main(String[] args) {
    String master = "http://172.16.18.133:8080/";
    if (args.length == 1) {
      master = args[0];
    }

    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (KubernetesClient client = new DefaultKubernetesClient(config)) {
      try {
        //创建资源配额
      //  ResourceQuota quota = new ResourceQuotaBuilder().withNewMetadata().withName("pod-quota").endMetadata().withNewSpec().addToHard("pods", new Quantity("10")).endSpec().build();
      //  log("Create resource quota", client.resourceQuotas().inNamespace("thisisatest1").create(quota));

        //列出所有job
//        try {
//          log("Get jobs in namespace", client.extensions().jobs().inNamespace("development").list());
//        } catch (APIGroupNotAvailableException e) {
//          log("Skipping jobs example - extensions API group not available");
//        }

//        // Create an RC
//        ReplicationController rc = new ReplicationControllerBuilder()
//          .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
//          .withNewSpec().withReplicas(3)
//          .withNewTemplate()
//          .withNewMetadata().addToLabels("server", "nginx").endMetadata()
//          .withNewSpec()
//          .addNewContainer().withName("nginx").withImage("nginx")
//          .addNewPort().withContainerPort(80).endPort()
//          .endContainer()
//          .endSpec()
//          .endTemplate()
//          .endSpec().build();
//
//        log("Created RC", client.replicationControllers().inNamespace("development").create(rc));

//        log("Created RC with inline DSL",
//          client.replicationControllers().inNamespace("development").createNew()
//            .withNewMetadata().withName("nginx2-controller1").addToLabels("server", "nginx").endMetadata()
//            .withNewSpec().withReplicas(3)
//            .withNewTemplate()
//            .withNewMetadata().addToLabels("server", "nginx2").endMetadata()
//            .withNewSpec()
//            .addNewContainer().withName("nginx").withImage("nginx")
//            .addNewPort().withContainerPort(80).endPort()
//            .endContainer()
//            .endSpec()
//            .endTemplate()
//            .endSpec().done());

//        ReplicationController gotRc = client.replicationControllers().inNamespace("development").withName("nginx-controller").get();
//        log("Get RC by name in namespace", gotRc);
//        // Dump the RC as YAML
//        // Dump the RC as YAML
//         log("Dump RC as YAML", SerializationUtils.dumpAsYaml(gotRc));
//         log("Dump RC as YAML without state", SerializationUtils.dumpWithoutRuntimeStateAsYaml(gotRc));
        // Get the RC by label
        //log("Get RC by label", client.replicationControllers().withLabel("server", "nginx").list());
        // Get the RC without label
         //log("Get RC without label", client.replicationControllers().withoutLabel("server", "apache").list());
        // Get the RC with label in
       // log("Get RC with label in", client.replicationControllers().withLabelIn("server", "nginx").list());
        // Get the RC with label in
        //log("Get RC with label not in", client.replicationControllers().withLabelNotIn("server", "apache").list());
        // Get the RC by label in namespace

        // Update the RC
        //client.replicationControllers().inNamespace("development").withName("nginx-controller").cascading(false).edit().editMetadata().addToLabels("new", "label").endMetadata().done();

       // client.replicationControllers().inNamespace("development").withName("nginx-controller").scale(8);
        // Update the RC - change the image to apache
//        client.replicationControllers().inNamespace("development").withName("nginx-controller").edit().editSpec().editTemplate().withNewSpec()
//          .addNewContainer().withName("nginx").withImage("httpd")
//          .addNewPort().withContainerPort(80).endPort()
//          .endContainer()
//          .endSpec()
//          .endTemplate()
//          .endSpec().done();
        //client.replicationControllers().inNamespace("development").withName("nginx-controller").rolling().updateImage("nginx");
        client.replicationControllers().inNamespace("development").withName("nginx-controller1").
          rolling().edit().editMetadata().addToLabels("testing", "rolling-update").endMetadata().done();


      } catch (KubernetesClientException e) {
        logger.error(e.getMessage(), e);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {

      }
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }

}
