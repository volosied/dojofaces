/*
 * Copyright 2009 Ganesh Jung
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author: Ganesh Jung (latest modification by $Author: ganeshpuri $)
 * Version: $Revision: 1.3 $ $Date: 2010/03/13 20:50:14 $
 */
package org.j4fry.dojo.beans;

import java.util.Map;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;

/**
* This Map is returned by {@link DojoHelper#getClientId()}
* when the clientId of component is required.
*/
public class ClientIdMap extends MapAdapter {
	private Map<String, UIComponent> bindings;

	public ClientIdMap(Map<String, UIComponent> bindings) {
		this.bindings = bindings;
	}

	public String get(Object id) {
		UIComponent comp = ((UIComponent) bindings.get(id));
		if (comp == null) return null;
		return comp.getClientId(FacesContext.getCurrentInstance());
	}
}