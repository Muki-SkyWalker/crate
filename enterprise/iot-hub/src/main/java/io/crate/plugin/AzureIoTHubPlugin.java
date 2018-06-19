/*
 * This file is part of a module with proprietary Enterprise Features.
 *
 * Licensed to Crate.io Inc. ("Crate.io") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 * To use this file, Crate.io must have given you permission to enable and
 * use such Enterprise Features and you must have a valid Enterprise or
 * Subscription Agreement with Crate.io.  If you enable or use the Enterprise
 * Features, you represent and warrant that you have a valid Enterprise or
 * Subscription Agreement with Crate.io.  Your use of the Enterprise Features
 * if governed by the terms and conditions of your Enterprise or Subscription
 * Agreement with Crate.io.
 */

package io.crate.plugin;

import io.crate.Plugin;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;


public class AzureIoTHubPlugin implements Plugin {
    private static final Logger LOGGER = Loggers.getLogger(AzureIoTHubPlugin.class);

    public AzureIoTHubPlugin(Settings settings) {
        LOGGER.info("AzureIoTHubPlugin loaded");
    }

    public String name() {
        return "iot-hub-plugin";
    }

    public String description() {
        return "Azure IoT Hub to CrateDB Ingestion Plugin";
    }

}
