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
package inetsoft.uql.viewsheet.graph;

import inetsoft.util.css.*;

import java.awt.*;

/**
 * Chart line colors.
 *
 * @author InetSoft Technology
 * @version 13.3
 */
public class ChartLineColor extends BaseColor {
   /**
    * Get the default color for chart axis line
    */
   public static Color getAxisLineColor(Color defaultColor) {
      return getLineColor(defaultColor, CSSConstants.CHART_AXIS_LINE, null);
   }

   private static Color getLineColor(Color defaultColor, String cls, String type) {
      CSSDictionary dict = getDictionary();
      Color clr = null;

      if(dict.checkPresent(cls)) {
         CSSAttr typeAttr = type != null ? new CSSAttr("type", type) : null;
         clr = dict.getForeground(new CSSParameter(cls, null, null, typeAttr));
      }

      return (clr != null) ? clr : defaultColor;
   }

   /**
    * Get the default color for chart plot line
    *
    * @param defaultColor the color to use if no css color is defined
    * @param type         x, y, diagonal, quadrant
    */
   public static Color getPlotLineColor(Color defaultColor, String type) {
      return getLineColor(defaultColor, CSSConstants.CHART_PLOT_LINE, type);
   }
}
