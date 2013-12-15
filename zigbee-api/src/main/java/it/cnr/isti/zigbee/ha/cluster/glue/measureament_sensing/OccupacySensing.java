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

package it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.event.OccupancyListener;
import org.bubblecloud.zigbee.proxy.cluster.api.core.Attribute;

/**
 * This class represent the <b>Occupancy sensing</b> Cluster as defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075123r01ZB
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 *
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 19:00:05 +0300 (Tue, 06 Aug 2013) $)
 * @since 0.1.0
 *
 */
public interface OccupacySensing extends Cluster {
	
	public Attribute getOccupancy();
	
	/**
	 * 
	 * @param listener The {@link OccupancyListener} to subscribe for events
	 * @since 0.2.0
	 */
	public void subscribe(OccupancyListener listener);
	
	/**
	 * 
	 * @param listener The {@link OccupancyListener} to unsubscribe
	 * @since 0.2.0
	 */
	public void unsubscribe(OccupancyListener listener);
	
	public Attribute getOccupancySensorType();
	
	public Attribute getPIROccupiedToUnoccupiedDelay();
	public Attribute getPIRUnoccupiedToOccupiedDelay();
	/**
	 * @since 0.7.0
	 */
	public Attribute getPIRUnoccupiedToOccupiedThreshold();
	
	public Attribute getUltraSonicOccupiedToUnoccupiedDelay();
	public Attribute getUltraSonicUnoccupiedToOccupiedDelay();
	/**
	 * @since 0.7.0
	 */
	public Attribute getUltraSonicUnoccupiedToOccupiedThreshold();
}
