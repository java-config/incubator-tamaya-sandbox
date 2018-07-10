/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tamaya.commons;

import org.apache.commons.configuration.Configuration;

import javax.config.spi.ConfigSource;
import java.util.*;

/**
 * PropertySource that wraps {@link org.apache.commons.configuration.Configuration}.
 */
public class CommonsConfigConfigSource implements ConfigSource {

    private Configuration commonsConfig;
    private int ordinal;
    private String name;

    public CommonsConfigConfigSource(int ordinal, String name, Configuration commonsConfig) {
        this.commonsConfig = Objects.requireNonNull(commonsConfig);
        this.ordinal = ordinal;
        this.name = Objects.requireNonNull(name);
    }

    public CommonsConfigConfigSource(String name, Configuration commonsConfig) {
        this.commonsConfig = Objects.requireNonNull(commonsConfig);
        this.name = Objects.requireNonNull(name);
        try {
            this.ordinal = commonsConfig.getInt(ConfigSource.CONFIG_ORDINAL);
        } catch (Exception e) {
            this.ordinal = 0;
        }
    }

    @Override
    public int getOrdinal() {
        return ordinal;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue(String key) {
        return commonsConfig.getString(key);
    }

    @Override
    public Map<String, String> getProperties() {
        Map<String,String> config = new HashMap<>();
        Iterator<String> keyIter = commonsConfig.getKeys();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            config.put(key, commonsConfig.getString(key));
        }
        return config;
    }

}
