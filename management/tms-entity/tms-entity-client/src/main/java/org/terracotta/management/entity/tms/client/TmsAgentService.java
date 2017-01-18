/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.management.entity.tms.client;

import org.terracotta.management.model.call.Parameter;
import org.terracotta.management.model.cluster.Cluster;
import org.terracotta.management.model.context.Context;
import org.terracotta.management.model.message.Message;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Anthony Dahanne
 */
public interface TmsAgentService {
    TmsAgentService setOperationTimeout(long duration, TimeUnit unit);

    Cluster readTopology() throws TimeoutException, InterruptedException, ExecutionException;

    List<Message> readMessages() throws InterruptedException, ExecutionException, TimeoutException;

    ManagementCall<Void> startStatisticCollector(Context context, long interval, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

    ManagementCall<Void> stopStatisticCollector(Context context) throws InterruptedException, ExecutionException, TimeoutException;

    <T> ManagementCall<T> call(Context context, String capabilityName, String methodName, Class<T> returnType, Parameter... parameters) throws InterruptedException, ExecutionException, TimeoutException;

    void cancelAllManagementCalls();
}
