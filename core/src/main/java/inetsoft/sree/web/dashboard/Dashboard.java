/*
 * This file is part of StyleBI.
 * Copyright (C) 2024  InetSoft Technology
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package inetsoft.sree.web.dashboard;

import inetsoft.util.XMLSerializable;

/**
 * This class defines the dashboard.
 *
 * @version 8.5, 6/15/2006
 * @author InetSoft Technology Corp
 */
public interface Dashboard extends XMLSerializable, Cloneable {
   /**
    * Type of viewsheet dashboard.
    */
   String VSDASHBOARD = "vs";

   /**
    * Get the type of the dashboard.
    */
   String getType();

   /**
    * Check if the dashboard editable.
    */
   boolean isComposable();

   /**
    * Get the description of the dashboard.
    */
   String getDescription();

   /**
    * Set the description of the dashboard.
    */
   void setDescription(String description);
}