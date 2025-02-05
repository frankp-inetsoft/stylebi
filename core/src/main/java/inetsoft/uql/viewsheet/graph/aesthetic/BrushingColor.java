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
package inetsoft.uql.viewsheet.graph.aesthetic;

import inetsoft.uql.viewsheet.graph.BaseColor;
import inetsoft.util.css.CSSDictionary;
import inetsoft.util.css.CSSParameter;

import java.awt.*;

/**
 * Brushing colors.
 *
 * @version 12.3
 * @author InetSoft Technology
 */
public class BrushingColor extends BaseColor {
   /**
    * Get the highlight color for brushing.
    */
   public static Color getHighlightColor() {
      CSSDictionary dict = getDictionary();
      Color clr = null;

      if(dict.checkPresent(".brush-highlight-color")) {
         clr = dict.getForeground(new CSSParameter("Chart", null, "brush-highlight-color", null));
      }

      return (clr != null) ? clr : Color.red;
   }

   /**
    * Get the dimmed color for brushing.
    */
   public static Color getDimColor() {
      CSSDictionary dict = getDictionary();
      Color clr = null;

      if(dict.checkPresent(".brush-dim-color")) {
         clr = dict.getForeground(new CSSParameter("Chart", null, "brush-dim-color", null));
      }

      return (clr != null) ? clr : Color.gray;
   }
}
