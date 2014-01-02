/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.api.cluster.impl;

import org.bubblecloud.zigbee.api.ZigbeeDeviceException;
import org.bubblecloud.zigbee.api.cluster.general.PumpConfigurationAndControl;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.Attribute;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.Reporter;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.ZigBeeClusterException;
import org.bubblecloud.zigbee.api.cluster.impl.general.PumpConfigurationAndControlCluster;
import org.bubblecloud.zigbee.network.ZigbeeEndpoint;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision:  $ ($LastChangedDate: $)
 *
 */

public class PumpConfigurationAndControlImpl implements PumpConfigurationAndControl {
	
	private PumpConfigurationAndControlCluster pumpConfigurationAndControlCluster;


	public PumpConfigurationAndControlImpl(ZigbeeEndpoint zbDevice){
		pumpConfigurationAndControlCluster = new PumpConfigurationAndControlCluster(zbDevice);
		
	}

	public int getId() {
		
		return pumpConfigurationAndControlCluster.getId();
	}

	public String getName() {
	
		return pumpConfigurationAndControlCluster.getName();
	}

    public Reporter[] getAttributeReporters() {
		return pumpConfigurationAndControlCluster.getAttributeReporters();
	}

	public Attribute[] getAttributes() {
	
		return pumpConfigurationAndControlCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = pumpConfigurationAndControlCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if( attributes[i].getId() == id ) 
				return attributes[i];
		}
		return null;
	}

	public String getDescription() throws ZigbeeDeviceException {
		 try {
	            return (String) pumpConfigurationAndControlCluster.getAttributeDescription().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigbeeDeviceException(e);
	        }
	}


}