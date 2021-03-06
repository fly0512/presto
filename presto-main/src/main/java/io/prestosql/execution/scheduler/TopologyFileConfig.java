/*
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
package io.prestosql.execution.scheduler;

import io.airlift.configuration.Config;
import io.airlift.units.Duration;
import io.airlift.units.MinDuration;

import java.io.File;

import static java.util.concurrent.TimeUnit.MINUTES;

public class TopologyFileConfig
{
    private File networkTopologyFile;
    private Duration refreshPeriod = new Duration(5, MINUTES);

    public File getNetworkTopologyFile()
    {
        return networkTopologyFile;
    }

    @Config("node-scheduler.network-topology.file")
    public TopologyFileConfig setNetworkTopologyFile(File networkTopologyFile)
    {
        this.networkTopologyFile = networkTopologyFile;
        return this;
    }

    @MinDuration("1ms")
    public Duration getRefreshPeriod()
    {
        return refreshPeriod;
    }

    @Config("node-scheduler.network-topology.refresh-period")
    public TopologyFileConfig setRefreshPeriod(Duration refreshPeriod)
    {
        this.refreshPeriod = refreshPeriod;
        return this;
    }
}
