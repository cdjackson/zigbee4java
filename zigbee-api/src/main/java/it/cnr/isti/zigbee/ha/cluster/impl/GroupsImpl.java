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

package it.cnr.isti.zigbee.ha.cluster.impl;

import org.bubblecloud.zigbee.core.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Groups;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import org.bubblecloud.zigbee.proxy.cluster.api.core.Attribute;
import org.bubblecloud.zigbee.proxy.cluster.api.core.Status;
import org.bubblecloud.zigbee.proxy.cluster.api.core.Subscription;
import org.bubblecloud.zigbee.proxy.cluster.api.core.ZigBeeClusterException;
import org.bubblecloud.zigbee.proxy.cluster.api.general.groups.AddGroupResponse;
import org.bubblecloud.zigbee.proxy.cluster.api.general.groups.GetGroupMembershipResponse;
import org.bubblecloud.zigbee.proxy.cluster.api.general.groups.RemoveGroupResponse;
import org.bubblecloud.zigbee.proxy.cluster.api.general.groups.ViewGroupResponse;
import org.bubblecloud.zigbee.proxy.cluster.api.global.DefaultResponse;
import org.bubblecloud.zigbee.proxy.cluster.impl.general.GroupsCluster;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:alessandro.giari@isti.cnr.it">Alessandro Giari</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 19:00:05 +0300 (Tue, 06 Aug 2013) $)
 * @since 0.1.0
 *
 */
public class GroupsImpl implements Groups {
	
	private GroupsCluster groupCluster;
	private Attribute nameSupport;
	
	public GroupsImpl(ZigBeeDevice zbDevice){
		groupCluster = new GroupsCluster(zbDevice);
		nameSupport = groupCluster.getAttributeNameSupport();
	}

	public AddGroupResponse addGroup(int groupId, String name) throws ZigBeeHAException{
		try {
			AddGroupResponse response = (AddGroupResponse)groupCluster.addGroup(groupId, name);
			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public void addGroupIfIdentifying(int groupId, String name) throws ZigBeeHAException{
		try {
			DefaultResponse response = (DefaultResponse)groupCluster.addGroupIfIdentifying(groupId, name);
			if (! response.getStatus().equals(Status.SUCCESS))
				throw new ZigBeeHAException(response.getStatus().toString());
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}

	}

	public GetGroupMembershipResponse getGroupMembership(int[] groupList) throws ZigBeeHAException{
		try {
			GetGroupMembershipResponse response = (GetGroupMembershipResponse)groupCluster.getGroupMembership(groupList);
			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Attribute getNameSupport() {
		return nameSupport;
	}

	public void removeAllGroup() throws ZigBeeHAException{
		try {
			DefaultResponse response = (DefaultResponse)groupCluster.removeAllGroup();
			if (! response.getStatus().equals(Status.SUCCESS))
				throw new ZigBeeHAException(response.getStatus().toString());
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public RemoveGroupResponse removeGroup(int groupId) throws ZigBeeHAException{
		try {
			RemoveGroupResponse response = (RemoveGroupResponse)groupCluster.removeGroup(groupId);
			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public ViewGroupResponse viewGroup(int groupId) throws ZigBeeHAException{
		try {
			ViewGroupResponse response = (ViewGroupResponse)groupCluster.viewGroup(groupId);
			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Subscription[] getActiveSubscriptions() {
		return groupCluster.getActiveSubscriptions();
	}

	public int getId() {
		return groupCluster.getId();
	}

	public String getName() {
		return groupCluster.getName();
	}

	public Attribute getAttribute(int id) {		
		Attribute[] attributes = groupCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if( attributes[i].getId() == id ) 
				return attributes[i];
		}
		return null;
	}

	public Attribute[] getAttributes() {
		return groupCluster.getAvailableAttributes();
	}
	
}
