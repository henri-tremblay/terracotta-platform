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
package org.terracotta.management.service.monitoring;

import com.tc.classloader.CommonComponent;
import org.terracotta.context.extended.StatisticsRegistry;
import org.terracotta.management.registry.collect.StatisticCollector;
import org.terracotta.management.registry.collect.StatisticConfiguration;

@CommonComponent
public interface StatisticsService {
  StatisticsRegistry createStatisticsRegistry(Object contextObject);

  StatisticCollector createStatisticCollector(StatisticCollector.Collector collector);

  StatisticConfiguration getStatisticConfiguration();
}
